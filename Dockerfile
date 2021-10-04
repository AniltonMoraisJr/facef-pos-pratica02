#seleciona imagem para o build
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
#criar a imagem docker do .jar
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/atividade-0.0.1-SNAPSHOT.jar /usr/local/lib/atividade.jar

ENTRYPOINT ["java", "-jar", "/usr/local/lib/atividade.jar"]