FROM openjdk:8
RUN mkdir weatservice
COPY target/weather-service-1.0.0.jar /weatservice
WORKDIR /weatservice
CMD ["java", "-jar", "weather-service-1.0.0.jar"]