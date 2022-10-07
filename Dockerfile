FROM openjdk:17

LABEL maintainer="Test@sebastian.de"

ADD backend/target/hh-java-22-2-movies.jar hh-java-22-2-movies.jar

CMD {"sh", "-c", "java -DServer.port=$PORT -jar / hh-java-22-2-movies.jar"}