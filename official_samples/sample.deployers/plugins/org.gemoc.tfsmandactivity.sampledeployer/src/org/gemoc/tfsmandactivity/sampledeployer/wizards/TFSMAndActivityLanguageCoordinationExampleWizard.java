/* $Id: KermetaExampleWizard.java,v 1.2 2008-10-30 16:45:57 dvojtise Exp $
 * Project    : fr.irisa.triskell.kermeta
 * File       : KermetaExampleWizard.java
 * License    : EPL
 * Copyright  : IRISA / INRIA / Universite de Rennes 1
 * -------------------------------------------------------------------
 * Authors : 
 *        	dvojtise <dvojtise@irisa.fr>
 */
package org.gemoc.tfsmandactivity.sampledeployer.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.gemoc.tfsmandactivity.sampledeployer.Activator;

import fr.inria.diverse.commons.eclipse.jface.wizards.AbstractExampleWizard;

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