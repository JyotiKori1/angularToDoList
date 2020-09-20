FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace
WORKDIR /usr/share/udemy

# ADD .jar under target from host
# into this image
ADD target/todocrudselenium-docker.jar 			todocrudselenium-docker.jar
ADD target/todocrudselenium-docker-tests.jar 	todocrudselenium-docker-tests.jar
ADD target/libs							libs

# in case of any other dependency like .csv / .json / .xls
# please ADD that as well

# ADD suite files
ADD testng.xml				testng.xml

#ADD Healthcheck file
ADD healthcheck.sh			healthcheck.sh


# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh healthcheck.sh