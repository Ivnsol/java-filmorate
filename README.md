# java-filmorate
Template repository for Filmorate project.

![Data Base Diagram](https://github.com/Ivnsol/java-filmorate/blob/main/DB%20Diagram.jpg

Таблица Film содержит в себе:
Film_id - айдишник фильма
Name- название 
Description -описание
Release_date - дата выхода
Duration - продолжительность
MPA_id - id возрастного ограничения и ссылку на таблицу Motion_picture_association
---------------------------
Таблица Motion_picture_association содержит id и второе поле-наименование возрастного ограничения
--------------------------
Таблица Genre:
Genre_id - айдишник наименования заголовка жанра
Title - наименование загловка
Genre_id указывает на таблицу Film_genre
--------------------------
Таблица Film_genre:
таблица имеет следующий вид:
1 | 1 | 3
2 | 1 | 5
3 | 1 | 7
(один фильм с несколькими жанрами)
Film_genre_id(первый столбец) - айдишник согласно второй нормальной формуле БД(нигде не используется)
Film_id - айдишник фильма
Genre_id - айдишник жанра
--------------------------
Таблица Likes (связывающая с юзером)
Likes_id - айдишник согласно второй нормальной формуле БД(нигде не используется)
Film_id - айди фильма (дает отсылку к таблице Film)
User_id - айди юзера (дает отсылку к таблице User)
--------------------------
Таблица User
User_id - айди юзера
Email - почта
Login - логин
Name - имя
Birthday - дата рождения
Friends_status - статус подачи заявки в друзья отсылка к таблице Friends_status
-------------------------
Таблица Friends_status 
Friends_status_id - айдишник
Status - тип Sting true/false, парсим на boolean
-------------------------
Таблица Friends
Friends_id - айдишник согласно второй нормальной формуле БД(нигде не используется)
User_ID - айди юзера
Users_ID - айди друзей юзера
-> пример 
1 | 1 | 3
2 | 1 | 5
3 | 1 | 7
