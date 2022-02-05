pipeline {

  environment {
    registry = "306655/image_repo"
    registryCredential = 'dockerhub'
  }
  agent any

  stages { // Define the individual processes, or stages, of your CI pipeline

    stage('Checkout') { // Checkout (git clone ...) the projects repository //test git-push
      steps {
        checkout scm

      }
    }

    stage('Building image') { //building image
      steps{
        script {
          docker.build("306655/image_repo","./simple_app/")
        }
      }
    }

    stage ('Test image') { // test image
      agent{
        docker {image'306655/image_repo'}
      }
      steps {
      sh "curl -X GET http://localhot:5000"}
    }

    stage ( 'push image' ) { //push image
      steps {
        script {
          docker.withRegistry('https://hub.docker.com/r/306655/image_repo','registryCredential') {
            dockerImage.push() 
          }
        }
      }
    }

    stage('Destroy') {
      steps {
        echo '> Destroying the docker artifacts ...'
        sh 'make -sC docker/ destroy'
      }
    }
    stage('Deploy') {
        steps {
          echo '> Deploying the application ...'
          sh 'ansible-playbook /simple-deploy.yml -i /inventory.yml'
        }
    }
  }
}