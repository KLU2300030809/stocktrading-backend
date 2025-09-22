pipeline {
    agent any

    environment {
        JAR_NAME = 'your-app.jar'  // Replace with your actual jar name
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                // Run Maven build on Windows
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                // Example: stop previous app if running
                bat '''
                tasklist /FI "IMAGENAME eq java.exe" | find /I "java.exe"
                if %ERRORLEVEL%==0 (
                    taskkill /F /IM java.exe
                    timeout /t 5
                )
                '''

                // Run your jar file in the background and redirect output
                bat "start /B java -jar target\\${JAR_NAME} > app.log 2>&1"
            }
        }
    }
    
    post {
        failure {
            echo 'Build or deployment failed.'
        }
    }
}
