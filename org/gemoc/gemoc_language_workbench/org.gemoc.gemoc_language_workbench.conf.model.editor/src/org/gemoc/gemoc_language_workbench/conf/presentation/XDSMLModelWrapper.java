package org.gemoc.gemoc_language_workbench.conf.presentation;

import org.eclipse.emf.common.notify.Notification;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;


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
//		        } else if (notifier instanceof Book) {
//		            handleBookNotification(n);
		        }
		    }

			private void handleLanguageDefinitionNotification(Notification n) {
				int featureID = n.getFeatureID(org.gemoc.gemoc_language_workbench.conf.LanguageDefinition.class);
		        if (featureID == org.gemoc.gemoc_language_workbench.conf.confPackage.LANGUAGE_DEFINITION__NAME){
		        		String oldLanguageName = n.getOldStringValue();
		        		String newLanguageName = n.getNewStringValue();
		        		LanguageDefinition languageDefinition = (LanguageDefinition) n.getNotifier();
		                System.out.println("The name is now " + newLanguageName );
		                firePropertyChange("languageName", oldLanguageName, newLanguageName);
		        }
			}
	  }
}


