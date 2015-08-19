package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import org.eclipse.emf.common.notify.Adapter;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;

import fr.obeo.dsl.debug.DebugTarget;
import fr.obeo.dsl.debug.StackFrame;

public class PlainK3DebugModelPresentation extends GemocDebugModelPresentation {
	
	@Override
	public String getText(Object element) {
		
		if (element instanceof Adapter) {
			Object target = ((Adapter)element).getTarget();
		
			if (target instanceof DebugTarget) {
				return "Debugging session";
				
			} else if (target instanceof fr.obeo.dsl.debug.Thread) {
				return "Debugging session";
				
			} else if (target instanceof StackFrame) {
				StackFrame target_cast = (StackFrame) target;
				if (target_cast.getContext() instanceof MSEOccurrence) {
					MSEOccurrence context = (MSEOccurrence) target_cast.getContext();
					return context.getMse().getName();
				}
				
			}
			
		}
		return super.getText(element);
	}

}
