pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Compile project
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                // Run test
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            // Archive artifacts
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
        }
    }
}