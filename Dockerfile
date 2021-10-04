#seleciona imagem para o build
FROM maven:3.6.0-jdk-11-slim AS build

WORKDIR /app

#copia o fonte projeto para o workdir
COPY ./ ./

RUN mvn clean package

COPY ./target/*.jar /app.jar

#criar a imagem docker do .jar

FROM openjdk:11-jre-slim

CMD ["java", "-jar", "/app.jar"]