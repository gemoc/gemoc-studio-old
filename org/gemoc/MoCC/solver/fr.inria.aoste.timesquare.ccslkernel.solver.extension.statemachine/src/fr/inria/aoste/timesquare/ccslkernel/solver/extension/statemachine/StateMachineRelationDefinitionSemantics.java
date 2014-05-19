package fr.inria.aoste.timesquare.ccslkernel.solver.extension.statemachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javabdd.BDD;

import org.gemoc.mocc.ccslmoc.model.ccslmocc.FinishClock;
import org.gemoc.mocc.ccslmoc.model.ccslmocc.StateMachineRelationDefinition;
import org.gemoc.mocc.fsmkernel.model.FSMModel.AbstractAction;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Guard;
import org.gemoc.mocc.fsmkernel.model.FSMModel.IntegerAssignement;
import org.gemoc.mocc.fsmkernel.model.FSMModel.State;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Transition;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Trigger;

import toools.io.Serializer;
import toools.io.Utilities;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.BasicTypeFactory;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.DiscreteClockType;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.IntegerElement;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.BooleanExpression;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntEqual;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntInf;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntMinus;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntPlus;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntSup;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntegerExpression;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntegerRef;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntegerVariableRef;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.AbstractEntity;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity;
import fr.inria.aoste.timesquare.ccslkernel.modelunfolding.AbstractConcreteMapping;
import fr.inria.aoste.timesquare.ccslkernel.solver.CCSLKernelSolver;
import fr.inria.aoste.timesquare.ccslkernel.solver.SolverElement;
import fr.inria.aoste.timesquare.ccslkernel.solver.SolverPrimitiveElement;
import fr.inria.aoste.timesquare.ccslkernel.solver.StepExecutor;
import fr.inria.aoste.timesquare.ccslkernel.solver.TimeModel.SolverClock;
import fr.inria.aoste.timesquare.ccslkernel.solver.exception.SolverException;
import fr.inria.aoste.timesquare.ccslkernel.solver.helpers.SemanticHelper;
import fr.inria.aoste.timesquare.ccslkernel.solver.relation.AbstractWrappedRelation;

public class StateMachineRelationDefinitionSemantics extends AbstractWrappedRelation {


	private State _currentState=null;
	private AbstractConcreteMapping<SolverElement> _abstract2concreteMap=null;
	private StateMachineRelationDefinition _modelSTS=null;
	
	private ArrayList<Transition> _sensitiveTransitition;

	private List<AbstractEntity> _parameters = null;
	private List<AbstractEntity> _clockParameters = null;
	private List<SolverElement> _allClocks = null;
	private Map<ConcreteEntity, IntegerElement> _localInteger = null;
	
	public StateMachineRelationDefinitionSemantics(StateMachineRelationDefinition modelSTS, AbstractConcreteMapping<SolverElement> context) {
		_modelSTS = modelSTS;
		_abstract2concreteMap = context;
		_currentState = _modelSTS.getInitialStates().get(0);
		_sensitiveTransitition = new ArrayList<Transition>();
		_parameters = _modelSTS.getDeclaration().getParameters();
		_clockParameters = keepOnlyClocks(_parameters);
		_allClocks = getConcreteElements(_clockParameters);
		
		_localInteger = new HashMap<ConcreteEntity, IntegerElement>();
		for (ConcreteEntity ce : _modelSTS.getDeclarationBlock().getConcreteEntities()) {
			if (ce instanceof IntegerElement){
				IntegerElement ie  = BasicTypeFactory.eINSTANCE.createIntegerElement();
				ie.setName(((IntegerElement)ce).getName());
				ie.setValue(((IntegerElement)ce).getValue());
//				IntegerElement ie =((IntegerElement)ce);
				_localInteger.put(ce, ie);
			}
		}
		
		for (Transition t : _currentState.getOutputTransitions()) {
			//construct three set, the one of clock that must tick and the clock that must not tick
			if(t.getTrigger() == null &&t.getGuard() != null  && evaluate((BooleanExpression)((Guard)t.getGuard()).getValue())){
			//here, it is the default transition
				for (AbstractAction a : t.getActions()) {
					if (a instanceof IntegerAssignement){
						IntegerAssignement ia = (IntegerAssignement)a;
						doAssignInt(ia);
					}
				}
			_currentState = t.getTarget();
			}
		}
		
		
	}

	@Override
	public void start(SemanticHelper helper) throws SolverException {
		_currentState = _modelSTS.getInitialStates().get(0);
		_sensitiveTransitition = new ArrayList<Transition>();
		for (Transition t : _currentState.getOutputTransitions()) {
			//construct three set, the one of clock that must tick and the clock that must not tick
			if(t.getTrigger() == null || evaluate((BooleanExpression)((Guard)t.getGuard()).getValue())){
			//here, it is the default transition
				System.out.println("default transition taken");
				for (AbstractAction a : t.getActions()) {
					if (a instanceof IntegerAssignement){
						IntegerAssignement ia = (IntegerAssignement)a;
						doAssignInt(ia);
					}
				}
			_currentState = t.getTarget();
			}
		}
		
	}

	private List<SolverElement> getConcreteElements(List<? extends AbstractEntity> abstractTriggers){
		ArrayList<SolverElement> triggers = new ArrayList<SolverElement>();
		for (AbstractEntity ae : abstractTriggers) {
			triggers.add(_abstract2concreteMap.getLocalValue(ae));
		}
		return triggers;
	}
	
	private List<AbstractEntity> keepOnlyClocks(List<AbstractEntity> l){
		ArrayList<AbstractEntity> res = new ArrayList<AbstractEntity>();
		for (AbstractEntity ae : l) {
			if (ae.getType() instanceof DiscreteClockType){
				res.add(ae);
			}
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void semantic(SemanticHelper semanticHelper) throws SolverException {
		if (semanticHelper.isSemanticDone(this)) {
			return;
		}
		semanticHelper.registerSemanticDone(this);

		BDD stateBDD =semanticHelper.createOne();
	
		//always possible to do nothing 
		for (SolverElement se : _allClocks) {
			stateBDD.andWith(semanticHelper.getFalseBDDVariable((SolverClock) se));
		}
		
		for (Transition t : _currentState.getOutputTransitions()) {
			if (t.getGuard() != null){
				if (! evaluate(((Guard)t.getGuard()).getValue())){
					continue;
				}
			}
			
			_sensitiveTransitition.add(t);
			
			List<SolverElement> trueTrigger = null;
			List<SolverElement> falseTrigger = null;
			List<SolverElement> clocksNotInTrigger = new ArrayList<SolverElement>(_allClocks);

			if(t.getTrigger() != null){
				trueTrigger = getConcreteElements((List<? extends AbstractEntity>) ((Trigger)t.getTrigger()).getTrueTriggers());
				falseTrigger = getConcreteElements((List<? extends AbstractEntity>) ((Trigger)t.getTrigger()).getFalseTriggers());
				clocksNotInTrigger.removeAll(trueTrigger);
			
			BDD triggersBDD =semanticHelper.createOne();
			for (SolverElement se : trueTrigger) {
				triggersBDD.andWith(semanticHelper.getBDDVariable((SolverClock)se));
			}
			for (SolverElement se : falseTrigger) {
				triggersBDD.andWith(semanticHelper.getFalseBDDVariable((SolverClock) se));
			}	
			for (SolverElement se : clocksNotInTrigger) {
				triggersBDD.andWith(semanticHelper.getFalseBDDVariable((SolverClock) se));
			}	
		
			stateBDD.orWith(triggersBDD);
			}
			semanticHelper.registerClockUse(_allClocks.toArray(new SolverClock[0]));

		}
		semanticHelper.semanticBDDAnd(stateBDD);
		semanticHelper.registerSemanticDone(this);
	}

	private boolean evaluate(BooleanExpression guard) {
		if(guard instanceof IntEqual){
			return evaluateIntEqual((IntEqual) guard);
		}
		if(guard instanceof IntInf){
			return evaluateIntInf((IntInf) guard);
		}
		if(guard instanceof IntSup){
			return evaluateIntSup((IntSup) guard);
		}
		return false;
	}

  
	@Override
	public void deathSemantic(SemanticHelper helper)
			throws SolverException {
		//TODO: take into account the final states... !
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(CCSLKernelSolver solver, StepExecutor stepExecutor) throws SolverException {
		allTransition: for (Transition t : _sensitiveTransitition) {
			//construct three set, the one of clock that must tick and the clock that must not tick
			List<SolverElement> trueTrigger = null;
			List<SolverElement> falseTrigger = null;
			List<SolverElement> clocksNotInTrigger = new ArrayList<SolverElement>(_allClocks);

			if(t.getTrigger() != null){
				trueTrigger = getConcreteElements((List<? extends AbstractEntity>) ((Trigger)t.getTrigger()).getTrueTriggers());
				falseTrigger = getConcreteElements((List<? extends AbstractEntity>) ((Trigger)t.getTrigger()).getFalseTriggers());
				clocksNotInTrigger.removeAll(trueTrigger);
			
			for (SolverElement se : trueTrigger) {
				if (! stepExecutor.clockHasFired((SolverClock) se)){
					continue allTransition; //it is not a fired transition
				}
			}
			for (SolverElement se : falseTrigger) {
				if (stepExecutor.clockHasFired((SolverClock) se)){
					continue allTransition; //it is not a fired transition
				}
			}
			for (SolverElement se : clocksNotInTrigger) {
				if (stepExecutor.clockHasFired((SolverClock) se)){
					continue allTransition; //it is not a fired transition
				}
			}
			
			//here, it is the fired transition
			
			for (AbstractAction a : t.getActions()) {
				if (a instanceof FinishClock){
					SolverClock toKill = (SolverClock) _abstract2concreteMap.getLocalValue((AbstractEntity) ((FinishClock) a).getClock());
					stepExecutor.getNewDeadClocks().add(toKill);
					toKill.setDead(true);
				}
				if (a instanceof IntegerAssignement){
					IntegerAssignement ia = (IntegerAssignement)a;
					doAssignInt(ia);
				}
			}
			
			
			_currentState = t.getTarget();
			
			}
			_sensitiveTransitition.clear();
			break;
		}
	}

	//TODO: make it clean either throw a visitor, or by using the timesquare mecanism
	
	
	private void doAssignInt(IntegerAssignement ia) {
		IntegerExpression leftExpr = ia.getLeftValue();
		IntegerExpression rightExpr = ia.getRightValue();
							
		if (!(rightExpr instanceof IntPlus |rightExpr instanceof IntMinus | rightExpr instanceof IntegerVariableRef)){
			throw new IllegalArgumentException("only integer plus/minus and integer variable ref expressions are supported as right value of assignment");
		}
		if(rightExpr instanceof IntPlus){
			IntPlus plus = (IntPlus)rightExpr;

			int iToIncrement = getInteger(plus.getLeftValue());
			int incrementValue = getInteger(plus.getRightValue());
			
			if (! (leftExpr instanceof IntegerRef)){
				throw new IllegalArgumentException("left value of assignment should be integerRef (to a local integer !)");
			}
			
			IntegerElement leftElement = ((IntegerRef)leftExpr).getIntegerElem();
			IntegerElement localLeftElement = _localInteger.get(leftElement);
			localLeftElement.setValue(iToIncrement+incrementValue);
//			System.out.println("new Value is: "+localLeftElement.getValue());
		}
		
		if(rightExpr instanceof IntMinus){
			IntMinus minus = (IntMinus)rightExpr;

			int iToIncrement = getInteger(minus.getLeftValue());
			int decrementValue = getInteger(minus.getRightValue());
			
			if (! (leftExpr instanceof IntegerRef)){
				throw new IllegalArgumentException("left value of assignment should be integerRef (to a local integer !)");
			}
			
			IntegerElement leftElement = ((IntegerRef)leftExpr).getIntegerElem();
			IntegerElement localLeftElement = _localInteger.get(leftElement);
			localLeftElement.setValue(iToIncrement-decrementValue);
//			System.out.println("new Value is: "+localLeftElement.getValue());
		}
		
		if(rightExpr instanceof IntegerVariableRef){
			IntegerVariableRef varRef = (IntegerVariableRef)rightExpr;

			int iToAssign = ((IntegerElement) _abstract2concreteMap.get(varRef.getReferencedVar()).getModelElement()).getValue().intValue();
			
			if (! (leftExpr instanceof IntegerRef)){
				throw new IllegalArgumentException("left value of assignment should be integerRef (to a local integer !)");
			}
			
			IntegerElement leftElement = ((IntegerRef)leftExpr).getIntegerElem();
			IntegerElement localLeftElement = _localInteger.get(leftElement);
			localLeftElement.setValue(iToAssign);
		}
		return;
	}

	private boolean evaluateIntEqual(IntEqual guard){
		
		IntegerExpression leftExpr = guard.getLeftValue();
		IntegerExpression rightExpr = guard.getRightValue();
		
		int left = getInteger(leftExpr);
		int right = getInteger(rightExpr);
		return left == right;
	}
	
	
	
	private boolean evaluateIntInf(IntInf guard){
		IntegerExpression leftExpr = guard.getLeftValue();
		IntegerExpression rightExpr = guard.getRightValue();
		
		int left = getInteger(leftExpr);
		int right = getInteger(rightExpr);
		
		return left < right;
	}
	
	private boolean evaluateIntSup(IntSup guard){
		IntegerExpression leftExpr = guard.getLeftValue();
		IntegerExpression rightExpr = guard.getRightValue();
		
		int left = getInteger(leftExpr);
		int right = getInteger(rightExpr);
		//System.out.println("capacity ("+left+") > currentSize("+right+")");
		return left > right;
	}
	
	private int getInteger(IntegerExpression expr){
		
		if(expr instanceof IntegerRef){
			IntegerElement localLeftElement = _localInteger.get(((IntegerRef)expr).getIntegerElem());
			if (localLeftElement == null){
				//this should never be a left element of an assignement, i.e. the integer ref points to an int "elsewhere" (e.g. in a lib)
				localLeftElement = ((IntegerRef)expr).getIntegerElem();
			}
			return localLeftElement.getValue();
		}else{
			if(expr instanceof IntegerVariableRef){
				SolverElement ce = _abstract2concreteMap.getLocalValue(((IntegerVariableRef)expr).getReferencedVar());
				if (ce instanceof SolverPrimitiveElement){
					try{
						return ((IntegerElement)((SolverPrimitiveElement)ce).getPrimitiveElement()).getValue();
					}catch(Exception e){
						throw new IllegalArgumentException("warning, you should only refer to IntegerVariable: "+e.toString());
					}
				}
				
			}else
			if(expr instanceof IntegerRef){
				return ((IntegerRef)expr).getIntegerElem().getValue();
			}
			else
			if(expr instanceof IntPlus){
				IntPlus plus = (IntPlus)expr;
	
				int iToIncrement = getInteger(plus.getLeftValue());
				int incrementValue = getInteger(plus.getRightValue());
				return iToIncrement + incrementValue;
			}
			else
			if(expr instanceof IntMinus){
				IntMinus minus = (IntMinus)expr;

				int iToDecrement = getInteger(minus.getLeftValue());
				int decrementValue = getInteger(minus.getRightValue());
				return iToDecrement - decrementValue;
			}
			else{
				throw new IllegalArgumentException("left value of assignment should be integerRef (to a local integer !)");
			}
			
		}
		return -1;
	}
	
	
	
	@Override
	public ArrayList<byte[]> getState() {
		//super does not add anything in the list
		ArrayList<byte[]> currentState = new ArrayList<byte[]>();
		int currentStateIndex = _modelSTS.getStates().indexOf(_currentState);
		currentState.add(Serializer.getDefaultProtocol().toBytes(currentStateIndex));
		for(IntegerElement ie : _localInteger.values()){
			currentState.add(Serializer.getDefaultProtocol().toBytes(ie.getValue().intValue()));
//			System.out.println("################################################################# mem:" +ie.getValue().intValue());
		}
		return currentState;
	}

	@Override
	public void setState(ArrayList<byte[]> state) {
		_currentState = _modelSTS.getStates().get((Integer) Serializer.getDefaultProtocol().fromBytes(state.get(0)));
		int i=1;
		for(IntegerElement ie : _localInteger.values()){
			ie.setValue((Integer) Serializer.getDefaultProtocol().fromBytes(state.get(i++)));
		}
		return;		
	}
	
	
}
