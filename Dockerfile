FROM eclipse-temurin:17

LABEL maintainer="Nguyen Hoang Nam <hoangnam2004hp@gmail.com>"

WORKDIR /app

COPY /target/usermanagement-0.0.1-SNAPSHOT.jar /app/usermanagement.jar

ENTRYPOINT ["java", "-jar", "usermanagement.jar"]