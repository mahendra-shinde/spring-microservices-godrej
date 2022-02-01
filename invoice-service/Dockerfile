FROM openjdk:8-jdk
COPY target/*.jar /app/invoice-service.jar
ENV EUREKA_SERVER=localhost
CMD ["java","-jar","/app/invoice-service.jar","--EUREKA_SERVER=${EUREKA_SERVER}"]