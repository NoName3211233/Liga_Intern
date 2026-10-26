
CRUD-приложение на Java 17 и Spring Boot 4 для работы с клиентами.
База данных PostgreSQL в Docker. Операции: создание, чтение,
обновление и удаление клиентов.

(docker run --name Liga-postgres -d -e POSTGRES_PASSWORD=root -e POSTGRES_NAME=postgres -p 5432:5432 postgres)

## Стэк:

1.	Java(17)
2.	Spring Boot
3.	Maven
4.	Hibernate (Spring Data JPA)
5.	Реляционная БД (PostgreSQL).


## Структура

UserController - HTTP-слой

UserService - бизнес-логика

UserRepository - доступ к бд через Spring Data JPA

UserEntity - сущность 

User- DTO

application.properties - настройки подключения к бд

## Хранение данных в Бд
<img width="908" height="439" alt="image" src="https://github.com/user-attachments/assets/f1ada7a9-ded3-402d-963b-5787021ebb39" />

## Метод post createClient
url: http://localhost:8080/api/clients

JSON body:
{
  "full_name": "Иванов Мария Сергеевна",
  "gender": "F"
}

## Метод get getAllClients
url: http://localhost:8080/api/clients

JSON response:
```
{
    
    "id": 1,
    
    "full_name": "Иванов Мария Сергеевна",
    
    "gender": "F",
    
    "status": "ACTIVE",
    
    "date_of_create": "2026-10-26T01:59:35.860314",
    
    "date_of_update": "2026-10-26T01:59:35.860314"
},
```

## Метод get getClientById
url: http://localhost:8080/api/clients/id

JSON response:
```
{
    "id": 1,
    
    "full_name": "Иванов Мария Сергеевна",
    
    "gender": "F",
    
    "status": "ACTIVE",
    
    "date_of_create": "2026-10-26T01:59:35.860314",
    
    "date_of_update": "2026-10-26T01:59:35.860314"
}
```
## Метод put updateClient
url: http://host:port/api/clients/id
JSON body:
```
{    
  
  "full_name": "Иванов Мария Сергеевна",
  
  "gender": "F",
  
  "status": "INACTIVE"
}
```

JSON response:
```
{
    
    "id": 2,
    
    "full_name": "Иванов Мария Сергеевна",
    
    "gender": "F",
    
    "status": "INACTIVE",
    
    "date_of_create": "2026-10-26T01:59:37.810701",
    
    "date_of_update": "2026-10-26T04:15:09.1654089"
}
```

## Метод delete deleteClient
url: http://localhost:8080/api/clients/id
