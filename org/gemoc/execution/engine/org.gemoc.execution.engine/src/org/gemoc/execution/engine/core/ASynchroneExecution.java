package org.gemoc.execution.engine.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import org.gemoc.execution.engine.Activator;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionFinishedCondition;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionResultCondition;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ComparisonOperator;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.Condition;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.Force;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ForceKind;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.When;

public class ASynchroneExecution extends OperationExecution
{
	
	private Collection<When> _whenStatements;
	private IMSEStateController _clockController;
	private HashMap<Force, When> _forces;
	
	public ASynchroneExecution(ModelSpecificEvent mse, Collection<When> whenStatements, IMSEStateController clockController, GemocExecutionEngine engine) 
	{
		super(mse, engine);
		_whenStatements = whenStatements;
		_clockController = clockController;
	}

	public void run() 
	{
		collectForces();
		// forbid
		for (Force force : _forces.keySet())
		{						
			if (force.getKind().equals(ForceKind.PRESENCE))
			{
				_clockController.forceAbsenceTickInTheFuture(force.getEventToBeForced());
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
		_forces = new HashMap<>();
		for (When statement : _whenStatements)
		{
//			if (statement.getCondition() instanceof ActionFinishedCondition)
//			{
//			}
			if (statement.getAction() instanceof Force)
			{
				Force a = (Force)statement.getAction();
				_forces.put(a, statement);								
			}
		}	
	}

	protected void internalRun() 
	{
		try
		{	
			executeMSESynchronously();
			// free
			for (Entry<Force, When> entry : _forces.entrySet())
			{						
				Condition condition = entry.getValue().getCondition();
				if (condition instanceof ActionFinishedCondition)
				{
					_clockController.freeInTheFuture(entry.getKey().getEventToBeForced());					
				}
				else if (condition instanceof ActionResultCondition)
				{
					ActionResultCondition resultCondition = (ActionResultCondition)condition;
					boolean goOn = false;
					
					switch(resultCondition.getOperator().getValue())
					{
						case ComparisonOperator.DIFFERENT_VALUE:
							goOn = getResult() != resultCondition.getComparisonValue();
							break;
						case ComparisonOperator.EQUALS_VALUE:
							goOn = getResult().equals(resultCondition.getComparisonValue());
							break;
						default:
							goOn = tryNumber(resultCondition.getOperator(), getResult(), resultCondition.getComparisonValue());
							break;
					}
					if (goOn)
					{
						if (entry.getKey().getOnTrigger() == null)
						{
							_clockController.freeInTheFuture(entry.getKey().getEventToBeForced());						
						}
						else
						{
							FreeClockFutureAction action = new FreeClockFutureAction(entry.getKey().getEventToBeForced(), entry.getKey().getOnTrigger(), _clockController);
							getEngine().addFutureAction(action);
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			Activator.getDefault().error("Exception received " + e.getMessage(), e);
		}
	}

	private boolean  tryNumber(ComparisonOperator operator, Object result, Object comparisonValue) throws Exception 
	{
		Double s1 = null;
		Double s2 = null;				
		if (result instanceof Number
			&& comparisonValue instanceof Number)
		{
			s1 = ((Number)result).doubleValue();
			s2 = ((Number)comparisonValue).doubleValue();
		}
		if (s1 == null
			|| s2 == null)
		{
			throw new Exception("Cannot convert result or comparison value to double.");
		}
		boolean goOn = false;
		int comparisonResult = Double.compare(s1.doubleValue(), s2.doubleValue());
		switch(operator.getValue())
		{
			case ComparisonOperator.INF_EQUALS_VALUE:
				goOn = comparisonResult <= 0;
				break;
			case ComparisonOperator.INF_VALUE:
				goOn = comparisonResult < 0;
				break;
			case ComparisonOperator.SUP_EQUALS_VALUE:
				goOn = comparisonResult >= 0;
				break;
			case ComparisonOperator.SUP_VALUE:
				goOn = comparisonResult > 0;
				break;
		}	
		return goOn;
	}

	private void executeMSESynchronously() 
	{
		SynchroneExecution execution = new SynchroneExecution(getMSE(), getEngine());
		execution.run();
		setResult(execution.getResult());
	}
	
}
