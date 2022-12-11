def call(String repoUrl){
    pipeline {
       agent any
        stages {
           stage("Tools initialization") {
               steps {
                   sh 'lscpu'
                   sh 'java -version'
               }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'main',
                          url: "${repoUrl}"
               }
           }
           stage("to-test-maven") {
               steps {
                   sh 'df -h'
                   sh 'free -m'
               }
           }
       }
}
}