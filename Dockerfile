FROM openjdk:8

ENV PORT=5005

COPY ./build/libs/ /app

# SET THE FOLDER WHERE THE CONTEXT IS
WORKDIR /app

EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "/app/oauth-1.0-SNAPSHOT.jar"]


# docker build -t username/java-keycloak .
# docker build -f java.dockerfile -t username/java-keycloak .

# docker run -d -p 8080:5005 cjafet/java-keycloak
