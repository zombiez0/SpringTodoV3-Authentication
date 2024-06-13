DROP TABLE IF EXISTS todo;
create table todo (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, username varchar(20) not null, description varchar(50), isdone boolean, phonenumber bigint not null);