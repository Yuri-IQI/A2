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

        stage('Running Services') {
            steps {
                script {
                    sh './mvnw -f eureka spring-boot:run &'
                    sh './mvnw -f gateway spring-boot:run &'
                }
            }
        }
    }
}