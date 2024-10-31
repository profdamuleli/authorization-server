pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from your repository
                git 'https://github.com/profdamuleli/authorization-server.git'
            }
        }

        stage('Build') {
            agent {
                docker {
                    image 'maven:3.8.6-jdk-17'
                    reuseNode true
                }
            }
            steps {
                // Build the application using Maven
                sh 'mvn clean package -DskipTests'
            }
        }

        /* Uncomment and modify as needed
        stage('Test') {
            steps {
                // Run tests
                sh './mvnw test' // for Maven
                // sh './gradlew test' // for Gradle
            }
        }

        stage('Static Code Analysis') {
            steps {
                // Run static code analysis (optional)
                sh 'mvn sonar:sonar' // or any other analysis tool
            }
        }

        stage('Dockerize') {
            steps {
                // Build Docker image
                sh 'docker build -t authorization-server:latest .'
            }
        }

        stage('Deploy to Staging') {
            steps {
                // Deploy to a staging environment
                sh 'docker run -d --name your-app-name -e DB_URL=${DB_URL} -e DB_USER=${DB_USER} -e DB_PASSWORD=${DB_PASSWORD} your-image-name:latest'
            }
        }

        stage('Integration Tests') {
            steps {
                // Run integration tests against the staging environment
                sh './run-integration-tests.sh'
            }
        }

        stage('Deploy to Production') {
            steps {
                input 'Approve Production Deployment?' // manual approval before deploying to production
                sh 'docker run -d --name your-app-name-prod -e DB_URL=${DB_URL} -e DB_USER=${DB_USER} -e DB_PASSWORD=${DB_PASSWORD} your-image-name:latest'
            }
        }
        */
    }

    post {
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed. Please check the logs.'
        }
    }
}