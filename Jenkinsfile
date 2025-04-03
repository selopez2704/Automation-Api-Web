pipeline {
    agent any
    environment {
        MAVEN_OPTS = '-Xmx1024m'
    }
    stages {
        stage('Install Dependencies') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Run Tests') {
            steps {
                sh 'mvn test -Dcucumber.filter.tags="@Pokeapi" -DsuiteXmlFile=src/test/resources/suites/suite.xml'
            }
        }
        stage('Archive Allure Results') {
            steps {
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
    post {
        always {
            echo 'Pipeline Complete'
        }
        success {
            echo 'Execution Successful'
        }
        failure {
            echo 'Execution Failed'
        }
    }
}