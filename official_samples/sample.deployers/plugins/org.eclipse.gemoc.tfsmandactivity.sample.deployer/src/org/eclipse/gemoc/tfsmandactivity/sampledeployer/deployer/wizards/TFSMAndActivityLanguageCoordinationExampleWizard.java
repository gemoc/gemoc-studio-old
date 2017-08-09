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


public class TFSMAndActivityLanguageCoordinationExampleWizard
	extends AbstractExampleWizard {
	
	protected Collection<ProjectDescriptor> getProjectDescriptors() {		
		// We need the statements example to be unzipped along with the
		// EMF library example model, edit and editor examples
		List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(1);
		
		// commons projects
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.modelexecution.operationalsemantics.ad.design.zip", "org.modelexecution.operationalsemantics.ad.design"));
		
		// concurrent projects
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.modelexecution.operationalsemantics.ad_concurrent.zip", "org.modelexecution.operationalsemantics.ad"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.modelexecution.operationalsemantics.ad.concurrent.ecl.zip", "org.modelexecution.operationalsemantics.ad.concurrent.ecl"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.modelexecution.operationalsemantics.ad.concurrent.k3.dynamic.zip", "org.modelexecution.operationalsemantics.ad.concurrent.k3.dynamic"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.modelexecution.operationalsemantics.ad.concurrent.xdsml.zip", "org.modelexecution.operationalsemantics.ad.concurrent.xdsml"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.modelexecution.operationalsemantics.ad_concurrent.grammar.zip", "org.modelexecution.operationalsemantics.ad.grammar"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.modelexecution.operationalsemantics.ad_concurrent.grammar.ui.zip", "org.modelexecution.operationalsemantics.ad.grammar.ui"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.modelexecution.operationalsemantics.ad_concurrent.input.grammar.zip", "org.modelexecution.operationalsemantics.ad.input.grammar"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.modelexecution.operationalsemantics.ad_concurrent.input.grammar.ui.zip", "org.modelexecution.operationalsemantics.ad.input.grammar.ui"));
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