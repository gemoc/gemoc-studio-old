package org.gemoc.gemoc_language_workbench.conf.presentation;

import org.eclipse.emf.common.notify.Notification;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.ODProject;
import org.gemoc.gemoc_language_workbench.conf.XTextEditorProject;
import org.gemoc.gemoc_language_workbench.conf.confFactory;


/**
 * Wrapped version of the XDSML model dedicated to the GemoXDSMLForm view
 * 
 *
 */
public class XDSMLModelWrapper extends ViewModelWrapper {
	
	LanguageDefinition languageDefinition;
	
	public XDSMLModelWrapper(){
		
	}
	
	public void init(LanguageDefinition languageDefinition){
		this.languageDefinition = languageDefinition;
		languageDefinition.eAdapters().add(new EMFEContent());
	}
	
	
	public String getLanguageName() {
		if(languageDefinition != null){
	    return languageDefinition.getName();
		}
		else return "";
	  }

	  public void setLanguageName(String name) {
	    firePropertyChange("languageName", languageDefinition.getName(), name);
	    languageDefinition.setName(name);
	  }

	  public String getDomainModelProjectName() {
		if(languageDefinition != null){
	    return languageDefinition.getDomainModelProject().getProjectName();
		}
		else return "";
	  }

	  public void setDomainModelProjectName(String name) {
		String oldName = languageDefinition.getDomainModelProject() != null ? languageDefinition.getDomainModelProject().getProjectName() : null;
	    firePropertyChange("domainModelProjectName", oldName, name);
	    if(languageDefinition.getDomainModelProject() == null){
	    	EMFEcoreProject domainModelProject = confFactory.eINSTANCE.createEMFEcoreProject();
	    	languageDefinition.setDomainModelProject(domainModelProject);
	    }
	    languageDefinition.getDomainModelProject().setProjectName(name);
	  } 
	  
	  public String getXTextEditorProjectName() {
		if(languageDefinition != null){
			for(EditorProject editor : languageDefinition.getEditorProjects()){
				if(editor instanceof XTextEditorProject){
					return editor.getProjectName();
				}
			}
		}
		return "";
	  }

	  public void setXTextEditorProjectName(String name) {
		String oldName = languageDefinition.getDomainModelProject() != null ? languageDefinition.getDomainModelProject().getProjectName() : null;
	    firePropertyChange("xTextEditorProjectName", oldName, name);
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
	    xTextEditor.setProjectName(name);
	  }
	  
	  public String getSiriusEditorProjectName() {
			if(languageDefinition != null){
				for(EditorProject editor : languageDefinition.getEditorProjects()){
					if(editor instanceof ODProject){
						return editor.getProjectName();
					}
				}
			}
			return "";
		  }

		  public void setSiriusEditorProjectName(String name) {
			String oldName = languageDefinition.getDomainModelProject() != null ? languageDefinition.getDomainModelProject().getProjectName() : null;
		    firePropertyChange("xSiriusEditorProjectName", oldName, name);
		    EditorProject xTextEditor = null;
		    for(EditorProject editor : languageDefinition.getEditorProjects()){
		    	if(editor instanceof ODProject){
		    		xTextEditor = editor;
		    	}
		    }
		    
		    if(xTextEditor == null){
		    	xTextEditor = confFactory.eINSTANCE.createODProject();
		    	languageDefinition.getEditorProjects().add(xTextEditor);
		    }
		    xTextEditor.setProjectName(name);
		  }
	  
	  
	  /**
	   * receive EMF notifications and call the appropriate firePropertyChange fot he corresponding
	   * @author dvojtise
	   *
	   */
	  class EMFEContent extends org.eclipse.emf.ecore.util.EContentAdapter{
		//override the notifyChanged method
		    public void notifyChanged(Notification n){
		        
		        super.notifyChanged(n); // the superclass handles adding/removing this Adapter to new Books
		        
		        // find out the type of the notifier which could be either 'LanguageDefinition' or 'Library'
		        Object notifier = n.getNotifier();
		        if (notifier instanceof LanguageDefinition) {
		            handleLanguageDefinitionNotification(n);
		        } else if (notifier instanceof DomainModelProject) {
		            handleDomainModelProjectNotification(n);
		        } else if (notifier instanceof XTextEditorProject) {
		        	handleXTextProjectNotification(n);
		        } else if (notifier instanceof ODProject) {
		        	handleSiriusProjectNotification(n);
		        }
		        
		    }

			private void handleLanguageDefinitionNotification(Notification n) {
				int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.LanguageDefinition.class);
		        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.LANGUAGE_DEFINITION__NAME){
		        		String oldLanguageName = n.getOldStringValue();
		        		String newLanguageName = n.getNewStringValue();
		        		//LanguageDefinition languageDefinition = (LanguageDefinition) n.getNotifier();
		                //System.out.println("The name is now " + newLanguageName );
		                firePropertyChange("languageName", oldLanguageName, newLanguageName);
		        }
			}
			private void handleDomainModelProjectNotification(Notification n) {
				int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.LanguageDefinition.class);
		        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.DOMAIN_MODEL_PROJECT__PROJECT_NAME){
		        		String oldValue = n.getOldStringValue();
		        		String newValue = n.getNewStringValue();
		                firePropertyChange("domainModelProjectName", oldValue, newValue);
		        }
			}

			private void handleXTextProjectNotification(Notification n) {
				int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.LanguageDefinition.class);
		        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.XTEXT_EDITOR_PROJECT__PROJECT_NAME){
		        		String oldValue = n.getOldStringValue();
		        		String newValue = n.getNewStringValue();
		                firePropertyChange("xTextEditorProjectName", oldValue, newValue);
		        }
			}
			private void handleSiriusProjectNotification(Notification n) {
				int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.LanguageDefinition.class);
		        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.OD_PROJECT__PROJECT_NAME){
		        		String oldValue = n.getOldStringValue();
		        		String newValue = n.getNewStringValue();
		                firePropertyChange("siriusEditorProjectName", oldValue, newValue);
		        }
			}
	  }
}


