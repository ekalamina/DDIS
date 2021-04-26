FROM openjdk:8
RUN mkdir predservice
COPY target/prediction-service-1.0.0.jar /predservice
WORKDIR /predservice
CMD ["java", "-jar", "prediction-service-1.0.0.jar"]