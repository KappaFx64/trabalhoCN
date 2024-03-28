FROM openjdk:17-jdk-slim

EXPOSE 8080
WORKDIR /app
COPY ./target/demo-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java", "-jar", "demo.jar"]
