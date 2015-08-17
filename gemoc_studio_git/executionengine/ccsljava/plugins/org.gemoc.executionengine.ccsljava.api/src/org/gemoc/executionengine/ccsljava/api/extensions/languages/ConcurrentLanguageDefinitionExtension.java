package org.gemoc.executionengine.ccsljava.api.extensions.languages;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.gemoc.executionengine.ccsljava.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtension;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

public class ConcurrentLanguageDefinitionExtension extends LanguageDefinitionExtension {

//	final public ICodeExecutor instanciateCodeExecutor() throws CoreException {
//		Object instance = instanciate(ConcurrentLanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_CODEEXECUTOR_ATT);
//		if (instance instanceof ICodeExecutor) {
//			return (ICodeExecutor) instance;
//		}
//		throwInstanciationCoreException();
//		return null;
//	}

	final public ISolver instanciateSolver() throws CoreException {
		Object instance = instanciate(ConcurrentLanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_SOLVER_ATT);
		if (instance instanceof ISolver) {
			return (ISolver) instance;
		}
		throwInstanciationCoreException();
		return null;
	}

	final public String getQVTOPath() {
		return _configurationElement
				.getAttribute(ConcurrentLanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_TO_CCSL_QVTO_FILE_PATH_ATT);
	}

//	final public Collection<IEngineAddon> instanciateEngineAddons() throws CoreException {
//		ArrayList<IEngineAddon> addons = new ArrayList<IEngineAddon>();
//		for (IConfigurationElement childConfElement : _configurationElement
//				.getChildren(ConcurrentLanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_ENGINE_ADDON_DEF)) {
//			childConfElement.getName();
//			final Object addon = childConfElement
//					.createExecutableExtension(ConcurrentLanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_ENGINE_ADDON_DEF_ENGINE_ADDON_ATT);
//			if (addon instanceof IEngineAddon) {
//				addons.add((IEngineAddon) addon);
//			}
//		}
//		return addons;
//	}

	final public Collection<IMSEStateController> instanciateMSEStateControllers() throws CoreException {
		ArrayList<IMSEStateController> controllers = new ArrayList<IMSEStateController>();
		for (IConfigurationElement childConfElement : _configurationElement
				.getChildren(ConcurrentLanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_MSE_STATE_CONTROLLER_DEFINITION)) {
			childConfElement.getName();
			final Object c = childConfElement
					.createExecutableExtension(ConcurrentLanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_MSE_STATE_CONTROLLER_CLASS_DEFINITION);
			if (c instanceof IMSEStateController) {
				controllers.add((IMSEStateController) c);
			}
		}
		return controllers;
	}


//	private LanguageDefinition _languageDefinitionCache;
//
//	public LanguageDefinition getLanguageDefinition() {
//		if (_languageDefinitionCache == null) {
//
//			// Loading languagedef model
//			ResourceSet rs = new ResourceSetImpl();
//			URI uri = URI.createPlatformPluginURI(getXDSMLFilePath(), true);
//			Resource res = rs.createResource(uri);
//			try {
//				res.load(null);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			EcoreUtil.resolveAll(rs);// IMPORTANT
//
//			if (res != null) {
//				EObject first = res.getContents().get(0);
//
//				// Follow-up in other operation...
//				if (first instanceof LanguageDefinition) {
//					_languageDefinitionCache = (LanguageDefinition) first;
//				}
//			}
//		}
//		return _languageDefinitionCache;
//	}

}
