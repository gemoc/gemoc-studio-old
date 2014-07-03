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
package fr.obeo.dsl.process.tests;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.IProcessRunner;
import fr.obeo.dsl.process.Process;
import fr.obeo.dsl.process.ProcessContext;

import java.util.List;

/**
 * {@link IProcessRunner} for test purpose.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class TestProcessRunner implements IProcessRunner {

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#getProcess()
	 */
	public Process getProcess() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#getContexts()
	 */
	public List<ProcessContext> getContexts() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#startNewContext()
	 */
	public ProcessContext startNewContext() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#doAction(fr.obeo.dsl.process.ProcessContext,
	 *      fr.obeo.dsl.process.ActionTask)
	 */
	public void doAction(ProcessContext context, ActionTask task) {
		// nothing to do here
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#undoAction(fr.obeo.dsl.process.ProcessContext,
	 *      fr.obeo.dsl.process.ActionTask)
	 */
	public void undoAction(ProcessContext context, ActionTask task) {
		// nothing to do here
	}

}
