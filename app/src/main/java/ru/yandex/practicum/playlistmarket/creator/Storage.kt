package ru.yandex.practicum.playlistmarket.creator

import ru.yandex.practicum.playlistmarket.data.dto.TrackDto

class Storage {
    private val listTracks = listOf(
        TrackDto("Владивосток 2000", "Мумий Тролль", 158000),
        TrackDto("Группа крови", "Кино", 283000),
        TrackDto("Не смотри назад", "Ария", 312000),
        TrackDto("Звезда по имени Солнце", "Кино", 225000),
        TrackDto("Лондон", "Аквариум", 272000),
        TrackDto("На заре", "Альянс", 230000),
        TrackDto("Перемен", "Кино", 296000),
        TrackDto("Розовый фламинго", "Сплин", 195000),
        TrackDto("Танцевать", "Мельница", 222000),
        TrackDto("Чёрный бумер", "Серега", 241000)
    )

    fun search(request: String): List<TrackDto> {
        return listTracks.filter { track ->
            track.trackName.lowercase().contains(request.lowercase())
        }
    }
}
