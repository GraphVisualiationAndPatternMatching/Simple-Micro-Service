pipeline {
    agent any

    stages {
        stage("build jar file") {
            steps {
                dir("service") {
                    sh "mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent package sonar:sonar " +
                            "    -Dsonar.branch=" + env.BRANCH_NAME
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