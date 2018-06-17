pipeline {
    agent any

    stages {
        stage("build jar file") {
            sh "mvn package"
        }
        stage("Run Unit Tests") {
            sh "mvn test"
        }
    }
    post {
        always {
            deleteDir();
        }
    }
}