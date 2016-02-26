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


--for ascpects;
--CREATE TABLE event_counter (
--	id INTEGER NOT NULL AUTO_INCREMENT,
--	event_id INTEGER,
--	count_access_event INTEGER,
--	count_access_event_price INTEGER,
--	count_booked_ticket INTEGER
--);

--CREATE TABLE discount_counter (
--	id INTEGER NOT NULL AUTO_INCREMENT,
--	name VARCHAR(50),
--	count INTEGER
--);

--CREATE TABLE lucky_winner_counter (
--	id INTEGER NOT NULL AUTO_INCREMENT,
--	user_id INTEGER,
--	count INTEGER
--);

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