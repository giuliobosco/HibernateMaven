/*
 * HibernateMaven.
 *
 * @author giuliobosco
 * @version 1.0
 */
DROP DATABASE IF EXISTS addtodatabase;
CREATE DATABASE addtodatabase;

USE addtodatabase;

CREATE TABLE utenti(
	ID INT PRIMARY KEY,
    nome VARCHAR (50),
    cognome VARCHAR (50),
    anni INT
);

CREATE TABLE amministratore(
	ID INT PRIMARY KEY ,
    id_utente INT,
    nome VARCHAR (50),
    FOREGIN KEY(id_utente) REFERENCES utenti(ID)
);