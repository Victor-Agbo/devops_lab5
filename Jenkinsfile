pipeline {
    agent any  // Run everything on local Ubuntu Jenkins host

    stages {
        stage('Checkout') {
            steps {
                // Get code from GitHub
                git branch: 'master', url: 'https://github.com/soram123/simple-maven-pipeline.git'
                sh 'ls -l' // Debug: show files, ensure Dockerfile exists
            }
        }

        stage('Build Maven Project') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t simple-maven-app:latest .'
                sh 'docker images | grep simple-maven-app'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker rm -f simple-maven-container || true'
                sh 'docker run -d --name simple-maven-container -p 9090:8080 simple-maven-app:latest'
                sh 'docker ps'
            }
        }
    }

    post {
        success {
            echo '✅ Build, Test, and Docker Run completed successfully!'
        }
        failure {
            echo '❌ Build failed. Check logs above.'
        }
    }
}
