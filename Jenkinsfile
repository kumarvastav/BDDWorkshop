pipeline {
  agent any
  stages {
    stage('Build-Deploy') {
      steps {
        sh 'mvn clean test'
      }
    }
  }
}