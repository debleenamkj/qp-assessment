
# Use the official OpenJDK base image
FROM openjdk:17-jdk-alpine

# Set the working directory within the container
WORKDIR /app

# Copy the JAR file from the target directory to the container
COPY target/grocery.booking-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the application will run on
EXPOSE 8081

# Define the default command to run the application when the container starts
CMD ["java", "-jar", "app.jar"]
