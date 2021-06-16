-- Database: test

-- DROP DATABASE test;

CREATE TABLE weatherWorldWide(
	city varchar(80),
	temp_lo int,
	temp_hi int,
	prcp real,
	pressure real,
	humidity real,
	wind int,
	date date

);
INSERT INTO weatherWorldWide VALUES ('Chisinau', 16, 24, 0.6, 29.95, 91, 5, '2021-06-17' );
INSERT INTO weatherWorldWide(city, temp_lo, temp_hi, prcp, pressure, humidity, wind, date)
VALUES ('New York', 14, 26, 0, 29.86, 28, 4, '2021-06-17' );
INSERT INTO weatherWorldWide VALUES ('London', 17, 22, 0.4, 29.81, 93, 5, '2021-06-16');
INSERT INTO weatherWorldWide VALUES ('Stockholm',10, 23, 0, 30.07, 72, 2, '2021-06-17');
SELECT * FROM weatherWorldWide;
SELECT city, (temp_lo + temp_hi) / 2 AS temp_average, wind, date FROM weatherWorldWide;
SELECT * FROM weatherWorldWide WHERE prcp=0;
SELECT * FROM weatherWorldWide WHERE temp_lo<=16 ORDER BY temp_lo DESC;