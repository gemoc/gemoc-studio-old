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
package org.gemoc.mocc.transformations.mocml2clocksystem.services;

import java.util.HashMap;
import java.util.List;

import org.gemoc.mocc.fsmkernel.model.FSMModel.Trigger;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.NamedElement;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity;

public class Services {
	HashMap<String, Integer> map ;
	
	public String basicConstraints(Trigger out) {
		StringBuilder mytab = new StringBuilder();
		List<BindableEntity> l_in = out.getTrueTriggers();
		List<BindableEntity> l_out = out.getTrueTriggers();
		//TODO to complete for false triggers if necessary
		for(int i=0; i< l_in.size() -1; i++)
		{
			String cc = "" + l_in.get(i).toString() + "=" + l_in.get(i+1).toString()+ ".";
			mytab.append(cc);
		}
		return mytab.toString();
	}
	
	public String nameToNumID(NamedElement ne){
		if (map==null) {
			map = new HashMap<String, Integer>();
		}
		if (!map.containsKey(ne.getName())) {
			Integer i = new Integer(map.size());
			map.put(ne.getName(), i);
		}
		return map.get(ne.getName()).toString();
	}
	
}
