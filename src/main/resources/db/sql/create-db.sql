--DROP TABLE users IF EXISTS;

CREATE TABLE users (
  id INTEGER NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(30),
  lastName  VARCHAR(30),
  email VARCHAR(30),
  birthDate DATE
);

CREATE TABLE ticket (
  id INTEGER NOT NULL AUTO_INCREMENT,
  userId INTEGER,
  eventId INTEGER,
  dateTime TIMESTAMP,
  seat INTEGER,
  price DOUBLE
);

CREATE TABLE event (
  id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(30),
  basePrice DOUBLE,
  rating VARCHAR(30)
);

--CREATE TABLE eventSession (
--  id INTEGER NOT NULL AUTO_INCREMENT,
--  eventId INTEGER,
--  session TIMESTAMP,
--  auditoriumId INTEGER
--);

--for ascpects;
CREATE TABLE access_by_name_counter (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR(50),
	accessCount INTEGER
);

CREATE TABLE access_price_by_name_counter (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR(50),
	accessCount INTEGER
);

CREATE TABLE book_place_by_name_counter (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR(50),
	accessCount INTEGER
);

CREATE TABLE discount_counter (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR(50),
	discountCount INTEGER
);

CREATE TABLE discount_per_user_counter (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR(50),
	discountCount INTEGER
);