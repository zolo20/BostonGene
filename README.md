**Практические задания для BostonGene**

_Часть 1. Многопоточность_
    
    1) Скачать репозиторий и открыть папку любым IDE.
    2) Для запуска в IDE необходимо запустить класс Main.

    Альтернативный способ запуска:
    1) Сборка мавеном и запуск.
        
_Часть 2. Spring user service_
    
    1) Скачать репозиторий и открыть папку любым IDE.
    2) Для запуска в IDE необходимо запустить класс Application.
    
    Альтернативный способ запуска:
    1) Сборка мавеном и запуск.
    
    Примеры запросов:
    1)  Добавление пользователя
    
        На URL http://localhost:8080/user отправляется POST-запрос
        
        Пример тела запроса:
        
            {
                "email":"mail@mail.com",
                "password":"abc",
                "name": "Arsen",
                "surname": "Kalashov",
                "birthday": "01.09.1995"
            }
        
     Формат даты: dd.MM.yyyy
    
    2) Удаление пользователя
    
    На URL http://localhost:8080/user/{id} отправляется DELETE-запрос,
     где id это номер пользователя, которого необходимо удалить.
     
     Пример URL http://localhost:8080/user/1
    
    3) Поиск пользователя по email
    
    На URL http://localhost:8080/user?email={email} отправляется GET-запрос,
         где email это параметр, которого необходимо предоставить для полуяения пользователя.
    
    Пример URL http://localhost:8080/user?email=mail@mail.com
    
    Пример тела ответа:
    
        {
            "userID": 1,
            "email": "mail@mail.com",
            "password": "$2a$10$NillhIGXtF9wkMphM9.CVeKBw0pErj9jU7RlnWPzPI1pqS5X5dWx6",
            "name": "Arsen",
            "surname": "Kalashov",
            "birthday": "01.09.1995"
        }
        
_Часть 3. Yandex translate API_

    1) Скачать репозиторий и открыть папку любым IDE.
    2) Для запуска в IDE необходимо запустить класс Translate.

    Альтернативный способ запуска:
    1) Сборка мавеном и запуск.