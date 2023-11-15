drop database if exists reto1;
create database reto1;
use reto1;

drop table if exists favorite;
drop table if exists users;
drop table if exists songs;

create table users(
id integer primary key auto_increment,
    name varchar(50) not null,
    surname varchar(50) not null,
    login varchar(10) unique,
    email varchar(50) unique,
    password varchar(100) not null
);

create table songs(
	id integer primary key auto_increment,
    url varchar(100) unique,
    title varchar(200) not null,
    author varchar(200) not null
);

create table favorite(
	id integer primary key auto_increment,
    id_song integer,
    id_user integer,
    constraint fk_favorite_IDSongs foreign key (id_song) references songs(id),    
    constraint fk_favorite_IDUsers foreign key (id_user) references users(id),
    unique(id_song, id_user)
);

drop user if exists 'reto1'@'%';
CREATE USER 'reto1'@'%' IDENTIFIED BY 'Elorrieta00';
GRANT ALL PRIVILEGES ON reto1.* TO 'reto1'@"%";


INSERT INTO users (email,login, name, surname, password) VALUES
    ('usuario1@example.com','Login1', 'Juan', 'Pérez', '$2a$10$lzILmhQckpWEkar9U0/lve4RwAD/93RW4eoz4fbOkmdVQFtXe3KCa'),
    ('usuario2@example.com','Login2', 'María', 'López', '$10$B2mtYltDVjut7pBx1jO50eMwbZ9C1r1lAlrqgtFSMdIHHLW3X050a'),
    ('usuario3@example.com','Login3', 'Carlos', 'Gómez', '$10$dNpgmCRCR3lvVYM4VfuTrOpvKJfjw/WrWvv3HXL8DrKi8/S/H/rUq'),
    ('usuario4@example.com','Login4', 'Ana', 'Martínez', '$10$VHpS0tjr.8qTRIot8FgbguFt/U4buZyVNVkdYCg4t3D8HcZadMzeO'),
    ('usuario5@example.com','Login5', 'Pedro', 'Sánchez', '$10$m2oVEtNQdc79J0PS4S4hRej9V8U4wGZFnI.Vy8f2nXp3DwVNfecmC'),
    ('usuario6@example.com','Login6', 'Laura', 'Rodríguez', '$10$J3lCIWQIp7zPxKnFBLQwouL7J6giUG9kl7zINK/cLv747KU.x/MMC'),
    ('usuario7@example.com','Login7', 'David', 'Fernández', '$2a$10$gsci1syYfgmn8Qn4VN3wmeeH87l9ah3wPw5ld4.UN/XtqQSHxJld6'),
    ('usuario8@example.com','Login8', 'Isabel', 'García', '$10$FO4DG1BVVaVNsoZvZANFCujXEdWy8yx70a7/AwraTEtQGtPjvKgjy'),
    ('usuario9@example.com','Login9', 'Javier', 'Díaz', '$2a$10$PLEQzooULnv2SixNb7LPDeyyWseJEP5runOfuZ0u/Iejz0JeLa8nG'),
    ('usuario10@example.com','Login10', 'Elena', 'Torres', '$2a$10$AMH6ztDT7qNZ16bAOJ1ldepszXDH2Cbn5R7tGr1bgIH7pBh5iNFAm');

INSERT INTO songs (title, url, author) VALUES ('LA NOCHE DE ANOCHE', 'https://youtube.com/watch?v=f5omY8jVrSM', 'Bad Bunny & ROSALIA');
INSERT INTO songs (title, url, author) VALUES ('Hawai', 'https://youtube.com/watch?v=pK060iUFWXg', 'Maluma');
INSERT INTO songs (title, url, author) VALUES ('BICHOTA', 'https://youtube.com/watch?v=QaXhVryxVBk', 'KAROL G');
INSERT INTO songs (title, url, author) VALUES ('Dakiti', 'https://youtube.com/watch?v=TmKh7lAwnBI', 'Bad Bunny & Jhay Cortez');
INSERT INTO songs (title, url, author) VALUES ('Tattoo', 'https://youtube.com/watch?v=wJT-YKmlWJc', 'Rauw Alejandro & Camilo');
INSERT INTO songs (title, url, author) VALUES ('Vida de Rico', 'https://youtube.com/watch?v=qKp1f7Vn9dM', 'Camilo');
INSERT INTO songs (title, url, author) VALUES ('Yo Perreo Sola', 'https://youtube.com/watch?v=GtSRKwDCaZM', 'Bad Bunny');
INSERT INTO songs (title, url, author) VALUES ('Caramelo Remix', 'https://youtube.com/watch?v=KilybZma5vY', 'Ozuna, Karol G, & Myke Towers');
INSERT INTO songs (title, url, author) VALUES ('Favorito', 'https://youtube.com/watch?v=2mY7AFTtYwQ', 'Camilo');
INSERT INTO songs (title, url, author) VALUES ('Tusa', 'https://youtube.com/watch?v=tbneQDc2H3I', 'KAROL G & Nicki Minaj');
INSERT INTO songs (title, url, author) VALUES ('Baila Conmigo', 'https://youtube.com/watch?v=h5WN3pkxPF0', 'Rauw Alejandro');
INSERT INTO songs (title, url, author) VALUES ('Ay, DiOs Mio!', 'https://youtube.com/watch?v=Ou2c2aj5Fcw', 'KAROL G');
INSERT INTO songs (title, url, author) VALUES ('Despeinada', 'https://youtube.com/watch?v=mLugzKRTf-0', 'Ozuna & Camilo');
INSERT INTO songs (title, url, author) VALUES ('Relacion', 'https://youtube.com/watch?v=c6D8v6DhKc4', 'Sech');
INSERT INTO songs (title, url, author) VALUES ('Hasta que Dios diga', 'https://youtube.com/watch?v=nCzwGVKpjpo', 'Bad Bunny & Anuel AA');
INSERT INTO songs (title, url, author) VALUES ('De Una Vez', 'https://youtube.com/watch?v=91VRyTvjoX4', 'Selena Gomez');
INSERT INTO songs (title, url, author) VALUES ('Bandido', 'https://youtube.com/watch?v=W6fme7tcweQ', 'Myke Towers & Juhn');
INSERT INTO songs (title, url, author) VALUES ('Elegi', 'https://youtube.com/watch?v=3Ftud32GEn0', 'Lenny Tavarez, Dalex, & Rauw Alejandro');
INSERT INTO songs (title, url, author) VALUES ('Reloj', 'https://youtube.com/watch?v=-3HjrdC0dAk', 'Anuel AA & Rauw Alejandro');
INSERT INTO songs (title, url, author) VALUES ('La Toxica', 'https://youtube.com/watch?v=puugRJxgdt4', 'Farruko');
INSERT INTO songs (title, url, author) VALUES ('Futbol & rumba', 'https://youtube.com/watch?v=oUNMq7AiYKU', 'Anuel AA');
INSERT INTO songs (title, url, author) VALUES ('UN DIA', 'https://youtube.com/watch?v=BjhW3vBA1QU', 'Bad Bunny, Dua Lipa, Tainy, & J Balvin');
INSERT INTO songs (title, url, author) VALUES ('TKN', 'https://youtube.com/watch?v=q5xIoeG4uVI', 'Travis Scott & ROSALIA');
INSERT INTO songs (title, url, author) VALUES ('Mi nina', 'https://youtube.com/watch?v=qfXfHRZEBeg', 'Ozuna');
