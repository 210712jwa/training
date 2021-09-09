#!/bin/bash

# === Installation ===
# java
sudo yum install java-1.8.0-openjdk-devel -y

# maven
sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
sudo yum install -y apache-maven

# git
sudo yum install git -y

# tomcat setup
wget https://mirrors.gigenet.com/apache/tomcat/tomcat-9/v9.0.52/bin/apache-tomcat-9.0.52.tar.gz
tar -zxvf apache-tomcat-9.0.52.tar.gz

# Startup tomcat by going to the tomcat folder -> bin, then run the startup.sh file
# ./startup.sh
# If you want to shutdown your Tomcat server, ./shutdown.sh

# Important note is to change the port that Tomcat should run on from 8080 to something else
# such as 8081
# The way you do this is by editing the configuration inside of conf/server.xml
# Because when you start up jenkins, it will listen on port 8080
# You can't have two different processes listening to the same port

# jenkins setup
sudo amazon-linux-extras install epel -y
sudo yum update -y

sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat/jenkins.repo
sudo rpm --import https://pkg.jenkins.io/redhat/jenkins.io.key
sudo yum install jenkins -y

# start jenkins (MAKE SURE to change Tomcat to a different port first!)
sudo service jenkins start

# To have Jenkins have the ability to run sudo, you need to modify the /etc/sudoers file
# sudo vim /etc/sudoers

# Add this line to the file:
# jenkins ALL=(ALL) NOPASSWD: ALL
