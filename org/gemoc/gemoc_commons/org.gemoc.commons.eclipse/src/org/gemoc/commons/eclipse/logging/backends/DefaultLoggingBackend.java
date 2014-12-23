package org.gemoc.commons.eclipse.logging.backends;

import org.eclipse.core.runtime.Status;
import org.gemoc.commons.eclipse.logging.ILoggingBackend;
import org.gemoc.commons.eclipse.logging.ILoggingEntity;

import fr.inria.diverse.commons.messagingsystem.api.MessagingSystem;
import fr.inria.diverse.commons.messagingsystem.api.impl.StdioSimpleMessagingSystem;

public class DefaultLoggingBackend implements ILoggingBackend 
{

	private ILoggingEntity _loggingEntity;

	public DefaultLoggingBackend(ILoggingEntity plugin)
	{
		_loggingEntity = plugin;
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
		getMessagingSystem().info(message, _loggingEntity.getId());	
	}

	@Override
	public void debug(String message) {
		getMessagingSystem().debug(message, _loggingEntity.getId());	
	}

	@Override
	public void warn(String message) {
		getMessagingSystem().warn(message, _loggingEntity.getId());	
	}

	@Override
	public void error(String message) {
		getMessagingSystem().error(message, _loggingEntity.getId());	
	}

	@Override
	public void warn(String message, Throwable e) {
		warn(message);
		_loggingEntity
			.getLog()
			.log(new Status(
						Status.WARNING, 
						_loggingEntity.getId(), 
						Status.OK, 
						message, e));
	}

	@Override
	public void error(String message, Throwable e) {
		error(message);
		_loggingEntity
			.getLog()
			.log(new Status(
						Status.ERROR, 
						_loggingEntity.getId(), 
						Status.OK, 
						message, e));	
	}

	@Override
	public void info(String message, Throwable e) {
		info(message);
		_loggingEntity
			.getLog()
			.log(new Status(
						Status.INFO, 
						_loggingEntity.getId(), 
						Status.OK, 
						message, e));	
	}

}
