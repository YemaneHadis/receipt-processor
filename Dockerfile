FROM openjdk:17-oracle
WORKDIR /app
COPY target/receipt-processor-0.0.1-SNAPSHOT.jar /app/receipt-processor.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/receipt-processor.jar"]
