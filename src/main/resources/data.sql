insert into todo(username,description,isdone,phonenumber)
values('admin', 'Learn JPA', false, 9739667751);

insert into todo(username,description,isdone,phonenumber)
values('admin', 'Learn Data JPA', false, 9739667752);

insert into todo(username,description,isdone,phonenumber)
values('chetan', 'Learn Microservices', true, 9739667753);


INSERT INTO users (username, password, email, enabled) VALUES ('demo', '$2a$12$AW2FnekfFpnoqEN2Yd9MROksDOQGPl0Wdiy2Qe5RNdxkqrjStp9zq', 'test@x.com', 1);  /* test is the password */
INSERT INTO authorities (email, authority) VALUES ('test@x.com', 'ROLE_ADMIN');
