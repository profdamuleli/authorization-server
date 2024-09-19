# Build stage
# Runtime stage
# And ship it using docker
FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} authorization-server.jar

ENTRYPOINT ["java", "-jar", "authorization-server.jar"]

EXPOSE 8091