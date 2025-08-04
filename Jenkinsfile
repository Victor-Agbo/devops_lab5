pipeline {
    agent none
    stages {
        stage('Build & Test Maven') {
            agent {
                docker {
                    image 'maven:3.9.6-eclipse-temurin-17'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                git branch: 'master', url: 'https://github.com/soram123/simple-maven-pipeline.git'
                sh 'mvn clean install'
                sh 'mvn test'
            }
        }
        stage('Build Docker Image') {
            agent any // runs on host, not inside Maven container
            steps {
                sh 'docker build -t simple-maven-app:latest .'
                sh 'docker images | grep simple-maven-app'
            }
        }
        stage('Run Docker Container') {
            agent any
            steps {
                sh 'docker rm -f simple-maven-container || true'
                sh 'docker run -d --name simple-maven-container -p 8080:8080 simple-maven-app:latest'
                sh 'docker ps'
            }
        }
    }
}
