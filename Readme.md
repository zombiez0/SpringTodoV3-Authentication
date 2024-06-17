Login credentials
Username : test@x.com
Password : test


This projects creates docker container from Dockerfile and pushes it to
chetananand87/${project.artifactId}

1) Docker push command
docker push chetananand87/springtodo-v2:0.0.1-SNAPSHOT

2) Run mysql docker container
docker run -d -e MYSQL_ROOT_PASSWORD=administrator -e MYSQL_DATABASE=tododb -e MYSQL_USERNAME=root -p 3306:3306 --name mysql mysql


2) Run Application docker container
docker run -e RDS_HOSTNAME=host.docker.internal -p 5000:5000 --link mysql:mysql chetananand87/springtodo-v2:0.0.1-SNAPSHOT

To Stop
docker container stop <container-id>



Spring Security
===================================================
1) Code
a) https://www.codejava.net/frameworks/spring-boot/form-authentication-with-jdbc-and-mysql  
b) https://www.baeldung.com/spring-security-jdbc-authentication


2) SQL, schemas
https://www.baeldung.com/spring-security-jdbc-authentication


3) Video tut
https://www.youtube.com/watch?v=TeBt0Ike_Tk




