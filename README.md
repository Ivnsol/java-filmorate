# java-filmorate

### The application tracks the popularity of movies. Added users like the films they created, thereby raising them in the rankings.

The application was written using Spring Boot, including the REST protocol. The data is stored in a database. Next, the designed database schema will be described in detail.

![Data Base Diagram](https://github.com/Ivnsol/java-filmorate/blob/main/DB%20Diagram.jpg

### Таблица Film содержит в себе:

Film_id - айдишник фильма

Name - название 

Description - описание

Release_date - дата выхода

Duration - продолжительность

mpa - id возрастного ограничения и ссылку на таблицу Motion_picture_association

Genre_id - id жанра фильма отсылка к таблице Film_Genre

### Таблица Motion_picture_association содержит:

film_id - айди фильма

mpa_id - айди возрастного ограничения

### Таблица Motion_picture_association содержит:

mpa_id - айди возрастного ограничения

MPA_title - наименование возрастного ограничения

### Таблица Film_Genre:

Genre_id - айдишник наименования заголовка жанра ссылка на таблицу Genre

Film_id - айдишник фильма

### Таблица Genre:

Genre_id - айдишник наименования заголовка жанра

Title - наименование загловка

### Таблица Likes 

Film_id - айди фильма (дает отсылку к таблице Film)

User_id - айди юзера поставивший лайк фильму

### Таблица User

User_id - айди юзера

Login - логин

Name - имя

Email - почта

Birthday - дата рождения

### Таблица Friends

User_ID - айди юзера

Users_ID - айди друзей юзера

status - статус друга по связке User_ID-Users_ID
