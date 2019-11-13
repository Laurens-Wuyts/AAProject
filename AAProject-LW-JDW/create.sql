DROP TABLE groepen PURGE;
DROP TABLE gebruikers PURGE;
DROP TABLE machines PURGE;

CREATE TABLE gebruikers (
	login varchar2(20) PRIMARY KEY,
	pwd   varchar(20),
	gnaam varchar(20),
	opl   varchar(10)	
);

CREATE TABLE groepen (
	login varchar2(20) REFERENCES gebruikers PRIMARY KEY,
	groep varchar2(20)
);

CREATE TABLE machines (
	mid   integer PRIMARY KEY,	-- ID
	mnaam varchar(20),	-- Machine Naam
	minfo varchar(200),	-- Machine Info
	mopl  varchar(10),	-- Machine Opleiding
	msnr  integer,		-- Machine Serienummer
	aprs  integer,		-- Aankoopprijs
	hprs  integer		-- Huurprijs
);

CREATE TABLE reservaties (
	rid   integer PRIMARY KEY,
	login varchar(20) REFERENCES gebruikers PRIMARY KEY,
	mid   integer REFERENCES machines PRIMARY KEY	
);

CREATE TABLE momenten (
	moid  integer PRIMARY KEY,
	mid   integer REFERENCES machines PRIMARY KEY,
	start integer,
	datum date
);

CREATE TABLE resmom (
	rid   integer REFERENCES reservaties PRIMARY KEY,
	moid  integer REFERENCES momenten PRIMARY KEY
);