pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-17'
            args '-v /root/.m2:/root/.m2' // cache dependencies
        }
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/soram123/simple-maven-pipeline.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Package into Docker Image') {
            steps {
                script {
                    echo "📦 Building Docker image for Maven project..."
                    sh '''
                        # Build Docker image
                        docker build -t simple-maven-app:latest .
                        docker images | grep simple-maven-app
                    '''
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    echo "🚀 Running container from built image..."
                    sh '''
                        # Stop old container if running
                        docker rm -f simple-maven-container || true
        
                        # Run new container in detached mode
                        docker run -d --name simple-maven-container -p 8080:8080 simple-maven-app:latest
        
                        # Show running containers
                        docker ps
                    '''
                }
            }
        }
    }
    post {
        success {
            echo '✅ Build successful'
        }
        failure {
            echo '❌ Build failed'
        }
    }
}
