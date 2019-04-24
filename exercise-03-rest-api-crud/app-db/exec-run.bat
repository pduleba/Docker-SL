@echo off
REM Expose port 3306 so you will be able to connect to MySQL docker container from outside (Host OS)
@echo on
docker run --rm -d -e MYSQL_ROOT_PASSWORD=password -p 3306:3306 --network=app-network --name app-db app-db:latest