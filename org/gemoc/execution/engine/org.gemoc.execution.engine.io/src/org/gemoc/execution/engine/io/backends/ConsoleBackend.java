package org.gemoc.execution.engine.io.backends;

import java.util.List;
import java.util.Observable;

import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.core.Backend;

/**
 * A very simple backend that writes in the console the strings it is given.
 * 
 * @author flatombe
 * 
 */
public class ConsoleBackend implements Backend {

	/**
	 * Configure which console to display to, etc...
	 */
	@Override
	public void configure() {

	}

	/**
	 * Looks for String or List<String> and displays whatever is found.
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof String) {
			String s = (String) arg1;
			Activator.info(s);
		} else if (arg1 instanceof List<?>) {
			List<String> trace = (List<String>) arg1;
			for (String s : trace) {
				Activator.getMessagingSystem().info(s.toString(),
						Activator.PLUGIN_ID);
			}
		} /*ignore non String messages from notification
			else {
			Activator.getMessagingSystem().error(
					"Trace was not formatted correctly", Activator.PLUGIN_ID);
		}*/
	}
}
