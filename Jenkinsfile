pipeline {
    agent any
    stages {
        stage('Build Jar') {
           agent {
              docker {
               image 'maven:3-alpine'
                   args '-v $HOME/.m2:/root/.m2'
               }
          }
            steps {
                //sh 
                bat 'mvn clean package -DskipTests'
            }
        }
       stage('Build Image') {
           steps {
              
              bat "docker build("jyotikori/todoitems-docker .")"
         
            }
     }
        stage('Push Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable:'pass',usernameVariable:'user')])
			        
			        bat "docker login --username=${user} --password=${pass}"
			        echo "docker login completed"
			        bat "docker push jyotikori/todoitems-docker:latest"
			        echo "docker push completed"
			    
                }
            }
        }
    }
}