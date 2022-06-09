CREATE DATABASE `DBMS_PROJECT`;
SHOW DATABASES;
USE `DBMS_PROJECT`;

SET SQL_SAFE_UPDATES = 0;



CREATE TABLE `manager`(
	`managerID` INT PRIMARY KEY,
    `password` INT NOT NULL,
    `managerName` VARCHAR(20) NOT NULL
);



CREATE TABLE `user`(
	`userID` INT PRIMARY KEY,
    `userName` VARCHAR(20) NOT NULL,
    `password` INT NOT NULL,
    `phone_number` VARCHAR(20) NOT NULL,
    `gender`  VARCHAR(10) NOT NULL
);



ALTER TABLE `user` DROP  `restID` ;

DROP TABLE `order`, `user` ,`restaurant`, `manager`,`picture`,`business_Hours`;

SHOW COLUMNS FROM  `order`;


ALTER TABLE `user` ADD `gender` VARCHAR(10) NOT NULL ;
ALTER TABLE `order` ADD FOREIGN KEY (`restID`) REFERENCES `restaurant`(`restID`) ON DELETE SET NULL  ;

SELECT * FROM `order`;

ALTER TABLE `user`ADD COLUMN `password`  INT;




CREATE TABLE `order`(
	`orderID` INT PRIMARY KEY AUTO_INCREMENT,
    `state` VARCHAR(10) NOT NULL CHECK (`state` IN ('正常','取消','備取')), 
    `waiting_Number` VARCHAR(20),
     `seating_Time` datetime NOT NULL,
     `order_Time`datetime default NOW(),
     `userID` INT,
     `restID`INT,
	 FOREIGN KEY (`userID`) REFERENCES `user`(`userID`) ON DELETE SET NULL ,
     FOREIGN KEY (`restID`) REFERENCES `restaurant`(`restID`) ON DELETE SET NULL 
);

CREATE TABLE `restaurant`(
	`restID` INT PRIMARY KEY AUTO_INCREMENT,
    `restName` VARCHAR(20) NOT NULL,
    `userID` INT,
    `seats` INT  NOT NULL,
    `phone_Numeber` VARCHAR(20)NOT NULL , 
    `location`  VARCHAR(20) NOT NULL,
     FOREIGN KEY (`userID`) REFERENCES `user`(`userID`) ON DELETE SET NULL 
);

CREATE TABLE `picture`(
	`pictureID` INT PRIMARY KEY AUTO_INCREMENT,
	`restID` INT ,
    `picture` BLOB,
    FOREIGN KEY (`restID`) REFERENCES `restaurant`(`restID`) ON DELETE SET  NULL
);

CREATE TABLE `business_Hours`(
	`business_HoursID`	INT PRIMARY KEY AUTO_INCREMENT,
	`restID` INT ,
    `day` VARCHAR(10)   CHECK (`day` IN ('MON.','TUE.','WED.','THUR.','FRI.','SUR.','SUN')),
    `hours` INT ,
    FOREIGN KEY (`restID`) REFERENCES `restaurant`(`restID`) ON DELETE SET NULL 
);

-- user register
INSERT INTO `user` (`userID` ,`password`,`userName`, `phone_number`,`gender`)VALUES('12345678','12345678','小美','0986587459','女');

-- restaurant  register
INSERT INTO `restaurant` ( `userID`,`restName` ,`seats`,`phone_Numeber`, `location`)VALUES('12345678','八方雲集','50','0986587459','台北市文山區');
INSERT INTO `business_Hours`( `restID`,`day`,`hours`)VALUES('12345678','MON.',9);

-- insert picture
INSERT INTO `picture` (`restID`,`picture`)VALUES('12345678','台北市文山區')

-- order 
INSERT INTO `order` (`state`,`seating_Time`,`order_Time`,`userID`,`restID`)VALUES('12345678','台北市文山區');
Select `state`
FROM `order`

if 
