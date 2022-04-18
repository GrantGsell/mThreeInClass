DROP DATABASE IF EXISTS books;
CREATE DATABASE books;
USE books;
#DROP TABLE book, authorBook, author, bookFormat, formatTable, bookGenre, genre;


CREATE TABLE book(
	bookId INT PRIMARY KEY,
    title varchar(100),
    publicationDate DATETIME
);



CREATE TABLE author(
	authorId INT PRIMARY KEY NOT NULL,
    firstName varchar(25) NOT NULL,
    middleName varchar(25),
    lastName varchar(50) NOT NULL,
    gender char(1),
    dateOfBirth DATETIME NOT NULL,
    dateOfDeath DATETIME
);

CREATE TABLE formatTable(
	formatId INT PRIMARY KEY NOT NULL,
    formatName varchar(12)
);

CREATE TABLE authorBook(
	authorId INT NOT NULL,
    bookId INT NOT NULL,
    CONSTRAINT pk_authorBook
		primary key (authorId, bookId),
    CONSTRAINT fk_bookId
		foreign key (bookId) references book(bookId),
	CONSTRAINT fk_authorId
		FOREIGN KEY (authorId) references author(authorId)
);

CREATE TABLE bookFormat(
	bookId INT NOT NULL,
    formatId INT NOT NULL,
	price double,
    quantityOnHand INT,
    CONSTRAINT pk_bookFormat
		PRIMARY KEY (bookId, formatId),
    CONSTRAINT fk_bookId
		foreign key (bookId) references book(bookId),
	CONSTRAINT fk_formatId
		foreign key (formatId) references formatTable(formatId)
);

/*


CREATE TABLE bookGenre(
	bookId INT PRIMARY KEY,
    genreId INT PRIMARY KEY,
    CONSTRAINT pk_bookGenre
		primary key (bookId, genreId),
    CONSTRAINT fk_bookId
		foreign key (bookId) references book(bookId),
	CONSTRAINT fk_genreId
		foreign key (genreId) references genre(genreId)
);

CREATE TABLE genre(
	genreID INT NOT NULL,
    genreName varchar(25)
);
*/