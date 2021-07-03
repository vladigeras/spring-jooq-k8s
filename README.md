# Description

This project shows some examples of using [jOOQ](https://www.jooq.org) access data layer inside Spring Boot application
with [Kubernetes](https://kubernetes.io) deployment with [Istio Service Mesh](https://istio.io) features.

Docker image build and deploy to Docker Hub by [jib](https://github.com/GoogleContainerTools/jib)
(jib-gradle-plugin). Also you can replace it by you own native Dockerfile and directly build and push image to registry.

The app is available by Gateway at the following path:
http://cluster-ip/app

## Deployment
**_manifests/kubernetes_** directory stores configurations for deployment to **native** **Kubernetes**
**_manifests/istio_** directory stores configurations for deployment to **Kubernetes** with **Istio** service mesh
features

## Dashboard (WEB-UI)
### Native Kubernetes
You can deploy a dashboard, which is no by default. Install it:
```
kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.2.0/aio/deploy/recommended.yaml
```
Actual version you can find [here](https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/). Also,
you must setup some account and role to cluster.
```
kubectl apply -f manifests/service-account.yaml
kubectl apply -f manifests/cluster-role.yaml
kubectl proxy
```
After it, go to http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/
and use a token to authenticate in Web UI. You can find token by executing
```
kubectl -n kubernetes-dashboard get secret $(kubectl -n kubernetes-dashboard get sa/admin-user -o jsonpath="{.secrets[0].name}") -o go-template="{{.data.token | base64decode}}"
```

### Minikube
Just use
```
minikube dashboard
```

## Database

There is **no** database inside Kubernetes cluster. So you need allow you database accept other connections (not only
local).

For example, for PostgreSQL:

In **postgresql.conf** set `listen_addresses = '*'`

In **pg_hba.conf** set `host  all  all  0.0.0.0/0  md5`

## Monitoring

You can connect app to monitoring systems (e.g. [Prometheus](https://prometheus.io)). Metric
exposer [Micrometer](https://micrometer.io) is already included with prometheus adapter. There is no Prometheus
or [Grafana](https://grafana.com) inside Kubernetes cluster.