DROP TABLE IF EXISTS todo;
create table todo (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, username varchar(20) not null, description varchar(50), isdone boolean, phonenumber bigint not null);

DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  email VARCHAR(50) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (email)
);


CREATE TABLE authorities (
  email VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (email) REFERENCES users(email)
);


CREATE UNIQUE INDEX ix_auth_email on authorities (email,authority);





--DROP TABLE IF EXISTS authorities;
--CREATE TABLE authorities (username VARCHAR(50) NOT NULL, authority VARCHAR(50) NOT NULL,CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username));