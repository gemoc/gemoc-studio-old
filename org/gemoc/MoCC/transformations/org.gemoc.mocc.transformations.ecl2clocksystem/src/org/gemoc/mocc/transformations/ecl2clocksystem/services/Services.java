/**
 * Copyright (c) 2012-2016 GEMOC consortium.
 * 
 * http://www.gemoc.org
 * 
 * Contributors:
 *   Stephen Creff - ENSTA Bretagne [stephen.creff@ensta-bretagne.fr]
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * $Id$
 */
package org.gemoc.mocc.transformations.ecl2clocksystem.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.gemoc.mocc.ccslmoc.model.ccslmocc.StateMachineRelationDefinition;
import org.gemoc.mocc.fsmkernel.model.FSMModel.AbstractAction;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Guard;
import org.gemoc.mocc.fsmkernel.model.FSMModel.IntegerAssignement;
import org.gemoc.mocc.fsmkernel.model.FSMModel.State;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Transition;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Trigger;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntInfEqual;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSupEqual;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.BooleanElement;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.DenseClockType;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.DiscreteClockType;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.IntegerElement;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.PrimitiveElement;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.And;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.BinaryIntegerExpression;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.BooleanExpression;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.BooleanRef;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.BooleanVariableRef;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpression;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpressionPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntDivide;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntEqual;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntInf;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntMinus;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntMultiply;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntPlus;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntSup;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntegerRef;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntegerVariableRef;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.Not;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.Or;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.Xor;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.AbstractEntity;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.RelationDeclaration;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.RelationDefinition;

/**
 * Services for the clocksystem model generation
 * <br/>FIXME: this is a first version of the services
 * <br/>add comments,
 * <br/>test more,
 * @author Stfun
 *
 */
public class Services {
	
	// StateMachine.name -> hashmap (state->number)
	HashMap<String, HashMap<String, Integer>> map;
	
	public String basicConstraints(Trigger out) {
		StringBuilder mytab = new StringBuilder();
		List<BindableEntity> l_in = out.getTrueTriggers();
		//List<BindableEntity> l_out = out.getTrueTriggers();
		//TODO to complete for false triggers if necessary
		for(int i=0; i< l_in.size() -1; i++)
		{
			String cc = "" + l_in.get(i).toString() + "=" + l_in.get(i+1).toString()+ ".";
			mytab.append(cc);
		}
		return mytab.toString();
	}
	
	public String nameToNumID(State s){
		if (map==null) {
			map = new HashMap<String, HashMap<String, Integer>>();
		}
		String fsmName = ((StateMachineRelationDefinition)s.eContainer()).getName();
		if (!map.containsKey(fsmName)) {			
			map.put(fsmName, new HashMap<String, Integer>());
		}
		
		if (!map.get(fsmName).containsKey(s.getName())) {
			Integer i = new Integer(map.get(fsmName).size());
			map.get(fsmName).put(s.getName(), i);
		}
		return map.get(fsmName).get(s.getName()).toString();
	}
	
	public String getListedClocks(RelationDefinition def){
		StringBuilder sb = new StringBuilder(0); 
		for (AbstractEntity ae : def.getDeclaration().getParameters()) {
			if ((ae.getType()instanceof DenseClockType)||(ae.getType()instanceof DiscreteClockType)) {
				if (sb.length()!=0) {
					sb.append(" ");
				}
				sb.append(":").append(ae.getName());
			}
		}
		return sb.toString();
	}
	
	private EList<PrimitiveElement> getVariables(RelationDefinition def){
		EList<PrimitiveElement> lst = new BasicEList<>();
		for (Iterator<EObject> iterator = def.eAllContents(); iterator.hasNext();) {
			EObject eo = iterator.next();
			if ((eo instanceof IntegerElement)||(eo instanceof BooleanElement)) {
				lst.add((PrimitiveElement)eo);
			}
		}
		return lst;
	}
	
	public int getVariableIndex(RelationDefinition def, String varName){
		int count = 0;
		for (PrimitiveElement el : getVariables(def)) {
			++count;
			if (el.getName().equals(varName)) {
				return count;
			}
		}
		return count;
	}
	
	public int getVariableIndexPlusOne(RelationDefinition def, String varName){
		return getVariableIndex(def, varName)+1;
	}
	
	public String getExpression(IntegerAssignement action){
		String result = print(action.getRightValue());
		return result.replaceAll(getActionVariableName(action), getActionVariableName(action)+'_');
	}
	
	public String getActionVariableName(IntegerAssignement action){
		if(action.getLeftValue() instanceof IntegerRef){
			return ((IntegerRef)action.getLeftValue()).getIntegerElem().getName();
		}
		if(action.getLeftValue() instanceof IntegerVariableRef){
			return ((IntegerVariableRef)action.getLeftValue()).getReferencedVar().getName();
		}
		return "TODOActionName";
	}
	
	public String getListedVariables(RelationDefinition def){
		StringBuilder sb = new StringBuilder(0); 
		for (PrimitiveElement el : getVariables(def)) {
			if (sb.length()!=0) {
				sb.append(" ");
			}
			sb.append(":").append(el.getName());
		}
		return sb.toString();
	}
	
	public String getListedConstants(RelationDefinition def){
		StringBuilder sb = new StringBuilder(0); 
		for (AbstractEntity ae : def.getDeclaration().getParameters()) {
			if (!((ae.getType()instanceof DenseClockType)||(ae.getType()instanceof DiscreteClockType))) {
				if (sb.length()!=0) {
					sb.append(" ");
				}
				sb.append(":").append(ae.getName());
			}
		}
		return sb.toString();
	} 
	
	public boolean hasOnlyTriggers(RelationDefinition def){
		boolean b=true;
		for (Transition t : ((StateMachineRelationDefinition)def).getTransitions()) {
			if ((t.getGuard()!=null)||(!t.getActions().isEmpty())) {
				b=false;
			}
		}
		return b;
	}
	
	public boolean hasGuard(Transition t){
		return (t.getGuard()!=null);
	}
	
	public boolean hasTrigger(Transition t){
		return (t.getTrigger()!=null);
	}
	
	public boolean hasActions(Transition t){
		return ((t.getActions()!=null)&&(!t.getActions().isEmpty()));
	}
	
	public String printTrigger(Transition t){
		StringBuilder sb = new StringBuilder(0);
		for (BindableEntity be : ((Trigger)t.getTrigger()).getTrueTriggers()) {
			if (sb.length()!=0) {
				sb.append(" ");
			}
			sb.append(be.getName());
		}
		return sb.toString();
	}
	
	public String printGuard(Transition t){
		BooleanExpression be = ((Guard)t.getGuard()).getValue();
		String result = print(be);
		
		return result;
	}
	
	private String print(ClassicalExpression ce){
		switch (ce.eClass().getClassifierID()) {
		case ClassicalExpressionPackage.AND:
			return print(((And)ce).getLeftValue())+" & "+print(((And)ce).getRightValue());
		case ClassicalExpressionPackage.NOT:
			return "not "+print(((Not)ce).getOperand());
		case ClassicalExpressionPackage.OR:
			return print(((Or)ce).getLeftValue())+" | "+print(((Or)ce).getRightValue());
		case ClassicalExpressionPackage.XOR:
			return print(((Xor)ce).getLeftValue())+" bitXor "+print(((Xor)ce).getRightValue());
		case ClassicalExpressionPackage.BOOLEAN_REF:
			return ((BooleanRef)ce).getReferencedBool().getName();
		case ClassicalExpressionPackage.BOOLEAN_VARIABLE_REF:
			return ((BooleanVariableRef)ce).getReferencedVar().getName();
		case ClassicalExpressionPackage.INTEGER_REF:
			return ((IntegerRef)ce).getIntegerElem().getName();
		case ClassicalExpressionPackage.INTEGER_VARIABLE_REF:
			return ((IntegerVariableRef)ce).getReferencedVar().getName();
		case ClassicalExpressionPackage.INT_DIVIDE:
			return print(((IntDivide)ce).getLeftValue())+" / "+print(((IntDivide)ce).getRightValue());
		case ClassicalExpressionPackage.INT_EQUAL:
			return print(((IntEqual)ce).getLeftValue())+" == "+print(((IntEqual)ce).getRightValue());
		case ClassicalExpressionPackage.INT_INF:
			return print(((IntInf)ce).getLeftValue())+" < "+print(((IntInf)ce).getRightValue());
		case ClassicalExpressionPackage.INT_MINUS:
			return print(((IntMinus)ce).getLeftValue())+" - "+print(((IntMinus)ce).getRightValue());
		case ClassicalExpressionPackage.INT_MULTIPLY:
			return print(((IntMultiply)ce).getLeftValue())+" * "+print(((IntMultiply)ce).getRightValue());
		case ClassicalExpressionPackage.INT_PLUS:
			return print(((IntPlus)ce).getLeftValue())+" + "+print(((IntPlus)ce).getRightValue());
		case ClassicalExpressionPackage.INT_SUP:
			return print(((IntSup)ce).getLeftValue())+" > "+print(((IntSup)ce).getRightValue());
		default:
			if (ce instanceof IntInfEqual) {
				return print(((IntInfEqual)ce).getLeftValue())+" <= "+print(((IntInfEqual)ce).getRightValue());
			}
			if (ce instanceof IntSupEqual) {
				return print(((IntSupEqual)ce).getLeftValue())+" >= "+print(((IntSupEqual)ce).getRightValue());
			}
			return "TODO_printType";
		}
		
	}
	
public String varArrayAction(Transition t){
		
		StringBuilder st= new StringBuilder();
		List<AbstractAction> act = t.getActions();
		List<String> intref = new ArrayList<String>(); // List of IntegerRef IntegerVariableRef and names
		List<EObject> allObj = new ArrayList<EObject>();
		for(int i=0; i< act.size();i++)
		{
			TreeIterator<EObject> obj = act.get(i).eAllContents();
			while(obj.hasNext()==true)
			{
				allObj.add(obj.next());
			}
			for(int j=0; j< allObj.size();j++)
			{
				if(allObj.get(j) instanceof IntegerRef)
					{
					 IntegerRef aImpl;
					 aImpl = (IntegerRef) allObj.get(j);
					 if(intref.contains(aImpl.getIntegerElem().getName())==false)
						 intref.add(aImpl.getIntegerElem().getName());
					}
				
				if(allObj.get(j) instanceof IntegerVariableRef)
				{
					 IntegerVariableRef _aImpl;
					 _aImpl = (IntegerVariableRef) allObj.get(j);
					 if(intref.contains(_aImpl.getReferencedVar().getName())==false)
						 intref.add(_aImpl.getReferencedVar().getName());
				}
			}
		}
		HashSet<String> hs = new HashSet<String>();
		hs.addAll(intref);
		intref.clear();
		intref.addAll(hs);
		for(int v=0; v<intref.size();v++)
		{
			st.append(" :"+intref.get(v));
		}
		return st.toString();
		//return allObj.toString();
	}
	
public String toStringAction(Transition t){
		
		StringBuilder st= new StringBuilder();
		List<AbstractAction> act = t.getActions();
		//List<String> intref = new ArrayList<String>(); // List of IntegerRef IntegerVariableRef and names
		//List<EObject> allObj = new ArrayList<EObject>();
		for(int i=0; i< act.size();i++)
		{
			String s = "";
			if (act.get(i) instanceof IntegerAssignement)
			{
				IntegerAssignement imp;
				imp = (IntegerAssignement) act.get(i);
				
				if ((imp.getRightValue() instanceof IntegerRef) || (imp.getRightValue() instanceof IntegerVariableRef))
				{
					IntegerRef ti;
					ti = (IntegerRef) imp.getLeftValue();
					s = ti.getIntegerElem().getName() + "="+sepVar(imp.getRightValue())+".";
				}
				else if (!((imp.getRightValue() instanceof IntegerRef) || (imp.getRightValue() instanceof IntegerVariableRef)))
				{
					if(imp.getRightValue() instanceof BinaryIntegerExpression)
					{
						IntegerRef ti;
						ti = (IntegerRef) imp.getLeftValue();
						BinaryIntegerExpression tr;
						tr = (BinaryIntegerExpression) imp.getRightValue();
						s = ti.getIntegerElem().getName() + "="+buildActionBlocUnit(tr)+".";
					}
				}
			}
			st.append(s);
		}

		return st.toString();
	}
	
	public String toStringGuard (ClassicalExpression cl)
	{
		String s="";
		
		if (cl instanceof IntEqual)
		{
			IntEqual si;
			si = (IntEqual) cl;
			s= sepVar(si.getLeftValue())+" == "+sepVar(si.getRightValue());
		}
		if (cl instanceof IntSup)
		{
			IntSup si;
			si = (IntSup) cl;
			s= sepVar(si.getLeftValue())+" > "+sepVar(si.getRightValue());
		}
		if (cl instanceof IntInf)	
		{
			IntInf si;
			si = (IntInf) cl;
			s= sepVar(si.getLeftValue())+" < "+sepVar(si.getRightValue());
		}
		return s;
	}
	
	public String buildActionBlocUnit (BinaryIntegerExpression in)
	{
		String l="";
		if(((in.getLeftValue() instanceof IntegerRef) || (in.getLeftValue() instanceof IntegerVariableRef)) && ((in.getRightValue() instanceof IntegerRef) || (in.getRightValue() instanceof IntegerVariableRef)))
			l = "("+ sepVar(in.getLeftValue())+ toStringSign(in)+sepVar(in.getRightValue()) +")";
		else if(((in.getLeftValue() instanceof IntegerRef) || (in.getLeftValue() instanceof IntegerVariableRef)) && (in.getRightValue() instanceof BinaryIntegerExpression))
			l = "("+ sepVar(in.getLeftValue())+ toStringSign(in)+buildActionBlocUnit((BinaryIntegerExpression) in.getRightValue()) +")";
		
		else if(((in.getRightValue() instanceof IntegerRef) || (in.getRightValue() instanceof IntegerVariableRef)) && (in.getLeftValue() instanceof BinaryIntegerExpression))
			l = "("+buildActionBlocUnit((BinaryIntegerExpression) in.getLeftValue())  + toStringSign(in)+sepVar(in.getRightValue())+")";
		
		else if ((in.getRightValue() instanceof BinaryIntegerExpression) && (in.getRightValue() instanceof BinaryIntegerExpression))
			l = "("+ buildActionBlocUnit((BinaryIntegerExpression) in.getLeftValue())+ toStringSign(in)+buildActionBlocUnit((BinaryIntegerExpression) in.getRightValue()) +")";
			return l;	
	}
	
	public String sepVar(Object obj)
	{
		String s="";
		if(obj instanceof IntegerRef)
		{
			IntegerRef ref;
			ref = (IntegerRef) obj; 
			s= ref.getIntegerElem().getName();
		}
		
		if(obj instanceof IntegerVariableRef)
		{
			IntegerVariableRef ref;
			ref = (IntegerVariableRef) obj;
			s=ref.getReferencedVar().getName();
		}
		return s;
	}
	public String toStringSign (BinaryIntegerExpression in)
	{
		String s="";
		if (in instanceof IntPlus)
		{
			s="+";
		}
		if (in instanceof IntMinus)
		{
			s="-";
		}
		if (in instanceof IntDivide)
		{
			s="/";
		}
		if (in instanceof IntMultiply)
		{
			s="*";
		}
		return s;
	}
	
	public String getConstants(RelationDeclaration rd){
		StringBuilder st= new StringBuilder();
		for (Iterator<AbstractEntity> iterator = rd.getParameters().iterator(); iterator.hasNext();) {
			AbstractEntity ae = iterator.next();
			if (!((ae.getType() instanceof DenseClockType)||(ae.getType() instanceof DiscreteClockType))) {
				if (st.length()!=0) {
					st.append(" ");
				}
				st.append(":").append(ae.getName());
			}
		}
		return st.toString();
	}
	
	public String getClocks(RelationDeclaration rd){
		StringBuilder st= new StringBuilder();
		for (Iterator<AbstractEntity> iterator = rd.getParameters().iterator(); iterator.hasNext();) {
			AbstractEntity ae = iterator.next();
			if ((ae.getType() instanceof DenseClockType)||(ae.getType() instanceof DiscreteClockType)) {
				if (st.length()!=0) {
					st.append(" ");
				}
				st.append(":").append(ae.getName());
			}
		}
		return st.toString();
	}
	
	public String getVariables(StateMachineRelationDefinition sm){
		StringBuilder st= new StringBuilder();
		//FIXME check whether var in the declaration block are considered as
		//variables or constants (by going through the automaton)
		for (ConcreteEntity ce : sm.getDeclarationBlock().getConcreteEntities()) {
			if (st.length()!=0) {
				st.append(" ");
			}
			st.append(":").append(ce.getName());
		}
		return st.toString();
	}
	
}
