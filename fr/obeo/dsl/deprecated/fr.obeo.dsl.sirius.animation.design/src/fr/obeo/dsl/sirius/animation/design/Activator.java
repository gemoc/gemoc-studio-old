/**
 * 
 * Copyright  2013 Obeo. All Rights Reserved.
 * 
 *  This file is part of Obeo Designer.
 * This software and the attached documentation are the exclusive ownership of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1, L123-12)"
 * By installing this software, you acknowledge being aware of this rights and accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 * 
 * Obeo is a  trademark owned by Obeo.
 * 
 */
package fr.obeo.dsl.sirius.animation.design;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import fr.obeo.dsl.viewpoint.business.api.componentization.ViewpointRegistry;
import fr.obeo.dsl.viewpoint.description.Viewpoint;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
    // The plug-in ID
    public static final String PLUGIN_ID = "fr.obeo.dsl.sirius.animation.design";

    // The shared instance
    private static Activator plugin;

    private static Set<Viewpoint> viewpoints; 

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
      super.start(context);
	  plugin = this;
	  viewpoints = new HashSet<Viewpoint>();
	  viewpoints.addAll(ViewpointRegistry.getInstance().registerFromPlugin(PLUGIN_ID + "/description/animation.odesign")); 
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
	plugin = null;
	if (viewpoints != null) {
	    for (final Viewpoint viewpoint: viewpoints) {
		ViewpointRegistry.getInstance().disposeFromPlugin(viewpoint);
	    }
	    viewpoints.clear();
	    viewpoints = null; 
	}
	super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
	return plugin;
    }
}
