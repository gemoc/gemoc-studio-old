#!groovy
node {
   catchError {
	   def mvnHome
	   stage('Preparation') {
	   
	      // Get code from GitHub repositories
	
	      // this will check if there is a branch with the same name as the current branch (ie. the branch containing this Jenkinsfile) and use that for the checkout, but if there is no
	      // branch with the same name it will fall back to the master branch
	      dir('gemoc-studio') {
	         def gemocstudioScm = resolveScm source: [$class: 'GitSCMSource', credentialsId: '', id: '_', remote: 'https://github.com/gemoc/gemoc-studio.git', traits: [[$class: 'BranchDiscoveryTrait']]], targets: [BRANCH_NAME, 'master']
	         checkout gemocstudioScm
	      }
	      dir('ModelDebugging') {
	         def gemocstudiomodeldebuggingScm = resolveScm source: [$class: 'GitSCMSource', credentialsId: '', id: '_', remote: 'https://github.com/SiriusLab/ModelDebugging.git', traits: [[$class: 'BranchDiscoveryTrait']]], targets: [BRANCH_NAME, 'master']
	         checkout gemocstudiomodeldebuggingScm
	      }
	      dir('gemoc-studio.wiki') {
	         def gemocstudiowikiScm = resolveScm source: [$class: 'GitSCMSource', credentialsId: '', id: '_', remote: 'https://github.com/gemoc/gemoc-studio.wiki.git', traits: [[$class: 'BranchDiscoveryTrait']]], targets: [BRANCH_NAME, 'master']
	         checkout gemocstudiowikiScm
	      }
	      dir('concurrency') {
	         def gemocstudioconcurrencyScm = resolveScm source: [$class: 'GitSCMSource', credentialsId: '', id: '_', remote: 'https://github.com/gemoc/concurrency.git', traits: [[$class: 'BranchDiscoveryTrait']]], targets: [BRANCH_NAME, 'master']
	         checkout gemocstudioconcurrencyScm
	      }
	      dir('coordination') {
	         def gemocstudiocoordinationScm = resolveScm source: [$class: 'GitSCMSource', credentialsId: '', id: '_', remote: 'https://github.com/gemoc/coordination.git', traits: [[$class: 'BranchDiscoveryTrait']]], targets: [BRANCH_NAME, 'master']
	         checkout gemocstudiocoordinationScm
	      }
	      echo 'Content of the workspace'
	      sh "ls"
	      // Get the Maven tool.
	      // ** NOTE: This 'apache-maven-latest' Maven tool must be configured in the global configuration.
	      // in order to find existing tools and their name, use the snippet generator available in the target jenkins instance (ie.  "Pipeline Syntax" link on the job)         
	      mvnHome = tool 'apache-maven-latest'
	   }
	   stage('Build and verify') {
	      // Run the maven build with test            
	      dir ('gemoc-studio/dev_support/full_compilation') {
	          wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
	              // sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean verify --errors -P ignore_CI_repositories,!use_CI_repositories"
	              sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore -DfailIfNoTests=false clean verify --errors -P ignore_CI_repositories,!use_CI_repositories"
	          }
	      }      
	   }	   
	   stage('Deployment') {
	      junit '**/target/surefire-reports/TEST-*.xml'
	      archiveArtifacts '**/target/products/*.zip,**/gemoc-studio/gemoc_studio/releng/org.eclipse.gemoc.gemoc_studio.updatesite/target/repository/**'
	   }
   }
   step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: '', sendToIndividuals: true])
}
