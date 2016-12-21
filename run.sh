#!/usr/bin/env bash
docker build -t fogframe/cloud-service .
docker rm -f fogframe/cloud-service
docker run -ti -p 8200:8200 --name cloud-service fogframe/cloud-service