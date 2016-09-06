/* $Id: KermetaExampleWizard.java,v 1.2 2008-10-30 16:45:57 dvojtise Exp $
 * Project    : fr.irisa.triskell.kermeta
 * File       : KermetaExampleWizard.java
 * License    : EPL
 * Copyright  : IRISA / INRIA / Universite de Rennes 1
 * -------------------------------------------------------------------
 * Authors : 
 *        	dvojtise <dvojtise@irisa.fr>
 */
package org.gemoc.gemoc_modeling_workbench.sample.deployer.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.gemoc.gemoc_modeling_workbench.sample.deployer.Activator;

public class TFSMExampleWizard
	extends AbstractExampleWizard {
	
	protected Collection<ProjectDescriptor> getProjectDescriptors() {		
		// We need the statements example to be unzipped along with the
		// EMF library example model, edit and editor examples
		List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(1);
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.simple_example.zip", "org.gemoc.sample.tfsm.simple_example"));
		//projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.daynight_single_traffic_light_sample.zip", "org.gemoc.sample.tfsm.daynight_single_traffic_light_sample"));
		//projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/org.gemoc.sample.tfsm.daynight_traffic_light_with_groovygui_sample.zip", "org.gemoc.sample.tfsm.daynight_traffic_light_with_groovygui_sample"));
		return projects;
	}

	@Override
	protected AbstractUIPlugin getContainerPlugin() {
		
		return Activator.getDefault();
	}
}