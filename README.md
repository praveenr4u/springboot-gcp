# Introduction
This is a sample dockerized spring boot application which is pushed to the GCR & deployed on cloud run.
- Google Container Registry - private Docker repository that works with popular continuous delivery systems & 
- Cloud Run - managed compute platform that lets you run containers directly on top of Google's scalable infrastructure.

Note : Please replace the user & service principal account with yours

### Adding roles/permission in the user 
-gcloud projects add-iam-policy-binding springboot-cloudrun-417018 --member=user:praveenr4u@gmail.com --role=roles/serviceusage.serviceUsageViewer;

### Activating service account in gcloud
-gcloud auth activate-service-account 787728066587-compute@developer.gserviceaccount.com --key-file=/Volumes/Macintosh/GCP/keys/springboot-cloudrun-417018-fcbce3529746.json

### Enable the cloud build API by visiting
https://console.developers.google.com/apis/api/cloudbuild.googleapis.com/overview?project=787728066587

### View the list of gcloud accounts
gcloud auth list

### run this command to activate my token again
gcloud auth print-access-token | docker login -u oauth2accesstoken --password-stdin https://gcr.io

### Binding policies as needed
gcloud projects add-iam-policy-binding 787728066587 --member "serviceAccount:787728066587@containerregistry.iam.gserviceaccount.com" 
--role "roles/storage.admin, roles/run.admin"

Ref: https://console.cloud.google.com/iam-admin/iam?hl=en&project=springboot-cloudrun-417018

TEST123


