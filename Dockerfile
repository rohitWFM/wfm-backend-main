# STAGE 1: Build the app
FROM eclipse-temurin:17-jdk as builder

WORKDIR /workspace

# Copy everything and build the app
COPY . .
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests

# STAGE 2: Run the app
FROM eclipse-temurin:17-jre

LABEL org.opencontainers.image.source="https://github.com/your-org/your-repo"
LABEL maintainer="devops@yourcompany.com"

WORKDIR /app

# Copy only the final JAR from builder stage
COPY --from=builder /workspace/target/*.jar app.jar

EXPOSE 8080

ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# Optional: Health check (enable Spring Boot actuator in your app first)
HEALTHCHECK --interval=30s --timeout=10s --start-period=30s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
