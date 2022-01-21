/* полное удаление прежней базы данных */
DROP DATABASE IF EXISTS `lab5`;

/* создание новой базы данных */
CREATE DATABASE `lab5` DEFAULT CHARACTER SET utf8;

/* использование в качестве текущей только что созданной базы данных */
USE `lab5`;

CREATE TABLE `doc` (
    `id`            INTEGER         NOT NULL    AUTO_INCREMENT,
    `id_spec`       INTEGER                     REFERENCES `spec`    ON UPDATE RESTRICT ON DELETE RESTRICT,
    `fio`           VARCHAR(50)     NOT NULL,
    `bday`          VARCHAR(10)     NOT NULL,
    `hiring`          VARCHAR(10)     NOT NULL,
    `number`        INTEGER,
    `payment`       DOUBLE,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `spec` (
    `id`            INTEGER         NOT NULL    AUTO_INCREMENT,
    `name`          VARCHAR(20)     NOT NULL,
    `uzk`           VARCHAR(10)      NOT NULL,
    `amount`        INTEGER         NOT NULL,
    `salary`        INTEGER        NOT NULL,
    `costs`         DOUBLE ,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `Users` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `role` VARCHAR(255) NOT NULL,
    `login` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

INSERT INTO `Users`
(`id`,`role`, `login`,`password`)
VALUES
(1,"admin","admin","admin"),
(2,"reg","reg","reg"),
(3,"user","user","user");

INSERT INTO `spec`
(`id`, `name`,      `uzk`, `amount`,`salary`,`costs`)VALUES
( 1,  "Хирург",      "y",     2,     15600 , NULL),
( 2,  "ЛОР",         "y",     1,     13200 , NULL),
( 3,  "Терапевт",    "n",     3,     10500 , NULL),
( 4,  "Офтальмолог", "n",     1,     17200 , NULL);


INSERT INTO `doc`
(`id`,  `id_spec`,     `fio`,            `bday`,        `hiring`,   `number`,   `payment`)VALUES
(  1,       1,     "Пчелкин А.М.",   "12.09.1985",   "16.09.2001",     NULL,        NULL),
(  2,       1,     "Семенов Г.В.",   "18.10.1977",   "28.04.1997",     NULL, 		NULL),
(  3,       2,     "Коробкин И.У.",  "07.02.1990",   "12.09.2017",     NULL, 		NULL),
(  4,       3,     "Пенкин З.И.",    "02.04.1963",   "15.10.1990",      12, 		NULL),
(  5,       3,     "Дятлов Е.Б.",    "23.11.1992",   "13.05.2020",      13, 		NULL),
(  6,       3,     "Собакен Ш.Т.",   "30.08.1950",   "02.02.1985",      14, 		NULL),
(  7,       2,     "Скумбрия М.Ж.",  "27.06.1986",   "17.01.2004",      45, 		NULL);


