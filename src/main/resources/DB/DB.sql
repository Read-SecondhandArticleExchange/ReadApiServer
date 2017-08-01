DROP TABLE IF EXISTS read.User;

CREATE TABLE read.User(
  `userId` bigint(20) Not Null primary Key,
  `nickName` varchar(50) Not Null,
  `profile_url` varchar(200) Not Null,
  `book_point` bigint(20) default 0 Not Null,
  `latitude` double,
  `longitude` double,
  `address` varchar(200),
  `userName` varchar(50),
  `phoneNumber` varchar(50)
);

DROP TABLE IF EXISTS read.Book;

CREATE TABLE read.Book(
  `bookId` char(36) Not Null Primary key,
  `author` varchar(50) Not Null,
  `translator` varchar(50) Not Null,
  `publisher` varchar(100) Not Null,
  `title` varchar(100) Not Null,
  `category` varchar(50) Not Null,
  `cover_url` varchar(200) Not Null,
  `isbn` varchar(100) Not Null,
  `publication` varchar(100)
);

DROP TABLE IF EXISTS read.Log;

CREATE TABLE read.Log(
  `userId` bigint(20) Not Null,
  `bookId` char(36) Not Null,
  `status` bigint(20) Not Null default 1,
  `address` varchar(200) Not NULL,
  `latitude` double Not Null,
  `longitude` double Not Null,
  `latest` DateTime Not NULL,
  `sequence` Long default 1 Not Null
);


DROP PROCEDURE IF EXISTS read.bookInsert;

DELIMITER $$
CREATE PROCEDURE read.bookInsert(userId bigint(20),author varchar(50),translator varchar(50), publisher varchar(100), title varchar(100), category varchar(50), cover_url varchar(200), isbn varchar(100), latitude double, longitude double)
begin
	SET @id:=UUID();
    INSERT INTO read.Book(bookId, author, translator, publisher, title, category, cover_url, isbn)
    VALUES(@id,author,translator, publisher, title, category, cover_url, isbn);

    SET @address = (SELECT address FROM read.User u WHERE u.userId=userId);

    INSERT INTO read.Log(userId,bookId,status,address,latitude,longitude,latest)
    VALUES(userId, @id, 1,@address, latitude, longitude, now());
end $$
DELIMITER ;

DROP PROCEDURE IF EXISTS read.mySequence;

DELIMITER $$
CREATE PROCEDURE read.mySequence(bookId varchar(36), userId bigint(20))
begin
	SET @ROWNUM:=0;
	SELECT @ROWNUM AS mySequence
	FROM(
		SELECT c.userId, c.bookId, @ROWNUM:=@ROWNUM+1
		FROM read.Log c
		WHERE c.bookId = bookId
		) ASD
	WHERE ASD.userId = userId;
end $$
DELIMITER ;
