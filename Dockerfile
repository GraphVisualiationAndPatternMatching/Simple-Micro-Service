FROM  ubuntu:latest

RUN apt-get update && apt-get -y upgrade
RUN  apt-get -y install openjdk-11-jdk
RUN mkdir /app
COPY  service/target/*.jar /app/app.jar
COPY  service/start.sh /start.sh
WORKDIR /
CMD java -jar /app/app.jar