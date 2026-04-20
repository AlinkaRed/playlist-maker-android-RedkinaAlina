package ru.yandex.practicum.playlistmarket.data.network

import kotlinx.coroutines.delay
import ru.yandex.practicum.playlistmarket.data.dto.TracksSearchRequest
import ru.yandex.practicum.playlistmarket.data.dto.TracksSearchResponse
import ru.yandex.practicum.playlistmarket.domain.NetworkClient
import ru.yandex.practicum.playlistmarket.domain.TracksRepository

class TracksRepositoryImpl(private val networkClient: NetworkClient) : TracksRepository {

    override suspend fun searchTracks(expression: String): List<Track> {
        val response = networkClient.doRequest(TracksSearchRequest(expression))
        delay(1000)
        return if (response.resultCode == 200) {
            (response as TracksSearchResponse).results.map { dto ->
                val seconds = dto.trackTimeMillis / 1000
                val minutes = seconds / 60
                val trackTime = "%02d".format(minutes) + ":" + "%02d".format(seconds - minutes * 60)
                Track(
                    trackName = dto.trackName,
                    artistName = dto.artistName,
                    trackTime = trackTime
                )
            }
        } else {
            emptyList()
        }
    }
}
