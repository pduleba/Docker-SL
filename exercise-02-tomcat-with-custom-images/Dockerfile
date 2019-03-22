# ------------------------------------------------------
#                   EXEC vs SHELL
# ------------------------------------------------------
#
# 'EXEC' form - shell processing does not happen - does not start /bin/sh -c on Linux or cmd /S /C on Windows
# WHEN
#   ENV name John Dow
#   ENTRYPOINT ["/bin/echo", "Hello, $name"]#
# THEN
#   Hello, $name
#
# 'SHELL' form - shell processing does happen - starts /bin/sh -c on Linux or cmd /S /C on Windows
# WHEN
#   ENV name John Dow
#   ENTRYPOINT echo "Hello, $name"
# THEN
#   Hello, John Dow
#
# ------------------------------------------------------
#                   RUN vs CMD vs SHELL vs ENTRYPOINT
# ------------------------------------------------------
# RUN (shell/exec form)         - commands will add new layer to image (results stored in new layer of image)
#   Example : RUN apt-get update && apt-get install -y git nano httpd
# SHELL                         - instruction allows the default shell used for the shell form of commands to be overridden (i.e. cmd -> powershell)
# CMD (shell/exec form)         - default command/parameters used on container RUN only. @Overriden if container RUN + command + arg
#   Example : CMD echo "Hello world"
#   Example : ignored when docker run -it <image> /bin/bash ('/bin/bash' is @Overriding)
# ENTRYPOINT (shell/exec form)  - similar to CMD but command can not be @Overriden on container RUN
#   GIVEN :
#       ENTRYPOINT ["/bin/echo", "Hello"]
#       CMD ["world"]
#
#   WHEN :
#       docker run -it <image>
#   THEN :
#       Hello world
#
#   WHEN :
#       docker run -it <image> John
#   THEN :
#       Hello John
#
#   WHEN shell form ENTRYPOINT ignores any CMD or docker run command line arguments
#
FROM tomcat:latest

# Deprecated - use label instead
MAINTAINER Pawel Duleba
LABEL maintainer="pduleba@pgs-soft.com"

COPY ./index.html /usr/local/tomcat/webapps/docker/
# Does the same as COPY + supports URLs & ARCHIVES
ADD ./list.html /usr/local/tomcat/webapps/docker/

# base dir for RUN, CMD, ENTRYPOINT, COPY and ADD instructions
WORKDIR /usr/local/tomcat/bin

# install free command (permanently as new layer of Docker)
RUN  apt-get update && apt-get install -y procps

EXPOSE 8080:8080

# will run in WORKDIR, parameter may be @overrriden on docker RUN
CMD ["catalina.sh", "run"]

ENV maintainer="pduleba@pgs-soft.com"