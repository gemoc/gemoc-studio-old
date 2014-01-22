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
package fr.obeo.dsl.debug.ide.sirius.ui.launch;

import fr.obeo.dsl.debug.ide.adapter.IDSLCurrentInstructionListener;
import fr.obeo.dsl.debug.ide.sirius.ui.services.AbstractDSLDebuggerServices;
import fr.obeo.dsl.debug.ide.ui.launch.DSLLaunchConfigurationTab;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.ui.PlatformUI;

/**
 * A Sirius implementation of {@link fr.obeo.dsl.debug.ide.launch.AbstractDSLLaunchConfigurationDelegate
 * AbstractDSLLaunchConfigurationDelegate} with {@link org.eclipse.debug.ui.ILaunchShortcut ILaunchShortcut}
 * support.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractDSLLaunchConfigurationDelegateUI extends fr.obeo.dsl.debug.ide.ui.launch.AbstractDSLLaunchConfigurationDelegateUI {

	/**
	 * The Sirius {@link org.eclipse.emf.ecore.resource.Resource Resource}
	 * {@link org.eclipse.emf.ecore.resource.Resource#getURI() URI}.
	 */
	public static final String SIRIUS_RESOURCE_URI = SiriusUtil.SESSION_RESOURCE_EXTENSION + RESOURCE_URI;

	@Override
	protected ILaunchConfiguration[] createLaunchConfiguration(IResource file, EObject firstInstruction,
			String mode) throws CoreException {
		final ILaunchConfiguration[] res;
		if (SiriusUtil.SESSION_RESOURCE_EXTENSION.equals(file.getFileExtension())) {
			final IResource semanticFile;
			if (firstInstruction != null) {
				semanticFile = getLaunchableResource(new StructuredSelection(firstInstruction));
				res = super.createLaunchConfiguration(semanticFile, firstInstruction, mode);
			} else {
				final Session session = SessionManager.INSTANCE.getSession(URI.createPlatformResourceURI(file
						.getFullPath().toString(), true), new NullProgressMonitor());
				session.getSemanticResources();
				// prompt the selection of an instruction from the Session EResources
				EObject selectedInstruction = DSLLaunchConfigurationTab.openFirstInstructionSelection(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), session
								.getTransactionalEditingDomain().getResourceSet());
				if (selectedInstruction != null) {
					semanticFile = getLaunchableResource(new StructuredSelection(selectedInstruction));
					res = super.createLaunchConfiguration(semanticFile, selectedInstruction, mode);
				} else {
					// TODO we have to few information to create the launch configuration prompt the user for
					// aird + first instruction ?
					semanticFile = null;
					res = super.createLaunchConfiguration(file, firstInstruction, mode);
				}
			}
			for (ILaunchConfiguration config : res) {
				if (config instanceof ILaunchConfigurationWorkingCopy) {
					((ILaunchConfigurationWorkingCopy)config).setAttribute(SIRIUS_RESOURCE_URI, file
							.getFullPath().toString());
					if (semanticFile != null) {
						IResource[] resources = config.getMappedResources();
						resources = Arrays.copyOf(resources, resources.length + 1);
						resources[resources.length - 1] = file;
						((ILaunchConfigurationWorkingCopy)config).setMappedResources(resources);
					}
					((ILaunchConfigurationWorkingCopy)config).doSave();
				}
			}
		} else {
			// TODO? assume the file is the first instruction resource
			res = super.createLaunchConfiguration(file, firstInstruction, mode);
		}
		return res;
	}

	@Override
	protected List<IDSLCurrentInstructionListener> getCurrentInstructionListeners() {
		final List<IDSLCurrentInstructionListener> res = super.getCurrentInstructionListeners();
		res.add(AbstractDSLDebuggerServices.LISTENER);
		return res;
	}

	@Override
	protected void launch(EObject firstInstruction, ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		final URI sessionResourceURI = URI.createPlatformResourceURI(configuration.getAttribute(
				SIRIUS_RESOURCE_URI, ""), true);
		// activate the session
		SessionManager.INSTANCE.getSession(sessionResourceURI, monitor).open(new NullProgressMonitor());
		super.launch(firstInstruction, configuration, mode, launch, monitor);
	}
}
