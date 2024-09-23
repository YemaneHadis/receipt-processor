FROM maven:3.9.9-ibm-semeru-21-jammy AS build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:17-oracle
WORKDIR /app
COPY --from=build /app/target/receipt-processor-0.0.1-SNAPSHOT.jar /app/receipt-processor.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/receipt-processor.jar"]
