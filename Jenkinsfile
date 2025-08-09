pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-17'
            args '-v /c/Users/Victor/AppData/Local/Jenkins/.jenkins/workspace/Maven-Docker-Build:/workspace'
        }
    }
    options {
        customWorkspace('/workspace')
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/soram123/simple-maven-pipeline.git'
                sh 'ls -l'
            }
        }
    }
}
