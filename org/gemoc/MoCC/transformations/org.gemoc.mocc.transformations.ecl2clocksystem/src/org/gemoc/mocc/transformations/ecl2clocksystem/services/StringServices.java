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

import org.eclipse.emf.ecore.EObject;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Trigger;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity;

/**
 * @author Stfun
 *
 */
public class StringServices {
	
	
	/**
	 * Useless eObject caller
	 * @param eo
	 * @return acceleo generation left square bracket
	 */
	public String lSquareBracket(EObject eo){
		return "['['/]";
	}
	
	/**
	 * Useless eObject caller
	 * @param eo
	 * @return acceleo generation right square bracket
	 */
	public String rSquareBracket(EObject eo){
		return "[']'/]";
	}
	
	public String printTriggers(Trigger t){
		StringBuilder sb = new StringBuilder(16);
		
		if ((t.getTrueTriggers()!=null) &&(!t.getTrueTriggers().isEmpty())) {
			for (Iterator<BindableEntity> iterator = t.getTrueTriggers().iterator(); iterator.hasNext();) {
				BindableEntity be = iterator.next();
				sb.append(be.getName());
				if (iterator.hasNext()) {
					sb.append(". ");
				}
			}
			return sb.toString();
		}
		
		if ((t.getFalseTriggers()!=null) &&(!t.getFalseTriggers().isEmpty())) {
			for (Iterator<BindableEntity> iterator = t.getFalseTriggers().iterator(); iterator.hasNext();) {
				BindableEntity be = iterator.next();
				sb.append(be.getName());
				if (iterator.hasNext()) {
					sb.append(". ");
				}
			}
			return sb.toString();
		}
		
		return "";
	}
}
