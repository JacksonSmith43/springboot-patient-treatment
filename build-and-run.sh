#!/bin/bash

echo "Baue das Spring Boot Projekt mit Maven..."
./mvnw clean package -DskipTests

if [ $? -ne 0 ]; then
  echo "Maven-Build fehlgeschlagen. Abbruch."
  exit 1
fi

echo "Starte Docker Compose Build & Run..."
docker-compose up -d --build

echo "Alles läuft im Hintergrund. Container-Status:"
docker ps