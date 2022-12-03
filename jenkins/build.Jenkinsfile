pipeline {
    agent any
    tools {
        maven 'Maven 3.8.2'
        jdk 'JDK8'
    }
    stages {
        stage('Build') {
            steps {
                sh 'printenv'
                sh 'ls -la'
                sh 'mvn clean install -DskipTests'
            }
        }
        stage("Run Test") {
            steps {
              sh 'mvn test'
            }
        }
    }
}

