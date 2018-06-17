pipeline {
    agent any

    stages {
        stage("build jar file") {
            steps {
                sh "ls"
                sh "mvn package"
            }
        }
        stage("Run Unit Tests") {
            steps {
                sh "mvn test"
            }
        }
    }
    post {
        always {
            deleteDir();
        }
    }
}