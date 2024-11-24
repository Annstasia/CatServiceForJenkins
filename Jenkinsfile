pipeline {
    agent any

    tools {
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
                sh 'mvn test -P allure'
            }
            post {
                always {
                    // Публикация отчетов о тестах
                    allure includeProperties:
                     false,
                     jdk: '',
                     results: [[path: 'target/allure-results']]
                }
            }
        }

        stage('Static Analysis') {
            steps {
                withSonarQubeEnv("SonarServer1") {
                    script {
                        sh 'mvn clean package sonar:sonar -P sonar'
                    }
                }
                echo 'Static Analysis Completed'
            }
        }
        stage('Quality Gate') {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    script {
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
                        }
                    }
                }
                echo 'Quality Gate Passed'
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
