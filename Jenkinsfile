pipeline {
    agent any

    stages {
        try {
            stage('checkout') {
                checkout scm
            }
            stage("build jar file") {
                sh "mvn package"
            }
            stage("Run Unit Tests") {
                sh "mvn test"
            }
        } catch(e) {
            throw e;
        }
        finally {
            deleteDir()
        }
    }
}