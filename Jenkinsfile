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
                    script {
                        if(env.BRANCH_NAME.equals("master")) {
                            sh "mvn  sonar:sonar"
                        } else {
                            sh "mvn  sonar:sonar -Dsonar.branch.name=" + env.BRANCH_NAME
                        }
                    }
                }
            }
        }
        stage("build production docker image") {
            script {
                sh "heroku container:push web"
            }
        }
        stage("deploy to production") {
            script {
                sh "heroku container:release web"
            }
        }
    }


    post {
        always {
            deleteDir();
        }
    }
}