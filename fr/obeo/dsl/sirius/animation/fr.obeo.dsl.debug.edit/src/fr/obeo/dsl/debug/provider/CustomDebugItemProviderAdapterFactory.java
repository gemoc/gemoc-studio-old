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
package fr.obeo.dsl.debug.provider;

import org.eclipse.emf.common.notify.Adapter;

/**
 * Custom implementation of {@link DebugItemProviderAdapterFactory}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CustomDebugItemProviderAdapterFactory extends DebugItemProviderAdapterFactory {

	@Override
	public Adapter createDebugTargetAdapter() {
		if (debugTargetItemProvider == null) {
			debugTargetItemProvider = new CustomDebugTargetItemProvider(this);
		}

		return debugTargetItemProvider;
	}

	@Override
	public Adapter createStackFrameAdapter() {
		if (stackFrameItemProvider == null) {
			stackFrameItemProvider = new CustomStackFrameItemProvider(this);
		}

		return stackFrameItemProvider;
	}

	@Override
	public Adapter createThreadAdapter() {
		if (threadItemProvider == null) {
			threadItemProvider = new CustomThreadItemProvider(this);
		}

		return threadItemProvider;
	}

}
