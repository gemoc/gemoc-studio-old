package org.gemoc.gemoc_language_workbench.conf.presentation;

import org.eclipse.emf.common.notify.Notification;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.ODProject;
import org.gemoc.gemoc_language_workbench.conf.XTextEditorProject;

/**
   * receive EMF notifications and call the appropriate firePropertyChange fot he corresponding
   * @author dvojtise
   *
   */
  class EMFEContent extends org.eclipse.emf.ecore.util.EContentAdapter{
	/**
	 * 
	 */
	private final XDSMLModelWrapper xdsmlModelWrapper;
	/**
	 * @param xdsmlModelWrapper
	 */
	EMFEContent(XDSMLModelWrapper xdsmlModelWrapper) {
		this.xdsmlModelWrapper = xdsmlModelWrapper;
	}

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
	                this.xdsmlModelWrapper.firePropertyChange("languageName", oldLanguageName, newLanguageName);
	        }
		}
		private void handleDomainModelProjectNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.LanguageDefinition.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.DOMAIN_MODEL_PROJECT__PROJECT_NAME){
	        		String oldValue = n.getOldStringValue();
	        		String newValue = n.getNewStringValue();
	                this.xdsmlModelWrapper.firePropertyChange("domainModelProjectName", oldValue, newValue);
	        }
		}

		private void handleXTextProjectNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.LanguageDefinition.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.XTEXT_EDITOR_PROJECT__PROJECT_NAME){
	        		String oldValue = n.getOldStringValue();
	        		String newValue = n.getNewStringValue();
	                this.xdsmlModelWrapper.firePropertyChange("xTextEditorProjectName", oldValue, newValue);
	        }
		}
		private void handleSiriusProjectNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.LanguageDefinition.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.OD_PROJECT__PROJECT_NAME){
	        		String oldValue = n.getOldStringValue();
	        		String newValue = n.getNewStringValue();
	                this.xdsmlModelWrapper.firePropertyChange("siriusEditorProjectName", oldValue, newValue);
	        }
		}
  }