FROM openjdk:8-jre-alpine

LABEL maintainer=Sergio\ Arcos\
	  version=1.0

COPY ./dockerfile/base/hardening.sh ./hardening.sh

RUN chmod o+x ./hardening.sh && sh ./hardening.sh && rm ./hardening.sh
