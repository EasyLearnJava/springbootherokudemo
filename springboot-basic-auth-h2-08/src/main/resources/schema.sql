drop table if exists customer;

CREATE  TABLE customer (
	id integer NOT Null AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL ,
  role VARCHAR(45) NOT NULL ,
  emailid VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  PRIMARY KEY (id),
  UNIQUE KEY username (username));