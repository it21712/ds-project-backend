
#A REST-API Server implemented with Spring

## Installation Guide

### Docker contained MySql Database

1. Open cmd
2. Run the following command: docker run --name mysqldb -v mysqldbvol:/var/lib/mysql -p 3306:3306 -e MYSQL_USER=user0 -e MYSQL_PASSWORD=changeit -e MYSQL_DATABASE=dsDb0 -e MYSQL_ROOT_PASSWORD=pass123 -d mysql/mysql-server:latest
3. 
