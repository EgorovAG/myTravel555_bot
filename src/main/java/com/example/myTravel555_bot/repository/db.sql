drop database myTravel_bot;
create database myTravel_bot;

create table IF NOT EXISTS travel
(
    id          bigint auto_increment PRIMARY KEY,
    city        varchar(100) not null unique ,
    description varchar(255)  not null
);

insert into travel (city, description)
VALUES ('Moscow', 'Red Square is huge'),
       ('Minsk', 'National Library is very round'),
       ('London', 'Big-Ben is very accurate');


