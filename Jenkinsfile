pipeline {
    agent any
    stages 
        stage("Compile code") {
            environment {
                JAVA_HOME = '/usr/local/Cellar/openjdk/21.0.3/libexec/openjdk.jdk/Contents/Home'
                MAVEN_HOME = '/usr/local/Cellar/maven/3.9.6/libexec'
            }

            steps {
                sh '/usr/local/Cellar/maven/3.9.6/libexec/bin/mvn clean compile'
            }
        }
        stage("Tests") {
            when {
                branch 'feature/*'
            }
            steps {
                sh '/usr/local/Cellar/maven/3.9.6/libexec/bin/mvn test'
            }
        }
        stage("Static analyse") {
            when {
                branch 'develop'
            }
            steps {
                sh '/usr/local/Cellar/maven/3.9.6/libexec/bin/mvn checkstyle:check'
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
                sh '/usr/local/Cellar/maven/3.9.6/libexec/bin/mvn install'
            }
        }
        stage("Publish") {
            steps {
                sh 'copy "main\\target\\main-1.0-SNAPSHOT-jar-with-dependencies.jar" Users\\main-1.0.jar"'
            }
    }
}

