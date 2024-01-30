CREATE TABLE Students (
 studentID char(9) NOT NULL,
 firstName varchar (20) NOT NULL,
 lastName varchar (20) NOT NULL,
 address varchar (30) NOT NULL,
 city varchar(30) NOT NULL,
 province char(2) NOT NULL,
 postalCode char(6) NOT NULL,
 PRIMARY KEY (studentID)
);


-- Ontario
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('300111222', 'Sam', 'Malone', '10 Somewhere Road', 'Toronto', 'ON', 'M1Y2H2');

-- Quebec
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('300222333', 'Diane', 'Chambers', '15 Any Street', 'Montreal', 'QC', 'H3Z1X1');

-- British Columbia
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('300333444', 'Woody', 'Boyd', '20 Another Avenue', 'Vancouver', 'BC', 'V6E3M9');

-- Alberta
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('300444555', 'Cliff', 'Clavin', '25 Random Lane', 'Calgary', 'AB', 'T2P0L6');

-- Nova Scotia
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('300555666', 'Carla', 'Tortelli', '30 Unpredictable Blvd', 'Halifax', 'NS', 'B3H2K5');


SELECT * FROM STUDENTS;

------------
-- Manitoba
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('300666777', 'Norm', 'Peterson', '35 Friendly Street', 'Winnipeg', 'MB', 'R3C2E1');

-- Saskatchewan
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('300777888', 'Rebecca', 'Howe', '40 Sunny Lane', 'Saskatoon', 'SK', 'S7N1W4');

-- New Brunswick
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('300888999', 'Frasier', 'Crane', '45 Intellectual Avenue', 'Fredericton', 'NB', 'E3B5A7');

-- Prince Edward Island
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('300999000', 'Lilith', 'Sternin', '50 Rational Road', 'Charlottetown', 'PE', 'C1A7Z2');

-- Newfoundland and Labrador
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('301000111', 'Eddie', 'LeBec', '55 Hockey Street', 'St. John’s', 'NL', 'A1A5T5');

-- Northwest Territories
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('301111222', 'Kelly', 'Gaines', '60 Aurora Avenue', 'Yellowknife', 'NT', 'X1A2L9');

-- Yukon
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('301222333', 'Caroline', 'Henley', '65 Wilderness Lane', 'Whitehorse', 'YT', 'Y1A3E5');

-- Nunavut
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('301333444', 'Gary', 'Portico', '70 Iceberg Road', 'Iqaluit', 'NU', 'X0A0H0');

-- Alberta
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('301444555', 'Roz', 'Doyle', '75 Radio Lane', 'Edmonton', 'AB', 'T5J2T3');

-- Nova Scotia
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('301555666', 'Martin', 'Crane', '80 Opera Avenue', 'Halifax', 'NS', 'B3M1P3');

-- Ontario
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('301666777', 'Woody', 'Boyd', '85 Maple Street', 'Toronto', 'ON', 'M5H2N2');

-- Quebec
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('301777888', 'Carla', 'Tortelli', '90 Cheers Boulevard', 'Montreal', 'QC', 'H4B1R9');

-- British Columbia
INSERT INTO Students (studentID, firstName, lastName, address, city, province, postalCode)
VALUES ('301888999', 'Cliff', 'Clavin', '95 Knowledge Lane', 'Vancouver', 'BC', 'V5K3P7');
