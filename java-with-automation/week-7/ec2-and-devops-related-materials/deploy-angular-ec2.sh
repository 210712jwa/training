#!/bin/bash
PROJECT_NAME=ship-manager-frontend
TOMCAT_APP_NAME=my-angular-app
EC2_ALIAS=ec2-deployment-demo-2
URL=ec2-18-188-206-162.us-east-2.compute.amazonaws.com:8443

cd $PROJECT_NAME
echo 'Building Angular application...' && ng build --prod --base-href //$URL/$TOMCAT_APP_NAME/ > /dev/null && echo 'Angular Application successfully built'

cd dist/$PROJECT_NAME

echo 'Attempting to create new directory on ec2 for tomcat webapp... ' && ssh $EC2_ALIAS "cd apache-tomcat-9.0.52/webapps; mkdir $TOMCAT_APP_NAME" 2> /dev/null || echo 'Not creating another directory... directory already exists'

echo 'Deploying to Tomcat on EC2...' && scp * $EC2_ALIAS:/home/ec2-user/apache-tomcat-9.0.52/webapps/$TOMCAT_APP_NAME/ && echo 'Deployment successful!'
