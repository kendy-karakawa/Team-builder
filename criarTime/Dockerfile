FROM maven AS build

WORKDIR /app/criar-time

COPY . .

RUN mvn clean package

FROM openjdk:17

EXPOSE 8080

WORKDIR /app

COPY --from=build /app/criar-time/target/criar-time*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]