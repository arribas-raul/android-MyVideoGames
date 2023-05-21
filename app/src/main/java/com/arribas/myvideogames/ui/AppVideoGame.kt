package com.arribas.myvideogames.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arribas.myvideogames.data.LocalMenuDataProvider
import com.arribas.myvideogames.data.VideoConsole
import com.arribas.myvideogames.ui.theme.MyVideoGamesTheme
import com.arribas.myvideogames.util.WindowContentType
import com.arribas.myvideogames.util.WindowNavigationType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppVideoGame(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val viewModel = VideoGameViewModel()
    val uiState by viewModel.uiState.collectAsState()
    val navigationType: WindowNavigationType
    val contentType: WindowContentType
    val navigationItemContentList = LocalMenuDataProvider.getMenuData()

    /**Config type of navigate buttons Menu, Menu compact or BottomBar*/
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = WindowNavigationType.BOTTOM_NAVIGATION
            contentType = WindowContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = WindowNavigationType.NAVIGATION_RAIL
            contentType = WindowContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = WindowNavigationType.PERMANENT_NAVIGATION_DRAWER
            contentType = WindowContentType.LIST_AND_DETAIL
        }
        else -> {
            navigationType = WindowNavigationType.BOTTOM_NAVIGATION
            contentType = WindowContentType.LIST_ONLY
        }
    }

    Scaffold(
        topBar = {
            TopBarVideoGame(
                uiState.currentVideoGame,
                isShowingListPage = uiState.isShowingListPage,
                onBackButtonClick = { viewModel.navigateToListPage() },
            )
        },

        bottomBar = {
            if(navigationType == WindowNavigationType.BOTTOM_NAVIGATION){
                BottomBarVideoGame(
                    currentTab = uiState.currentTab,
                    onTabPressed = { type: VideoConsole ->
                        viewModel.updateCurrentTypeList(type = type)
                    },
                    navigationItemContentList = navigationItemContentList,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }else{}
        }
    ) { innerPadding ->
        PermanentNavigationDrawer(
            drawerContent = {
                if(navigationType != WindowNavigationType.BOTTOM_NAVIGATION){
                    PermanentDrawerSheet(Modifier.width(80.dp)) {

                        NavigationDrawerContent(
                            selectedDestination = uiState.currentTab,
                            onTabPressed = { type: VideoConsole ->
                                viewModel.updateCurrentTypeList(type = type)
                                //viewModel.resetHomeScreenStates()
                            },
                            navigationItemContentList = navigationItemContentList,
                            modifier = Modifier
                                .wrapContentWidth()
                                .fillMaxHeight()
                                .background(MaterialTheme.colorScheme.inverseOnSurface)
                                .padding(innerPadding)
                        )
                    }
                }else{}
            }
        ){
            if(contentType == WindowContentType.LIST_AND_DETAIL){
                Row(modifier = modifier) {
                    ListVideoGame(
                        modifier = Modifier
                            .padding(innerPadding)
                            .weight(1f),
                        list = uiState.audiovisualList,
                        onItemClick = {
                            viewModel.updateCurrentVideogame(it)
                            viewModel.navigateToDetailPage()
                        }
                    )

                    DetailVideoGame(
                        videogame = uiState.currentVideoGame,
                        modifier = Modifier
                            .weight(1f)
                            .padding(innerPadding)
                    )
                }
            }else {
                if (uiState.isShowingListPage) {
                    ListVideoGame(
                        modifier = Modifier.padding(innerPadding),
                        list = uiState.audiovisualList,
                        onItemClick = {
                            viewModel.updateCurrentVideogame(it)
                            viewModel.navigateToDetailPage()
                        }
                    )

                } else {
                    DetailVideoGame(
                        videogame = uiState.currentVideoGame,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyVideoGamesTheme {
        AppVideoGame(windowSize = WindowWidthSizeClass.Expanded)
    }
}