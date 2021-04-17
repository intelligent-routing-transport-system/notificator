FROM adoptopenjdk/openjdk11:alpine
ARG JAR_FILE=target/*.jar
ARG GOOGLE_CREDENCIALS=*.json
COPY ${JAR_FILE} notificator.jar
COPY ${GOOGLE_CREDENCIALS} google-credentials
ENV google.application.credentials=google-credentials
ENTRYPOINT ["java","-jar","notificator.jar"]