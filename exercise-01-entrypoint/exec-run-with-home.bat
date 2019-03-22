@echo off
REM Will run command in format :: ENTRYPOINT CMD -> /bin/cat /etc/os-release
REM
docker run --rm test:test /etc/os-release