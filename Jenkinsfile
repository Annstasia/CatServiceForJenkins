pipeline {
    agent any

    tools {
        jdk 'jdk-21'
        maven 'maven-3.6.3'
    }

    stages {
        stage('Check Environment') {
            steps {
                sh 'echo "JAVA_HOME=$JAVA_HOME"'
                sh 'echo "PATH=$PATH"'
                sh 'java -version || echo "Java not found"'
                sh 'mvn -version || echo "Maven not found"'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                // Запуск тестов
                sh 'mvn test'
            }
            post {
                always {
                    // Публикация отчетов о тестах
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Deliver') {
            steps {
                // Доставка артефактов или выполнение других действий
                sh 'echo "Delivering artifacts..."'
            }
        }
    }

    post {
        success {
            echo 'Сборка прошла успешно!'
        }
        failure {
            echo 'Сборка завершилась с ошибкой.'
        }
    }
}
