pipeline {

  environment {
    registry = "306655/image_repo"
    registryCredential = 'dockerhub'
  }
  agent any

// Define the individual processes, or stages, of your CI pipeline

  stages {
// Checkout (git clone ...) the projects repository
// to test push a change to git
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

//building image
    stage('Building image') {
      steps{
        script {
          docker.build("306655/image_repo","./Dockerfile")
        }
      }
    }

// test image
    stage ('Test image') {
      agent{
        docker {image'306655/image_repo'}
      }
      steps {
        sh "curl -X GET http://localhot:5000"
      }
    }

//push image
    stage ( 'push image' ) {
      steps {
        script {
          docker.withRegistry('https://hub.docker.com/r/306655/image_repo','registryCredential')
          {
            dockerImage.push()
          }
        }
      }
    }

//destroy the docker artifacts
		stage('Destroy') {
		  steps {
		      echo '> Destroying the docker artifacts ...'
		      sh 'make -sC docker/ destroy'
		  }
		}

//deploy image with ansible to production server
		stage('Deploy') {
		  steps {
		      echo '> Deploying the application ...'
		      sh 'ansible-playbook /simple-deploy.yml -i /inventory.yml'
		  }
		}
	}
}
