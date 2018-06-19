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
                    String branchName = env.BRANCH_NAME;
                    if(branchName.equals("master")) {
                        sh "mvn  sonar:sonar"
                    } else {
                        sh "mvn  sonar:sonar sonar.branch.name= " + branchName
                    }

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