node(){
		def repoURL='https://github.com/muhammadfarhansoomro/SprintBoot_Learning_project.git'

		stage("Prepare Workspace"){
			cleanWs()
			env.WORKSPACE_LOCAL=sh(returnStdout:true,script:'pwd').trim()
			echo"Workspace set to:"+env.WORKSPACE_LOCAL
		}
		stage('Checkout Self'){
		git branch:'master',credentialsId:'',url:repoURL
		}
		stage('Cucumber Tests'){
			withMaven(maven:'Maven35'){
				bat """
					cd ${env.WORKSPACE_LOCAL}
					mvn clean test
				"""
			}
		}
		stage('Expose report'){
			archive "**/cucumber.json"
			cucumber '**/cucumber.json'
		}

            stage('Generate HTML report') {
                cucumber buildStatus: 'UNSTABLE',
                        reportTitle: 'SprintBoot Learning project Test Report',
                        fileIncludePattern: '**/cucumber.json',
                        trendsLimit: 10,
                        classifications: [
                            [
                                'key': 'Browser',
                                'value': 'Firefox'
                            ]
                        ]
            }
  }