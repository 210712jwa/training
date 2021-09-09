#!/bin/bash

# basics
sudo yum install java-1.8.0-openjdk-devel -y

sudo yum install maven -y
sudo yum install git -y

# tomcat setup
wget https://mirrors.gigenet.com/apache/tomcat/tomcat-9/v9.0.52/bin/apache-tomcat-9.0.52.tar.gz
tar -zxvf apache-tomcat-9.0.52.tar.gz

# Important note is to change the port that Tomcat should run on from 8080 to something else
# Because when you start up jenkins, it will listen on port 8080
# You can't have two different processes listening to the same port

# jenkins setup
sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat-stable/jenkins.repo
sudo rpm --import http://pkg.jenkins-ci.org/redhat-stable/jenkins-ci.org.key
sudo yum install -y jenkins

# start jenkins
sudo service jenkins start

