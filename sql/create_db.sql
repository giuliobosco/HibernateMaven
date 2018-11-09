DROP DATABASE IF EXISTS tutorialDb;
CREATE DATABASE tutorialDb;

USE tutorialDb;

CREATE TABLE tutorialDb.user_table (
	user_id      INT(20)      NOT NULL,
	user_name    VARCHAR(255) NOT NULL,
	created_by   VARCHAR(255) NOT NULL,
	created_date DATE         NOT NULL,

	PRIMARY KEY (user_id)
);