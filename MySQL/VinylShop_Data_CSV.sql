USE vinylrecordshop;

-- Delete all previous artist records --
DELETE FROM artist WHERE artistId < 30;
-- Read in data from csv file
LOAD DATA LOCAL INFILE "C:/Users/Grant/Desktop/mThreeInClass/MySQL/artist.csv"
INTO TABLE vinylrecordshop.artist 
FIELDS TERMINATED BY ',';

-- 


SELECT * from artist;