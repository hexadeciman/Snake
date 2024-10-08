FROM openjdk:17-jdk-slim

# Install required libraries for GUI, including libfreetype6 for font rendering
RUN apt-get update && \
    apt-get install -y \
    libxext6 \
    libx11-6 \
    libxrender1 \
    libxtst6 \
    libfreetype6 \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY SnakeGame.jar /app/SnakeGame.jar

ENTRYPOINT ["java", "-jar", "/app/SnakeGame.jar"]