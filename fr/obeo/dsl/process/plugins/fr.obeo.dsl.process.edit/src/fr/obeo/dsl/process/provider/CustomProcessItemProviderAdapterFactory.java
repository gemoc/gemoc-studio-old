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
package fr.obeo.dsl.process.provider;

import org.eclipse.emf.common.notify.Adapter;

/**
 * Custom implementation of the {@link ProcessItemProviderAdapterFactory}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CustomProcessItemProviderAdapterFactory extends ProcessItemProviderAdapterFactory {

	@Override
	public Adapter createActionTaskAdapter() {
		if (actionTaskItemProvider == null) {
			actionTaskItemProvider = new CustomActionTaskItemProvider(this);
		}

		return actionTaskItemProvider;
	}

	@Override
	public Adapter createAllDoneAdapter() {
		if (allDoneItemProvider == null) {
			allDoneItemProvider = new CustomAllDoneItemProvider(this);
		}

		return allDoneItemProvider;
	}

	@Override
	public Adapter createAnyDoneAdapter() {
		if (anyDoneItemProvider == null) {
			anyDoneItemProvider = new CustomAnyDoneItemProvider(this);
		}

		return anyDoneItemProvider;
	}

	@Override
	public Adapter createComposedTaskAdapter() {
		if (composedTaskItemProvider == null) {
			composedTaskItemProvider = new CustomComposedTaskItemProvider(this);
		}

		return composedTaskItemProvider;
	}

	@Override
	public Adapter createOneDoneAdapter() {
		if (oneDoneItemProvider == null) {
			oneDoneItemProvider = new CustomOneDoneItemProvider(this);
		}

		return oneDoneItemProvider;
	}
}
