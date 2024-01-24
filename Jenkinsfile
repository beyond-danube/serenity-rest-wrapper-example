pipeline {
    agent any
    stages {
        stage('Run REST tests') {
            steps {
                sh 'mvn clean verify -U --illegal-access=warn --add-opens=java.base/java.lang=ALL-UNNAMED'
            }
        }
    }
    post {
        always {
            junit '**/target/**/*.xml'
        }
    }
}