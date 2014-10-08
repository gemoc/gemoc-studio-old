package org.gemoc.gemoc_language_workbench.conf.util;

import org.gemoc.gemoc_language_workbench.conf.AnimatorProject;
import org.gemoc.gemoc_language_workbench.conf.DSAProject;
import org.gemoc.gemoc_language_workbench.conf.DSEProject;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.FileResource;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.MoCProject;
import org.gemoc.gemoc_language_workbench.conf.ODProject;
import org.gemoc.gemoc_language_workbench.conf.XTextEditorProject;
import org.gemoc.gemoc_language_workbench.conf.confFactory;

public class XDSMLModelHelper {
	public static DomainModelProject getOrCreateDomainModelProject(LanguageDefinition languageDefinition){
		if(languageDefinition.getDomainModelProject() == null){
	    	EMFEcoreProject domainModelProject = confFactory.eINSTANCE.createEMFEcoreProject();
	    	languageDefinition.setDomainModelProject(domainModelProject);
	    }
		return languageDefinition.getDomainModelProject();
	}
	
	public static EditorProject getOrCreateXTextEditorProject(LanguageDefinition languageDefinition){

	    EditorProject xTextEditor = null;
		for(EditorProject editor : languageDefinition.getEditorProjects()){
	    	if(editor instanceof XTextEditorProject){
	    		xTextEditor = editor;
	    	}
	    }
	    
	    if(xTextEditor == null){
	    	xTextEditor = confFactory.eINSTANCE.createXTextEditorProject();
	    	languageDefinition.getEditorProjects().add(xTextEditor);
	    }
	    return xTextEditor;
	}
	
	public static EditorProject getOrCreateSiriusEditorProject(LanguageDefinition languageDefinition){

	    EditorProject siriusEditor = null;
		for(EditorProject editor : languageDefinition.getEditorProjects()){
	    	if(editor instanceof ODProject){
	    		siriusEditor = editor;
	    	}
	    }
	    
	    if(siriusEditor == null){
	    	siriusEditor = confFactory.eINSTANCE.createODProject();
	    	languageDefinition.getEditorProjects().add(siriusEditor);
	    }
	    return siriusEditor;
	}

	public static AnimatorProject getOrCreateSiriusAnimatorProject(
			LanguageDefinition languageDefinition) {
		AnimatorProject siriusEditor = null;
		for(AnimatorProject editor : languageDefinition.getAnimatorProjects()){
	    	if(editor instanceof ODProject){
	    		siriusEditor = editor;
	    	}
	    }
	    
	    if(siriusEditor == null){
	    	siriusEditor = confFactory.eINSTANCE.createSiriusAnimatorProject();
	    	languageDefinition.getAnimatorProjects().add(siriusEditor);
	    }
	    return siriusEditor;
	}

	public static FileResource getOrCreateEmfGenmodel(
			LanguageDefinition languageDefinition) {
		EMFEcoreProject ecoreProject = (EMFEcoreProject)getOrCreateDomainModelProject(languageDefinition);
		if(ecoreProject.getEmfGenmodel() == null){
			ecoreProject.setEmfGenmodel(confFactory.eINSTANCE.createEMFGenmodel());
		}
		return ecoreProject.getEmfGenmodel();
	}
	
	public static DSAProject getOrCreateDSAProject(LanguageDefinition languageDefinition){
		if(languageDefinition.getDsaProject() == null){
	    	languageDefinition.setDsaProject(confFactory.eINSTANCE.createK3DSAProject());
	    }
		return languageDefinition.getDsaProject();
	}
	public static DSEProject getOrCreateDSEProject(LanguageDefinition languageDefinition){
		if(languageDefinition.getDSEProject() == null){
	    	languageDefinition.setDSEProject(confFactory.eINSTANCE.createECLProject());
	    }
		return languageDefinition.getDSEProject();
	}
	
	public static MoCProject getOrCreateMoCCProject(LanguageDefinition languageDefinition){
		if(languageDefinition.getMoCModelProject() == null){
	    	languageDefinition.setMoCModelProject(confFactory.eINSTANCE.createCCSLMoCProject());
	    }
		return languageDefinition.getMoCModelProject();
	}
}
