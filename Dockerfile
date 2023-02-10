FROM openjdk:8-jdk-alpine
MAINTAINER retobackend
RUN addgroup -S spring && adduser -S spring -S spring
USER spring:spring
COPY "./target/reto-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]