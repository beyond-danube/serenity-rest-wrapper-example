pipeline {
    agent any
    environment {
        MAVEN_OPTS = "--illegal-access=warn --add-opens=java.base/java.lang=ALL-UNNAMED"
    }
    stages {
        stage('Run REST tests') {
            steps {
                withMaven(maven: 'maven-3') {
                    sh 'mvn clean verify -U'
                }
            }
        }
    }
    post {
        always {
            junit '**/target/**/*.xml'
        }
    }
}