FROM mysql:8

ENV MYSQL_DATABASE app-database

LABEL maintainer="pduleba@pgs-soft.com"

EXPOSE 3306:3306

# Add the content of the sql-scripts/ directory to your image
# All scripts in docker-entrypoint-initdb.d/ are automatically
# executed during container startup
COPY ./sql/ /docker-entrypoint-initdb.d/