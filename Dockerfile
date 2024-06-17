FROM openjdk:17-jdk-alpine
VOLUME /tmp
EXPOSE 5000
COPY target/springtodo-v3-authentication-0.0.1-SNAPSHOT.jar springtodo-auth-demo.jar
ENTRYPOINT ["java","-jar","/springtodo-auth-demo.jar"]