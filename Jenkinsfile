pipeline {
    agent any
    
    stages {
        stage("Compile code") {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage("Tests") {
            when {
                branch 'feature/*'
            }
            steps {
                sh 'mvn test'
            }
        }
        stage("Static analyse") {
            when {
                branch 'develop'
            }
            steps {
                sh 'mvn checkstyle:check'
            }
        }
        stage("Report") {
            when {
                branch 'feature/*'
            }
            steps {
                junit testResults: '**/surefire-reports/*.xml'
                jacoco()
            }
        }
        stage("Install") {
            steps {
                sh 'mvn install'
            }
        }
        stage("Publish") {
            steps {
                sh 'copy "main\\target\\main-1.0-SNAPSHOT-jar-with-dependencies.jar" Users\\main-1.0.jar"'
            }
        }
    }
}
