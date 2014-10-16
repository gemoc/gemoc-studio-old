package org.gemoc.gemoc_language_workbench.conf.presentation;

import org.eclipse.emf.common.notify.Notification;
import org.gemoc.gemoc_language_workbench.conf.DSAProject;
import org.gemoc.gemoc_language_workbench.conf.DSEProject;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.MoCCProject;
import org.gemoc.gemoc_language_workbench.conf.SiriusAnimatorProject;
import org.gemoc.gemoc_language_workbench.conf.SiriusEditorProject;
import org.gemoc.gemoc_language_workbench.conf.XTextEditorProject;

/**
   * receive EMF notifications and call the appropriate firePropertyChange for the corresponding property
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
	        } else if (notifier instanceof SiriusEditorProject) {
	        	handleSiriusEditorProjectNotification(n);
	        } else if (notifier instanceof SiriusAnimatorProject) {
	        	handleSiriusAnimatorProjectNotification(n);
	        } else if (notifier instanceof MoCCProject) {
	            handleMoCProjectNotification(n);
	        } else if (notifier instanceof DSAProject) {
	            handleDSAProjectNotification(n);
	        } else if (notifier instanceof DSEProject) {
	            handleDSEProjectNotification(n);
	        }
	        
	        
	    }

		private void handleLanguageDefinitionNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.LanguageDefinition.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.LANGUAGE_DEFINITION__NAME){
	        		String oldLanguageName = n.getOldStringValue();
	        		String newLanguageName = n.getNewStringValue();
	                this.xdsmlModelWrapper.firePropertyChange("languageName", oldLanguageName, newLanguageName);
	        }
		}
		private void handleDomainModelProjectNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.DomainModelProject.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.DOMAIN_MODEL_PROJECT__PROJECT_NAME){
	        		String oldValue = n.getOldStringValue();
	        		String newValue = n.getNewStringValue();
	                this.xdsmlModelWrapper.firePropertyChange("domainModelProjectName", oldValue, newValue);
	        }
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.DOMAIN_MODEL_PROJECT__GENMODELURI){
        		String oldValue = n.getOldStringValue();
        		String newValue = n.getNewStringValue();
                this.xdsmlModelWrapper.firePropertyChange("genmodelLocationURI", oldValue, newValue);
	        }
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.DOMAIN_MODEL_PROJECT__DEFAULT_ROOT_EOBJECT_QUALIFIED_NAME){
        		String oldValue = n.getOldStringValue();
        		String newValue = n.getNewStringValue();
                this.xdsmlModelWrapper.firePropertyChange("rootContainerModelElement", oldValue, newValue);
	        }
		}
		

		private void handleXTextProjectNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.XTextEditorProject.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.XTEXT_EDITOR_PROJECT__PROJECT_NAME){
	        		String oldValue = n.getOldStringValue();
	        		String newValue = n.getNewStringValue();
	                this.xdsmlModelWrapper.firePropertyChange("XTextEditorProjectName", oldValue, newValue);
	        }
		}
		private void handleSiriusEditorProjectNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.EditorProject.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.SIRIUS_EDITOR_PROJECT__PROJECT_NAME){
	        		String oldValue = n.getOldStringValue();
	        		String newValue = n.getNewStringValue();
	                this.xdsmlModelWrapper.firePropertyChange("siriusEditorProjectName", oldValue, newValue);
	        }
		}
		private void handleSiriusAnimatorProjectNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.AnimatorProject.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.SIRIUS_ANIMATOR_PROJECT__PROJECT_NAME){
	        		String oldValue = n.getOldStringValue();
	        		String newValue = n.getNewStringValue();
	                this.xdsmlModelWrapper.firePropertyChange("siriusAnimatorProjectName", oldValue, newValue);
	        }
		}
		private void handleMoCProjectNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.MoCCProject.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.MO_CC_PROJECT__PROJECT_NAME){
	        		String oldValue = n.getOldStringValue();
	        		String newValue = n.getNewStringValue();
	                this.xdsmlModelWrapper.firePropertyChange("moCCProjectName", oldValue, newValue);
	        }
		}
		private void handleDSAProjectNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.DSAProject.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.DSA_PROJECT__PROJECT_NAME){
	        		String oldValue = n.getOldStringValue();
	        		String newValue = n.getNewStringValue();
	                this.xdsmlModelWrapper.firePropertyChange("DSAProjectName", oldValue, newValue);
	        }
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.DSA_PROJECT__CODE_EXECUTOR_CLASS){
        		String oldValue = n.getOldStringValue();
        		String newValue = n.getNewStringValue();
                this.xdsmlModelWrapper.firePropertyChange("codeExecutorClass", oldValue, newValue);
        }
		}
		private void handleDSEProjectNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.DSEProject.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.DSE_PROJECT__PROJECT_NAME){
	        		String oldValue = n.getOldStringValue();
	        		String newValue = n.getNewStringValue();
	                this.xdsmlModelWrapper.firePropertyChange("DSEProjectName", oldValue, newValue);
	        }
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.DSE_PROJECT__QVTO_URI){
        		String oldValue = n.getOldStringValue();
        		String newValue = n.getNewStringValue();
                this.xdsmlModelWrapper.firePropertyChange("qvtoURI", oldValue, newValue);
        }
		}
  }