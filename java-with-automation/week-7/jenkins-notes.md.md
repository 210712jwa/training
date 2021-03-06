# Jenkins

Jenkins is a popular, open source CI/CD tool used throughout the industry to create and manage build pipelines.

# Setup
The dashboard for Jenkins can be found at `http://localhost:8080` (assuming this is the port we are running Tomcat on). By visiting this dashboard for the first time, we can go through the initial Jenkins setup process, where it will download popular plugins and allow us to create an admin account.

# Plugins
Jenkins is popular because of the rich plugin community that provides a lot of additional functionalities that you can use during your builds. On initial setup, a variety of popular plugins were bundled w/ Jenkins and many more can also be installed individually.

Some examples of plugins would be plugins that allow us to deploy to an AWS S3 bucket, deal with deployments to Tomcat, and deal with Docker deployments as well.

# Jobs
A pipeline is defined through a Jenkins job, which is a project created and monitored on the dashboard. Jobs can be structured in many different ways through a variety of different archetypes. Every job has a folder w/ a separate workspace directory so that builds can be isolated from other jobs.

You can configure jobs either through the GUI (typically as a freestyle project) or programmatically through a Jenkinsfile script (known as a **declarative pipeline**).

Besides building the project itself, we can also configure pre-build or post-build stages that can set environment variables, prepare build tools, poll SCM repositories, or log messages to messaging services such as Slack or even Discord.

# Freestyle v. Declarative Pipelines
**Freestyle** jobs are generally considered an older way of implementing Jenkins jobs. This type of job is configured through the GUI interface of Jenkins and can be easier to understand when first starting out using Jenkins.

However, the drawback of configuring a Jenkins job through the GUI is that we don't have source code control over the build steps. We would need to manually log into our Jenkins dashboard and change the build steps if something about our source code changed and required different build steps as a result of those particular changes.

However, we have a modern way of configuring build steps for a Jenkins job. This is known as a **declarative pipeline**. A declarative pipeline has the various build steps defined in a `Jenkinsfile`. An example is shown below:

```text
pipeline {
    agent any

    stages {
        stage('clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('deploy') {
            steps {
                sh 'cp /home/ec2-user/.jenkins/workspace/my-first-pipeline/target/MyApp.war /home/ec2-user/apache-tomcat-9.0.52/webapps/'
            }
        }
    }
}
```

Declarative pipelines allow us to split up steps into individual stages. We can have multiple steps within each stage. The stages allow for better organization of our build steps.

# Github Webhooks
We can configure Jenkins to listen to our Github repository for any push events, which will then trigger an HTTP request sent from Github to our Jenkins server. We can configure our Jenkins job to execute a build when it receives this HTTP request.

## Configuration
In order to configure our Github repository to send an HTTP request to the Jenkins server, we need to go to "Settings" -> "Webhooks' and then add the Jenkins hook url: `http://localhost:8080/github-webhook/`

**Note:** The `/` at the end of `github-webhook/` is very important. You will run into issues otherwise

You may also need to configure your security group settings to allow the Github ip addresses to have inbound connections to port 8080. To figure out what IP addresses you need to allow, we can navigate to `https://api.github.com/meta` to display a list of IP addresses that Github utilizes.

At this moment, the IP addresses are the following
- 192.30.252.0/22
- 185.199.108.0/22
- 140.82.112.0/20
- 143.55.64.0/20
- 2a0a:a440::/29
- 2606:50c0::/32