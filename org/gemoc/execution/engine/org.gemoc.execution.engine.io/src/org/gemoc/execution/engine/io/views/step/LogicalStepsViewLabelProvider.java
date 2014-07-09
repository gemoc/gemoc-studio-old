package org.gemoc.execution.engine.io.views.step;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.gemoc.execution.engine.core.LogicalStepHelper;
import org.gemoc.execution.engine.io.SharedIcons;
import org.gemoc.execution.engine.io.views.ViewUtils;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.trace.LogicalStep;

public class LogicalStepsViewLabelProvider extends LabelProvider 
{

	private GemocExecutionEngine _engine;
	public void setEngine(GemocExecutionEngine engine)
	{
		_engine = engine;
	}
	
	@Override
	public String getText(Object element) 
	{
		if (element instanceof LogicalStep)
		{
			LogicalStep ls = (LogicalStep)element;
			return LogicalStepHelper.getLogicalStepName(ls);
		}
		else if (element instanceof Event)
		{
			Event event = (Event)element;
			String detail = ViewUtils.eventToString(event);
			String result = String.format("%-40s", event.getName());
			if (detail != null
				&& !detail.equals(""))
				result += " -> " + detail; 
			return result;
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) 
	{
		if (element instanceof LogicalStep)
		{
			LogicalStep ls = (LogicalStep)element;
			if(ls == _engine.getEngineStatus().getChosenLogicalStep())
			{
				return SharedIcons.getSharedImage(SharedIcons.LOGICALSTEP_RUNNING_ICON);
			}
			else {
				return SharedIcons.getSharedImage(SharedIcons.LOGICALSTEP_ICON);					
			}
		}
		else if (element instanceof Event)
		{
			return SharedIcons.getSharedImage(SharedIcons.VISIBLE_EVENT_ICON);
		}
		return null;
	}
	
}
