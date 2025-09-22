pipeline {
    agent any

    environment {
        GIT_REPO = 'https://github.com/KLU2300030809/stocktrading-backend.git'
        APP_NAME = 'stocktrading-backend'
        JAR_NAME = "${APP_NAME}.jar"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: "${env.GIT_REPO}"
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    if pgrep -f ${JAR_NAME}; then
                        echo "Stopping existing app..."
                        pkill -f ${JAR_NAME}
                        sleep 5
                    fi
                '''
                sh "nohup java -jar target/${JAR_NAME} > app.log 2>&1 &"
            }
        }
    }

    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Build or deployment failed.'
        }
    }
}
