FROM openjdk:8
RUN mkdir eurekaser
COPY target/eureka-service-1.0.0.jar /eurekaser
WORKDIR /eurekaser
CMD ["java", "-jar", "eureka-service-1.0.0.jar"]