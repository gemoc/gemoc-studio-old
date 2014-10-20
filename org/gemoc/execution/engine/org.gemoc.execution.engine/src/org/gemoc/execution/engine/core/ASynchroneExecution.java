package org.gemoc.execution.engine.core;

import java.util.ArrayList;
import java.util.Collection;

import org.gemoc.execution.engine.Activator;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dsa.IClockController;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionFinishedCondition;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.Force;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ForceKind;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.When;

public class ASynchroneExecution extends OperationExecution
{
	
	private Collection<When> _whenStatements;
	private IClockController _clockController;
	private Collection<Force> _forces;
	
	public ASynchroneExecution(ModelSpecificEvent mse, Collection<When> whenStatements, IClockController clockController, GemocExecutionEngine engine) 
	{
		super(mse, engine);
		_whenStatements = whenStatements;
		_clockController = clockController;
	}

	public void run() 
	{
		collectForces();
		// forbid
		for (Force force : _forces)
		{						
			if (force.getKind().equals(ForceKind.PRESENCE))
			{
				_clockController.doNotTickInTheFuture(force.getEventToBeForced());
			}
		}
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() 
			{
				internalRun();
			}
		};
		Thread t = new Thread(runnable);
		t.start();
	}

	private void collectForces() 
	{
		_forces = new ArrayList<>();
		for (When statement : _whenStatements)
		{
			if (statement.getCondition() instanceof ActionFinishedCondition)
			{
				if (statement.getAction() instanceof Force)
				{
					Force a = (Force)statement.getAction();
					_forces.add(a);								
				}
			}
		}	
	}

	protected void internalRun() 
	{
		try
		{	
			Thread.sleep(5000);
			executeMSESynchronously();
			// free
			for (Force force : _forces)
			{						
				
				_clockController.freeInTheFuture(force.getEventToBeForced());
			}
		}
		catch (Exception e)
		{
			Activator.getDefault().error("Exception received " + e.getMessage(), e);
		}
	}

	private void executeMSESynchronously() 
	{
		SynchroneExecution execution = new SynchroneExecution(getMSE(), getEngine());
		execution.run();
		setResult(execution.getResult());
	}
	
}
