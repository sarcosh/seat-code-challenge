FROM openjdk:8-jre-alpine

LABEL maintainer=Sergio\ Arcos\
	  version=1.0

COPY /workspace/source/dockerfile/base/hardening.sh ./hardening.sh

RUN chmod +x ./hardening.sh

RUN ./hardening.sh
