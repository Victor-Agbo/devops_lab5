pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-17'
            args '-v /c/Users/Victor/AppData/Local/Jenkins/.jenkins/workspace/Maven-Docker-Build:/workspace -w /workspace'
        }
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
