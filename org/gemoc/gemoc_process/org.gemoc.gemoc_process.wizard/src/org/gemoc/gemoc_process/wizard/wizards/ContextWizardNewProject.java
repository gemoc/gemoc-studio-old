package org.gemoc.gemoc_process.wizard.wizards;

import java.util.ArrayList;

import k2.standard.RichKermetaOrderedSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;


public class ContextWizardNewProject {
	
	public boolean 	ecoreProject;
	public String 	typeProject;
	public String 	nameProject;
	public String 	locationProject;
	public IFile 	ecoreIFile;
	public String 	ecoreProjectPath;
	public String 	operationName;
	public String 	operationReturnType;
	public Integer	indexTransfomation;
	
	public k2.standard.KermetaOrderedSet<String> listNewClass;
	public k2.standard.KermetaOrderedSet<String> operationParams; 
	
	public ContextWizardNewProject () {
		this.ecoreProject 			= false;
		this.typeProject			= "None";
		this.nameProject 			= "NewKermetaProject";
		this.locationProject 		= ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
		this.ecoreIFile				= null;
		this.ecoreProjectPath		= "";
		this.operationName 			= "";
		this.operationReturnType 	= "";
		this.operationParams 		= new RichKermetaOrderedSet<String>(new ArrayList<String>());
		this.listNewClass 			= new RichKermetaOrderedSet<String>(new ArrayList<String>());
		this.indexTransfomation		= 0;
	}
}
