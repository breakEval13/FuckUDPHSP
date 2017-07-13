#!/bin/bash
echo 'start  build ...'

source ~/.bash_profile


sudo mvn clean package


sudo cp target/FuckUDPHSP-1.0-SNAPSHOT-jar-with-dependencies.jar ./

echo 'docker build start...'

docker build -t 192.168.1.45:5000/gfw/app:latest .

echo 'docker push reg...'

docker push 192.168.1.45:5000/gfw/app:latest


docker rmi -f  192.168.1.45:5000/gfw/app:latest

kubectl config use-context kube45

kubectl delete -f gfw-app.yaml


kubectl create -f gfw-app.yaml

