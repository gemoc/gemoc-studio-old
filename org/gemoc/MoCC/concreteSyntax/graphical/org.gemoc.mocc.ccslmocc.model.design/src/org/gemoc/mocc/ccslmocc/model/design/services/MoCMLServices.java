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
package org.gemoc.mocc.ccslmocc.model.design.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.gemoc.mocc.ccslmoc.model.ccslmocc.CcslmoccPackage;
import org.gemoc.mocc.ccslmoc.model.ccslmocc.FinishClock;
import org.gemoc.mocc.ccslmoc.model.ccslmocc.StartClock;
import org.gemoc.mocc.ccslmoc.model.ccslmocc.StateMachineRelationDefinition;
import org.gemoc.mocc.ccslmoc.model.ccslmocc.StateRelationBasedLibrary;
import org.gemoc.mocc.fsmkernel.model.FSMModel.AbstractAction;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Guard;
import org.gemoc.mocc.fsmkernel.model.FSMModel.IntegerAssignement;
import org.gemoc.mocc.fsmkernel.model.FSMModel.IntegerAssignementBlock;
import org.gemoc.mocc.fsmkernel.model.FSMModel.State;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Transition;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Trigger;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.NamedElement;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.Type;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.AbstractEntity;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity;



/**
 * MoCMLServices for CCSLMoCC odesign
 * @author Stfun
 *
 */
public class MoCMLServices {
	
	public MoCMLServices() {}
	
	/**
	 * Get an ordered list of states and transitions for a given state machine, starting
	 * from the initial state, its outgoing transitions, then the other states and outgoing transitions.
	 * @param fsm : the given state machine
	 * @return the ordered list of states and transitions
	 */
	public Collection<NamedElement> getDetails(StateMachineRelationDefinition fsm){
		Collection<NamedElement> lst = new ArrayList<NamedElement>();
		//initial state
		lst.add(fsm.getInitialStates().get(0));
		//outgoing transitions
		if ((fsm.getInitialStates().get(0).getOutputTransitions()!=null) &&(!fsm.getInitialStates().get(0).getOutputTransitions().isEmpty())) {
			lst.addAll(fsm.getInitialStates().get(0).getOutputTransitions());
		}
		//do the same for the other states..
		for (State state : fsm.getStates()) {
			if (!fsm.getInitialStates().contains(state)) {
				lst.add(state);
				//outgoing transitions
				if ((state.getOutputTransitions()!=null) &&(!state.getOutputTransitions().isEmpty())) {
					lst.addAll(state.getOutputTransitions());
				}
			}
		}
		return lst;
	}
	
	
	/**
	 * Get all types, including the given entry point type.
	 * @param type
	 * @return all existing types referenced by the model
	 */
	public Collection<Type> getAllExistingTypes(Type type){
		if (type.eContainer() instanceof StateRelationBasedLibrary) {
			return getAllExistingTypes((StateRelationBasedLibrary)type.eContainer());
		}
		return null;
	}
	
	
	/**
	 * Get all types, contained by the library or imported from others.
	 * @param stateLib
	 * @return all existing types referenced by the model
	 */
	public Collection<Type> getAllExistingTypes(StateRelationBasedLibrary stateLib){
		Collection<Type> lst = new ArrayList<Type>();
		if ((stateLib.getImports()!=null) && (!stateLib.getImports().isEmpty())) {
			lst.addAll(getImportedTypes(stateLib));
		}
		if ((stateLib.getPredefinedTypes()!=null)&&(!stateLib.getPredefinedTypes().isEmpty())) {
			lst.addAll(stateLib.getPredefinedTypes());
		}
		return lst;
	}
	
	
	/**
	 * Get all types from imported libraries.
	 * @param stateLib
	 * @return all existing imported types
	 */
	public Collection<Type> getImportedTypes(StateRelationBasedLibrary stateLib){
		Collection<Type> lst = new ArrayList<Type>();
		if ((stateLib.getImports()!=null) && (!stateLib.getImports().isEmpty())) {
			for (Iterator<Notifier> iterator = stateLib.eResource().getResourceSet().getAllContents(); iterator.hasNext();) {
				Notifier n = iterator.next();
				if (n instanceof Type) {
					if (((Type) n).eContainer()!=stateLib) {
						lst.add((Type)n);
					}
				}
			}
		}
		return lst;
	}
	
	/**
	 * Are considered the bindable entities contained in the fsm, and
	 * the ones referenced in the associated declaration
	 * @param fsm
	 * @return
	 */
	public Collection<BindableEntity> getExistingBindableEntities(StateMachineRelationDefinition fsm){	
		Collection<BindableEntity> lst = new ArrayList<BindableEntity>();
		if ((fsm.getDeclaration()!=null)&&(!fsm.getDeclaration().getParameters().isEmpty())) {
			lst.addAll(fsm.getDeclaration().getParameters());
		}
		if (fsm.getDeclarationBlock()!=null) {
			for (Iterator<EObject> iterator = fsm.getDeclarationBlock().eAllContents(); iterator.hasNext();) {
				EObject eo = iterator.next();
				if (eo instanceof BindableEntity) {
					lst.add((BindableEntity)eo);
				}
			}
		}
		return lst;
	}
	
	/**
	 * Compute the given AbstractEntity label
	 * @param element : the AbstractEntity
	 * @return the computed label "[name]: [type]"
	 */
	public String computeLabel(AbstractEntity element){
		StringBuilder sb = new StringBuilder(16);
		/*if (element.getDesiredEventKind()!=null) {
			sb.append("{");
			sb.append(element.getDesiredEventKind().getLiteral());
			sb.append("} ");
		}*/
		sb.append(element.getName());
		if (element.getType()!=null) {
			sb.append(": ");
			sb.append(element.getType().getName());
		}
		return sb.toString();
	}
	
	/**
	 * Create the given State label
	 * @param element : the State
	 * @return the created label "[FSM-name-initials]_S[NumberOfStates]"
	 */
	public String createLabel(State element){
		StringBuilder sb = new StringBuilder(16);
		sb.append(getUpperCaseLettersAndNumbers(((StateMachineRelationDefinition)element.eContainer()).getName()));
		sb.append("_S");
		sb.append(((StateMachineRelationDefinition)element.eContainer()).getStates().size());
		return sb.toString();
	}
	
	
	/**
	 * Filter (keep) the Upper case letter and numbers from a string
	 * @param name : the string
	 * @return "AzerTy1" -> "AT1"
	 */
	private String getUpperCaseLettersAndNumbers(String name){
		if ((name!=null)&&(!name.isEmpty())) {
			StringBuilder sb = new StringBuilder(16);
			for(int i=0; i<name.length(); i++) {
		        if(Character.isUpperCase(name.charAt(i))) {
		        	sb.append(name.charAt(i));
		        }else if (Character.isDigit(name.charAt(i))) {
		        	sb.append(name.charAt(i));
				}
			}
			if (sb.length()==0) {
				sb.append(name.charAt(0));
			}
			return sb.toString();
		}
		return "";
	}
	
	/**
	 * Compute a detailed label for a transition
	 * @param element : the given transition
	 * @return "	to:[targetName], defined as:[transitionLabel]"
	 */
	public String computeDetailedLabel(Transition element){
		StringBuilder sb = new StringBuilder(16);
		sb.append("    to:").append(element.getTarget().getName());
		sb.append(", defined as:").append(computeLabel(element));
		return sb.toString();
	}
	
	
	/**
	 * Compute a transition label, included guard, trigger and transition whether existing..
	 * @param element : the given transition
	 * @return
	 */
	public String computeLabel(Transition element){
		StringBuilder sb = new StringBuilder(16);
		boolean changed = false;
		if (element.getTrigger()!=null) {
			if (!((Trigger)element.getTrigger()).getTrueTriggers().isEmpty()) {
				for (Iterator<BindableEntity> iterator = ((Trigger)element.getTrigger()).getTrueTriggers().iterator(); iterator
						.hasNext();) {
					BindableEntity trigger = (BindableEntity) iterator.next();
					sb.append(trigger.getName());
					if (iterator.hasNext()) {
						sb.append(", ");
					}
				}			
			}else if (!((Trigger)element.getTrigger()).getFalseTriggers().isEmpty()) {
				for (Iterator<BindableEntity> iterator = ((Trigger)element.getTrigger()).getFalseTriggers().iterator(); iterator
						.hasNext();) {
					BindableEntity trigger = (BindableEntity) iterator.next();
					sb.append(trigger.getName());
					if (iterator.hasNext()) {
						sb.append(", ");
					}
				}
			}
			changed = true;
		}
		if (element.getGuard()!=null) {
			sb.append(" [");
			sb.append(((Guard)element.getGuard()).getValue().getName());
			sb.append("] ");
			changed = true;
		} 
		if (!element.getActions().isEmpty()) {
				sb.append(" /");
				for (Iterator<AbstractAction> iterator = element.getActions().iterator(); iterator
						.hasNext();) {
					AbstractAction action = iterator.next();
					sb.append("do ");
					switch (action.eClass().getClassifierID()) {
					case CcslmoccPackage.START_CLOCK:
						sb.append("start ");
						sb.append(((StartClock)action).getClock().getName());
						break;
					case CcslmoccPackage.FINISH_CLOCK:
						sb.append("finish ");
						sb.append(((FinishClock)action).getClock().getName());
						break;
					default: //FSMModelPackage.INTEGER_ASSIGNEMENT or block
						if (action instanceof IntegerAssignement) {
							sb.append("assign ");
							sb.append(((IntegerAssignement)action).getName());
						}else {
							sb.append("assign ");
							sb.append(((IntegerAssignementBlock)action).getName());
						}
						
						break;
					}
					if (iterator.hasNext()) {
						sb.append(", ");
					}
				}
				changed = true;
		}
		if (!changed) {
			sb.append(element.getName());
		}
		return sb.toString();
	}
	
	
	/**
	 * Create a label for a transition
	 * @param element  : the given transition
	 * @return "[sourceName]To[targetName]index"
	 */
	public String createLabel(Transition element){
		StringBuilder sb = new StringBuilder(16);
		sb.append(element.getSource().getName()).append("To").append(element.getTarget().getName());
		String text = sb.toString();
		int i =1;
		for (Iterator<Transition> iterator = ((StateMachineRelationDefinition)element.eContainer()).getTransitions().iterator(); iterator.hasNext();) {
			Transition t = iterator.next();
			if (t!=element) {
				if (t.getName().equalsIgnoreCase(text)) {
					i++;
				}
			}
		}
		if (i!=1) {
			sb.append(i);
		}				
		return sb.toString();
	}
	
	/**
	 * Compute state label
	 * @param state
	 * @return "({init}|{final}|{init, final})? [stateName]"
	 */
	public String computeLabel(State state){
		StringBuilder sb = new StringBuilder(16);
		if (((StateMachineRelationDefinition)state.eContainer()).getInitialStates().contains(state)) {
			sb.append("{init");
			if (((StateMachineRelationDefinition)state.eContainer()).getFinalStates().contains(state)) {
			sb.append(", final} ");
			}else {
				sb.append("} ");
			}
		}else {
			if (((StateMachineRelationDefinition)state.eContainer()).getFinalStates().contains(state)) {
				sb.append("{final} ");
			}
		}
		sb.append(state.getName());
		return sb.toString();
	}
	
}
