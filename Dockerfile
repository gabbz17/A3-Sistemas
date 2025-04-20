# Use uma imagem base do OpenJDK
FROM openjdk:21-jdk-slim

# Cria um diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR da aplicação (assume que só há um JAR no target/)
COPY target/*.jar app.jar

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]