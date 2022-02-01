# Stage 1 : Build from source code
FROM maven:3-jdk-8 as build
WORKDIR /app
COPY . .
RUN ["mvn","package","-DskipTests"]

FROM openjdk:8-jdk
COPY --from=build /app/target/eureka-server-1.0.jar /app/eureka-server.jar
CMD ["java","-jar","/app/eureka-server.jar"]