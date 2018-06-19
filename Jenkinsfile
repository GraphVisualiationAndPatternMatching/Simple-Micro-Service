pipeline {
    agent any

    stages {
        stage("build jar file") {
            steps {
                dir("service") {
                    sh "mvn package"
                }
            }
        }
        stage("Run Unit Tests") {
            steps {
                dir("service") {
                    sh "mvn test  org.jacoco:jacoco-maven-plugin:prepare-agent "
                }

            }
        }
        stage("Analyze Code using Sonar") {
            steps {
                dir("service") {
                    sh "mvn  sonar:sonar"
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