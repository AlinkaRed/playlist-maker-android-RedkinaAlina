package ru.yandex.practicum.playlistmarket.data.network

import ru.yandex.practicum.playlistmarket.creator.Storage
import ru.yandex.practicum.playlistmarket.data.dto.TracksSearchRequest
import ru.yandex.practicum.playlistmarket.data.dto.TracksSearchResponse
import ru.yandex.practicum.playlistmarket.domain.NetworkClient

class RetrofitNetworkClient(private val storage: Storage) : NetworkClient {
    override fun doRequest(dto: Any): TracksSearchResponse {
        val searchList = storage.search((dto as TracksSearchRequest).expression)
        return TracksSearchResponse(searchList).apply { resultCode = 200 }
    }
}
