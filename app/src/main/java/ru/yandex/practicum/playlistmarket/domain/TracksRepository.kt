package ru.yandex.practicum.playlistmarket.domain

import ru.yandex.practicum.playlistmarket.data.network.Track

interface TracksRepository {
    suspend fun searchTracks(expression: String): List<Track>
}
