pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS=credentials('docker-hub-access')
    }

    stages {
        stage('Cloning Git Repository') {
            steps {
                git branch: 'master', url: 'https://github.com/Yuri-IQI/A2.git'
            }
        }

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
                dir('eureka') {
                    sh './mvnw spring-boot:run'
                }
                dir('gateway') {
                    sh './mvnw spring-boot:run'
                }
            }
        }
    }
}