FROM openjdk:8-jdk

LABEL maintainer="pduleba@pgs-soft.com"

COPY ./target/app-rest-api.jar /usr/local/app-rest-api/

WORKDIR /usr/local/app-rest-api

EXPOSE 8888:8888

# will run in WORKDIR, parameter may be @overrriden on docker RUN
ENTRYPOINT ["java", "-jar", "app-rest-api.jar", "-Xdebug"]
