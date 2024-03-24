psql -U postgres
himitu

DROP DATABASE IF EXISTS googlemap;
DROP USER IF EXISTS kouki;
CREATE ROLE kouki WITH SUPERUSER LOGIN PASSWORD 'himitu';
CREATE DATABASE googlemap OWNER kouki ENCODING 'UTF8';
GRANT ALL ON DATABASE googlemap TO kouki;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO kouki;

\c googlemap kouki
himitu

CREATE TABLE users (
	usersid SERIAL,
	name TEXT,
	pass TEXT,
	email TEXT,
	sex INTEGER,
	birthday TEXT
);

CREATE TABLE posts (
	postid SERIAL,
	userid INTEGER,
	shopid TEXT,
	postdate TEXT,
	shopname TEXT,
	lat TEXT,
	lng TEXT,
	comment TEXT,
	recscene INTEGER,
	url TEXT,
	evaluate INTEGER,
	goods INTEGER
);

GRANT ALL ON users TO kouki;
INSERT INTO users(name, pass, email, sex, birthday) VALUES('koki', '9d4e1e23bd5b727046a9e3b4b7db57bd8d6ee684', 'koki@gmail.com', 1, 20000413);
\q
