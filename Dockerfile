FROM adoptopenjdk:11-jdk-hotspot-focal
MAINTAINER Kihoon Han <me@hoony9x.dev>
LABEL "org.opencontainers.image.source"="https://github.com/hoony9x/sample-web-server-for-k8s-explanation"

COPY . /app
WORKDIR /app

RUN ./gradlew assemble
RUN mv /app/build/libs/*.jar /app/sample.jar

EXPOSE 8080

CMD java -jar /app/sample.jar