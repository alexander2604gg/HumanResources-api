FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/rrhh-project-0.0.1-SNAPSHOT.jar /app/rrhh-project.jar

EXPOSE 8080

# Reemplazamos la forma de pasar variables de entorno
CMD ["sh", "-c", "java -jar /app/rrhh-project.jar \
  --server.port=${SERVER_PORT} \
  --datasource.url=${DATASOURCE_URL} \
  --datasource.username=${DATASOURCE_USERNAME} \
  --datasource.password=${DATASOURCE_PASSWORD} \
  --security.jwt.private.key=${PRIVATE_KEY} \
  --security.jwt.user.generator=${USER_GENERATOR}"]
