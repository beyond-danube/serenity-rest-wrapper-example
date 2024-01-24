pipeline {
    agent any
    stages {
        stage('Run REST tests') {
            steps {
                sh 'mvn clean verify -U'
            }
        }
    }
    post {
        always {
            junit '**/target/**/*.xml'
        }
    }
}