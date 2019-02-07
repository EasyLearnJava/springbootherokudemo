drop table if exists customers;

CREATE  TABLE customers (
	id integer NOT Null AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL ,
  role VARCHAR(45) NOT NULL ,
  emailid VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  PRIMARY KEY (id),
  UNIQUE KEY username (username));