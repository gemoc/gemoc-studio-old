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

public class SDFExampleWizard
	extends AbstractExampleWizard {
	
	protected Collection<ProjectDescriptor> getProjectDescriptors() {		
		// We need the statements example to be unzipped along with the
		// EMF library example model, edit and editor examples
		List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(1);
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/fr.cnrs.luchogie.ultimateplotter.zip", "fr.cnrs.luchogie.ultimateplotter"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/fr.inria.aoste.hope.sdf.concrete.design.zip", "fr.inria.aoste.hope.sdf.concrete.design"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/fr.inria.aoste.hope.sdf.k3dsa.zip", "fr.inria.aoste.hope.sdf.k3dsa"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/fr.inria.aoste.hope.sdf.moc.application.zip", "fr.inria.aoste.hope.sdf.moc.application"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/fr.inria.aoste.hope.sdf.moc.lib.zip", "fr.inria.aoste.hope.sdf.moc.lib"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/fr.inria.aoste.hope.sdf.model.zip", "fr.inria.aoste.hope.sdf.model"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/fr.inria.aoste.hope.sdf.model.edit.zip", "fr.inria.aoste.hope.sdf.model.edit"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/fr.inria.aoste.hope.sdf.model.editor.zip", "fr.inria.aoste.hope.sdf.model.editor"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/fr.inria.aoste.hope.sdf.model.tests.zip", "fr.inria.aoste.hope.sdf.model.tests"));
		projects.add(new ProjectDescriptor(Activator.PLUGIN_ID, "zips/fr.inria.aoste.hope.sdf.xdsml.zip", "fr.inria.aoste.hope.sdf.xdsml"));
		return projects;
	}

	@Override
	protected AbstractUIPlugin getContainerPlugin() {
		
		return Activator.getDefault();
	}
}