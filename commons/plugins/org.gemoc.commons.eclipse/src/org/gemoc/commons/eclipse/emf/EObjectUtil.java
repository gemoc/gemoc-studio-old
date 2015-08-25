package org.gemoc.commons.eclipse.emf;

import org.eclipse.emf.ecore.EObject;

public class EObjectUtil {
	
	/**
	 * recursively search into the eContainer (parents) of the EObject the first that is instance of this type. return null if no parent is of the givent type 
	 * @param obj
	 * @param t
	 * @return 
	 */
	public  static <T extends EObject> T eContainerOfType(EObject obj, Class<? extends T> type){
		T result = null;
		EObject parent = obj.eContainer();
		if(obj.eContainer() != null){
			if ( type.isInstance(parent) ) {
				result = type.cast(parent);
			}
			else{
				result = eContainerOfType(parent, type);
			}
		}
		return result;
	}



}
