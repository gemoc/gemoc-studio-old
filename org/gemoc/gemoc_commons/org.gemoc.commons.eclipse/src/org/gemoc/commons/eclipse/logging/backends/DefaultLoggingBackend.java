package org.gemoc.commons.eclipse.logging.backends;

import org.eclipse.core.runtime.Status;
import org.gemoc.commons.eclipse.logging.ILoggingBackend;
import org.gemoc.commons.eclipse.pde.IPlugin;
import org.kermeta.utils.systemservices.api.impl.StdioSimpleMessagingSystem;
import org.kermeta.utils.systemservices.api.messaging.MessagingSystem;

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
			_messagingSystem = new StdioSimpleMessagingSystem();
		}
		return _messagingSystem;
	}
	
	public void setMessagingSystem(MessagingSystem messagingSystem)
	{
		_messagingSystem = messagingSystem;
	}
	
	@Override
	public void info(String message) {
		getMessagingSystem().info(message, _plugin.getId());	
	}

	@Override
	public void debug(String message) {
		getMessagingSystem().debug(message, _plugin.getId());	
	}

	@Override
	public void warn(String message) {
		getMessagingSystem().warn(message, _plugin.getId());	
	}

	@Override
	public void error(String message) {
		getMessagingSystem().error(message, _plugin.getId());	
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
