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
        stage("build  and run docker image for acceptance tests") {
            steps {
                script {
                    sh "docker build . -t simple-micro-service"
                    sh "docker run -p 8081:8080  simple-micro-service -d"
                }
            }
        }
        stage("run acceptance tests") {
            steps {
                script {
                    dir("acceptanceTests") {
                        sh "SERVICE_URL=http://localhost:8081 mvn test"
                    }
                }

            }
        }
        stage("build production docker image") {
           steps {
               script {
                   sh "heroku container:push web --app simple-micro-service"
               }
           }
        }
        stage("deploy to production") {
            steps {
                script {
                    sh "heroku container:release web  --app simple-micro-service"
                }
            }
        }
        stage("verify production working ") {
            steps {
                script {
                    dir("acceptanceTests") {
                        sh "SERVICE_URL=http://simple-micro-service.herokuapp.com mvn test"
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