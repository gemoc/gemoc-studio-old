package org.gemoc.execution.engine.io.backends;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.gemoc.execution.engine.io.Activator;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IBackend;

/**
 * A very simple backend that writes in the console the strings it is given.
 * 
 * @author flatombe
 * 
 */
public class ConsoleBackend implements IBackend, Observer {

	/**
	 * Looks for String or List<String> and displays whatever is found.
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof String) {
			String s = (String) arg1;
			Activator.getDefault().info(s);
		} else if (arg1 instanceof List<?>) {
			List<String> trace = (List<String>) arg1;
			for (String s : trace) {
				Activator.getDefault().info(s.toString());
			}
		} /*ignore non String messages from notification
			else {
			Activator.getMessagingSystem().error(
					"Trace was not formatted correctly", Activator.PLUGIN_ID);
		}*/
	}

	@Override
	public void dispose() 
	{
		if (_engine instanceof Observable)
			((Observable) _engine).deleteObserver(this);
	}

	private GemocExecutionEngine _engine;
	
	@Override
	public void initialize(GemocExecutionEngine engine)
	{
		_engine = engine;
		if (engine instanceof Observable)
			((Observable) engine).addObserver(this);
	}
}
