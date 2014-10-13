package org.gemoc.execution.engine.io.views.event;

public enum CacheStatus
{
	RUNNING("Running"),
	RECORDING("Recording"),
	PLAYING("Playing"),
	STOPPED("Engine not running");

	private String text;

	CacheStatus(String text)
	{
		this.text = text;
	}

	String getText()
	{
		return text;
	}

}
