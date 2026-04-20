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
        TrackDto("Чёрный бумер", "Серега", 241000),
        TrackDto("Yesterday (Remastered 2009)", "The Beatles", 155000),
        TrackDto("Here Comes The Sun (Remastered 2009)", "The Beatles", 241000),
        TrackDto("No Reply", "The Beatles", 312000),
        TrackDto("Let It Be", "The Beatles", 241000),
        TrackDto("Girl", "The Beatles", 251000),
        TrackDto("Michelle", "The Beatles", 181000),
        TrackDto("Eleanor Rigby", "The Beatles", 372000),
        TrackDto("Come Together", "The Beatles", 249000)
    )

    fun search(request: String): List<TrackDto> {
        val normalizedRequest = request.lowercase()
        return listTracks.filter { track ->
            track.trackName.lowercase().contains(normalizedRequest) ||
                track.artistName.lowercase().contains(normalizedRequest)
        }
    }
}
