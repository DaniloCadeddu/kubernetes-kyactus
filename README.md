# Kubernetes Kyactus 

Just a funny project for playing with Kubernetes and the official Kubernetes java API client

## How to run

### Prerequisites

- docker
- [minikube](https://minikube.sigs.k8s.io/)
- JDK11 and Maven

Create a simple kubernetes cluster with minikube with
```bash
minikube start --driver docker
```

Set up a few example k8s pods, the **/k8s** in the root folder contains two kubernetes configuration files
for creating one pod with mysql in it and another with the [openlog](https://github.com/cdbros/openlog) backend project.

To create the pods run
```bash
 kubectl apply -f /path/to/config/yml
```
Verify the status of the created pods with
```bash
 kubectl get pod
```

At this point just run the Spring application
```bash
 mvn spring-boot:run
```

Go to http://localhost:8080/ and you should see something like a few kyactus that represent
the pods names in your k8s cluster


