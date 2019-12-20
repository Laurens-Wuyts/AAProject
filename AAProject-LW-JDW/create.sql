DROP TABLE groepen PURGE;
DROP TABLE reservaties PURGE;
DROP TABLE momenten PURGE;
DROP TABLE gebruikers PURGE;
DROP TABLE machines PURGE;

CREATE TABLE Gebruikers (
	login varchar2(20) PRIMARY KEY,
	pwd   varchar(20),
	gnaam varchar(20),
	opl   varchar(10)	
);

CREATE TABLE Groepen (
	login varchar2(20) REFERENCES gebruikers PRIMARY KEY,
	groep varchar2(20)
);

CREATE TABLE Machines (
	mid   integer PRIMARY KEY,	-- ID
	mnaam varchar(20),	-- Machine Naam
	minfo varchar(200),	-- Machine Info
	mopl  varchar(10),	-- Machine Opleiding
	msnr  integer,		-- Machine Serienummer
	aprs  integer,		-- Aankoopprijs
	hprs  integer		-- Huurprijs
);

CREATE TABLE Momenten (
	moid  integer PRIMARY KEY,
	mid   integer,
	strt  integer,
	datum date,
        FOREIGN KEY (mid) REFERENCES Machines(mid) ON DELETE CASCADE
);

CREATE TABLE Reservaties (
	rid   integer PRIMARY KEY,
	login varchar(20),
        moid  integer,
        FOREIGN KEY (login) REFERENCES Gebruikers(login) ON DELETE CASCADE,
        FOREIGN KEY (moid) REFERENCES Momenten(moid) ON DELETE CASCADE
);

insert into Gebruikers values ('r0614393', 'passwd', 'Laurens Wuyts', 'MasterEi');
insert into Gebruikers values ('r0614941', 'passwd',  'Jonas De Wit', 'MasterEi');
insert into Gebruikers values ( 'student', 'passwd',       'Student', 'MasterEi');
insert into Gebruikers values (  'extern', 'passwd',        'Extern', 'MasterEi');
insert into Gebruikers values (   'admin',  'admin',         'Admin', 'MasterEi');
insert into Gebruikers values ( 'docChem',  'admin',         'Admin',     'chem');

insert into Groepen values ('student', 'Student');
insert into Groepen values ('extern', 'Extern');
insert into Groepen values ('r0614393', 'Student');
insert into Groepen values ('r0614941', 'Extern');
insert into Groepen values ('admin', 'Docent');
insert into Groepen values ('docChem', 'Docent');

insert into Machines values (1, 'Computer 1', 'Lokaal A202', 'MasterEi', 1234, 350, 5);
insert into Machines values (2, 'Computer 2', 'Lokaal A202', 'MasterEi', 5678, 250, 5);
insert into Machines values (3, 'Computer 3', 'Lokaal A202', 'MasterEi', 9101, 400, 5);
insert into Machines values (4, 'Computer 4', 'Lokaal C106', 'chem', 1121, 2000, 50);
insert into Machines values (5, 'Computer 5', 'Lokaal C106', 'chem', 3141, 2000, 50);

insert into Momenten values ( 1, 2, 11, TO_DATE('27/12/2019', 'DD/MM/YYYY'));
insert into Momenten values ( 2, 2, 12, TO_DATE('27/12/2019', 'DD/MM/YYYY'));
insert into Momenten values ( 3, 2, 13, TO_DATE('27/12/2019', 'DD/MM/YYYY'));
insert into Momenten values ( 4, 2, 11, TO_DATE('28/12/2019', 'DD/MM/YYYY'));
insert into Momenten values ( 5, 3, 11, TO_DATE('30/12/2019', 'DD/MM/YYYY'));
insert into Momenten values ( 6, 3,  9, TO_DATE('01/12/2019', 'DD/MM/YYYY'));
insert into Momenten values ( 7, 1, 10, TO_DATE('27/12/2019', 'DD/MM/YYYY'));
insert into Momenten values ( 8, 5, 12, TO_DATE('28/12/2019', 'DD/MM/YYYY'));
insert into Momenten values ( 9, 4, 15, TO_DATE('30/12/2019', 'DD/MM/YYYY'));
insert into Momenten values (10, 2,  9, TO_DATE('14/01/2020', 'DD/MM/YYYY'));
insert into Momenten values (11, 2, 15, TO_DATE('15/01/2020', 'DD/MM/YYYY'));
insert into Momenten values (12, 2, 11, TO_DATE('17/01/2020', 'DD/MM/YYYY'));
insert into Momenten values (13, 2,  8, TO_DATE('22/01/2020', 'DD/MM/YYYY'));
insert into Momenten values (14, 2, 14, TO_DATE('28/01/2020', 'DD/MM/YYYY'));
insert into Momenten values (15, 3, 11, TO_DATE('13/01/2020', 'DD/MM/YYYY'));
insert into Momenten values (16, 1,  9, TO_DATE('16/01/2020', 'DD/MM/YYYY'));
insert into Momenten values (17, 1, 10, TO_DATE('17/01/2020', 'DD/MM/YYYY'));
insert into Momenten values (18, 5, 12, TO_DATE('28/01/2020', 'DD/MM/YYYY'));
insert into Momenten values (19, 5, 15, TO_DATE('29/01/2020', 'DD/MM/YYYY'));


insert into Reservaties values (1, 'r0614393', 3);
insert into Reservaties values (2, 'r0614941', 4);
insert into Reservaties values (3, 'admin', 7);