#!/bin/bash
echo "Creating network..."

docker network create ntw_elastic
docker volume create vol_elastic

docker compose up -d elasticsearch
