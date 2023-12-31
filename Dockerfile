FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY build/libs/appl.jar build/

WORKDIR /app/build
EXPOSE 8082
CMD ["java", "-jar", "/app/build/appl.jar"]