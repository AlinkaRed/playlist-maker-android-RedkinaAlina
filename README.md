# playlist-maker-android-RedkinaAlina

Учебный Android-проект Playlist Maker.

## Как запустить

1. Откройте проект в Android Studio.
2. Дождитесь Gradle Sync.
3. Запустите приложение на эмуляторе или устройстве (Run `app`).

## Технологии

- Kotlin
- Android SDK
- Jetpack Compose
- Material 3

## Спринты

- Sprint 3:
  - Добавлен главный экран на Compose.
  - Реализованы базовые переходы с главного экрана на поиск и настройки.
  - Добавлен чек-лист в `checklists/sprint-3.md`.
- Sprint 4:
  - Добавлен `PlaylistHost` с навигацией через `NavHost` и `NavController`.
  - Реализованы `MainScreen`, `SearchScreen`, `SettingsScreen` на Compose.
  - Добавлена логика очистки поискового запроса на экране поиска.
  - Реализованы действия настроек: share, email и открытие пользовательского соглашения.
  - Добавлен чек-лист в `checklists/sprint-4.md`.
- Sprint 5:
  - Проект переведен на структуру Clean Architecture: `creator`, `data`, `domain`, `ui`.
  - `MainActivity` перенесена в пакет `ui/activity`, обновлен путь активности в `AndroidManifest.xml`.
  - Добавлен эмулятор сервера `Storage` и сетевой клиент `RetrofitNetworkClient`.
  - Добавлены DTO и ответы поиска: `BaseResponse`, `TrackDto`, `TracksSearchRequest`, `TracksSearchResponse`.
  - Добавлены `NetworkClient`, `TracksRepository` и реализация `TracksRepositoryImpl` с маппингом времени трека.
  - Уточнены сценарии настроек: надежное открытие почты и браузера через chooser.
- Sprint 6:
  - Добавлены `SearchState` и `SearchViewModel` для экрана поиска (MVVM).
  - Добавлен `Creator` для создания `TracksRepository`.
  - Реализованы 4 состояния поиска: initial, loading, success, fail.
  - Экран `SearchScreen` подключен к `StateFlow` и отображает найденные треки.
  - Добавлен ресурс `ic_music` для списка треков.