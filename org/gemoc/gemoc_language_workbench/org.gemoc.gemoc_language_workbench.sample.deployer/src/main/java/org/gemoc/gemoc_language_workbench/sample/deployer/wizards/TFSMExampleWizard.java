/* $Id: KermetaExampleWizard.java,v 1.2 2008-10-30 16:45:57 dvojtise Exp $
 * Project    : fr.irisa.triskell.kermeta
 * File       : KermetaExampleWizard.java
 * License    : EPL
 * Copyright  : IRISA / INRIA / Universite de Rennes 1
 * -------------------------------------------------------------------
 * Authors : 
 *        	dvojtise <dvojtise@irisa.fr>
 */
package org.gemoc.gemoc_language_workbench.sample.deployer.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.gemoc.gemoc_language_workbench.sample.deployer.Activator;

public class TFSMExampleWizard
	extends AbstractExampleWizard {
	
	protected Collection<ProjectDescriptor> getProjectDescriptors() {		
		// We need the statements example to be unzipped along with the
		// EMF library example model, edit and editor examples
		List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(1);
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.design.zip", "org.gemoc.sample.tfsm.design"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.eclmoc2as.zip", "org.gemoc.sample.tfsm.eclmoc2as"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.k3dsa.zip", "org.gemoc.sample.tfsm.k3dsa"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.moc.lib.zip", "org.gemoc.sample.tfsm.moc.lib"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.model.zip", "org.gemoc.sample.tfsm.model"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.model.edit.zip", "org.gemoc.sample.tfsm.model.edit"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.model.editor.zip", "org.gemoc.sample.tfsm.model.editor"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.xdsml.zip", "org.gemoc.sample.tfsm.xdsml"));
		return projects;
	}

	@Override
	protected AbstractUIPlugin getContainerPlugin() {
		
		return Activator.getDefault();
	}
}