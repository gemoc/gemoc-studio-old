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
package fr.obeo.dsl.debug.ide.sirius.ui.action;

import fr.obeo.dsl.debug.ide.sirius.ui.DebugSiriusIdeUiPlugin;
import fr.obeo.dsl.debug.ide.ui.launch.AbstractDSLLaunchConfigurationDelegateUI;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchDelegate;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction2;
import org.eclipse.ui.PlatformUI;

/**
 * Debug {@link org.eclipse.sirius.tools.api.ui.IExternalJavaAction IExternalJavaAction}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractDebugAsAction implements IExternalJavaAction2 {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.tools.api.ui.IExternalJavaAction#execute(java.util.Collection, java.util.Map)
	 */
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		final ILaunchConfigurationType launchConfigType = DebugPlugin.getDefault().getLaunchManager()
				.getLaunchConfigurationType(getLaunchConfigurationTypeID());
		Set<String> modes = new HashSet<String>();
		modes.add("debug");
		try {
			ILaunchDelegate[] delegates = launchConfigType.getDelegates(modes);
			if (delegates.length != 0
					&& delegates[0].getDelegate() instanceof AbstractDSLLaunchConfigurationDelegateUI) {
				AbstractDSLLaunchConfigurationDelegateUI delegate = (AbstractDSLLaunchConfigurationDelegateUI)delegates[0]
						.getDelegate();
				delegate.launch(delegate.getLaunchableResource(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage().getActiveEditor()),
						getFirstInstruction(selections), "debug");
			}
		} catch (CoreException e) {
			DebugSiriusIdeUiPlugin.getPlugin().getLog().log(
					new Status(IStatus.ERROR, DebugSiriusIdeUiPlugin.ID, e.getLocalizedMessage(), e));
		}
	}

	/**
	 * Gets the first {@link EObject instruction} from the given {@link java.util.List List} of
	 * {@link EObject}.
	 * 
	 * @param selections
	 *            the {@link java.util.List List} of {@link EObject}
	 * @return the first {@link EObject instruction} from the given {@link java.util.List List} of
	 *         {@link EObject} or <code>null</code> for interactive selection
	 */
	protected EObject getFirstInstruction(Collection<? extends EObject> selections) {
		final EObject res;

		if (selections.size() != 0) {
			res = selections.iterator().next();
		} else {
			res = null;
		}

		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.tools.api.ui.IExternalJavaAction#canExecute(java.util.Collection)
	 */
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.tools.api.ui.IExternalJavaAction2#mayDeleteElements()
	 */
	public boolean mayDeleteElements() {
		return false;
	}

	/**
	 * Gets the {@link org.eclipse.debug.core.ILaunchConfiguration ILaunchConfiguration}
	 * {@link org.eclipse.debug.core.ILaunchConfiguration#getType() type}.
	 * 
	 * @return the {@link org.eclipse.debug.core.ILaunchConfiguration ILaunchConfiguration}
	 *         {@link org.eclipse.debug.core.ILaunchConfiguration#getType() type}
	 */
	protected abstract String getLaunchConfigurationTypeID();

}
