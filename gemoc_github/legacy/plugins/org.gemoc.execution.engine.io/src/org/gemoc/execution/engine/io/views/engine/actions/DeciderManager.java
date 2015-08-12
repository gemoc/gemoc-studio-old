package org.gemoc.execution.engine.io.views.engine.actions;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.extensions.deciders.DeciderSpecificationExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.deciders.DeciderSpecificationExtensionPoint;

public class DeciderManager {

	
	public static DeciderAction getStepByStepDeciderAction(){
		for (DeciderAction action : getAllDeciderActions())
		{
			
			if (action.getText().contains("step"))
				return action;
		}
		return null;
	}
	
	public static DeciderAction getDeciderAction(ILogicalStepDecider decider){
		for (DeciderAction action : getAllDeciderActions())
		{
			
			if (action.getSpecification().getDeciderClassName().equals(decider.getClass().getName()))
				return action;
		}
		return null;
	}
	
	/** return a Step by step decider if the current decider is a running one, and a solver decider if this is a step by step decider
	 * 
	 * @param decider
	 * @return
	 */
	public static DeciderAction getSwitchDeciderAction(ILogicalStepDecider currentEngineDecider){
		String searchedDecider = "Step";
		if(currentEngineDecider.getClass().getName().contains("Step")){
			searchedDecider = "Solver";
		}
		for (DeciderAction action : getAllDeciderActions())
		{
			
			if (action.getSpecification().getDeciderClassName().contains(searchedDecider))
				return action;
		}
		return getStepByStepDeciderAction();
	}
	
	protected static List<DeciderAction> _deciderActions;
	
	public static List<DeciderAction> getAllDeciderActions(){
		if(_deciderActions == null){
			_deciderActions = new ArrayList<DeciderAction>();
			for (DeciderSpecificationExtension spec : DeciderSpecificationExtensionPoint.getSpecifications())
			{
				_deciderActions.add( new DeciderAction(spec));
			}
		}
		return _deciderActions;
	}
}
