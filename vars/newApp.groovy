def call(String repoUrl){
    pipeline{
        agent any
        stages{
            stage('1-build'){
                steps{
                    sh 'free -m'
                }
            }
           stage('2-parallel jobs'){
				parallel{
					stage('1-analysis'){
						steps{
							sh 'lscpu'
						}
					}
					stage('2-parallel2-job'){
						when {
							branch 'feature'
						}
						steps{
							sh 'df -h'
							sh 'free -g'
						}
					}

				}
			}
            stage("Checkout Code") {
               steps{
                   git branch: 'main',
                          url: "${repoUrl}"
               }
           }
           stage('closing'){
            steps{
                echo "AppBank"
            }
           }
           stage('Analysis'){
            steps{
                sh 'free -g'
                sh 'pwd'
            }
           }
        }
    }
}
