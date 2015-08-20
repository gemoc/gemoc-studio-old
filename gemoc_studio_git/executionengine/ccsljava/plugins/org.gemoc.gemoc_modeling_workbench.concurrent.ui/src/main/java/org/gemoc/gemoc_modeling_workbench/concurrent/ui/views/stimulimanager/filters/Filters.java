package org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.filters;

/**
 * Store a "mapping" of all declared filters with a name
 */
public enum Filters
{
	ALL("All Events", new NoFilter()),
	NO_LEFT_BIND("No Left binded Clocks", new LeftBindedClockFilter()),
	NO_BIND("Free Clocks", new AllBindedClockFilter());

	private Filter f;
	private String name;

	Filters(String name, Filter f)
	{
		this.name = name;
		this.f = f;
	}

	public Filter getFilter()
	{
		return f;
	}

	public String getName()
	{
		return name;
	}
}