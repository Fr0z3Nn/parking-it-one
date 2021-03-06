# PARKING
## Техническое задание                  
Задание для java разработки                             
Необходимо разработать сервер для функционирования автомобильной парковки                 
Парковка имеет 2 шлагбаума. Один на въезд, другой на выезд. У приложения разработать rest api для работы с внешними устройствами. Шлагбаумы опрашивают приложение на разрешение на въезд. Датчики наличия автомобиля на паркоместе отправляют в приложение свой статус(есть автомобиль/нет автомобиля). Информационное табло парковки опрашивает систему для определения свободных мест парковки.
Необходимо показать реализацию:                  
1.Контроллеры             
2.Сервисы            
3.Модель            
4.Персистентный слой                 
                        
Необходимо написать один тест на контроллер(проверка количество свободных паркомест) с замоканным слоем персистенции                   
                      
Реализация компонент не участвующих при работе теста может быть опущена. Приложение не обязательно должно запускаться               

***
## Stack
- Open JDK 8    
- Spring Boot 
- Spring Data   
- H2 Database
- Lombok    
- Mockito
- JUnit 5
***
## Endpoints
- `(POST)/api/barrier/add`  
Добавляет машину на парковку, если это возможно      
**Parameters**   
carNum : string (x123xx)   
**_Пример_**   
`http://localhost:9090/api/barrier/add?carNum=x123xx`
------
- `(POST)/api/barrier/remove`  
Убирает машину с парковки, если это возможно      
**Parameters**   
carNum : string (x123xx)   
**_Пример_**   
`http://localhost:9090/api/barrier/remove?carNum=x123xx`
------
- `(GET)/api/status`  
Общий статус парковки    
**_Пример_**   
`http://localhost:9090/api/status`
------
- `(POST)/api/status`  
Проверяет парковочное место, выводит информацию о нем.   
**Parameters**   
id : long (12)   
**_Пример_**   
`http://localhost:9090/api/status?id=123`
------
***
 ## Примечание
 - Тест написан только для одного метод-маппинг контроллера.
