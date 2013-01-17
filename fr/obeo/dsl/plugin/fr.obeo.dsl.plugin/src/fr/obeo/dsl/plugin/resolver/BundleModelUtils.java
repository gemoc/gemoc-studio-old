package fr.obeo.dsl.plugin.resolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.ExportPackageDescription;
import org.eclipse.pde.core.plugin.IPluginExtensionPoint;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.FeatureModelManager;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.PluginModelManager;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;
import org.eclipse.pde.internal.core.ifeature.IFeaturePlugin;

import fr.obeo.dsl.plugin.Bundle;
import fr.obeo.dsl.plugin.Component;
import fr.obeo.dsl.plugin.ExtensionPoint;
import fr.obeo.dsl.plugin.PhysicalArchitecture;
import fr.obeo.dsl.plugin.Plugin;
import fr.obeo.dsl.plugin.PluginFactory;
import fr.obeo.dsl.plugin.TargetPlatform;

public class BundleModelUtils {

    public IPluginModelBase[] getAllPlugins() {
        PluginModelManager manager = PDECore.getDefault().getModelManager();
        return manager.getAllModels();
    }

    public IFeatureModel[] getAllFeatures() {
        FeatureModelManager manager = PDECore.getDefault().getFeatureModelManager();
        return manager.getModels();
    }

    public boolean select(IPluginModelBase plugin, String filter) {
        return plugin.getPluginBase().getId().indexOf(filter) != -1;

    }

    public IPluginModelBase[] getSelectedPlugins(String filter) {
        Collection result = new ArrayList();
        IPluginModelBase[] plugins = getAllPlugins();
        for (int i = 0; i < plugins.length; i++) {
            if (select(plugins[i], filter)) {
                result.add(plugins[i]);
            }
        }
        return (IPluginModelBase[]) result.toArray(new IPluginModelBase[result.size()]);

    }

    private Map<BundleDescription, Plugin> bundleToPlugin = new HashMap<BundleDescription, Plugin>();

    public void addBundles(PhysicalArchitecture root) {
        IPluginModelBase[] plugins = getAllPlugins();
        for (int i = 0; i < plugins.length; i++) {
            Plugin plugin = iPluginToPlugin(plugins[i]);
            root.getOwnedBundles().add(plugin);
        }
        // now resolving dependencies
        for (int i = 0; i < plugins.length; i++) {
            BundleDescription[] dependancies = AnalysisUtil.getDependencies(plugins[i].getBundleDescription());
            Plugin plugin = (Plugin) bundleToPlugin.get(plugins[i].getBundleDescription());
            for (int j = 0; j < dependancies.length; j++) {
                Plugin pluginImDependingOn = (Plugin) bundleToPlugin.get(dependancies[j]);
                if (pluginImDependingOn != null && !plugin.getRequire().contains(pluginImDependingOn)) {
                    plugin.getRequire().add(pluginImDependingOn);
                }
            }
        }
        for (int i = 0; i < plugins.length; i++) {
            resolveExtensionPointDependancies(plugins[i]);
        }
    }

    private Plugin iPluginToPlugin(IPluginModelBase base) {
        Plugin plugin = PluginFactory.eINSTANCE.createPlugin();
        plugin.setName(base.getPluginBase().getId());
        plugin.setDescription(base.toString());
        bundleToPlugin.put(base.getBundleDescription(), plugin);
        // extension points
        for (int i = 0; i < base.getExtensions().getExtensionPoints().length; i++) {
            ExtensionPoint point = iExtensionPointToExtensionPoint(base.getExtensions().getExtensionPoints()[i]);
            plugin.getOwnedExtensionPoints().add(point);
        }
        // exported packages
        for (int i = 0; i < base.getBundleDescription().getExportPackages().length; i++) {
            fr.obeo.dsl.plugin.Package pack = PluginFactory.eINSTANCE.createPackage();
            ExportPackageDescription desc = base.getBundleDescription().getExportPackages()[i];
            pack.setName(desc.getName());
            plugin.getExportedPackages().add(pack);
        }

        return plugin;
    }

    private Plugin resolveExtensionPointDependancies(IPluginModelBase base) {
        Plugin plugin = (Plugin) bundleToPlugin.get(base.getBundleDescription());
        for (int i = 0; i < base.getExtensions().getExtensions().length; i++) {
            String id = base.getExtensions().getExtensions()[i].getPoint();
            if (extensionIdToExtensionPoint.get(id) != null) {
                plugin.getExtensions().add(extensionIdToExtensionPoint.get(id));
            }
        }
        return plugin;
    }

    private Map<String, ExtensionPoint> extensionIdToExtensionPoint = new HashMap<String, ExtensionPoint>();

    private ExtensionPoint iExtensionPointToExtensionPoint(IPluginExtensionPoint point) {
        ExtensionPoint result = PluginFactory.eINSTANCE.createExtensionPoint();
        result.setId(point.getFullId());
        extensionIdToExtensionPoint.put(point.getFullId(), result);
        result.setXsd(point.getSchema());
        return result;
    }

    public void addFeatures(Component root, EList<Bundle> ownedBundles) {
        Map<String, Bundle> idToPlugin = new HashMap<String, Bundle>(ownedBundles.size());
        for (Bundle bundle : ownedBundles) {
            idToPlugin.put(bundle.getName(), bundle);
        }
        for (IFeatureModel feature : getAllFeatures()) {
            if (!(feature.getFeature().getId().endsWith("sdk") || feature.getFeature().getId().endsWith("source") || feature.getFeature().getId().endsWith("doc"))) {
                Component modelFeat = PluginFactory.eINSTANCE.createComponent();
                modelFeat.setName(feature.getFeature().getId());
                for (IFeaturePlugin childPlugin : feature.getFeature().getPlugins()) {
                    Bundle foundBundle = idToPlugin.get(childPlugin.getId());
                    if (foundBundle != null) {
                        modelFeat.getBundles().add(foundBundle);
                    }
                }
                root.getSubComponents().add(modelFeat);
            }
        }

    }
}
