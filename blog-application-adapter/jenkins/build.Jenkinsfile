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
                sh 'mvn clean package -DskipTests'
            }
        }
        stage("Run Test") {
            steps {
              sh 'mvn test'
            }
        }
        stage("SonarQube Analysis") {
            steps {
              withSonarQubeEnv('SonarQube-Scanner') {
                sh 'mvn clean package sonar:sonar'
              }
            }
        }
        stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
        }
    }
}

