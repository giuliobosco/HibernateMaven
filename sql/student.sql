create schema websystique;

create table websystique.STUDENT (
   id INT NOT NULL auto_increment PRIMARY KEY,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   section    VARCHAR(30) NOT NULL
);