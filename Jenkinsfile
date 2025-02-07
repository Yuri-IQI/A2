pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS=credentials('docker-hub-access')
    }

    stages {
        stage('Docker Login') {
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }

        stage('Setup Kafka') {
            steps {
                dir('kafka') {
                    sh 'docker-compose up -d'
                }
            }
        }

        stage('Run Redis') {
            steps {
                sh 'docker run --name redis -p 6379:6379 -d redis'
            }
        }

        stage('Parallel Stages') {
            parallel {
                stage('Running Eureka') {
                    steps {
                        dir('eureka') {
                            sh './mvnw spring-boot:run'
                        }
                    }
                }

                stage('Running Gateway') {
                    steps {
                        dir('gateway') {
                            sh './mvnw spring-boot:run'
                        }
                    }
                }

                stage('Running Informational') {
                    steps {
                        dir('informational') {
                            sh './mvnw spring-boot:run'
                        }
                    }
                }
            }
        }
    }
}