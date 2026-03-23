# Dockerfile para Spring Boot + Oracle
FROM eclipse-temurin:21-jre

# Variables de entorno para Oracle
ENV ORACLE_DB_HOST=oracle-db
ENV ORACLE_DB_PORT=1521
ENV ORACLE_DB_SID=XE
ENV ORACLE_DB_USER=appuser
ENV ORACLE_DB_PASSWORD=apppassword

WORKDIR /app

COPY build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]
