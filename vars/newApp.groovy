def uber(String repoUrl){
    pipeline{
        agent any
        stages{
            stage('1-build'){
                steps{
                    sh 'free -m'
                }
            }
            stage('2-system-analysis'){
                steps{
                    sh 'lsblk'
                }
            }
            stage("Checkout Code") {
               steps {
                   git branch: 'main',
                          url: "${repoUrl}"
               }
           }
           stage('closing'){
            steps{
                echo "Build my app"
            }
           }
           stage('clone'){
            steps{
                sh 'free -g'
            }
           }
        }
    }
}
