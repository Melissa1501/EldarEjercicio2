# Build stage
FROM maven:3.9.9-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Package stage
FROM openjdk:21-jdk
COPY --from=build /target/api-0.0.1-SNAPSHOT.jar api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","api.jar"]