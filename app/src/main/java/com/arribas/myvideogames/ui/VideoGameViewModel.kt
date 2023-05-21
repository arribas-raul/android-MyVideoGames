package com.arribas.myvideogames.ui

import androidx.lifecycle.ViewModel
import com.arribas.myvideogames.data.LocalGameDataProvider
import com.arribas.myvideogames.data.VideoConsole
import com.arribas.myvideogames.data.Videogame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class VideoGameViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(VideoGameUiState())

    val uiState: StateFlow<VideoGameUiState> = _uiState

    init {
        _uiState.value =
            VideoGameUiState(
                audiovisualList = LocalGameDataProvider.getGameData(VideoConsole.PS5),
                currentVideoGame = LocalGameDataProvider.getGameData(VideoConsole.PS5).getOrElse(0) {
                    LocalGameDataProvider.defaultGame
                }
            )
    }

    fun updateCurrentVideogame(selected: Videogame) {
        _uiState.update {
            it.copy(currentVideoGame = selected)
        }
    }

    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }

    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }

    fun updateCurrentTypeList(type: VideoConsole) {
        _uiState.update {
            it.copy(
                audiovisualList = LocalGameDataProvider.getGameData(type = type),
                currentVideoGame = it.currentVideoGame,
                currentTab = type,
                isShowingListPage = true
            )
        }
    }
}

data class VideoGameUiState(
    val audiovisualList: List<Videogame> = emptyList(),
    val currentVideoGame: Videogame = LocalGameDataProvider.defaultGame,
    val isShowingListPage: Boolean = true,
    val currentTab: VideoConsole = VideoConsole.PS5,

)