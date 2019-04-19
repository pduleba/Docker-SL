pipeline {

    // BEFORE RUN REQUIRED
    // * exercise-03-rest-api-crud/app-db/exec-run-network.bat
    // * exercise-03-rest-api-crud/app-db/exec-build.bat
    // * exercise-03-rest-api-crud/app-db/exec-run.bat

    //-----------------------------------------
    // Declarative Pipeline Syntax Reference :: https://jenkins.io/doc/book/pipeline/syntax/#declarative-pipeline
    // Declarative Pipeline Steps Reference  :: https://jenkins.io/doc/pipeline/steps/
    //-----------------------------------------

    // default agent - docker container
    agent {
        docker {
            // maven 3.6.1 + jdk 8
            image "maven:3.6.1-jdk-8"
            // `app-network` need to be present
            args "-p 8888:8888 --network=app-network --name app-rest-api"
        }
    }
    parameters {
        // parallel integration (on node labeled `master-label`)
        string(name: "ROOT_PATH", defaultValue: "exercise-03-rest-api-crud/app-rest-api", description: "Project root path in workspace")
    }

    options {
        disableConcurrentBuilds()
    }

    tools {
        // NOT in use with `docker` agent, but leaving for use with jenkins agent
        // tool `1.8.0_201` needs to be defined in Manage Jenkins -> Global tools -> JDK
        jdk "1.8.0_201"
        // tool `3.6.0` needs to be defined in Manage Jenkins -> Global tools -> Maven
        maven "3.6.0"
    }

    stages {
        stage("Start?") {
            input{
                message "Start?"
                ok "Yes."
            }
            steps {
                echo "Approved"
            }
        }

        stage("Clean") {
            steps {
                dir(params.ROOT_PATH) {
                    sh "mvn clean"
                }
            }
        }

        stage("Test") {
            steps {
                dir(params.ROOT_PATH) {
                    sh "mvn test"
                }
            }
        }

        stage("Install") {
            steps {
                dir(params.ROOT_PATH) {
                    sh "mvn install -Dmaven.test.skip=true"
                }
            }
        }

        stage("Archive") {
            steps {
                dir(params.ROOT_PATH) {
                    archiveArtifacts "target/*.jar"
                }
            }
        }

        stage("Deploy to development") {
            when {
                branch "development"
            }
            steps {
                sh "cd ${params.ROOT_PATH} && ./app-start.sh"
                input message: "Is `development` API running on port 8888?", ok: "Yes"
                sh "cd ${params.ROOT_PATH} && ./app-stop.sh"
            }
        }
        stage("Deploy for production") {
            when {
                branch "production"
            }
            steps {
                sh "cd ${params.ROOT_PATH} && ./app-start.sh"
                input message: "Is `production` API running on port 8888?", ok: "Yes"
                sh "cd ${params.ROOT_PATH} && ./app-stop.sh"
            }
        }
    }
}
