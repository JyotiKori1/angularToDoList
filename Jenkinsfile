pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }
       stage('Build Image') {
           steps {
              
              bat "docker build -t=jyotikori/todoitems-docker ."
         
            }
     }
        stage('Push Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable:'pass',usernameVariable:'user')])
			        //docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
			        //	app.push("${BUILD_NUMBER}")
			        //    app.push("latest")
			        bat "docker login --username=${user} --password=${pass}"
			        echo "docker login completed"
			        bat "docker push jyotikori/todoitems-docker:latest"
			        echo "docker push completed"
			    
                }
            }
        }
    }

