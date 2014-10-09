package org.gemoc.gemoc_language_workbench.conf.presentation;

import org.eclipse.emf.common.notify.Notification;
import org.gemoc.gemoc_language_workbench.conf.DSAProject;
import org.gemoc.gemoc_language_workbench.conf.DSEProject;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.EMFGenmodel;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.MoCProject;
import org.gemoc.gemoc_language_workbench.conf.ODProject;
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
	        } else if (notifier instanceof ODProject) {
	        	handleSiriusProjectNotification(n);
	        } else if (notifier instanceof EMFGenmodel) {
	            handleGenmodelNotification(n);
	        } else if (notifier instanceof MoCProject) {
	            handleMoCProjectNotification(n);
	        } else if (notifier instanceof DSAProject) {
	            handleDSAProjectNotification(n);
	        } else if (notifier instanceof DSEProject) {
	            handleDSEProjectNotification(n);
	        }
	        // be careful to the inheritance between objects
	        if (notifier instanceof EMFEcoreProject) {
	            handleEcoreProjectNotification(n);
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
		}
		private void handleEcoreProjectNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.EMF_ECORE_PROJECT__DEFAULT_ROOT_EOBJECT_QUALIFIED_NAME){
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
		private void handleSiriusProjectNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.ODProject.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.OD_PROJECT__PROJECT_NAME){
	        		String oldValue = n.getOldStringValue();
	        		String newValue = n.getNewStringValue();
	                this.xdsmlModelWrapper.firePropertyChange("siriusEditorProjectName", oldValue, newValue);
	        }
		}
		private void handleGenmodelNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.EMFGenmodel.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.EMF_GENMODEL__LOCATION_URI){
	        		String oldValue = n.getOldStringValue();
	        		String newValue = n.getNewStringValue();
	                this.xdsmlModelWrapper.firePropertyChange("genmodelLocationURI", oldValue, newValue);
	        }
		}
		private void handleMoCProjectNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.MoCProject.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.MO_CPROJECT__PROJECT_NAME){
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
		}
		private void handleDSEProjectNotification(Notification n) {
			int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.DSEProject.class);
	        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.DSE_PROJECT__PROJECT_NAME){
	        		String oldValue = n.getOldStringValue();
	        		String newValue = n.getNewStringValue();
	                this.xdsmlModelWrapper.firePropertyChange("DSEProjectName", oldValue, newValue);
	        }
		}
  }