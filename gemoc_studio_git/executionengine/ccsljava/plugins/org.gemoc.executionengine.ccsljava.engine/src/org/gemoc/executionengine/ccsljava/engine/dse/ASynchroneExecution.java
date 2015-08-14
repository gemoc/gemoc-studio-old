package org.gemoc.executionengine.ccsljava.engine.dse;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.dse.FreeClockFutureAction;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.executionengine.ccsljava.api.core.INonDeterministicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionFinishedCondition;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionResultCondition;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ComparisonOperator;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.Condition;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.Force;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ForceKind;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.When;

public class ASynchroneExecution extends OperationExecution
{
	
	private Collection<When> _whenStatements;
	private IMSEStateController _clockController;
	private HashMap<Force, When> _forces;
	
	public ASynchroneExecution(MSEOccurrence mseOccurrence, Collection<When> whenStatements, IMSEStateController clockController, INonDeterministicExecutionEngine engine) 
	{
		super(mseOccurrence, engine);
		_whenStatements = whenStatements;
		_clockController = clockController;
	}

	public void run() 
	{
		collectForces();
		// forbid
		//why forcing absence by default ?
		for (Force force : _forces.keySet())
		{						
			if (force.getKind().equals(ForceKind.PRESENCE))
			{
				//should force presence ?
				_clockController.forceAbsenceTickInTheFuture(force.getEventToBeForced());
			}
		}
		
//		il y avait un problème de course dans le cas d'un feedback qui devait etre immédiat. L'idée de François 
//		c'etait on interdit tout en attendant de la réponse de l'exécution asynchrone de la méthode.
//		dans certains exemples il n'est pas possible de "faire autre chose en attendant" et donc on doit forcément attendre le retour de la
//		fonction associée pour éviter les deadlocks... Je propose avant de mieux faire de ne rendre asynchrone que les futurs et pas les feedbacks...
		
		
		boolean shouldBeLaunchInAThread= false;
		 
		for (Entry<Force, When> entry : _forces.entrySet())
		{
			Condition condition = entry.getValue().getCondition();
			if (condition instanceof ActionFinishedCondition)
			{
				shouldBeLaunchInAThread = true;
			}
		}
		
		
		
		if(shouldBeLaunchInAThread){
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() 
				{
					internalRun();
				}
			};
			Thread t = new Thread(runnable);
			t.start();
		}else{
			try
			{	
				executeMSESynchronously();
				// free
				for (Entry<Force, When> entry : _forces.entrySet())
				{						
					Condition condition = entry.getValue().getCondition();
					dealWithExecutionResult(entry, condition);
				}
			}
			catch (Exception e)
			{
				Activator.getDefault().error("Exception received " + e.getMessage(), e);
			}
		}
		
		
		
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
				else{
					dealWithExecutionResult(entry, condition);
				}
			}
		}
		catch (Exception e)
		{
			Activator.getDefault().error("Exception received " + e.getMessage(), e);
		}
	}

	private void dealWithExecutionResult(Entry<Force, When> entry, Condition condition) throws Exception {
		if (condition instanceof ActionResultCondition)
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
		SynchroneExecution execution = new SynchroneExecution(getMSEOccurrence(), getEngine());
		execution.run();
		setResult(execution.getResult());
	}
	
}
