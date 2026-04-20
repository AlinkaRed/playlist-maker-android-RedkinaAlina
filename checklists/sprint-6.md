# Самопроверка sprint-6

- [x] Созданы `SearchState` и `SearchViewModel`.
- [x] В `SearchViewModel` используется `TracksRepository`, получаемый через `Creator`.
- [x] Реализованы состояния поиска: `Initial`, `Searching`, `Success`, `Fail`.
- [x] Экран поиска подписан на `StateFlow` из ViewModel.
- [x] При нажатии на иконку поиска запускается поиск по введенной строке.
- [x] На экране отображаются все состояния: стартовое, загрузка, успех, ошибка.
- [x] Список найденных треков отображается в `LazyColumn` с `TrackListItem`.
