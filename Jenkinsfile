pipeline {
    agent any
    tools {
        maven 'Maven 3.9.6'
    }
    environment {
        MAVEN_OPTS = "--illegal-access=warn --add-opens=java.base/java.lang=ALL-UNNAMED"
    }
    stages {
        stage('Run REST tests') {
            steps {
                sh 'mvn clean verify -U'
            }
        }
    }
    post {
        always {
            junit 'target/failsafe-reports/TEST-*.xml'

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