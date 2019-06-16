FROM openjdk:8-jre-alpine

LABEL maintainer=Sergio\ Arcos\
	  version=1.0

COPY launcher.sh ./launcher.sh
COPY app.jar ./app.jar 

RUN chmod +x ./launcher.sh

ENTRYPOINT ["/bin/sh","-c", "/launcher.sh"]
