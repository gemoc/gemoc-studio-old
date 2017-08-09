/*******************************************************************************
 * Copyright (c) 2015, 2017  Inria  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.gemoc.tfsmandactivity.sampledeployer.deployer.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.gemoc.commons.eclipse.ui.wizards.AbstractExampleWizard;
import org.eclipse.gemoc.tfsmandactivity.sampledeployer.deployer.Activator;


public class TFSMAndActivityModelExampleWizard
	extends AbstractExampleWizard {
	
	protected Collection<ProjectDescriptor> getProjectDescriptors() {		
		// We need the statements example to be unzipped along with the
		// EMF library example model, edit and editor examples
		List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(1);
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.modelexecution.operationalsemantics.ad.samplemodels.zip", "org.modelexecution.operationalsemantics.ad.samplemodels"));
		//projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.sigpml.simple_example_with_melange.zip", "org.gemoc.sample.sigpml.simple_example_with_melange"));
		return projects;
	}

	@Override
	protected AbstractUIPlugin getContainerPlugin() {
		
		return Activator.getDefault();
	}

	@Override
	public void error(String message, Throwable e) {
		Activator.getDefault().error(message, e);
	}

	@Override
	public ActionIfProjectExist getActionIfProjectExist(IProject project) {		
		return ActionIfProjectExist.ASKUSER;
	}
}