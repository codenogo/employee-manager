FROM openjdk:15
MAINTAINER arnold.com
COPY target/test-0.0.1-SNAPSHOT.jar test-0.0.1-SNAPSHOT.jar
EXPOSE 5001
ENTRYPOINT ["java","-jar","test-0.0.1-SNAPSHOT.jar"]



