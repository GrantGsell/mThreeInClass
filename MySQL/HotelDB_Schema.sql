-- Database initialization
DROP DATABASE IF EXISTS hoteldb;
CREATE DATABASE hoteldb;
USE hoteldb;

CREATE TABLE roomType(
	roomType varchar(6) PRIMARY KEY NOT NULL,
    standardOccupancy tinyint,
    maximumOccupancy tinyint,
    extraPersonCost double,
    jacuzziCost double,
    basePrice double
);


CREATE TABLE room(
	roomNumber smallint PRIMARY KEY NOT NULL,
    roomType varchar(6),
    microwave boolean,
    refridgerator boolean,
    kitchen boolean,
    stovOven boolean,
    jacuzzi boolean,
    ada boolean,
    CONSTRAINT fk_room_type
		FOREIGN KEY (roomType)
        REFERENCES roomType(roomType)
);


CREATE TABLE reservations(
	reservationId int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    roomNumber smallint NOT NULL,
    reservationName varchar(50),
    numberAdults smallint,
	numberChildren smallint,
    startDate datetime,
    endDate datetime,
    price double,
    CONSTRAINT fk_room
		FOREIGN KEY (roomNumber)
        REFERENCES room(roomNumber)
);


CREATE TABLE guests(
	reservationId int PRIMARY KEY NOT NULL,
	guestName varchar(50),
    address varchar(25),
    city varchar(30),
    state char(2),
    zipcode tinyint,
    phone varchar(12),
    CONSTRAINT fk_reservations 
		FOREIGN KEY (reservationId) 
        REFERENCES reservations(reservationId)
);