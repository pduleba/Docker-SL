@echo off
REM %1 pod name
REM %2 container name
@echo on
kubectl exec -it -c %2 %1 -- /bin/bash