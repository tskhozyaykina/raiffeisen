#language: ru
@test
Функционал: Эндпоинт http://data.fixer.io/api/2000-01-03

  Структура сценария: Отправка запроса c "<дата>" и <symbols>
    Когда Указываю базовый url: "http://data.fixer.io/api/" и включаю логирование

    Тогда делаю GET запрос по path: "<дата>" c params
      | access_key | f137c604155ecd2d009f56893e25aa73 |
      | symbols    | <symbols>                        |

    И прверяю что код ответа 200

    И прверяю что json содержит:
      | date | <ожидаемая дата> |

    Примеры:
      | symbols | дата       | ожидаемая дата |
      | RUB,EUR | 2000-01-03 | 2000-01-03     |
      | RUB,ENG | 2011-01-03 | 2011-01-03     |

