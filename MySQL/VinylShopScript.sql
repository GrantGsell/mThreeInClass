USE vinylrecords;
DROP TABLE album, artist, band, song, songAlbum, bandArtist;


CREATE TABLE album (
    albumId INT AUTO_INCREMENT,
    albumTitle VARCHAR(100) NOT NULL,
    label VARCHAR(50),
    releaseDate DATE,
    price DECIMAL(5,2),
    CONSTRAINT pk_album 
        PRIMARY KEY (albumId)
);

CREATE TABLE artist(
	artistId INT auto_increment primary key,
    artistFirstName varchar(50),
    artistLastName varchar(50)
);

CREATE TABLE band(
	bandId INT auto_increment primary key,
    bandName varchar(50)
);

CREATE TABLE song (
    songId INT NOT NULL AUTO_INCREMENT,
    songTitle VARCHAR(100) NOT NULL,
    videoUrl VARCHAR(100),
    bandId INT NOT NULL,
    CONSTRAINT pk_song 
    	PRIMARY KEY (songId),
    CONSTRAINT fk_song_band 
    	FOREIGN KEY (bandID)
    	REFERENCES band(bandId)
);

CREATE TABLE songAlbum (
    songId INT,
    albumId INT,
    CONSTRAINT pk_songAlbum 
    	PRIMARY KEY (songId, albumId),
    CONSTRAINT fk_songAlbum_song
    	FOREIGN KEY (songId)
    	REFERENCES song(songId),
    CONSTRAINT fk_songAlbum_album
    	FOREIGN KEY (albumId)
    	REFERENCES album(albumId)
);

CREATE TABLE bandArtist(
	bandId int, 
    artistId int,
    constraint pk_bandArtist
		primary key (bandId, artistId),
    constraint fk_bandArtist_band
		foreign key (bandId) references band(bandId),
	constraint fk_bandArtist_artist
		foreign key (artistId) references artist(artistID)
);