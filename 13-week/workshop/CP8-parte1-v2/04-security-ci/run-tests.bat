@echo off
cd /d "%~dp0court-service"
echo Running court-service negative authorization test with Docker...
docker run --rm -v "%cd%":/app -v futbolix-m2:/root/.m2 -w /app maven:3.9-eclipse-temurin-21 mvn -B test -Dtest=AdminCourtAuthorizationTest
pause
