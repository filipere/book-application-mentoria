@ECHO OFF

CLS

ECHO RESTART DOCKER

@REM DERRUBANDO CONTAINER
docker-compose down

@REM REMOVENDO VOLUME SQL
docker volume rm mssql-server

@REM SUBINDO CONTAINER
docker-compose up -d