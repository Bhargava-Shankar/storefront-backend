FROM mysql:latest

# Set environment variables
ENV MYSQL_ROOT_PASSWORD=123456
ENV MYSQL_DATABASE=bezkoder_db
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=123456

# Expose the MySQL port
EXPOSE 3306

# Copy the schema.sql to docker-entrypoint-initdb.d/ directory
# Uncomment if you have a schema file to initialize the database
# COPY schema.sql /docker-entrypoint-initdb.d/

# Command to run MySQL
CMD ["mysqld"]

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

