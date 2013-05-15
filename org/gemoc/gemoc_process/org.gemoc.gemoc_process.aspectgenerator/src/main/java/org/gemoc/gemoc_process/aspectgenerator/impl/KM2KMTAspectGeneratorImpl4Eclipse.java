package org.gemoc.gemoc_process.aspectgenerator.impl;

import org.gemoc.gemoc_process.aspectgenerator.KM2KMTAspectGenerator;

public class KM2KMTAspectGeneratorImpl4Eclipse implements KM2KMTAspectGenerator {

	public KM2KMTAspectGeneratorImpl4Eclipse(){

		kermeta_standard.org.kermeta.language.structure.KerRichFactory$ k;
		
		gemoc_process_aspectgeneratorrunner.DefaultRunner$.MODULE$.init4eclipse();   	
    }
	
	@Override
	public void mainOperationScala (){
		gemoc_process_aspectgeneratorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_aspectgenerator.mainPackage.MainClass mainClass_ = gemoc_process_aspectgenerator.mainPackage.KerRichFactory.createMainClass();
		mainClass_.mainOperation();
	}
	
	@Override
    public void generateCompilerProjectScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject) {
		gemoc_process_aspectgeneratorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_aspectgenerator.org.kermeta.language.aspectgenerator.AspectGenerator aspectGenerator_ = gemoc_process_aspectgenerator.org.kermeta.language.aspectgenerator.KerRichFactory.createAspectGenerator();
        aspectGenerator_.generateCompilerProject (nameProject, folderLocation, ecoreFile, ecoreProject);
	}
    
	@Override
	public void generateInterpreterProjectScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject) {
		gemoc_process_aspectgeneratorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_aspectgenerator.org.kermeta.language.aspectgenerator.AspectGenerator aspectGenerator_ = gemoc_process_aspectgenerator.org.kermeta.language.aspectgenerator.KerRichFactory.createAspectGenerator();
		aspectGenerator_.generateInterpreterProject(nameProject, folderLocation, ecoreFile, ecoreProject);
	}
    
	@Override
	public void generateCustomizeProjectScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject, String operationName, String operationReturnType, k2.standard.KermetaOrderedSet<String> operationParams, k2.standard.KermetaOrderedSet<String> listNewClass) {
		gemoc_process_aspectgeneratorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_aspectgenerator.org.kermeta.language.aspectgenerator.AspectGenerator aspectGenerator_ = gemoc_process_aspectgenerator.org.kermeta.language.aspectgenerator.KerRichFactory.createAspectGenerator();
		aspectGenerator_.generateCustomizeProject(nameProject, folderLocation, ecoreFile, ecoreProject, operationName, operationReturnType, operationParams, listNewClass);
	}
    
	@Override
	public void generateVisitorProjectScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject) {
		gemoc_process_aspectgeneratorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_aspectgenerator.org.kermeta.language.aspectgenerator.AspectGenerator aspectGenerator_ = gemoc_process_aspectgenerator.org.kermeta.language.aspectgenerator.KerRichFactory.createAspectGenerator();
		aspectGenerator_.generateVisitorProject (nameProject, folderLocation, ecoreFile, ecoreProject);
	}
    
	@Override
	public void generateAspectProjectScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject) {
		gemoc_process_aspectgeneratorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_aspectgenerator.org.kermeta.language.aspectgenerator.AspectGenerator aspectGenerator_ = gemoc_process_aspectgenerator.org.kermeta.language.aspectgenerator.KerRichFactory.createAspectGenerator();
		aspectGenerator_.generateAspectProject (nameProject, folderLocation, ecoreFile, ecoreProject);
	}
	
	@Override
	public void generateNoneScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject) {
		gemoc_process_aspectgeneratorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_aspectgenerator.org.kermeta.language.aspectgenerator.AspectGenerator aspectGenerator_ = gemoc_process_aspectgenerator.org.kermeta.language.aspectgenerator.KerRichFactory.createAspectGenerator();
		aspectGenerator_.generateNone (nameProject, folderLocation, ecoreFile, ecoreProject);
	}
}
