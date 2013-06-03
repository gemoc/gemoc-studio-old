package org.gemoc.gemoc_process.executable_metamodel_creator.impl;

import org.gemoc.gemoc_process.executable_metamodel_creator.KM2KMTexecutable_metamodel_creator;

public class KM2KMTexecutable_metamodel_creatorImpl4Eclipse implements KM2KMTexecutable_metamodel_creator {

	public KM2KMTexecutable_metamodel_creatorImpl4Eclipse(){

		kermeta_standard.org.kermeta.language.structure.KerRichFactory$ k;
		
		gemoc_process_executable_metamodel_creatorrunner.DefaultRunner$.MODULE$.init4eclipse();   	
    }
	

	public void mainOperationScala (){
		gemoc_process_executable_metamodel_creatorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_executable_metamodel_creator.mainPackage.MainClass mainClass_ = gemoc_process_executable_metamodel_creator.mainPackage.KerRichFactory.createMainClass();
		mainClass_.mainOperation();
	}
	

    public void generateCompilerProjectScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject) {
		gemoc_process_executable_metamodel_creatorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_executable_metamodel_creator.org.kermeta.language.aspectgenerator.AspectGenerator aspectGenerator_ = gemoc_process_executable_metamodel_creator.org.kermeta.language.aspectgenerator.KerRichFactory.createAspectGenerator();
        aspectGenerator_.generateCompilerProject (nameProject, folderLocation, ecoreFile, ecoreProject);
	}
    

	public void generateInterpreterProjectScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject) {
		gemoc_process_executable_metamodel_creatorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_executable_metamodel_creator.org.kermeta.language.aspectgenerator.AspectGenerator aspectGenerator_ = gemoc_process_executable_metamodel_creator.org.kermeta.language.aspectgenerator.KerRichFactory.createAspectGenerator();
		aspectGenerator_.generateInterpreterProject(nameProject, folderLocation, ecoreFile, ecoreProject);
	}
    

	public void generateCustomizeProjectScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject, String operationName, String operationReturnType, k2.standard.KermetaOrderedSet<String> operationParams, k2.standard.KermetaOrderedSet<String> listNewClass) {
		gemoc_process_executable_metamodel_creatorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_executable_metamodel_creator.org.kermeta.language.aspectgenerator.AspectGenerator aspectGenerator_ = gemoc_process_executable_metamodel_creator.org.kermeta.language.aspectgenerator.KerRichFactory.createAspectGenerator();
		aspectGenerator_.generateCustomizeProject(nameProject, folderLocation, ecoreFile, ecoreProject, operationName, operationReturnType, operationParams, listNewClass);
	}
    

	public void generateVisitorProjectScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject) {
		gemoc_process_executable_metamodel_creatorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_executable_metamodel_creator.org.kermeta.language.aspectgenerator.AspectGenerator aspectGenerator_ = gemoc_process_executable_metamodel_creator.org.kermeta.language.aspectgenerator.KerRichFactory.createAspectGenerator();
		aspectGenerator_.generateVisitorProject (nameProject, folderLocation, ecoreFile, ecoreProject);
	}
    

	public void generateAspectProjectScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject) {
		gemoc_process_executable_metamodel_creatorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_executable_metamodel_creator.org.kermeta.language.aspectgenerator.AspectGenerator aspectGenerator_ = gemoc_process_executable_metamodel_creator.org.kermeta.language.aspectgenerator.KerRichFactory.createAspectGenerator();
		aspectGenerator_.generateAspectProject (nameProject, folderLocation, ecoreFile, ecoreProject);
	}
	

	public void generateNoneScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject) {
		gemoc_process_executable_metamodel_creatorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_executable_metamodel_creator.org.kermeta.language.aspectgenerator.AspectGenerator aspectGenerator_ = gemoc_process_executable_metamodel_creator.org.kermeta.language.aspectgenerator.KerRichFactory.createAspectGenerator();
		aspectGenerator_.generateNone (nameProject, folderLocation, ecoreFile, ecoreProject);
	}
	

	public void generateDynamicAttributeScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject, String operationName, String operationReturnType, k2.standard.KermetaOrderedSet<String> operationParams, k2.standard.KermetaOrderedSet<String> listNewClass) {
		gemoc_process_executable_metamodel_creatorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_executable_metamodel_creator.mainPackage.MainClass mainClass_ = gemoc_process_executable_metamodel_creator.mainPackage.KerRichFactory.createMainClass();
		mainClass_.generateDynamicAttribute(nameProject, folderLocation, ecoreFile, ecoreProject, operationName, operationReturnType, operationParams, listNewClass);
	}
	
	public k2.standard.KermetaOrderedSet<String> listMetaClassesScala (String ecoreProjectPath) {
		gemoc_process_executable_metamodel_creatorrunner.DefaultRunner$.MODULE$.init4eclipse();
		
		gemoc_process_executable_metamodel_creator.mainPackage.MainClass mainClass_ = gemoc_process_executable_metamodel_creator.mainPackage.KerRichFactory.createMainClass();
		return mainClass_.listMetaClasses(ecoreProjectPath);
	}
}
