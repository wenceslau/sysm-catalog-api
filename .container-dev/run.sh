#!/bin/bash
echo "Creating network..."

docker network create ntw_elastic
docker network create ntw_kafka
docker network create ntw_app
docker volume create vol_elastic
docker volume create vol_kafka
docker volume create vol_kconnect

docker compose up -d
