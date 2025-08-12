# Use an official Maven image with JDK 17
FROM maven:3.9.4-eclipse-temurin-17 AS build
 
# Set working directory
WORKDIR /EcommerceApp
 
# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline
 
# Copy source code
COPY src ./src
 
# Package the application
RUN mvn clean package -DskipTests
 
# Use a lightweight JDK 17 runtime image
FROM eclipse-temurin:17-jdk-alpine
 
# Set working directory
WORKDIR /EcommerceApp
 
# Copy the jar from the build stage
COPY --from=build /EcommerceApp/target/*.jar EcommerceApp.jar
 
# Expose the port your Spring Boot app runs on
EXPOSE 8080
 
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
 
EXPOSE 8083
 
# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "EcommerceApp.jar"]
