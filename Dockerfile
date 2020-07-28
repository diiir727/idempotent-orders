FROM openjdk:11
LABEL maintainer="diiir727"
WORKDIR /app
COPY . .
USER 9000
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
