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
package org.gemoc.gemoc_language_workbench.process.specific;

import fr.obeo.dsl.process.ActionTask;

import org.gemoc.gemoc_language_workbench.process.PrecedingActionProcessorCaller;
import org.gemoc.gemoc_language_workbench.process.ResourceActionProcessorCaller;

public abstract class AbstractActionProcessor2 extends AbstractActionProcessor<GemocLanguageProcessContext>
{

	public AbstractActionProcessor2(ActionTask task, boolean acceptChangeOnPrecedingInternalChange) 
	{
		super(task);
		addCaller(new ResourceActionProcessorCaller<GemocLanguageProcessContext>());
		addCaller(new PrecedingActionProcessorCaller<GemocLanguageProcessContext>());
	}

}
