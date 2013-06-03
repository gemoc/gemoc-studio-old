package org.gemoc.gemoc_process.executable_metamodel_creator;

public interface KM2KMTexecutable_metamodel_creator {

	    public void mainOperationScala ();
	    
	    public void generateCompilerProjectScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject);
	    public void generateInterpreterProjectScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject);
	    public void generateCustomizeProjectScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject, String operationName, String operationReturnType, k2.standard.KermetaOrderedSet<String> operationParams, k2.standard.KermetaOrderedSet<String> listNewClass);
	    public void generateVisitorProjectScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject);
	    public void generateAspectProjectScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject);
	    public void generateNoneScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject);
	    public void generateDynamicAttributeScala(String nameProject, String folderLocation, String ecoreFile, String ecoreProject, String operationName, String operationReturnType, k2.standard.KermetaOrderedSet<String> operationParams, k2.standard.KermetaOrderedSet<String> listNewClass);
	    public k2.standard.KermetaOrderedSet<String> listMetaClassesScala(String ecoreProjectPath);
}