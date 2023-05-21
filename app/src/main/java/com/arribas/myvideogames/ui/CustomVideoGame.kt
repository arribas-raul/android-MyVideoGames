package com.arribas.myvideogames.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.arribas.myvideogames.data.LocalGameDataProvider
import com.arribas.myvideogames.data.Videogame
import com.arribas.myvideogames.ui.theme.MyVideoGamesTheme
import com.arribas.myvideogames.R
import com.arribas.myvideogames.data.LocalMenuDataProvider
import com.arribas.myvideogames.data.NavigationItemContent
import com.arribas.myvideogames.data.VideoConsole

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarVideoGame(
    videogame: Videogame,
    isShowingListPage: Boolean,
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier
){
    val title = if (isShowingListPage) R.string.app_name else videogame.name

    TopAppBar(
        title = {
            Text(text = stringResource(title))
        },

        navigationIcon =
            if (!isShowingListPage) {
                {
                    IconButton(onClick = { onBackButtonClick() } ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back Button"
                        )
                    }
                }

            } else {
                { Box() {} }
            },

        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),

        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerContent(
    selectedDestination: VideoConsole,
    onTabPressed: ((VideoConsole) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {

        for (navItem in navigationItemContentList) {
            NavigationDrawerItem(
                selected = selectedDestination == navItem.type,
                label = {
                    Text(
                        text = navItem.text
                    )
                },
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent
                ),
                onClick = { onTabPressed(navItem.type) }
            )
        }
    }
}

@Composable
fun BottomBarVideoGame(
    currentTab: VideoConsole,
    onTabPressed: ((VideoConsole) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab == navItem.type,
                onClick = { onTabPressed(navItem.type) },
                icon = {
                    Text(text = navItem.text)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    MyVideoGamesTheme {
        TopBarVideoGame(
            videogame = LocalGameDataProvider.defaultGame,
            isShowingListPage = true,
            onBackButtonClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationBarPreview() {
    MyVideoGamesTheme {
        NavigationDrawerContent(
            selectedDestination = VideoConsole.PS5,
            onTabPressed = {},
            navigationItemContentList =  LocalMenuDataProvider.getMenuData()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    MyVideoGamesTheme {
        BottomBarVideoGame(
            currentTab = VideoConsole.PS5,
            onTabPressed = { },
            navigationItemContentList = LocalMenuDataProvider.getMenuData()
        )
    }
}