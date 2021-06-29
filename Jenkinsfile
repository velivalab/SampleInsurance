node {  
	def mvnHome = tool 'Maven'
	echo "${mvnHome}"
	
	stage('Checkout') {
		snDevOpsStep()
		checkout poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'git@github.com:bvelivala/SampleInsurance.git']]]
		sh 'mvn clean'
    	}
	
	stage('Build') {
		snDevOpsStep()
		sh 'mvn compile'
	}
	
	stage('Test') {
		snDevOpsStep()
		sh 'mvn test -Dmaven.test.failure.ignore=true'
	}
	
	stage('Deploy') {
		snDevOpsStep()
		sh 'echo Deploy Stage'
	}
	
	//stage('Sonar Code Analysis') {
	//	withSonarQubeEnv('Sonar') {
	//		sh "/usr/local/Cellar/maven/3.6.3_1/libexec/bin/mvn sonar:sonar -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.login=admin -Dsonar.password=admin13 -Dsonar.github.repository=pmbharsh/SampleInsurance -Dsonar.projectName=Autoclaim_${BUILD_NUMBER} -Dsonar.projectVersion=${BUILD_NUMBER} -Dsonar.sources=src/main"
	//	}
	//}
}
