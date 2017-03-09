node {  
	def mvnHome = tool 'Maven3.3.9'
	echo "${mvnHome}"
	
	stage('Checkout') {
		checkout poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'git@github.com:bvelivala/SampleInsurance.git']]]
		sh '/usr/local/apache-maven/apache-maven-3.3.9/bin/mvn clean'
    }
	
	stage('Build, Unit Test and Code Coverage') {
		sh '/usr/local/apache-maven/apache-maven-3.3.9/bin/mvn org.jacoco:jacoco-maven-plugin:prepare-agent install cobertura:cobertura -Dcobertura.report.format=xml'
	}	
	
	stage('Sonar Code Analysis') {
		withSonarQubeEnv {
			sh "/usr/local/apache-maven/apache-maven-3.3.9/bin/mvn sonar:sonar -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.login=admin -Dsonar.password=admin -Dsonar.github.repository=bvelivala/SampleInsurance -Dsonar.projectName=Autoclaim_${BUILD_NUMBER} -Dsonar.projectVersion=${BUILD_NUMBER} -Dsonar.sources=src/main -Dsonar.junit.reportsPath=target/surefire-reports -Dsonar.jacoco.reportPath=target/jacoco.exec -Dsonar.jacoco.itReportPath=target/jacoco.exec -Dsonar.cobertura.reportPath=target/site/cobertura/coverage.xml"
		}
	}
					
	stage('Push Binaries') {
	    junit 'target/surefire-reports/*.xml'
	    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/site/jacoco', reportFiles: 'index.html', reportName: 'Code Coverage'])          
		performanceReport compareBuildPrevious: false, configType: 'PRT', errorFailedThreshold: 10, errorUnstableResponseTimeThreshold: '', errorUnstableThreshold: 10, failBuildIfNoResultFile: false, modeOfThreshold: false, modePerformancePerTestCase: true, modeThroughput: false, nthBuildNumber: 0, parsers: [[$class: 'JUnitParser', glob: '**/TEST-*.xml']], relativeFailedThresholdNegative: -5.0, relativeFailedThresholdPositive: 5.0, relativeUnstableThresholdNegative: -5.0, relativeUnstableThresholdPositive: 5.0
		nexusArtifactUploader artifacts: [[artifactId: 'autoclaim', classifier: '', file: 'target/autoclaim.war', type: 'war']], credentialsId: 'nexus', groupId: 'com.example', nexusUrl: 'ec2-35-166-232-252.us-west-2.compute.amazonaws.com:8081/nexus', nexusVersion: 'nexus2', protocol: 'http', repository: 'releases', version: '${BUILD_NUMBER}'
	}
}
