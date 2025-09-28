FROM eclipse-temurin:17-jre

# Add metadata
LABEL maintainer="MiBanco DevSecOps Team"
LABEL version="1.0.0"
LABEL description="MiBanco DevSecOps Challenge Application"

# Create non-root user for security
RUN groupadd -r appuser && useradd -r -g appuser appuser

# Set working directory
WORKDIR /app

# Copy JAR file
COPY target/*.jar app.jar

# Change ownership to non-root user
RUN chown -R appuser:appuser /app
USER appuser

# Expose port
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
  CMD curl -f http://localhost:8080/mibanco/actuator/health || exit 1

# Run application
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=70.0", "-jar", "app.jar"]