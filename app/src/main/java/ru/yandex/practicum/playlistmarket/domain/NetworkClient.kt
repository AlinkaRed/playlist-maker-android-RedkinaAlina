package ru.yandex.practicum.playlistmarket.domain

import ru.yandex.practicum.playlistmarket.data.dto.BaseResponse

interface NetworkClient {
    fun doRequest(dto: Any): BaseResponse
}
