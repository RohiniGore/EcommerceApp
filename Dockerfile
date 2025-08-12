# Use the official Maven image with JDK 17 to build the application

FROM maven:3.8.5-openjdk-17 AS build
 
# Set the working directory within the container

WORKDIR /ecommerce-app
 
# Copy the necessary files and directories into the container

COPY pom.xml .

COPY src ./src
 
# Build the application using Maven

RUN mvn clean package
 
# Use a lightweight OpenJDK image to run the application

FROM openjdk:17-jdk-slim
 
# Set the working directory within the container

WORKDIR /ecommerce-app
 
# Copy the built JAR file from the build stage

COPY --from=build /ecommerce-app/target/*.jar app.jar
 
# Expose port 8083 for the Java application

EXPOSE 8083
 
# Define the command to run the Java application

CMD ["java", "-jar", "app.jar"]
 
