# Description

This project shows some examples of using [jOOQ](https://www.jooq.org) access data layer inside
Spring Boot application with [Kubernetes](https://kubernetes.io) deployment features.

Docker image build and deploy to Docker Hub by [jib](https://github.com/GoogleContainerTools/jib)
(jib-gradle-plugin). Also you can replace it by you own native Dockerfile and directly build and
push image to registry.

The app is available by Gateway at the following path:
http://cluster-ip/app

## Notes

You can easily extend current Kubernetes deployment configurations to get a [Istio](https://istio.io/) service mesh and [OpenShift](https://www.openshift.com/) features.
You need to provide at least **16 Gb RAM** to run the Istio correctly.

### Deployment

**_kubernetes_** directory stores configurations for deployment to **native** **Kubernetes**

### Database

There is **no** database inside Kubernetes cluster. So you need allow you database accept other
connections (not only local).

For example, for PostgreSQL:

In **postgresql.conf** set `listen_addresses = '*'`

In **pg_hba.conf** set `host  all  all  0.0.0.0/0  md5`

### Monitoring

You can connect app to monitoring systems (e.g. [Prometheus](https://prometheus.io)). Metric
exposer [Micrometer](https://micrometer.io) is already included with prometheus adapter. There is no
Prometheus or [Grafana](https://grafana.com) inside Kubernetes cluster.
