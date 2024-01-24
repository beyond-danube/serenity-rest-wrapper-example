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

            publishHTML (target: [
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: "Tests Report (Full)"
            ])
            publishHTML (target: [
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/site/serenity',
                    reportFiles: 'serenity-summary.html',
                    reportName: "Tests Report (Summary)"
            ])
            cleanWs()
        }
    }
}