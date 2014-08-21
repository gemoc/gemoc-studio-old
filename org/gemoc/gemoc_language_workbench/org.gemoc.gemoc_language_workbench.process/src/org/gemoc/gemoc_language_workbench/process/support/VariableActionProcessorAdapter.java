/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package org.gemoc.gemoc_language_workbench.process.support;

import fr.obeo.dsl.process.ContextVariable;
import fr.obeo.dsl.process.ProcessContext;

import org.gemoc.gemoc_language_workbench.process.IActionProcessor;
import org.gemoc.gemoc_language_workbench.process.IVariableActionProcessor;

public class VariableActionProcessorAdapter implements IVariableActionProcessor
{
	
	private IVariableActionProcessor _realActionProcessor;

	public VariableActionProcessorAdapter(IActionProcessor actionProcessor) {
		if (actionProcessor instanceof IVariableActionProcessor)
		{
			_realActionProcessor = (IVariableActionProcessor)actionProcessor;
		}
	}

	@Override
	public boolean acceptChangeVariableChanged(ProcessContext context, ContextVariable variable) 
	{
		boolean result = false;
		if (_realActionProcessor != null)
			result = _realActionProcessor.acceptChangeVariableChanged(context, variable);
		return result;	
	}

	public IActionProcessor getAdaptedProcessor() {
		return (IActionProcessor)_realActionProcessor;
	}

}
