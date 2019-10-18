def call(){
    //Jenkinsfile
node {
  stage('build') {
    //build code (ex: mvn deploy)
  }
  stage('deploy to qa') {
    //deploy code (ex: aws cloudformation create-stack)
  }
  stage('test') {
    //test code (ex: sh /path/to/test/script.sh)
  }
  stage('deploy to staging') {
    //deploy code (ex: aws cloudformation create-stack)
  }
  stage('test') {
    //test code (ex: sh /path/to/test/script.sh)
  }
  stage('deploy to prod') {
    //deploy code (ex: aws cloudformation create/update-stack)
      }
    }
}
def packageArtifact(){
    stage("Package artifact") {
        sh "mvn package"
    }
}

def buildAndTest(){
    stage("Backend tests"){
        sh "mvn test"
    }
}
