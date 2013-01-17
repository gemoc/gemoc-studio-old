package fr.obeo.dsl.plugin.resolver;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import fr.obeo.dsl.plugin.Component;
import fr.obeo.dsl.plugin.PhysicalArchitecture;
import fr.obeo.dsl.plugin.PluginFactory;
import fr.obeo.dsl.plugin.TargetPlatform;

public class PluginsResourceFactory {

    public static Resource createResource(URI uri) {
        Resource res = new XMIResourceImpl(uri);
        return res;
    }

    public static PhysicalArchitecture createTargetPlatform() {
        PhysicalArchitecture platform = PluginFactory.eINSTANCE.createPhysicalArchitecture();
        new BundleModelUtils().addBundles(platform);
        Component root = PluginFactory.eINSTANCE.createComponent();
        root.setName("Target Platform Features");
        new BundleModelUtils().addFeatures(root,platform.getOwnedBundles());
        platform.setRootFeature(root);
        return platform;
    }

}

