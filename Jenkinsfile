pipeline {
  agent any
  stages {
    stage('Dev Code Pull') {
      steps {
        git(url: 'https://github.com/TestLeafInc/WebApp.git', branch: 'master')
      }
    }

    stage('Dev Maven Build') {
      steps {
        tool(name: 'MAVEN_HOME', type: 'maven')
        bat 'start /min stopApp.bat'
        bat 'mvn install'
        bat 'set JENKINS_NODE_COOKIE=dontkillMe && start /min startApp.bat'
      }
    }

    stage('QA Deploy') {
      steps {
        echo 'Deployment to QA'
      }
    }

    stage('QA Automation Test') {
      parallel {
        stage('QA Automation Test') {
          steps {
            echo 'Run Automation Test'
            sleep 10
          }
        }

        stage('API Test') {
          steps {
            git(url: 'https://github.com/susivictor04/WebAppApiAutomation.git', branch: 'master')
            bat 'mvn test'
          }
        }

        stage('UI Automation test') {
          steps {
            git(url: 'https://github.com/TestLeafInc/WebAppUiAutomation.git', branch: 'master')
            bat 'mvn test'
          }
        }

      }
    }

    stage('QA Certify') {
      steps {
        input 'Do you want to certify?'
      }
    }

    stage('UAT Deployment') {
      steps {
        echo 'Deployment to UAT'
      }
    }

    stage('UAT Certify') {
      steps {
        input 'Do you want to certify UAT ?'
      }
    }

    stage('Prod Deployment') {
      steps {
        echo 'Deployment to Production'
      }
    }

  }
}