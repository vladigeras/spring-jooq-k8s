# Description

This project shows some examples of using [jOOQ](https://www.jooq.org) access data layer inside
Spring Boot application with [OpenShift](https://www.openshift.com) deployment
with [Istio Service Mesh](https://istio.io) features.

Docker image build and deploy to Docker Hub by [jib](https://github.com/GoogleContainerTools/jib)
(jib-gradle-plugin). Also you can replace it by you own native Dockerfile and directly build and
push image to registry.

The app is available by Gateway at the following path:
http://cluster-ip/app

## Notes
### Deployment
**_kubernetes_** directory stores configurations for deployment to **native** **Kubernetes**


### Database
There is **no** database inside OpenShift cluster. So you need allow you database accept other
connections (not only local).

For example, for PostgreSQL:

In **postgresql.conf** set `listen_addresses = '*'`

In **pg_hba.conf** set `host  all  all  0.0.0.0/0  md5`
