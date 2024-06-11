FROM openjdk:17-oracle

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN sed -i 's/\r$//' mvnw && chmod +x mvnw

RUN ./mvnw dependency:go-offline

CMD ["./mvnw", "spring-boot:run"]