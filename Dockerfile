# -------- Build stage --------
    FROM gradle:8.5-jdk17 AS build
    WORKDIR /app
    
    # Copy Gradle metadata first (for better layer caching)
    COPY spring/build.gradle spring/settings.gradle /app/
    RUN gradle --no-daemon clean build || true
    
    # Now copy the full Spring Boot app
    COPY spring /app
    RUN gradle build --no-daemon
    
    # -------- Runtime stage --------
    FROM eclipse-temurin:17-jdk
    WORKDIR /app
    
    # Copy the built JAR
    COPY --from=build /app/build/libs/poker-0.0.1-SNAPSHOT.jar app.jar
    
    EXPOSE 8080
    ENTRYPOINT ["java", "-jar", "app.jar"]