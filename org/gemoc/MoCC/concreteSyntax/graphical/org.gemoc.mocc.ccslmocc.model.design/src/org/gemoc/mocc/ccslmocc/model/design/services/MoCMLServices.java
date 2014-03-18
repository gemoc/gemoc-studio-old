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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gemoc.mocc.ccslmoc.model.ccslmocc.CcslmoccPackage;
import org.gemoc.mocc.ccslmoc.model.ccslmocc.FinishClock;
import org.gemoc.mocc.ccslmoc.model.ccslmocc.StartClock;
import org.gemoc.mocc.ccslmoc.model.ccslmocc.StateMachineRelationDefinition;
import org.gemoc.mocc.ccslmoc.model.ccslmocc.StateRelationBasedLibrary;
import org.gemoc.mocc.fsmkernel.model.FSMModel.AbstractAction;
import org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Guard;
import org.gemoc.mocc.fsmkernel.model.FSMModel.IntegerAssignement;
import org.gemoc.mocc.fsmkernel.model.FSMModel.IntegerAssignementBlock;
import org.gemoc.mocc.fsmkernel.model.FSMModel.State;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Transition;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Trigger;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.Type;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.CCSLModelPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpression;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.AbstractEntity;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity;



public class MoCMLServices {
	public MoCMLServices() {
		// TODO Auto-generated constructor stub
	}
	
	public Collection<Type> getAllExistingTypes(Type type){
		if (type.eContainer() instanceof StateRelationBasedLibrary) {
			return getAllExistingTypes((StateRelationBasedLibrary)type.eContainer());
		}
		return null;
	}
	
	
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
	
	public Collection<BindableEntity> getExistingBindableEntities(StateMachineRelationDefinition fsm){
		//Are considered the bindable entities contained in the fsm, and
		//the ones refered in the associated declaration
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
	
	public String computeLabel(AbstractEntity element){
		StringBuilder sb = new StringBuilder(16);
		if (element.getDesiredEventKind()!=null) {
			sb.append("{");
			sb.append(element.getDesiredEventKind().getLiteral());
			sb.append("} ");
		}
		sb.append(element.getName());
		if (element.getType()!=null) {
			sb.append(": ");
			sb.append(element.getType().getName());
		}
		return sb.toString();
	}
	
	public String createLabel(State element){
		StringBuilder sb = new StringBuilder(16);
		sb.append(getUpperCaseLettersAndNumbers(((StateMachineRelationDefinition)element.eContainer()).getName()));
		sb.append("_S");
		sb.append(((StateMachineRelationDefinition)element.eContainer()).getStates().size());
		return sb.toString();
	}
	
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
	
	
	/*public String computeLabel(EObject Element){
		return Element.eClass().getName();
		if (Element instanceof MoCInterface) {
			return computeLabel((MoCInterface) Element);
		}
		return "test EOBject";
	}*/
}
