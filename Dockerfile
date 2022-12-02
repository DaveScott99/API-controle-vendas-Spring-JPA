FROM openjdk

WORKDIR /app/api

COPY target/api-webService-0.0.1-SNAPSHOT.jar /app/api/api-spring.jar

ENTRYPOINT ["java", "-jar", "api-spring.jar"]