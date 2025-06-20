FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/grupo5-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_proyecto_soa.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app_proyecto_soa.jar"]