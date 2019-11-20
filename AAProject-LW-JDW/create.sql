DROP TABLE groepen PURGE;
DROP TABLE resmom PURGE;
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

CREATE TABLE Reservaties (
	rid   integer PRIMARY KEY,
	login varchar(20),
	mid   integer,
        FOREIGN KEY (mid) REFERENCES Machines(mid),
        FOREIGN KEY (login) REFERENCES Gebruikers(login) 
);

CREATE TABLE Momenten (
	moid  integer PRIMARY KEY,
	mid   integer,
	strt  integer,
	datum date,
        FOREIGN KEY (mid) REFERENCES Machines(mid)
);

CREATE TABLE Resmom (
	rid   integer,
	moid  integer,
        FOREIGN KEY (rid) REFERENCES Reservaties(rid),
        FOREIGN KEY (moid) REFERENCES Momenten(moid)
);


insert into Gebruikers values ('r0614393', 'passwd', 'Laurens Wuyts', 'MasterEi');
insert into Gebruikers values ('r0614941', 'passwd', 'Jonas De Wit', 'MasterEi');
insert into Gebruikers values ('admin', 'admin', '', '');

insert into Groepen values ('r0614393', 'Student');
insert into Groepen values ('r0614941', 'Extern');
insert into Groepen values ('admin', 'Docent');