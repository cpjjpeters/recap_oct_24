# Dockerfile for "recap" application using Java 21
# Use an ARM-compatible base image with Java 21
FROM eclipse-temurin:21-jre
# Use an official Azul Java runtime as a parent image
#FROM azul/zulu-openjdk:21
# Set the working directory in the container
WORKDIR /app

# Copy application code into the container
COPY . /app

# Compile the application if needed, assuming it's a Maven or Gradle project
# Uncomment and modify the line based on your build tool
# RUN ./mvnw clean install -DskipTests  # For Maven
# RUN ./gradlew build -x test           # For Gradle

# Set the JAR file as the entry point (replace 'app.jar' with your JAR name)
COPY target/recap-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080

# Set the default command to run the application
CMD ["java", "-jar", "/app/app.jar"]