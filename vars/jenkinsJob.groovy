def call(){
    //Jenkinsfile
node {
  stage('build') {
    echo 'from build stage'
  }
  stage('deploy to qa') {
    //deploy code (ex: aws cloudformation create-stack)
      echo 'from deploy to qa stage'
  }
  stage('test') {
    //test code (ex: sh /path/to/test/script.sh)
      echo 'from build stage'
  }
  stage('deploy to staging') {
    //deploy code (ex: aws cloudformation create-stack)
      echo 'deploy to staging'
  }
  stage('test') {
    //test code (ex: sh /path/to/test/script.sh)
      echo 'from test stage'
      packageArtifact()
  }
  stage('deploy to prod') {
    //deploy code (ex: aws cloudformation create/update-stack)
      echo 'from build deploy to prod stage'
      buildAndTest()
      }
   }
}
def packageArtifact(){
    stage("Package artifact") {
        sh "date"
    }
}

def buildAndTest(){
    stage("Backend tests"){
        sh "pwd"
    }
}
