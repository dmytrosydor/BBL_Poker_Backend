# -------- Build stage --------
    FROM gradle:8.5-jdk17 AS build
    WORKDIR /app
    
    # Copy Spring app
    COPY spring /app
    
    # Build the JAR
    RUN gradle build --no-daemon
    
    # -------- Runtime stage --------
    FROM eclipse-temurin:17-jdk
    WORKDIR /app
    
    # Copy the built JAR (adjust the JAR name if needed)
    COPY --from=build /app/build/libs/poker-0.0.1-SNAPSHOT.jar app.jar
    
    # Expose port 8080
    EXPOSE 8080
    
    # Run your Spring Boot application
    ENTRYPOINT ["java", "-jar", "app.jar"]
    