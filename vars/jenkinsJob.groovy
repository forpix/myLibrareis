def call(){

deleteDir()
    node {
        stage('Checkout') {
            checkout scm
        
    try {
        stage ('Build') {
            sh "echo 'shell scripts to build project...'"
            build()
        }
        stage ('Tests') {
            parallel 'static': {
                sh "echo 'shell scripts to run static tests...'"
            },
            'unit': {
                sh "echo 'shell scripts to run unit tests...'"
            },
            'integration': {
                sh "echo 'shell scripts to run integration tests...'"
            }
        }
        stage ('Deploy') {
            sh "echo 'shell scripts to deploy to server...'"
        }
    } catch (err) {
        currentBuild.result = 'FAILED'
        throw err
    }
        }

        // Execute different stages depending on the job
        if(env.JOB_NAME.contains("deploy")){
            packageArtifact()
        } else if(env.JOB_NAME.contains("test")) {
            buildAndTest()
        }
    }
}

def build(){
    stage("Package artifact") {
        def mvnHome = tool name: 'maven 3.5.4', type: 'maven'
        sh "${mvnHome}/bin/mvn clean package -Dmaven.test.skip=true"
    }
}

def buildAndTest(){
    stage("Backend tests"){
        sh "mvn test"
    }
}
