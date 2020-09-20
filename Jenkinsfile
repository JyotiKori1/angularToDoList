pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh 
                bat 'mvn clean package -DskipTests'
            }
        }
       stage('Build Image') {
        steps {
		
             bat "docker build -t=jyotikori/todoitems-docker ."
	}
        }
        stage('Push Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub1', passwordVariable:'pass',usernameVariable:'user')])
			        bat "docker login --username=${user} --password=${pass}"
			        echo "docker login completed"
			        bat "docker push jyotikori/todoitems-docker:latest"
			        echo "docker push completed"
		}
                }
            }
        }
    }

