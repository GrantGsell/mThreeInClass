USE hoteldb;

-- Clear Table: roomType
SET SQL_SAFE_UPDATES = 0;
DELETE FROM roomType WHERE true;
SET SQL_SAFE_UPDATES = 1;

-- Populate Table: roomType
LOAD DATA LOCAL INFILE "C:/Users/Grant/Desktop/mThreeInClass/MySQL/roomtype_db.csv"
INTO TABLE hoteldb.roomType
FIELDS TERMINATED BY ",";


-- Clear Table: room
SET SQL_SAFE_UPDATES = 0;
DELETE FROM room WHERE true;
SET SQL_SAFE_UPDATES = 1;

-- Populate Table: room
LOAD DATA LOCAL INFILE "C:/Users/Grant/Desktop/mThreeInClass/MySQL/room_db.csv"
INTO TABLE hoteldb.room
FIELDS TERMINATED BY ",";


-- Clear Table: guests
SET SQL_SAFE_UPDATES = 0;
-- DELETE FROM guests WHERE true;
SET SQL_SAFE_UPDATES = 1;

-- Populate Table: guests
LOAD DATA LOCAL INFILE "C:/Users/Grant/Desktop/mThreeInClass/MySQL/guests_db.csv"
INTO TABLE hoteldb.guests
FIELDS TERMINATED BY ","
LINES TERMINATED BY "\n"
(
	@guestId,
	@guestName,
    @address,
    @city,
    @state,
    @zipcode,
    @phoneNumber
)
SET
	guestId = @guestId,
	guestName = @guestName,
    address = @address,
    city = @city,
    state = @state,
    zipcode = @zipcode,
    phone = @phoneNumber
;


-- Clear Table: reservations
Set SQL_SAFE_UPDATES = 0;
DELETE FROM reservations WHERE true;
SET SQL_SAFE_UPDATES = 1;

-- Populate Table: 
LOAD DATA LOCAL INFILE "C:/Users/Grant/Desktop/mThreeInClass/MySQL/reservations.csv"
INTO TABLE hoteldb.reservations
FIELDS TERMINATED BY ","
LINES TERMINATED BY "\n"
(
	@roomNumber,
    @reservationName,
    @numAdults,
    @numChildren,
    @startDate,
    @endDate,
    @price,
    @guestId
)
SET 
	roomNumber = @roomNumber,
	reservationName = @reservationName,
    numberAdults = @numAdults,
    numberChildren = @numChildren,
    startDate = @startDate,
    endDate = @endDate,
    price = @price,
    guestId = @guestId
;



-- Check all table data
SELECT * FROM reservations;
SELECT * FROM roomType;
SELECT * FROM room;
SELECT * FROM guests;