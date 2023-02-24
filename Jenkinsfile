#!/usr/bin/env groovy

@Library('lto-jenkins-pipeline-library@master') _

def mavenOptions = [
    maven: "maven-in-docker-build-slave",
    jdk: "openjdk-19-in-docker-image",
    mavenOpts: setMavenOptions()
]

pipeline {
    agent none
    environment {
        APP_TYPE = 'lsl-jaxb3-basics'
        APP_VERSION = setMavenVersion()
    }
    options {
        buildDiscarder(
                logRotator(numToKeepStr: '100', daysToKeepStr: '30', artifactNumToKeepStr: '20', artifactDaysToKeepStr: '10')
        )
        timestamps()
    }
    stages {
        stage('Build and Test') {
            agent {
                label 'openjdk-19'
            }
            steps {
                withMaven(mavenOptions) {
                    echo "MAVEN_OPTS: ${MAVEN_OPTS}"
                    sh 'mvn versions:set -DnewVersion=${APP_VERSION}'
                    sh '_JAVA_OPTIONS="--add-opens=java.base/java.net=ALL-UNNAMED"  mvn -U -Ptests clean verify'
                }
                stash name: 'target', includes: '**/target/**'
            }
        }
        // stage('Sonar Analysis') {
        //     agent {
        //         label 'openjdk-19'
        //     }
        //     steps {
        //         unstash 'target'
        //         withSonarQubeEnv('sonar.qantasloyalty.io') {
        //             withMaven(mavenOptions) {
        //                 echo "MAVEN_OPTS: ${MAVEN_OPTS}"
        //                 sh 'mvn sonar:sonar -Dsonar.projectVersion=${APP_VERSION}'
        //             }
        //         }
        //         timeout(time: 1, unit: 'HOURS') {
        //             waitForQualityGate abortPipeline: true
        //         }
        //     }
        // }
        stage('Artefact Deploy') {
            agent {
                label 'openjdk-19'
            }
            when {
                beforeAgent true
                anyOf {
                    branch 'master';
                    branch 'develop';
                }
            }
            steps {
                unstash 'target'
                script {
                    if ("${BRANCH_NAME}" == "master") {
                        withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'github-qantasloyalty-org-admin', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
                            sh("git tag -a ${APP_VERSION} -m 'Version ${APP_VERSION}'")
                            sh("git push https://${USERNAME}:${PASSWORD}@github.com/qantasloyalty/${APP_TYPE}.git --tags")
                        }
                    }
                }
                withMaven(mavenOptions) {
                    unstash 'target'
                    echo "MAVEN_OPTS: ${MAVEN_OPTS}"
                    sh 'mvn versions:set -DnewVersion=${APP_VERSION}'
                    sh 'mvn -T 1C jar:jar source:jar javadoc:jar deploy:deploy'
                }
            }
        }
    }
    post {
        success {
            slackSend(
                    channel: "tech-cicd",
                    color: 'good',
                    message: "Woohoo! The pipeline ${currentBuild.fullDisplayName} completed successfully. ${BUILD_URL}"
            )
        }
        unstable {
            slackSend(
                    channel: "tech-cicd",
                    color: 'warning',
                    message: "The pipeline ${currentBuild.fullDisplayName} is unstable. ${BUILD_URL}"
            )
        }
        failure {
            slackSend(
                    channel: "tech-cicd",
                    color: 'danger',
                    message: "Uh oh! The pipeline ${currentBuild.fullDisplayName} failed. ${BUILD_URL}"
            )
        }
    }
}
