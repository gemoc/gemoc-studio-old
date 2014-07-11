package org.gemoc.execution.engine.io.views;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;

public class ViewUtils {

	public static String eventToString(Event event) {
		if (event.getReferencedObjectRefs().size() == 2){
			//String name = SimpleAttributeResolver.NAME_RESOLVER.apply(obj);
			String metaClassName = event.getReferencedObjectRefs().get(0).eClass().getName();
			String targetObjectNiceName = SimpleAttributeResolver.NAME_RESOLVER.apply(event.getReferencedObjectRefs().get(0));
			if( event.getReferencedObjectRefs().get(1) instanceof EOperation) {
				String operationName = ((EOperation)event.getReferencedObjectRefs().get(1)).getName();
//				return String.format("%-12s: %s", metaClassName, targetObjectNiceName +"." + operationName+"()");
				return String.format("%s->%s", metaClassName, targetObjectNiceName +"." + operationName+"()");
			}
			else{
//				return   String.format("%-12s: %s", metaClassName, targetObjectNiceName + "." + event.getReferencedObjectRefs().get(1));
				return   String.format("%s->%s", metaClassName, targetObjectNiceName + "." + event.getReferencedObjectRefs().get(1));
			}
		}
		else if (event.getReferencedObjectRefs().size() == 1){
			String metaClassName = event.getReferencedObjectRefs().get(0).eClass().getName();
			String targetObjectNiceName = SimpleAttributeResolver.NAME_RESOLVER.apply(event.getReferencedObjectRefs().get(0));
//			return String.format("%-12s: %s", metaClassName, targetObjectNiceName);
			return String.format("%s->%s", metaClassName, targetObjectNiceName);
		}
		else{
			return "";
		}
	}
	
}
