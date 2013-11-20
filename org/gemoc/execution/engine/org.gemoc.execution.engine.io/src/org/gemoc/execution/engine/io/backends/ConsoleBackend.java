package org.gemoc.execution.engine.io.backends;

import java.util.List;
import java.util.Observable;

import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.Backend;

public class ConsoleBackend implements Backend {

	@Override
	public void configure() {

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof String) {
			String s = (String) arg1;
			Activator.getMessagingSystem().info(s, Activator.PLUGIN_ID);
		} else if (arg1 instanceof List<?>) {
			List<String> trace = (List<String>) arg1;
			for (String s : trace) {
				Activator.getMessagingSystem().info(s.toString(), Activator.PLUGIN_ID);
			}
		} else {
			Activator.getMessagingSystem().error(
					"Trace was not formatted correctly", Activator.PLUGIN_ID);
		}
	}
}
