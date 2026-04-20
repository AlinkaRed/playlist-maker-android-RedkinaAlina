package ru.yandex.practicum.playlistmarket.creator

import ru.yandex.practicum.playlistmarket.data.network.RetrofitNetworkClient
import ru.yandex.practicum.playlistmarket.data.network.TracksRepositoryImpl
import ru.yandex.practicum.playlistmarket.domain.TracksRepository

object Creator {
    fun getTracksRepository(): TracksRepository {
        return TracksRepositoryImpl(RetrofitNetworkClient(Storage()))
    }
}
