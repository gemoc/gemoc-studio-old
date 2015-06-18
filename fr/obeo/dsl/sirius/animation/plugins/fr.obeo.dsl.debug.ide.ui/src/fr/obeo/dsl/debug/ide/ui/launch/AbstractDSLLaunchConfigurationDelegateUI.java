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
package fr.obeo.dsl.debug.ide.ui.launch;

import fr.obeo.dsl.debug.ide.Activator;
import fr.obeo.dsl.debug.ide.launch.AbstractDSLLaunchConfigurationDelegate;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchGroup;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.debug.ui.ILaunchShortcut2;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.ResourceUtil;

/**
 * An UI implementation of {@link AbstractDSLLaunchConfigurationDelegate} with {@link ILaunchShortcut}
 * support.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractDSLLaunchConfigurationDelegateUI extends AbstractDSLLaunchConfigurationDelegate implements ILaunchShortcut, ILaunchShortcut2 {

	@Override
	protected void launch(EObject firstInstruction, ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				ExtendedImageRegistry.getInstance(); // initialize the image registry
			}
		});
		super.launch(firstInstruction, configuration, mode, launch, monitor);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchShortcut2#getLaunchConfigurations(org.eclipse.jface.viewers.ISelection)
	 */
	public ILaunchConfiguration[] getLaunchConfigurations(ISelection selection) {
		return getLaunchConfigurations(getLaunchableResource(selection));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchShortcut2#getLaunchConfigurations(org.eclipse.ui.IEditorPart)
	 */
	public ILaunchConfiguration[] getLaunchConfigurations(IEditorPart editorpart) {
		return getLaunchConfigurations(getLaunchableResource(editorpart));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchShortcut2#getLaunchableResource(org.eclipse.jface.viewers.ISelection)
	 */
	public IResource getLaunchableResource(ISelection selection) {
		IResource res = null;
		if (selection instanceof IStructuredSelection) {
			for (final Object element : ((IStructuredSelection)selection).toArray()) {
				if (element instanceof IFile) {
					res = (IResource)element;
					break;
				} else if (element instanceof EObject) {
					final URI resourceURI = ((EObject)element).eResource().getURI();
					if (resourceURI.isPlatformResource()) {
						final String pathString = resourceURI.toPlatformString(true);
						res = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(pathString));
						break;
					}
				}
			}
		}

		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchShortcut2#getLaunchableResource(org.eclipse.ui.IEditorPart)
	 */
	public IResource getLaunchableResource(IEditorPart editorpart) {
		return ResourceUtil.getFile(editorpart.getEditorInput());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchShortcut#launch(org.eclipse.jface.viewers.ISelection,
	 *      java.lang.String)
	 */
	public void launch(ISelection selection, String mode) {
		launch(getLaunchableResource(selection), getFirstInstruction(selection), mode);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchShortcut#launch(org.eclipse.ui.IEditorPart, java.lang.String)
	 */
	public void launch(IEditorPart editor, String mode) {
		launch(getLaunchableResource(editor), getFirstInstruction(editor), mode);
	}

	/**
	 * Get all {@link ILaunchConfiguration} that target the given {@link IResource}.
	 * 
	 * @param resource
	 *            root file to execute
	 * @return {@link ILaunchConfiguration}s using resource
	 */
	protected ILaunchConfiguration[] getLaunchConfigurations(IResource resource) {
		final List<ILaunchConfiguration> configurations = new ArrayList<ILaunchConfiguration>();

		final ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		final ILaunchConfigurationType type = manager
				.getLaunchConfigurationType(getLaunchConfigurationTypeID());

		// try to find existing configurations using the same file
		try {
			for (ILaunchConfiguration configuration : manager.getLaunchConfigurations(type)) {
				if (configuration.hasAttribute(AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI)) {
					final String pathString = configuration.getAttribute(
							AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI, "");
					try {
						IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(pathString));
						if (resource != null && resource.equals(file)) {
							configurations.add(configuration);
						}
					} catch (IllegalArgumentException e) {
						Activator.getDefault().error(e);
					}
				}
			}
		} catch (CoreException e) {
			// could not load configurations, ignore
			e.toString();
		}

		return configurations.toArray(new ILaunchConfiguration[configurations.size()]);
	}

	/**
	 * Launch a resource. Try to launch using a launch configuration. Used for contextual launches
	 * 
	 * @param file
	 *            source file
	 * @param firstInstruction
	 *            the first {@link EObject instruction}
	 * @param mode
	 *            launch mode
	 */
	public void launch(final IResource file, EObject firstInstruction, final String mode) {

		if (file instanceof IFile) {
			prepareLaunch(file, firstInstruction, mode);

			try {
				ILaunchConfiguration[] configurations = getLaunchConfigurations(file);
				if (configurations.length == 0) {
					// try to create a launch configuration
					configurations = createLaunchConfiguration(file, firstInstruction, mode);
				}

				// launch
				if (configurations.length == 1) {
					configurations[0].launch(mode, new NullProgressMonitor());
				} else {
					// more than one configuration applies
					// open launch dialog for selection
					final ILaunchGroup group = DebugUITools.getLaunchGroup(configurations[0], mode);
					DebugUITools.openLaunchConfigurationDialogOnGroup(PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell(),
							new StructuredSelection(configurations[0]), group.getIdentifier(), null);
				}

			} catch (CoreException e) {
				// could not create launch configuration, run file directly
				// try {
				// launch(firstInstruction, null, mode, null, new NullProgressMonitor());
				// } catch (CoreException e1) {
				Activator.getDefault().error(e);
				// }
			}
		}
	}

	/**
	 * Prepares the launch of the given {@link IResource}.
	 * 
	 * @param file
	 *            source file
	 * @param firstInstruction
	 *            the first {@link EObject instruction}
	 * @param mode
	 *            launch mode
	 */
	protected void prepareLaunch(final IResource file, EObject firstInstruction, final String mode) {
		// try to save dirty editors
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().saveAllEditors(true);
	}

	/**
	 * Creates a {@link ILaunchConfiguration}. If the <code>firstInstruction</code> is <code>null</code> the
	 * launch configuration dialog is opened.
	 * 
	 * @param file
	 *            the selected model {@link IFile}
	 * @param firstInstruction
	 *            the first {@link EObject instruction} or <code>null</code> for interactive selection
	 * @param mode
	 *            the {@link ILaunchConfiguration#getModes() mode}
	 * @return an array of possible {@link ILaunchConfiguration}, can be empty but not <code>null</code>
	 * @throws CoreException
	 *             if {@link ILaunchConfiguration} initialization fails of models can't be loaded
	 */
	protected ILaunchConfiguration[] createLaunchConfiguration(final IResource file,
			EObject firstInstruction, final String mode) throws CoreException {
		final ILaunchConfiguration[] res;

		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = manager.getLaunchConfigurationType(getLaunchConfigurationTypeID());

		ILaunchConfigurationWorkingCopy configuration = type.newInstance(null, file.getName());
		configuration.setMappedResources(new IResource[] {file, });
		configuration.setAttribute(AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI, file.getFullPath()
				.toString());
		if (firstInstruction == null) {
			// open configuration for further editing
			final ILaunchGroup group = DebugUITools.getLaunchGroup(configuration, mode);
			if (group != null) {
				configuration.doSave();
				DebugUITools.openLaunchConfigurationDialog(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(), configuration, group.getIdentifier(), null);
			}
			res = new ILaunchConfiguration[] {};
		} else {
			configuration.setAttribute(AbstractDSLLaunchConfigurationDelegate.FIRST_INSTRUCTION_URI,
					EcoreUtil.getURI(firstInstruction).toString());
			// save and return new configuration
			configuration.doSave();
			res = new ILaunchConfiguration[] {configuration, };
		}
		return res;
	}

	/**
	 * Gets the {@link ILaunchConfiguration} {@link ILaunchConfiguration#getType() type}.
	 * 
	 * @return the {@link ILaunchConfiguration} {@link ILaunchConfiguration#getType() type}
	 */
	protected abstract String getLaunchConfigurationTypeID();

	/**
	 * Gets the first {@link EObject instruction} from the given {@link ISelection}.
	 * 
	 * @param selection
	 *            the {@link ISelection}
	 * @return the first {@link EObject instruction} from the given {@link ISelection} or <code>null</code>
	 *         for interactive selection
	 */
	protected abstract EObject getFirstInstruction(ISelection selection);

	/**
	 * Gets the first {@link EObject instruction} from the given {@link IEditorPart}.
	 * 
	 * @param editor
	 *            the {@link IEditorPart}
	 * @return the first {@link EObject instruction} from the given {@link IEditorPart} or <code>null</code>
	 *         for interactive selection
	 */
	protected abstract EObject getFirstInstruction(IEditorPart editor);

}
