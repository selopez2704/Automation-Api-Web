pipeline {
    agent any
    environment {
        MAVEN_OPTS = '-Xmx1024m'
        JOB_NAME = 'automatio-pokeApi'
        BASE_URL = "http://localhost:8080/job/${JOB_NAME}/${currentBuild.number}/allure"
    }
    stages {
        stage('Install Dependencies') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Run Tests') {
            steps {
                sh 'mvn test -Dcucumber.filter.tags=\"@Pokeapi or @SouceDemo\" -DsuiteXmlFile=src/test/resources/suites/suite.xml'
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
        stage('Slack notification'){
            steps {
                script {
                def allureLink = "${BASE_URL}"
                def message = "Testing has been completed. You can see Allure's report here: <${allureLink}|report link>"
                slackSend( message: message, color: '#3552e6')
                }
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