# java-filmorate
Template repository for Filmorate project.

![Data Base Diagram](https://github.com/Ivnsol/java-filmorate/blob/main/DB%20Diagram.jpg

### Таблица Film содержит в себе:

Film_id - айдишник фильма

Name- название 

Description -описание

Release_date - дата выхода

Duration - продолжительность

MPA_id - id возрастного ограничения и ссылку на таблицу Motion_picture_association

Genre_id - id жанра фильма отсылка к таблице Genre

Таблица Motion_picture_association содержит:

id - айди

MPA_title - наименование возрастного ограничения

### Таблица Genre:
Genre_id - айдишник наименования заголовка жанра

Title - наименование загловка

### Таблица Likes (связывающая с юзером)

Film_id - айди фильма (дает отсылку к таблице Film)

User_id - айди юзера (дает отсылку к таблице User)

### Таблица User
User_id - айди юзера

Email - почта

Login - логин

Name - имя

Birthday - дата рождения

### Таблица Friends

User_ID - айди юзера

Users_ID - айди друзей юзера

Friends_status - статус друга по связке User_ID-Users_ID
