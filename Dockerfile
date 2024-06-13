FROM openjdk:17-jdk-alpine
VOLUME /tmp
EXPOSE 5000
COPY target/springtodo-v2-0.0.1-SNAPSHOT.jar springtodo-demo.jar
ENTRYPOINT ["java","-jar","/springtodo-demo.jar"]