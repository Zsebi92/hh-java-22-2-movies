FROM openjdk:17

LABEL maintainer="Test@sebastian.de"

ADD backend/target/hh-java-22-2-movies.jar hh-java-22-2-movies.jar

CMD {"sh", "-c", "java -jar / hh-java-22-2-movies.jar"}