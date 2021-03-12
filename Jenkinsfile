pipeline {
    agent any
        options { timeout(time: 5) } // Stop execution if spend more than 5 min

     stages {
     stage ('Initialize') {
                steps {
                  echo 'Getting PATH'
                    sh '''
                        echo "PATH = ${PATH}"
                        echo "M2_HOME = ${M2_HOME}"
                    '''
                }
            }
        stage('Build') {
            steps {
            echo 'Running test suite'
               sh 'mvn clean test -Dsuite=testng'
            }
        }
    }

    /* post {
            always {
               cucumber '**//* cucumber.json'

                echo 'Sending email'
                 mail to: 'bmaggioi_l667d@fuluj.com',
                          subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
                          body: "${env.BUILD_URL} has result ${currentBuild.result}",
                          sortingMethod: 'ALPHABETICAL'


                          mail to: 'bmaggioi_l667d@fuluj.com',
                              subject: "Job '${JOB_NAME}' (${BUILD_NUMBER}) is waiting for input",
                              body: "Please go to ${BUILD_URL} and verify the build"
            }
        } */


        post {
                     always {
                         echo 'This will always run'
                         cucumber '**/cucumber.json'

                         emailext(
                            attachmentsPattern: "report-output/WebReport/ExtentWeb.html",
                            subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
                            body: "${env.BUILD_URL} has result ${currentBuild.result}",
                            to: 'bmaggioi_l667d@fuluj.com'
                         )
                     }
                     success {
                         echo 'This will run only if successful'
                     }
                     failure {
                         emailext(
                             attachmentsPattern: "report-output/WebReport/ExtentWeb.html",
                             subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
                             body: "${env.BUILD_URL} has result ${currentBuild.result}",
                             to: 'bmaggioi_l667d@fuluj.com'
                           )
                        // mail bcc: '', body: "<b>Example</b><br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL}", cc: '', charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "ERROR CI: Project name -> ${env.JOB_NAME}", to: "foo@foomail.com";
                     }
                     unstable {
                         echo 'This will run only if the run was marked as unstable'
                     }
                     changed {
                         echo 'This will run only if the state of the Pipeline has changed'
                         echo 'For example, if the Pipeline was previously failing but is now successful'
                     }
                 }



}