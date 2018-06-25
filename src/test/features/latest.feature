#language: ru
@test
Функционал: Эндпоинт http://data.fixer.io/api/latest

  Сценарий: Отправка запроса
    Когда Указываю базовый url: "http://data.fixer.io/api/" и включаю логирование
    Тогда делаю GET запрос по path: "latest" c params
      | access_key | f137c604155ecd2d009f56893e25aa73 |
