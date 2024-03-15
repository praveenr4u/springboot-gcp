# changes the current directory to the parent directory of the directory containing the script being executed
cd "$(dirname $0)/.."
gcloud builds submit --tag gcr.io/springboot-cloudrun-417018/livespringapp

