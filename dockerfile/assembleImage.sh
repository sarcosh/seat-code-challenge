#!/bin/bash

if [[ -f ../target/app.jar ]];
then

    cp ../target/app.jar ./alpine; cd alpine; docker build -t docker.io/sarcosh666/seat-code-challenge .; rm app.jar

else
    echo "Compiled application not found"
    exit 1
fi
