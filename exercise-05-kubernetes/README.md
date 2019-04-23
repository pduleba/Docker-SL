# Kubernetes

### Introduction
This is demonstrating usage of Docker Compose on Kubernetes.
Based on `docker-compose.yml` from exercise 4.

### K8s basic structure overview
Kubernetes -> Nodes -> Pods -> Services -> Containers

### Basic commands
* `kubectl get all`- see status of all elements on k8s
* `kubectl get nodes` - see status of `nodes` elements on k8s
* `kubectl get pods` - see status of `pods` elements on k8s
* `kubectl get deployments` - see status of `deployments` elements on k8s
* `kubectl get services` - see status of `services` elements on k8s
* `kubectl get rs` - see status of `replicaSets` elements on k8s

### Docker-Compose into K8s via `Kompose` toolkit
* Prerequisites (one of):
* * build images locally 
* * perform `docker login` and deploy images
* `exec-convert.bat` - convert `docker-compose.yml` into Kubernetes deployment
* * **WARNING !!!** `kompose convert` generates no `imagePullPolicy` which is #BUG imho (manual fix required)
* `exec-deploy.bat` - apply `k8s` folder configuration into Kubernetes 
* `kubectl get pods` - check if both pods are in `Running` state
* `exec-port-forward.bat POD_NAME` - enable port forwarding for `app-rest-api` pod
* `exec-remove.bat` - delete deployment (`app-rest-api` and `app-db`)
* [Documentation](http://kompose.io/)

### Docker-Compose into K8s via `compose-on-kubernetes` toolkit
* `docker stack deploy --orchestrator=kubernetes -c docker-compose.yml app-stack` - deploy directly from Docker into K8s
* [Documentation](https://github.com/docker/compose-on-kubernetes)

### Extras - how to do it manually
* `docker-image-build.bat` - Build required images locally 
* `kubectl run app-db --image=app-mysql:latest --image-pull-policy=Never --env="MYSQL_ROOT_PASSWORD=password"` - Run MySQL
* `kubectl run app-rest-api --image=app-rest-api:latest --image-pull-policy=Never` - Run Spring Boot app
* `kubectl get pods` - check if both pods are in `Running` state
* `kubectl port-forward POD_NAME 8888:8888` - Enable port forward for pod `POD_NAME`
* `kubectl delete deployment app-db app-rest-api` - Delete deployment
* `docker-image-build.bat` - Clean up

### Extras - how to debug issues
* `debug\exec-describe-pod.bat POD_NAME` - Check pod `POD_NAME` state details
* `debug\exec-logs-pod.bat POD_NAME` - Check logs of given pod
* `debug\exec-connect-pod.bat POD_NAME CONTAINER_NAME` - Connect to `CONTAINER_NAME` container in `POD_NAME` pod

