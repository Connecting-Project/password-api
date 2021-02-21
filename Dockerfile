FROM openjdk:12
LABEL seongwon="seongwon@edu.hanbat.ac.kr"

COPY ./password-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD [ "java", "-jar", "password-0.0.1-SNAPSHOT.jar"]