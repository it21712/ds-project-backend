
# A REST-API Server implemented with Spring

## Installation Guide

### Step 1
### Create a MySQL Database with Docker

1. Run the following command in the command line: 
   docker run --name mysqldb -v mysqldbvol:/var/lib/mysql -p 3306:3306 -e MYSQL_USER=user0 -e MYSQL_PASSWORD=changeit -e MYSQL_DATABASE=dsDb0 -e MYSQL_ROOT_PASSWORD=pass123 -d mysql/mysql-server:latest
3. 
