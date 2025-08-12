# Stage 1: Build the application using Maven and JDK 17
FROM maven:3.9.4-eclipse-temurin-17 AS build
 
# Set working directory inside the container
WORKDIR /EcommerceApp
 
# Copy Maven wrapper and pom.xml
COPY EcommerceApp/pom.xml .


 
# Fix permission issue for mvnw
RUN chmod +x mvnw
 
# Download dependencies
RUN mvn dependency:go-offline
 
# Copy the source code
COPY EcommerceApp/src ./src
 
# Build the application
RUN ./mvnw clean package -DskipTests
 
# Stage 2: Run the application using a lightweight JDK 17 image
FROM eclipse-temurin:17-jdk-alpine
 
# Set working directory
WORKDIR /EcommerceApp
 
# Copy the built jar file
COPY --from=build /ecommerce-app/target/*.jar EcommerceApp.jar
 
# Expose the application port
EXPOSE 8083
 
# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "EcommerceApp.jar"]
