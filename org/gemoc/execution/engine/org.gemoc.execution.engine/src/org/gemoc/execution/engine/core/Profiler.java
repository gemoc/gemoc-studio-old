package org.gemoc.execution.engine.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public class Profiler {

	private List<Unit> _units = new ArrayList<Unit>();

	private Hashtable<Unit, List<Date>> _startTimes = new Hashtable<Unit, List<Date>>();
	private Hashtable<Unit, List<Date>> _endTimes = new Hashtable<Unit, List<Date>>();
	
	public void start(String unitName) 
	{
		Unit unit = getOrCreateUnit(unitName);
		List<Date> startTimes = getOrCreateStartTimes(unit);
		startTimes.add(new Date());
	}

	public void end(String unitName) 
	{
		Unit unit = getOrCreateUnit(unitName);
		List<Date> endTimes = getOrCreateEndTimes(unit);
		endTimes.add(new Date());
	}

	private Unit getOrCreateUnit(String unitName) 
	{
		Unit unit = getUnit(unitName);
		if (unit == null)
		{
			unit = new Unit(unitName);
			_units.add(unit);
		}
		return unit;
	}

	private Unit getUnit(String unitName) 
	{
		for (Unit u : _units)
		{
			if (u.getName().equals(unitName))
			{
				return u;
			}
		}
		return null;
	}

	private List<Date> getOrCreateStartTimes(Unit unit)
	{
		List<Date> l = _startTimes.get(unit);
		if (l == null)
		{
			l = new ArrayList<Date>();
			_startTimes.put(unit, l);
		}
		return l;
	}

	private List<Date> getOrCreateEndTimes(Unit unit)
	{
		List<Date> l = _endTimes.get(unit);
		if (l == null)
		{
			l = new ArrayList<Date>();
			_endTimes.put(unit, l);
		}
		return l;
	}

	public void printReport() 
	{
		for (Unit u : _units)
		{
			System.out.printf(u.getName() + ": ");
			int i = 0;
			while (i != _startTimes.get(u).size()
					|| i != _endTimes.get(u).size())
			{
				Date start = _startTimes.get(u).get(i);
				Date end = _endTimes.get(u).get(i);
				System.out.printf((end.getTime() - start.getTime()) + "ms, ");
				i++;
			}
			System.out.printf("\r\n");
		}
	}

}
