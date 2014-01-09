/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved. This software and the attached documentation are the
 * exclusive ownership of its authors and was conceded to the profit of Obeo SARL. This software and the
 * attached documentation are protected under the rights of intellectual ownership, including the section
 * "Titre II  Droits des auteurs (Articles L121-1 L123-12)" By installing this software, you acknowledge being
 * aware of this rights and accept them, and as a consequence you must: - be in possession of a valid license
 * of use conceded by Obeo only. - agree that you have read, understood, and will comply with the license
 * terms and conditions. - agree not to do anything that could conflict with intellectual ownership owned by
 * Obeo or its beneficiaries or the authors of this software Should you not agree with these terms, you must
 * stop to use this software and give it back to its legitimate owner.
 *******************************************************************************/
package fr.obeo.dsl.debug.ide.launch;

import fr.obeo.dsl.debug.DebugTarget;
import fr.obeo.dsl.debug.DebugTargetUtils;
import fr.obeo.dsl.debug.ide.Activator;
import fr.obeo.dsl.debug.ide.DSLEclipseDebugIntegration;
import fr.obeo.dsl.debug.ide.IDSLDebugger;
import fr.obeo.dsl.debug.ide.ModelUpdater;
import fr.obeo.dsl.debug.ide.adapter.DSLDebugTargetAdapter;
import fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * An abstract implementation of {@link ILaunchConfigurationDelegate} for DSL debugger.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractDSLLaunchConfigurationDelegate implements ILaunchConfigurationDelegate {

	/**
	 * The {@link org.eclipse.emf.ecore.resource.Resource Resource}
	 * {@link org.eclipse.emf.ecore.resource.Resource#getURI() URI}.
	 */
	public static final String RESOURCE_URI = "Resource";

	/**
	 * The {@link EObject} {@link org.eclipse.emf.ecore.util.EcoreUtil#getURI(EObject) URI}.
	 */
	public static final String FIRST_INSTRUCTION_URI = "First Instruction";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch,
			IProgressMonitor monitor) throws CoreException {
		launch(getFirstInstruction(configuration), configuration, mode, launch, monitor);
	}

	/**
	 * Launches the execution for the given first {@link EObject instruction}.
	 * 
	 * @param firstInstruction
	 *            the first {@link EObject instruction}
	 * @param configuration
	 *            the {@link ILaunchConfiguration}
	 * @param mode
	 *            the launch mode
	 * @param launch
	 *            the {@link ILaunchConfiguration}
	 * @param monitor
	 *            the {@link IProgressMonitor}
	 * @throws CoreException
	 *             if execution fails
	 */
	protected void launch(EObject firstInstruction, ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		if (ILaunchManager.DEBUG_MODE.equals(mode)) {
			DebugTarget eDebugTarget = DebugTargetUtils.createDebugTarget(getDebugTargetName(configuration,
					firstInstruction), firstInstruction);

			DSLDebugEventDispatcher dispatcher = new DSLDebugEventDispatcher();
			// Connect the model to the dispatcher
			DSLEclipseDebugIntegration integration = new DSLEclipseDebugIntegration(launch, eDebugTarget,
					new ModelUpdater(), dispatcher);
			final DSLDebugTargetAdapter debugTarget = integration.getDebugTarget(eDebugTarget);
			dispatcher.setModel(debugTarget);

			// Connect the debugger to the dispatcher
			IDSLDebugger debugger = getDebugger(configuration, dispatcher, firstInstruction, monitor);
			dispatcher.setDebugger(debugger);

			launch.addDebugTarget(debugTarget);

			Job job = new Job(getDebugJobName(configuration, firstInstruction)) {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					debugTarget.start();
					return new Status(IStatus.OK, getPluginID(), "Execution was successfull");
				}
			};
			job.schedule();
		}
	}

	/**
	 * Gets the first {@link EObject instruction}.
	 * 
	 * @param configuration
	 *            the {@link ILaunchConfiguration}
	 * @return the first {@link EObject instruction}
	 */
	protected EObject getFirstInstruction(ILaunchConfiguration configuration) {
		EObject res = null;
		final ResourceSet rs = getResourceSet();

		try {
			rs.getResource(URI.createPlatformResourceURI(configuration.getAttribute(RESOURCE_URI, ""), true),
					true);
			res = rs.getEObject(URI.createURI(configuration.getAttribute(FIRST_INSTRUCTION_URI, ""), true),
					true);
		} catch (CoreException e) {
			Activator.getDefault().error(e);
		}

		return res;
	}

	/**
	 * Gets the {@link ResourceSet} for {@link org.eclipse.emf.ecore.resource.Resource Resource} loading.
	 * 
	 * @return the {@link ResourceSet} for {@link org.eclipse.emf.ecore.resource.Resource Resource} loading
	 */
	protected ResourceSet getResourceSet() {
		return new ResourceSetImpl();
	}

	/**
	 * Gets the {@link IDSLDebugger} to be {@link IDSLDebugger#start() started}.
	 * 
	 * @param configuration
	 *            the {@link ILaunchConfiguration}
	 * @param dispatcher
	 *            the {@link DSLDebugEventDispatcher} to communicates with the {@link DebugTarget}
	 * @param firstInstruction
	 *            the first {@link EObject instruction}
	 * @param monitor
	 *            hte {@link IProgressMonitor}
	 * @return the {@link IDSLDebugger} to be {@link IDSLDebugger#start() started}
	 */
	protected abstract IDSLDebugger getDebugger(ILaunchConfiguration configuration,
			DSLDebugEventDispatcher dispatcher, EObject firstInstruction, IProgressMonitor monitor);

	/**
	 * Gets the {@link DebugTarget}'s {@link DebugTarget#getName() name}.
	 * 
	 * @param configuration
	 *            the {@link ILaunchConfiguration}
	 * @param firstInstruction
	 *            the first {@link EObject instruction}
	 * @return the {@link DebugTarget}'s {@link DebugTarget#getName() name}
	 */
	protected abstract String getDebugTargetName(ILaunchConfiguration configuration, EObject firstInstruction);

	/**
	 * Gets the debug {@link Job}'s {@link DebugTarget#getName() name}.
	 * 
	 * @param configuration
	 *            the {@link ILaunchConfiguration}
	 * @param firstInstruction
	 *            the first {@link EObject instruction}
	 * @return the debug {@link Job}'s {@link DebugTarget#getName() name}
	 */
	protected abstract String getDebugJobName(ILaunchConfiguration configuration, EObject firstInstruction);

	/**
	 * Gets the current plug-in ID.
	 * 
	 * @return the current plug-in ID
	 */
	protected abstract String getPluginID();

}
