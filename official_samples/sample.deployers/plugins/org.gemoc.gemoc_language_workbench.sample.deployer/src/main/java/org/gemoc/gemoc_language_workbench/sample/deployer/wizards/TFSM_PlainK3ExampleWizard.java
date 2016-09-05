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

public class TFSM_PlainK3ExampleWizard
	extends AbstractExampleWizard {
	
	protected Collection<ProjectDescriptor> getProjectDescriptors() {		
		// We need the statements example to be unzipped along with the
		// EMF library example model, edit and editor examples
		List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(1);
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.plaink3.design.zip", "org.gemoc.sample.tfsm.plaink3.design"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.plaink3.dsa.zip", "org.gemoc.sample.tfsm.plaink3.dsa"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.plaink3.model.zip", "org.gemoc.sample.tfsm.plaink3.model"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.plaink3.xdsml.zip", "org.gemoc.sample.tfsm.plaink3.xdsml"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.zip", "org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.edit.zip", "org.gemoc.sample.tfsm.plaink3.xdsml.xfsm.edit"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.editor.zip", "org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.editor"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.plaink3.xtfsm.trace.zip", "org.gemoc.sample.tfsm.plaink3.xtfsm.trace"));
		return projects;
	}

	@Override
	protected AbstractUIPlugin getContainerPlugin() {
		
		return Activator.getDefault();
	}
}