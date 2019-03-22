@echo off
REM Will run command in format :: ENTRYPOINT CMD -> /bin/cat /etc/passwd
REM 
docker run --rm test:test /etc/passwd