# Stage 1 : Build from source code
FROM openjdk:8-jdk as build
WORKDIR /app
COPY . .
RUN ["./mvnw","package","-DskipTests"]

FROM openjdk:8-jdk
ENV servicePort=8080
COPY --from=build /app/target/*.jar /app/product-service.jar
CMD ["java","-jar","/app/product-service.jar"]