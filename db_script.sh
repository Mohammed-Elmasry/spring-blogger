#!/bin/bash

docker run -d --rm --name mysql -p 3306:3306 --volume main-volume:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password  mysql:latest
