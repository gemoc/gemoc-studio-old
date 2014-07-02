package org.gemoc.commons.eclipse.logging.backends;

import org.eclipse.core.runtime.Status;
import org.eclipse.ui.PlatformUI;
import org.gemoc.commons.eclipse.logging.ILoggingBackend;
import org.gemoc.commons.eclipse.pde.IPlugin;
import org.kermeta.utils.systemservices.api.messaging.MessagingSystem;
import org.kermeta.utils.systemservices.eclipse.api.EclipseMessagingSystem;

public class DefaultLoggingBackend implements ILoggingBackend 
{

	private IPlugin _plugin;

	public DefaultLoggingBackend(IPlugin plugin)
	{
		_plugin = plugin;
	}
	
	private MessagingSystem _messagingSystem;

	private MessagingSystem getMessagingSystem()
	{
		if (_messagingSystem == null)
		{
			_messagingSystem = new EclipseMessagingSystem(_plugin.getId(), _plugin.getName());
		}
		return _messagingSystem;
	}
	
	@Override
	public void info(String message) {
		if (PlatformUI.isWorkbenchRunning())
			getMessagingSystem().info(message, _plugin.getId());	
		else
			System.out.println(_plugin.getId() + " INFO: " + message);
	}

	@Override
	public void debug(String message) {
		if (PlatformUI.isWorkbenchRunning())
			getMessagingSystem().debug(message, _plugin.getId());	
		else
			System.out.println(_plugin.getId() + " DEBUG: " + message);
	}

	@Override
	public void warn(String message) {
		if (PlatformUI.isWorkbenchRunning())
			getMessagingSystem().warn(message, _plugin.getId());	
		else
			System.out.println(_plugin.getId() + " WARN: " + message);
	}

	@Override
	public void error(String message) {
		if (PlatformUI.isWorkbenchRunning())
			getMessagingSystem().error(message, _plugin.getId());	
		else
			System.out.println(_plugin.getId() + " ERROR: " + message);
	}

	@Override
	public void warn(String message, Throwable e) {
		warn(message);
		_plugin
			.getLog()
			.log(new Status(
						Status.WARNING, 
						_plugin.getId(), 
						Status.OK, 
						message, e));
	}

	@Override
	public void error(String message, Throwable e) {
		error(message);
		_plugin
			.getLog()
			.log(new Status(
						Status.ERROR, 
						_plugin.getId(), 
						Status.OK, 
						message, e));	
	}

	@Override
	public void info(String message, Throwable e) {
		info(message);
		_plugin
			.getLog()
			.log(new Status(
						Status.INFO, 
						_plugin.getId(), 
						Status.OK, 
						message, e));	
	}

}
