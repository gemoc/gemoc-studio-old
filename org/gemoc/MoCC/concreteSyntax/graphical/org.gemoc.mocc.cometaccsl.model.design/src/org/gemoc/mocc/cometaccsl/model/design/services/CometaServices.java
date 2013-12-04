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
package org.gemoc.mocc.cometaccsl.model.design.services;

import java.util.Iterator;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Ack;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Receive;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Send;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Service;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCEvent;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBehavior;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition;


public class CometaServices {
	public CometaServices() {
		// TODO Auto-generated constructor stub
	}
	
	/*public String computeLabel(StructureContainer Element){
		return "test sc";
	}*/
	
	public String computeLabel(Send element){
		Send snd = (Send) element;
		StringBuilder sb = new StringBuilder(snd.getName());
		//return Element.eClass().getName();
		if (!snd.getEventParameters().isEmpty()) {
			sb.append("(");
			for (Iterator<Parameter> iterator = snd.getEventParameters().iterator(); iterator.hasNext();) {
				Parameter param = (Parameter) iterator.next();
				sb.append(param.getName()).append(":").append(param.getParameterType().getName());
				if (iterator.hasNext()) {
					sb.append(", ");
				}
			}
			sb.append(")");
		}
		return sb.toString();
	}
	
	public String computeLabel(Receive element){
		Receive rcv = (Receive) element;
		StringBuilder sb = new StringBuilder(rcv.getName());
		//return Element.eClass().getName();
		if (!rcv.getEventParameters().isEmpty()) {
			sb.append("(");
			for (Iterator<Parameter> iterator = rcv.getEventParameters().iterator(); iterator.hasNext();) {
				Parameter param = (Parameter) iterator.next();
				sb.append(param.getName()).append(":").append(param.getParameterType().getName());
				if (iterator.hasNext()) {
					sb.append(", ");
				}
			}
			sb.append(")");
		}
		return sb.toString();
	}
	
	public String computeLabel(Ack element){
		Ack ack = (Ack) element;
		StringBuilder sb = new StringBuilder(ack.getName());
		//return Element.eClass().getName();
		if (!ack.getEventParameters().isEmpty()) {
			sb.append("(");
			for (Iterator<Parameter> iterator = ack.getEventParameters().iterator(); iterator.hasNext();) {
				Parameter param = (Parameter) iterator.next();
				sb.append(param.getName()).append(":").append(param.getParameterType().getName());
				if (iterator.hasNext()) {
					sb.append(", ");
				}
			}
			sb.append(")");
		}
		return sb.toString();
	}
	
	public String computeLabel(MoCEvent element){
		StringBuilder sb = new StringBuilder(element.getName());
		//return Element.eClass().getName();
		if (!element.getEventParameters().isEmpty()) {
			sb.append("(");
			for (Iterator<Parameter> iterator = element.getEventParameters().iterator(); iterator.hasNext();) {
				Parameter param = (Parameter) iterator.next();
				sb.append(param.getName()).append(":").append(param.getParameterType().getName());
				if (iterator.hasNext()) {
					sb.append(", ");
				}
			}
			sb.append(")");
		}
		return sb.toString();
	}
	
	public String computeLabel(Queue element){
		StringBuilder sb = new StringBuilder("Queue - kind:");
		sb.append(element.getKind()).append(" - size:").append(element.getSize());
		
		if (!element.getRtInterfaces().isEmpty()) {
			sb.append("(");
			for (Iterator<RTInterface> iterator = element.getRtInterfaces().iterator(); iterator.hasNext();) {
				RTInterface interf = iterator.next();
				if (interf instanceof Service) {
					sb.append("RTIService:").append(interf.getName());
				}else {
					sb.append("RTIParam:").append(interf.getName());
				}
				if (iterator.hasNext()) {
					sb.append(", ");
				}
			}
			sb.append(")");
		}
		return sb.toString();
	}
	
	public String computeLabel(MoCDomain element){
		StringBuilder sb = new StringBuilder(element.getName());
		if (!element.getMocBehaviors().isEmpty()) {
			sb.append("(");
			for (Iterator<Behavior> iterator = element.getMocBehaviors().iterator(); iterator.hasNext();) {
				Behavior bhvr = iterator.next();
				if (bhvr instanceof OpaqueBehavior) {
					sb.append("Opaque:").append(bhvr.getName());
				}else {
					sb.append("FSM:").append(bhvr.getName());
				}
				if (iterator.hasNext()) {
					sb.append(", ");
				}
			}
			sb.append(")");
		}
		return sb.toString();
	}
	
	public String computeLabel(Transition element){
		StringBuilder sb = new StringBuilder(16);
		sb.append("[");
		
		element.getName();
		element.getTrigger();
		return sb.toString();
	}
	
	
	/*public String computeLabel(CometaElement Element){
		return "test CometaElement";
	}*/
	
	/*public String computeLabel(EObject Element){
		return Element.eClass().getName();
		if (Element instanceof MoCInterface) {
			return computeLabel((MoCInterface) Element);
		}
		return "test EOBject";
	}*/
}
