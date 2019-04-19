#!/bin/bash
java -jar target/app-rest-api.jar & echo $! > ./pid.file &