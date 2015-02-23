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

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.xtext.base.basecs.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.LetVariableCS;
import org.gemoc.mocc.ccslmoc.model.moccml.StateMachineRelationDefinition;
import org.gemoc.mocc.ccslmoc.model.moccml.StateRelationBasedLibrary;
import org.gemoc.mocc.transformations.ecl2clocksystem.libLoader.LibLoader;

import fr.inria.aoste.timesquare.ECL.ECLDocument;
import fr.inria.aoste.timesquare.ECL.ECLExpression;
import fr.inria.aoste.timesquare.ECL.ECLRelation;
import fr.inria.aoste.timesquare.ECL.EventType;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.IntegerElement;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ExpressionLibrary;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Library;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.RelationDeclaration;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.RelationDefinition;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.RelationLibrary;

/**
 * Services to go through the ECL models
 * <br/>FIXME: this is a first version of the services
 * <br/>add comments,
 * <br/>test more,
 * @author Stfun
 *
 */
public class EclServices {
	
	public String getMoCIDFromFirstLib(ECLDocument document){
		StateRelationBasedLibrary lib = LibLoader.loadMoCMLLibrary(document.getImports().get(0));
		return lib.getName();
	}
	
	public EList<String> getContextFullLabels(ECLDocument document){
		EList<String> result = new BasicEList<>();	
		for (Iterator<ContextDeclCS> iterator = getContexts(document).iterator(); iterator.hasNext();) {
			ContextDeclCS c = iterator.next();
			String cLabel = ((Package)((PackageDeclarationCS)c.eContainer()).getPivot()).getName()+"::"+((org.eclipse.ocl.examples.pivot.Class)c.getPivot()).getName();
			if (!result.contains(cLabel)) {
				result.add(cLabel);
			}
		}
		return result;
	}
	
	public EList<ContextDeclCS> getContexts(ECLDocument document){
		EList<ContextDeclCS> result = new BasicEList<>();
		for (Iterator<ContextDeclCS> iterator = getAllContextOccurences(document).iterator(); iterator.hasNext();) {
			ContextDeclCS contextDeclCS = iterator.next();
			if (!result.contains(contextDeclCS)) {
				result.add(contextDeclCS);
			}	
		}	
		return result;
	}
	
	public EList<String> getContextLabels(ECLDocument document){
		EList<String> result = new BasicEList<>();
		for (Iterator<ContextDeclCS> iterator = getAllContextOccurences(document).iterator(); iterator.hasNext();) {
			ContextDeclCS contextDeclCS = iterator.next();
			String name = ((org.eclipse.ocl.examples.pivot.Class)contextDeclCS.getPivot()).getName();
			if (!result.contains(name)) {
				result.add(name);
			}	
		}	
		return result;
	}
	
	public EList<ContextDeclCS> getAllContextOccurences(ECLDocument document){
		EList<ContextDeclCS> result = new BasicEList<>();
		for (Iterator<PackageDeclarationCS> iterator = document.getPackages().iterator(); iterator.hasNext();) {
			PackageDeclarationCS p = iterator.next();
			for (Iterator<ContextDeclCS> iterator2 = p.getContexts().iterator(); iterator2.hasNext();) {
				ContextDeclCS c = iterator2.next();
				result.add(c);
			}
		}	
		return result;
	}
	
	public EList<String> getAllEvents(ECLDocument document){
		EList<String> result = new BasicEList<>();
		for (Iterator<ContextDeclCS> iterator = getAllContextOccurences(document).iterator(); iterator.hasNext();) {
			ContextDeclCS c = iterator.next();
			result.addAll(getEvents(c));
		}
		return result;
	}
	
	public String getLabel(ContextDeclCS context){
		return ((org.eclipse.ocl.examples.pivot.Class)context.getPivot()).getName();
	}
	
	public EList<String> getEvents(ContextDeclCS context){
		EList<String> result = new BasicEList<>();
		if (context instanceof ClassifierContextDeclCS) {
			ClassifierContextDeclCS cCls = (ClassifierContextDeclCS) context;
			for (Iterator<DefCS> iterator2 = cCls.getDefinitions().iterator(); iterator2
					.hasNext();) {
				DefCS def = iterator2.next();
				if (def.getOwnedType() instanceof EventType) {
					result.add(def.getName());
				}				
			}	
		}
		return result;
	}
	
	public EList<String> getAllEvents(ECLDocument document, String contextName){
		EList<String> result = new BasicEList<>();
		result.addAll(getEvents(document, contextName));
		return result;
	}
	
	public String getExpressionName(ECLDocument document, String contextName, String eventName){
		for (ContextDeclCS contextDeclCS : getAllContextOccurences(document)) {
			if (((org.eclipse.ocl.examples.pivot.Class)contextDeclCS.getPivot()).getName().equals(contextName)) {
				EList<ConstraintCS> invList = getInvariants(contextDeclCS);
				for (ConstraintCS constraintCS : invList) {
					EList<LetExpCS> lst = new BasicEList<>();
					getLetRelation(((ExpSpecificationCS)constraintCS.getSpecification()).getOwnedExpression(), lst);
					for (LetExpCS letExpCS : lst) {
						for(LetVariableCS letVariableCS :letExpCS.getVariable()){
							if (letVariableCS.getOwnedType() instanceof EventType) {
								if (letVariableCS.getName().equalsIgnoreCase(eventName)) {
									return ((ECLExpression)letVariableCS.getInitExpression()).getType().getName();
								}
							}
						}
					}
				}
			}
		}
		return "error in getExpressionName";
	}
	
	
	public String printListedClockParameters(ECLDocument document, String contextName, String eventName){
		for (ContextDeclCS contextDeclCS : getAllContextOccurences(document)) {
			if (((org.eclipse.ocl.examples.pivot.Class)contextDeclCS.getPivot()).getName().equals(contextName)) {
				EList<ConstraintCS> invList = getInvariants(contextDeclCS);
				for (ConstraintCS constraintCS : invList) {
					EList<LetExpCS> lst = new BasicEList<>();
					getLetRelation(((ExpSpecificationCS)constraintCS.getSpecification()).getOwnedExpression(), lst);
					for (LetExpCS letExpCS : lst) {
						for(LetVariableCS letVariableCS :letExpCS.getVariable()){
							if (letVariableCS.getOwnedType() instanceof EventType) {
								if (letVariableCS.getName().equalsIgnoreCase(eventName)) {
									return getClockNamesListedAndSepBySpace(letVariableCS);
								}
							}
						}
					}
				}
			}
		}
		return "error in printListedClockParameters";
	}
	
	public String printListedClockParametersSepByDot(ECLDocument document, String contextName, String eventName){
		for (ContextDeclCS contextDeclCS : getAllContextOccurences(document)) {
			if (((org.eclipse.ocl.examples.pivot.Class)contextDeclCS.getPivot()).getName().equals(contextName)) {
				EList<ConstraintCS> invList = getInvariants(contextDeclCS);
				for (ConstraintCS constraintCS : invList) {
					EList<LetExpCS> lst = new BasicEList<>();
					getLetRelation(((ExpSpecificationCS)constraintCS.getSpecification()).getOwnedExpression(), lst);
					for (LetExpCS letExpCS : lst) {
						for(LetVariableCS letVariableCS :letExpCS.getVariable()){
							if (letVariableCS.getOwnedType() instanceof EventType) {
								if (letVariableCS.getName().equalsIgnoreCase(eventName)) {
									return getClockNamesListedAndSepByDot(letVariableCS);
								}
							}
						}
					}
				}
			}
		}
		return "error in printListedClockParametersSepByDot";
	}
	
	public EList<String> getAllInternalEvents(ECLDocument document, String contextName){
		EList<String> result = new BasicEList<>();
		//add internal events from let expression
		for (ContextDeclCS contextDeclCS : getAllContextOccurences(document)) {
			if (((org.eclipse.ocl.examples.pivot.Class)contextDeclCS.getPivot()).getName().equals(contextName)) {
				EList<ConstraintCS> invList = getInvariants(contextDeclCS);
				for (ConstraintCS constraintCS : invList) {
					EList<LetExpCS> lst = new BasicEList<>();
					getLetRelation(((ExpSpecificationCS)constraintCS.getSpecification()).getOwnedExpression(), lst);
					for (LetExpCS letExpCS : lst) {
						for(LetVariableCS letVariableCS :letExpCS.getVariable()){
							if (letVariableCS.getOwnedType() instanceof EventType) {
								result.add(letVariableCS.getName());
							}
						}
					}
				}
			}
			
		}
		return result;
	}
	
	
	public boolean hasInternalEvents(ECLDocument document, String contextName){
		//add internal events from let expression
		for (ContextDeclCS contextDeclCS : getAllContextOccurences(document)) {
			if (((org.eclipse.ocl.examples.pivot.Class)contextDeclCS.getPivot()).getName().equals(contextName)) {
				EList<ConstraintCS> invList = getInvariants(contextDeclCS);
				for (ConstraintCS constraintCS : invList) {
					EList<LetExpCS> lst = new BasicEList<>();
					getLetRelation(((ExpSpecificationCS)constraintCS.getSpecification()).getOwnedExpression(), lst);
					for (LetExpCS letExpCS : lst) {
						for(LetVariableCS letVariableCS :letExpCS.getVariable()){
							if (letVariableCS.getOwnedType() instanceof EventType) {
								return true;
							}
						}
					}
				}
			}
			
		}
		return false;
	}		
	
	public EList<String> getEvents(ECLDocument document, ContextDeclCS context){
		EList<String> result = new BasicEList<>();
		
		for (Iterator<ContextDeclCS> iterator = getAllContextOccurences(document).iterator(); iterator.hasNext();) {
			ContextDeclCS c = iterator.next();
			if (((org.eclipse.ocl.examples.pivot.Class)c.getPivot()).getName().equals(((org.eclipse.ocl.examples.pivot.Class)context.getPivot()).getName())) {
				result.addAll(getEvents(c));
			}
		}
		return result;
	}
	
	public EList<String> getEvents(ECLDocument document, String contextName){
		EList<String> result = new BasicEList<>();
		
		for (Iterator<ContextDeclCS> iterator = getAllContextOccurences(document).iterator(); iterator.hasNext();) {
			ContextDeclCS c = iterator.next();
			if (((org.eclipse.ocl.examples.pivot.Class)c.getPivot()).getName().equals(contextName)) {
				result.addAll(getEvents(c));
			}
		}
		return result;
	}
	
	public String getListedEventsSepByDot(ECLDocument document, String contextName){
		StringBuilder sb = new StringBuilder(16);
		for (Iterator<String> iterator = getEvents(document, contextName).iterator(); iterator.hasNext();) {
			String e = iterator.next();
			sb.append(e).append("[element.name/]");
			if (iterator.hasNext()) {
				sb.append(". ");
			}
		}
		return sb.toString();
	}
	
	public EList<ConstraintCS> getInvariants(ContextDeclCS context){
		if (context instanceof ClassifierContextDeclCS) {
			ClassifierContextDeclCS cCls = (ClassifierContextDeclCS) context;
			return cCls.getInvariants();	
		}
		return null;
	}
	
	public EList<ConstraintCS> getInvariants(ECLDocument document, String contextName){
		EList<ConstraintCS> result = new BasicEList<>();
		
		for (Iterator<ContextDeclCS> iterator = getAllContextOccurences(document).iterator(); iterator.hasNext();) {
			ContextDeclCS c = iterator.next();
			if (((org.eclipse.ocl.examples.pivot.Class)c.getPivot()).getName().equals(contextName)) {
				result.addAll(getInvariants(c));
			}
		}
		return result;
	}
	
	public String getLibraryName(ConstraintCS inv){
		
		if (inv.getSpecification()!=null) {
			if (!(inv.getSpecification() instanceof ExpSpecificationCS)) {
				return "TODO";
			}
			ECLRelation rel = getECLRelation(((ExpSpecificationCS)inv.getSpecification()).getOwnedExpression());
			
			if (rel!=null) {
				return ((Library)((RelationLibrary)rel.getType().eContainer()).eContainer()).getName();
			}
			return "TODO: complete EclServices.java, ConstraintCS.getLibraryName() for expression type " +((ExpSpecificationCS)inv.getSpecification()).getOwnedExpression().eClass().getName();

		}
		return "TODO";
	}
	
	public String getLibraryName(LetVariableCS var){
		return ((Library)((ExpressionLibrary)((ECLExpression)var.getInitExpression()).getType().eContainer()).eContainer()).getName();
	}
	
	public String getRelationName(LetVariableCS var){
		return ((ECLExpression)var.getInitExpression()).getType().getName().toString();
	}
	
	public String getClockNamesListedAndSepByDot(LetVariableCS var){
		return getClockNamesListedAndSepBySep(var, ". ");
	}
	
	public String getClockNamesListedAndSepBySpace(LetVariableCS var){
		return getClockNamesListedAndSepBySep(var, " ");
	}
	
	public String getClockNamesListedAndSepBySep(LetVariableCS var, String sep){
		StringBuilder sb = new StringBuilder(16);
		ECLExpression exp = (ECLExpression)var.getInitExpression();
		for (int i = 0; i < exp.getParameters().size(); i++) {
			ExpCS e = exp.getParameters().get(i);
			//e.
			if (e.getPivot().toString().contains("->collect")) {
				//[for (ne : NamedElement | element.allocatedAgents.oclAsType(Agent))] isExecuting[ne.name/] [/for]
				String str = e.toString().replace("self.", "element.");
				String type = str.substring(str.lastIndexOf("oclAsType("), str.length());
				sb.append("[for (ne : ").append(type.substring(10, type.indexOf(")"))).append(" | ").append(str.substring(0, str.lastIndexOf("."))).append(")]").append(str.substring(str.lastIndexOf(".")+1, str.length())).append("[ne.name/]").append(sep).append("[/for]");
			} else {
				if (e.toString().contains("self.")) {
					if (e.toString().replace("self.", "").contains(".")) {
						//complex navigation TODO
						String str = e.toString().replace("self.", "element.");//FIXME
						sb.append(str.substring(str.lastIndexOf(".")+1, str.length())).append("[").append(str.substring(0, str.lastIndexOf("."))).append(".name/]"); 
					}else {
						sb.append(e.toString().replace("self.", "")).append("[element.name/]"); //FIXME UGGLY
					}
				}else {
					//parameter of type integer constant 
				}
				if (i<exp.getParameters().size()-1) {
					if (exp.getParameters().get(i+1).toString().contains("self.")) {
						sb.append(sep);
					}
				}
			}
		}
		return sb.toString();
	}
	
	
	public String getConstantsOrLinkersListedAndSepByDot(LetVariableCS var){
		StringBuilder sb = new StringBuilder(16);
		ECLExpression exp = (ECLExpression)var.getInitExpression();
		for (int i = 0; i < exp.getParameters().size(); i++) {
			ExpCS e = exp.getParameters().get(i);
			if (e.toString().contains("self.")) {
				// clocks
			}else {
				//parameter of type integer constant 
				EObject eo = var.eContainer();
				do {
					eo = eo.eContainer();
				} while (!(eo instanceof ConstraintCS));
				ConstraintCS c = (ConstraintCS)eo;
				EList<LetExpCS> lst = new BasicEList<>();
				getLetRelation(((ExpSpecificationCS)c.getSpecification()).getOwnedExpression(), lst);
				for (LetExpCS letExpCS : lst) {
					for (LetVariableCS letVarCS : letExpCS.getVariable()) {
						if (letVarCS.getName().equals(e.toString())) {
							if (letVarCS.getInitExpression().toString().contains("self.")) {
								if (letVarCS.getInitExpression().toString().replace("self.", "").contains(".")) {
									//complex navigation TODO
									sb.append("["+letVarCS.getInitExpression().toString().replace("self.", "element.")+"/]"); //FIXME
									
								}else {
									sb.append("[element."+letVarCS.getInitExpression().toString().replace("self.", "")+"/]");
								}
							}else {
								sb.append(letVarCS.getInitExpression().toString());
							}
						}
					}
				}
				if (i<exp.getParameters().size()-1) {
					if (!exp.getParameters().get(i+1).toString().contains("self.")) {
						sb.append(". ");
					}
				}
			}
		}
		return sb.toString();
	}
	
	public String getClockNamesListedAndSepBySep(ConstraintCS inv, String sep){
		StringBuilder sb = new StringBuilder();
		if (inv.getSpecification()!=null) {
			if (!(inv.getSpecification() instanceof ExpSpecificationCS)) {
				return "TODO: complete EclServices.java, ConstraintCS.getClockNamesListedAndSepBySep()";
			}
			ECLRelation rel = getECLRelation(((ExpSpecificationCS)inv.getSpecification()).getOwnedExpression());
			
			if (rel!=null) {
				for (int i = 0; i < rel.getParameters().size(); i++) {
					ExpCS e = rel.getParameters().get(i);
					if (e.getPivot().toString().contains("->collect")) {
						String str = e.toString().replace("self.", "element.");
						String type = str.substring(str.lastIndexOf("oclAsType("), str.length());
						sb.append("[for (ne : ").append(type.substring(10, type.indexOf(")"))).append(" | ").append(str.substring(0, str.lastIndexOf("."))).append(")]").append(str.substring(str.lastIndexOf(".")+1, str.length())).append("[ne.name/] [/for]");
					}else {
						if (e.toString().contains("self.")) {
							if (e.toString().replace("self.", "").contains(".")) {
								//complex navigation TODO
								String str = e.toString().replace("self.", "element.");//FIXME
								sb.append(str.substring(str.lastIndexOf(".")+1, str.length())).append("[").append(str.substring(0, str.lastIndexOf("."))).append(".name/]"); 
							}else {
								sb.append(e.toString().replace("self.", "")).append("[element.name/]"); //FIXME UGGLY
							}
						}else {
							if (e.toString().startsWith("(")) { //clock in let
								String letID = e.toString().substring(e.toString().indexOf("(")+1, e.toString().lastIndexOf(")"));
								EList<LetExpCS> lst = new BasicEList<>();
								getLetRelation(((ExpSpecificationCS)inv.getSpecification()).getOwnedExpression(), lst);
								for (LetExpCS letExpCS : lst) {
									for (LetVariableCS letVariableCS : letExpCS.getVariable()) {
										if (letVariableCS.getName().equals(letID)) {
											String str = letVariableCS.getInitExpression().toString().replace("self", "element");//FIXME
											sb.append(e.toString().substring(e.toString().lastIndexOf(".")+1, e.toString().length())).append("[").append(str).append(".name/]");
										}
									}
								}
								
							}else {//only name, either parameter of type integer constant or internal clock
								EObject eo = e.eContainer();
								do {
									eo = eo.eContainer();
								} while (!(eo instanceof ConstraintCS));
								ConstraintCS c = (ConstraintCS)eo;
								EList<LetExpCS> lst = new BasicEList<>();
								getLetRelation(((ExpSpecificationCS)c.getSpecification()).getOwnedExpression(), lst);
								for (LetExpCS letExpCS : lst) {
									for (LetVariableCS letVarCS : letExpCS.getVariable()) {
										if (letVarCS.getName().equals(e.toString())) {
											if (letVarCS.getOwnedType() instanceof EventType) {
												if (e.toString().contains("self.")) {
													if (e.toString().replace("self.", "").contains(".")) {
														//complex navigation TODO
														String str = e.toString().replace("self.", "element.");//FIXME
														sb.append(str.substring(str.lastIndexOf(".")+1, str.length())).append("[").append(str.substring(0, str.lastIndexOf("."))).append(".name/]"); 
													}else {
														sb.append(e.toString().replace("self.", "")).append("[element.name/]"); //FIXME UGGLY
													}
												}else {
													if (sb.length()!=0) {
														sb.append(sep);
													}
													sb.append(e.toString()).append("[element.name/]");
												}
											}
										}
									}
								}
							}
						}
						if (i<rel.getParameters().size()-1) {
							if (rel.getParameters().get(i+1).toString().contains("self.") || rel.getParameters().get(i+1).toString().startsWith("(")) {
								sb.append(sep);
							}
						}
					}
				}
				return sb.toString();
			}
			return "TODO: complete EclServices.java, ConstraintCS.getClockNamesListedAndSepBySep()";
		}
		return "TODO: complete EclServices.java, ConstraintCS.getClockNamesListedAndSepBySep()";
	}
	
	public String getClockNamesListedAndSepBySpace(ConstraintCS inv){
		return getClockNamesListedAndSepBySep(inv, " ");
	}
	
	
	public String getClockNamesListedAndSepByDot(ConstraintCS inv){
		return getClockNamesListedAndSepBySep(inv, ". ");
	}
	
	public String getVariablesListedAndSepByDot(ConstraintCS inv){
		StringBuilder sb = new StringBuilder();
		if (inv.getSpecification()!=null) {
			if (!(inv.getSpecification() instanceof ExpSpecificationCS)) {
				return "TODO";
			}
			ECLRelation rel = getECLRelation(((ExpSpecificationCS)inv.getSpecification()).getOwnedExpression());
			if (rel==null) {
				return "TODO: complete EclServices.java, ConstraintCS.getVariablesListedAndSepByDot() for expression type " +((ExpSpecificationCS)inv.getSpecification()).getOwnedExpression().eClass().getName();
			}
			if (((RelationLibrary)rel.getType().eContainer()).getName().equalsIgnoreCase("kernelRelations")) {
				return "";
			}//FIXME do it for all ccsl lib
			
			RelationDefinition rd = getCorrespondingRelationDefinition(((RelationLibrary)rel.getType().eContainer()), rel.getType());
			if (rd==null) {
				return "TODO: complete EclServices.java, ConstraintCS.getVariablesListedAndSepByDot() for expression type " +((ExpSpecificationCS)inv.getSpecification()).getOwnedExpression().eClass().getName();
			}
			if (rd instanceof StateMachineRelationDefinition) {
				for (ConcreteEntity ce : ((StateMachineRelationDefinition)rd).getDeclarationBlock().getConcreteEntities()) {
					//FIXME do it for other concreteEntity specializations
					if (ce instanceof IntegerElement) {
						if (sb.length()!=0) {
							sb.append(". ");
						}
						sb.append(((IntegerElement)ce).getValue());
					}else {
						return "TODO: complete EclServices.java, ConstraintCS.getVariablesListedAndSepByDot() for expression type " +((ExpSpecificationCS)inv.getSpecification()).getOwnedExpression().eClass().getName();
					}
				}
			}
			return sb.toString();
		}
		return "TODO";
	}
	
	private RelationDefinition getCorrespondingRelationDefinition(RelationLibrary rl, RelationDeclaration rd){
		for (RelationDefinition rdef : rl.getRelationDefinitions()) {
			if (rdef.getDeclaration().equals(rd)) {
				return rdef;
			}
		}
		return null;
	}
	
	
	public String getConstantsOrLinkersListedAndSepByDot(ConstraintCS inv){
		StringBuilder sb = new StringBuilder(16);
		EList<LetExpCS> lst = new BasicEList<>();
		getLetRelation(((ExpSpecificationCS)inv.getSpecification()).getOwnedExpression(), lst);
		for (Iterator<LetExpCS> iterator = lst.iterator(); iterator.hasNext();) {
			LetExpCS expCS = iterator.next();
			EList<LetVariableCS> listVar = expCS.getVariable();
			boolean isIn = false;
			for (int i = 0; i < listVar.size(); i++) {
				LetVariableCS letVariableCS = listVar.get(i);
				if (letVariableCS.getOwnedType() instanceof  PrimitiveTypeRefCS) {
					if (((PrimitiveTypeRefCS)letVariableCS.getOwnedType()).getName().equalsIgnoreCase("Integer")) {
						isIn = false;
						ECLRelation rel = getECLRelation(((ExpSpecificationCS)inv.getSpecification()).getOwnedExpression());
						for (ExpCS e : rel.getParameters()) {
							if (e.toString().contains(expCS.getVariable().get(0).getName())) {
								isIn=true;
							};
						}
						if (isIn) {//if in relation
							if (letVariableCS.getInitExpression().toString().contains("self.")) {
								if (letVariableCS.getInitExpression().toString().replace("self.", "").contains(".")) {
									//complex navigation TODO
									sb.append("["+letVariableCS.getInitExpression().toString().replace("self.", "element.")+"/]"); //FIXME
									
								}else {
									sb.append("[element."+letVariableCS.getInitExpression().toString().replace("self.", "")+"/]");
								}
							}else {
								sb.append(letVariableCS.getInitExpression().toString());
							}
							if (i<listVar.size()-1) {
								sb.append(". ");
							}
						}
					}
				}
				
			}
			if (isIn &&iterator.hasNext()) {
				sb.append(". ");
			}
		}
		return sb.toString();
	}
	
	private ECLRelation getLetRelation(ExpCS exp, EList<LetExpCS> lst){
		if (exp instanceof ECLRelation) {
			return (ECLRelation) exp;
		}
		if (exp instanceof LetExpCS) {
			lst.add((LetExpCS)exp);
			return getLetRelation(((LetExpCS)exp).getIn(),lst);
		}
		if (exp instanceof InfixExpCS) {
			return getLetRelation(((InfixExpCS)exp).getOwnedExpression().get(1),lst);
		}
		return null;
	}
	
	public String getRelationName(ConstraintCS inv){
		if (inv.getSpecification()!=null) {
			if (!(inv.getSpecification() instanceof ExpSpecificationCS)) {
				return "TODO";
			}
			ECLRelation rel = getECLRelation(((ExpSpecificationCS)inv.getSpecification()).getOwnedExpression());
			
			if (rel!=null) {
				RelationDefinition rd = getCorrespondingRelationDefinition((RelationLibrary)rel.getType().eContainer(), rel.getType());
				return rd.getName();
			}
			return "TODO: complete EclServices.java, ConstraintCS.getRelationName() for expression type " +((ExpSpecificationCS)inv.getSpecification()).getOwnedExpression().eClass().getName();

		}
		return "TODO";
	}
	
	public String getRelationDeclName(ConstraintCS inv){
		if (inv.getSpecification()!=null) {
			if (!(inv.getSpecification() instanceof ExpSpecificationCS)) {
				return "TODO";
			}
			ECLRelation rel = getECLRelation(((ExpSpecificationCS)inv.getSpecification()).getOwnedExpression());
			
			if (rel!=null) {
				return rel.getType().getName();
			}
			return "TODO: complete EclServices.java, ConstraintCS.getRelationName() for expression type " +((ExpSpecificationCS)inv.getSpecification()).getOwnedExpression().eClass().getName();

		}
		return "TODO";
	}
	
	private ECLRelation getECLRelation(ExpCS exp){
		if (exp instanceof ECLRelation) {
			return (ECLRelation) exp;
		}
		if (exp instanceof LetExpCS) {
			return getECLRelation(((LetExpCS)exp).getIn());
		}
		if (exp instanceof InfixExpCS) {
			return getECLRelation(((InfixExpCS)exp).getOwnedExpression().get(1));
		}
		return null;
	}
	
	public String getNsURIToDeclare(ECLDocument document){
		StringBuilder sb = new StringBuilder(48);
		for (Iterator<PackageDeclarationCS> iterator = document.getPackages().iterator(); iterator.hasNext();) {
			PackageDeclarationCS p = iterator.next();
			sb.append("'").append(((Package)p.getPivot()).getNsURI()).append("'");
			if (iterator.hasNext()) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	public boolean hasInternalClocks(ECLDocument document){
		EList<ContextDeclCS> contextList = getAllContextOccurences(document);
		for (ContextDeclCS contextDeclCS : contextList) {
			EList<ConstraintCS> invList = getInvariants(contextDeclCS);
			for (ConstraintCS constraintCS : invList) {
				return hasInternalClocks(constraintCS);
			}
		}
		return false;
	}
	
	public boolean hasInternalClocks(ConstraintCS constraintCS){
		EList<LetExpCS> lst = new BasicEList<>();
		getLetRelation(((ExpSpecificationCS)constraintCS.getSpecification()).getOwnedExpression(), lst);
		for (LetExpCS letExpCS : lst) {
			for(LetVariableCS letVariableCS :letExpCS.getVariable()){
				if (letVariableCS.getOwnedType() instanceof EventType) {
					return true;
				}
			}
		}
		return false;
	}
	
	public EList<String> getInternalClocks(ConstraintCS constraintCS){
		EList<String> result = new BasicEList<String>();
		EList<LetExpCS> lst = new BasicEList<>();
		getLetRelation(((ExpSpecificationCS)constraintCS.getSpecification()).getOwnedExpression(), lst);
		for (LetExpCS letExpCS : lst) {
			for(LetVariableCS letVariableCS :letExpCS.getVariable()){
				if (letVariableCS.getOwnedType() instanceof EventType) {
					result.add(letVariableCS.getName());
				}
			}
		}
		return result;
	}
	
	public EList<LetVariableCS> getInternalClockExps(ConstraintCS constraintCS){
		EList<LetVariableCS> result = new BasicEList<LetVariableCS>();
		EList<LetExpCS> lst = new BasicEList<>();
		getLetRelation(((ExpSpecificationCS)constraintCS.getSpecification()).getOwnedExpression(), lst);
		for (LetExpCS letExpCS : lst) {
			for(LetVariableCS letVariableCS :letExpCS.getVariable()){
				if (letVariableCS.getOwnedType() instanceof EventType) {
					result.add(letVariableCS);
				}
			}
		}
		return result;
	}
	
	
	
	
	public EList<String> getInternalClocks(ECLDocument document){
		EList<String> result = new BasicEList<String>();
		EList<ContextDeclCS> contextList = getAllContextOccurences(document);
		for (ContextDeclCS contextDeclCS : contextList) {
			EList<ConstraintCS> invList = getInvariants(contextDeclCS);
			for (ConstraintCS constraintCS : invList) {
				result.addAll(getInternalClocks(constraintCS));
			}
		}
		return result;
	}
}
