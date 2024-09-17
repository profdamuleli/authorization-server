# Build stage
FROM maven:3.8.8-openjdk:17 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM amazoncorretto:17
# Define few things

WORKDIR /app
COPY --from=buid /build/target/authorization-server-*.jar /app/

EXPOSE 8080

CMD java -jar authorization-server-1.0.0.jar