FROM eclipse-temurin:17-jdk-jammy as builder

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN --mount=type=cache,target=/root/.m2,rw ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/*.jar
ENTRYPOINT ["java", "-jar","/app/*.jar"]

