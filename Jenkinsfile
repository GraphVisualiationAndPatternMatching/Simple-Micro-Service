pipeline {
    agent any

    stages {
        stage("build jar file") {
            steps {
                dir("service") {
                    sh "ls"
                    sh "mvn package"
                }
            }
        }
        stage("Run Unit Tests") {
            steps {
                dir("service") {
                    sh "mvn test"
                }

            }
        }
    }
    post {
        always {
            deleteDir();
        }
    }
}