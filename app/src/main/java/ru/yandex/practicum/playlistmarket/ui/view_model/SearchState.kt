package ru.yandex.practicum.playlistmarket.ui.view_model

import ru.yandex.practicum.playlistmarket.data.network.Track

sealed class SearchState {
    data object Initial : SearchState()
    data object Searching : SearchState()
    data class Success(val foundList: List<Track>) : SearchState()
    data class Fail(val error: String) : SearchState()
}
