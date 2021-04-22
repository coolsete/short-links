FROM openjdk:8-jdk-alpine

RUN mkdir /app

COPY ./build/libs/shorter-*-SNAPSHOT.jar /app/shorter.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar","/app/shorter.jar"]
