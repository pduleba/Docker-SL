@echo off
REM Converts via tool located at http://kompose.io/
@echo on
kompose convert -f docker-compose.yml -o k8s