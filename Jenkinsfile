pipeline {
    agent any

    tools {
        maven 'Maven 3.6.3'
        jdk 'JDK 21'
    }

    stages {

        stage('Build') {
            steps {
                // Сборка проекта
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
