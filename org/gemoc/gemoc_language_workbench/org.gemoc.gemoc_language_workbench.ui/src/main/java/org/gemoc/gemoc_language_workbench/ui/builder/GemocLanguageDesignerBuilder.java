package org.gemoc.gemoc_language_workbench.ui.builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.gemoc.gemoc_language_workbench.conf.BuildOptions;
import org.gemoc.gemoc_language_workbench.conf.DSAProject;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.ECLFile;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.K3DSAProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.ODProject;
import org.gemoc.gemoc_language_workbench.conf.ProjectKind;
import org.gemoc.gemoc_language_workbench.conf.TreeEditorProject;
import org.gemoc.gemoc_language_workbench.conf.XTextEditorProject;
import org.gemoc.gemoc_language_workbench.conf.impl.confFactoryImpl;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.builder.pde.PluginXMLHelper;
import org.gemoc.gemoc_language_workbench.utils.emf.EObjectUtil;
import org.gemoc.gemoc_language_workbench.utils.pde.ManifestChanger;
import org.gemoc.gemoc_language_workbench.utils.resource.ResourceUtil;
import org.jdom2.Element;
import org.osgi.framework.BundleException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import fr.inria.aoste.timesquare.ecl.ecltoqvto.main.AcceleoLauncherForEclToQvto;

public class GemocLanguageDesignerBuilder extends IncrementalProjectBuilder {

	class LanguageProjectDeltaVisitor implements IResourceDeltaVisitor {
		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse
		 * .core.resources.IResourceDelta)
		 */
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				// handle added resource
				updateProjectPersistentProperties(resource);
				updateProjectPluginConfiguration(resource);
				break;
			case IResourceDelta.REMOVED:
				// handle removed resource
				removePersistentProperties(resource);
				break;
			case IResourceDelta.CHANGED:
				// handle changed resource
				updateProjectPersistentProperties(resource);
				updateProjectPluginConfiguration(resource);
				break;
			}
			// return true to continue visiting children.
			return true;
		}
	}

	class LanguageProjectResourceVisitor implements IResourceVisitor {
		public boolean visit(IResource resource) {
			updateProjectPersistentProperties(resource);
			updateProjectPluginConfiguration(resource);
			// return true to continue visiting children.
			return true;
		}
	}

	class XMLErrorHandler extends DefaultHandler {

		private IFile file;

		public XMLErrorHandler(IFile file) {
			this.file = file;
		}

		private void addMarker(SAXParseException e, int severity) {
			GemocLanguageDesignerBuilder.this.addMarker(file, e.getMessage(), e.getLineNumber(), severity);
		}

		public void error(SAXParseException exception) throws SAXException {
			addMarker(exception, IMarker.SEVERITY_ERROR);
		}

		public void fatalError(SAXParseException exception) throws SAXException {
			addMarker(exception, IMarker.SEVERITY_ERROR);
		}

		public void warning(SAXParseException exception) throws SAXException {
			addMarker(exception, IMarker.SEVERITY_WARNING);
		}
	}

	public static final String BUILDER_ID = "org.gemoc.gemoc_language_workbench.ui.gemocLanguageDesignerBuilder";

	private static final String MARKER_TYPE = "org.gemoc.gemoc_language_workbench.ui.xmlProblem";

	private void addMarker(IFile file, String message, int lineNumber, int severity) {
		try {
			IMarker marker = file.createMarker(MARKER_TYPE);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, severity);
			if (lineNumber == -1) {
				lineNumber = 1;
			}
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
		} catch (CoreException e) {
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
	 * java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		} else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}

	private void updateProjectPersistentProperties(IResource resource) {
		if (resource instanceof IFile && resource.getName().equals(Activator.GEMOC_PROJECT_CONFIGURATION_FILE)) {
			IFile file = (IFile) resource;
			IProject project = file.getProject();
			try {
				if (file.exists()) {

					resetPersistentProperties(project);

					Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
					Map<String, Object> m = reg.getExtensionToFactoryMap();
					m.put(Activator.GEMOC_PROJECT_CONFIGURATION_FILE_EXTENSION, new XMIResourceFactoryImpl());

					// Obtain a new resource set
					ResourceSet resSet = new ResourceSetImpl();

					// Create the resource
					Resource modelresource = resSet.getResource(URI.createURI(file.getLocationURI().toString()), true);
					TreeIterator<EObject> it = modelresource.getAllContents();
					while (it.hasNext()) {
						EObject eObject = (EObject) it.next();
						if (eObject instanceof org.gemoc.gemoc_language_workbench.conf.DomainModelProject) {
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID,
									Activator.GEMOC_PROJECT_PROPERTY_HAS_DOMAINMODEL), "true");
						}
						if (eObject instanceof org.gemoc.gemoc_language_workbench.conf.DSAProject) {
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID,
									Activator.GEMOC_PROJECT_PROPERTY_HAS_DSA), "true");
						}
						if (eObject instanceof org.gemoc.gemoc_language_workbench.conf.DSEProject) {
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID,
									Activator.GEMOC_PROJECT_PROPERTY_HAS_DSE), "true");
						}
						if (eObject instanceof org.gemoc.gemoc_language_workbench.conf.MoCProject) {
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID,
									Activator.GEMOC_PROJECT_PROPERTY_HAS_MOC), "true");
						}
						if (eObject instanceof org.gemoc.gemoc_language_workbench.conf.EditorProject) {
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID,
									Activator.GEMOC_PROJECT_PROPERTY_HAS_EDITOR), "true");
						}
						if (eObject instanceof org.gemoc.gemoc_language_workbench.conf.AnimatorProject) {
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID,
									Activator.GEMOC_PROJECT_PROPERTY_HAS_ANIMATOR), "true");
						}
					}
				}
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}

		}
	}

	private void removePersistentProperties(IResource resource) {
		if (resource instanceof IFile && resource.getName().equals(Activator.GEMOC_PROJECT_CONFIGURATION_FILE)) {
			IFile file = (IFile) resource;
			resetPersistentProperties(file.getProject());
		}
	}

	private void resetPersistentProperties(IProject project) {
		try {
			project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID,
					Activator.GEMOC_PROJECT_PROPERTY_HAS_DOMAINMODEL), null);
			project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID,
					Activator.GEMOC_PROJECT_PROPERTY_HAS_DSA), null);
			project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID,
					Activator.GEMOC_PROJECT_PROPERTY_HAS_DSE), null);
			project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID,
					Activator.GEMOC_PROJECT_PROPERTY_HAS_MOC), null);
			project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID,
					Activator.GEMOC_PROJECT_PROPERTY_HAS_EDITOR), null);
			project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID,
					Activator.GEMOC_PROJECT_PROPERTY_HAS_ANIMATOR), null);
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
	}

	/**
	 * Update plugin.xml according to the model
	 * 
	 * @param resource
	 */
	private void updateProjectPluginConfiguration(IResource resource) {
		if (resource instanceof IFile && resource.getName().equals(Activator.GEMOC_PROJECT_CONFIGURATION_FILE)) {
			IFile file = (IFile) resource;
			IProject project = file.getProject();
			// try {
			if (file.exists()) {

				Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
				Map<String, Object> m = reg.getExtensionToFactoryMap();
				m.put(Activator.GEMOC_PROJECT_CONFIGURATION_FILE_EXTENSION, new XMIResourceFactoryImpl());

				// Obtain a new resource set
				ResourceSet resSet = new ResourceSetImpl();

				// Create the resource
				Resource modelresource = resSet.getResource(URI.createURI(file.getLocationURI().toString()), true);
				// get buil option first
				GemocLanguageWorkbenchConfiguration gemocLanguageWorkbenchConfiguration = (GemocLanguageWorkbenchConfiguration) modelresource.getContents().get(0);
			    BuildOptions buildOptions = gemocLanguageWorkbenchConfiguration.getBuildOptions();
			    if(buildOptions == null) buildOptions = confFactoryImpl.eINSTANCE.createBuildOptions();
			    // then look to all the content to do the work
				TreeIterator<EObject> it = modelresource.getAllContents();
				String languageRootElement = "";
				while (it.hasNext()) {
					EObject eObject = (EObject) it.next();
					if (eObject instanceof DomainModelProject) {
						DomainModelProject domainModelProject = (DomainModelProject) eObject;
						updateDependenciesWithDomainProject(project, domainModelProject);
						if (eObject instanceof EMFEcoreProject){
							languageRootElement = ((EMFEcoreProject)eObject).getDefaultRootEObjectQualifiedName();
						}
					}
					if (eObject instanceof DSAProject) {
						DSAProject dsaProject = (DSAProject) eObject;
						updateDependenciesWithDSAProject(project, dsaProject);
					}

					if (eObject instanceof XTextEditorProject) {
						XTextEditorProject xtextProject = (XTextEditorProject) eObject;
						updateDependenciesWithXTextEditorProject(project, xtextProject);
					}
					if (eObject instanceof ECLFile) {
						if(buildOptions.isGenerateQVTOFromECL()){
							updateECL_QVTO(project, (ECLFile) eObject, languageRootElement);
						}
					}
					/*
					 * if(eObject instanceof
					 * org.gemoc.gemoc_language_workbench.conf.MoCProject){
					 * project.setPersistentProperty(new
					 * QualifiedName(Activator.PLUGIN_ID,
					 * Activator.GEMOC_PROJECT_PROPERTY_HAS_MOC), "true"); }
					 * if(eObject instanceof
					 * org.gemoc.gemoc_language_workbench.conf.EditorProject){
					 * project.setPersistentProperty(new
					 * QualifiedName(Activator.PLUGIN_ID,
					 * Activator.GEMOC_PROJECT_PROPERTY_HAS_EDITOR), "true"); }
					 * if(eObject instanceof
					 * org.gemoc.gemoc_language_workbench.conf.AnimatorProject){
					 * project.setPersistentProperty(new
					 * QualifiedName(Activator.PLUGIN_ID,
					 * Activator.GEMOC_PROJECT_PROPERTY_HAS_ANIMATOR), "true");
					 * }
					 */
					if (eObject instanceof LanguageDefinition) {
						LanguageDefinition ld = (LanguageDefinition) eObject;
						changePluginLanguageName(project, ld.getName());
						if(buildOptions.isGenerateModelLoaderService()){							
							updateModelLoaderClass(project, ld);
						}
						//updateInitializerClass(project, ld);
						if(buildOptions.isGenerateCodeExecutorService()){
							updateCodeExecutorClass(project, ld);
						}
					}
				}
			}
			/*
			 * } catch (CoreException e) { Activator.error(e.getMessage(), e); }
			 */

		}
	}

	protected void changePluginLanguageName(IProject project, final String languageName) {
		IFile pluginfile = project.getFile(PluginXMLHelper.PLUGIN_FILENAME);
		PluginXMLHelper.createEmptyTemplateFile(pluginfile, false);
		PluginXMLHelper helper = new PluginXMLHelper();
		helper.loadDocument(pluginfile);
		Element gemocExtensionPoint = helper.getOrCreateExtensionPoint(Activator.GEMOC_LANGUAGE_EXTENSION_POINT_NAME);
		helper.updateXDSMLDefinitionInExtensionPoint(gemocExtensionPoint, languageName);
		helper.updateXDSMLDefinitionAttributeInExtensionPoint(gemocExtensionPoint,
				Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_XDSML_FILE_PATH_ATT, project.getFullPath()
						.toString() + "/project.xdsml");
		helper.saveDocument(pluginfile);
	}

	protected void updateDependenciesWithDomainProject(IProject project, DomainModelProject domainModelProject) {
		IFile manifestFile = project.getFile(new Path("META-INF/MANIFEST.MF"));

		try {
			ManifestChanger mfChanger = new ManifestChanger(manifestFile);
			// TODO find a way to remove possible old domain model dependencies
			mfChanger.addPluginDependency(domainModelProject.getProjectName(), "0.0.0", true, true);

			mfChanger.writeManifest(manifestFile);
		} catch (IOException e) {
			Activator.error(e.getMessage(), e);
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		} catch (BundleException e) {
			Activator.error(e.getMessage(), e);
		}
	}

	protected void updateDependenciesWithDSAProject(IProject project, DSAProject dsaPoject) {
		IFile manifestFile = project.getFile(new Path("META-INF/MANIFEST.MF"));

		try {
			if (dsaPoject.getProjectKind().equals(ProjectKind.ECLIPSE_PLUGIN)) {
				ManifestChanger mfChanger = new ManifestChanger(manifestFile);
				// TODO find a way to remove possible old domain model
				// dependencies
				mfChanger.addPluginDependency(dsaPoject.getProjectName(), "0.0.0", true, true);

				mfChanger.writeManifest(manifestFile);
			} else {
				// TODO deal with maven project (ie. ensure copy of the jar and
				// use it as internal lib in manifest)
			}
		} catch (IOException e) {
			Activator.error(e.getMessage(), e);
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		} catch (BundleException e) {
			Activator.error(e.getMessage(), e);
		}
	}

	protected void updateDependenciesWithXTextEditorProject(IProject project,
			XTextEditorProject xtextEditorProject) {
		IFile manifestFile = project.getFile(new Path("META-INF/MANIFEST.MF"));

		try {
			ManifestChanger mfChanger = new ManifestChanger(manifestFile);
			// TODO find a way to remove possible old domain model dependencies
			mfChanger.addPluginDependency(xtextEditorProject.getProjectName(),
					"0.0.0", true, true);

			mfChanger.writeManifest(manifestFile);
		} catch (IOException e) {
			Activator.error(e.getMessage(), e);
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		} catch (BundleException e) {
			Activator.error(e.getMessage(), e);
		}
	}
	/**
	 * create or replace existing ModelLoaderClass by an implementation that is
	 * able to load models of the domain
	 * 
	 * @param project
	 * @param ld
	 */
	protected void updateModelLoaderClass(IProject project, LanguageDefinition ld) {
		// TODO remove possible previous classes
		// create the java class
		String languageToUpperFirst = ld.getName().substring(0, 1).toUpperCase() + ld.getName().substring(1);
		String packageName = project.getName() + ".xdsml.api.impl";
		String folderName = packageName.replaceAll("\\.", "/");
		if (ld.getDomainModelProject() != null) {
			String fileContent = BuilderTemplates.MODEL_LOADER_CLASS_TEMPLATE;
			fileContent = fileContent.replaceAll(Pattern.quote("${package.name}"), packageName);
			fileContent = fileContent.replaceAll(Pattern.quote("${language.name.toupperfirst}"), languageToUpperFirst);
			StringBuilder sb = new StringBuilder();
			sb.append("System.out.println(\"[" + languageToUpperFirst + Activator.MODEL_LOADER_CLASS_NAMEPART
					+ "] loading model from uri \"+modelFileUri);\n");
			ArrayList<EditorProject> editorWithXMIResource = new ArrayList<EditorProject>();
			Set<String> xmiExtensions = new HashSet<String>();
			for (EditorProject editorProject : ld.getEditorProjects()) {
				if(editorProject instanceof TreeEditorProject){
					editorWithXMIResource.add(editorProject);
					xmiExtensions.addAll(editorProject.getFileExtension());
				}
				if(editorProject instanceof ODProject){
					editorWithXMIResource.add(editorProject);
					xmiExtensions.addAll(editorProject.getFileExtension());
				}
			}
			sb.append("		if(modelFileUri.endsWith(\".xmi\")");
			for (String xmiExtension : xmiExtensions) {
				sb.append(" || modelFileUri.endsWith(\"."+xmiExtension+"\")");
			}
			sb.append(" ){\n"
					+ "			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;\n"
					+ "		    Map<String, Object> m = reg.getExtensionToFactoryMap();\n"
					+ "		    m.put(\"xmi\", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());\n");
			for (String xmiExtension : xmiExtensions) {
				sb.append("		    m.put(\""+xmiExtension+"\", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());\n");
			}
			sb.append("		    // Obtain a new resource set\n"
					+ "		    ResourceSet resSet = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();\n"
					+ "		    // Create the resource\n"
					+ "		    result = resSet.getResource(URI.createURI(modelFileUri), true);\n"
					+ "		}\n");
			
			for (EditorProject editorProject : ld.getEditorProjects()) {
				if(editorProject instanceof XTextEditorProject && editorProject.getFileExtension().size() > 0){
					sb.append("		if(modelFileUri.endsWith(\"."+editorProject.getFileExtension().get(0)+"\")){\n");
					sb.append("			com.google.inject.Injector injector = new "+((XTextEditorProject)editorProject).getGrammarName()+"StandaloneSetup().createInjector();\n");
					sb.append("			org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);\n");
					sb.append("			org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);\n");
					for (String extension : editorProject.getFileExtension()) {
						sb.append("			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(\""+extension+"\", resourceFactory);\n");	
					}
					sb.append("			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(\n");
					sb.append("			Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());\n");
					for (String extension : editorProject.getFileExtension()) {
						sb.append("			org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put(\""+extension+"\", serviceProvider);\n");	
					}	
					sb.append("			org.eclipse.xtext.resource.XtextResourceSet resourceSet = injector.getInstance(org.eclipse.xtext.resource.XtextResourceSet.class);\n");
					sb.append("			resourceSet.addLoadOption(org.eclipse.xtext.resource.XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);\n");
					sb.append("			result = resourceSet.getResource(URI.createURI(modelFileUri), true);\n");		
					sb.append("		}\n");
				}
			}
			fileContent = fileContent.replaceAll(
					Pattern.quote("${loadModel.content}"), sb.toString());
			IFile file = project
					.getFile(Activator.EXTENSION_GENERATED_CLASS_FOLDER_NAME
							+ folderName + "/" + languageToUpperFirst
							+ Activator.MODEL_LOADER_CLASS_NAMEPART + ".java");
			ResourceUtil.writeFile(file, fileContent);
		}
		// update plugin.xml
		IFile pluginfile = project.getFile(PluginXMLHelper.PLUGIN_FILENAME);
		PluginXMLHelper.createEmptyTemplateFile(pluginfile, false);
		PluginXMLHelper helper = new PluginXMLHelper();
		helper.loadDocument(pluginfile);
		if (ld.getDomainModelProject() != null) {
			Element gemocExtensionPoint = helper.getOrCreateExtensionPoint(Activator.GEMOC_LANGUAGE_EXTENSION_POINT_NAME);
			helper.updateXDSMLDefinitionAttributeInExtensionPoint(gemocExtensionPoint,
				Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_LOADMODEL_ATT, packageName + "."
						+ languageToUpperFirst + Activator.MODEL_LOADER_CLASS_NAMEPART);	
		}
		helper.saveDocument(pluginfile);

	}

	/**
	 * create or replace existing InitializerClass by an implementation that is
	 * able to initialize all required components
	 * 
	 * @param project
	 * @param ld
	 */
	protected void updateInitializerClass(IProject project, LanguageDefinition ld) {
		// TODO remove possible previous classes
		// create the java class
		String languageToUpperFirst = ld.getName().substring(0, 1).toUpperCase() + ld.getName().substring(1);
		String packageName = project.getName() + ".xdsml.api.impl";
		String folderName = packageName.replaceAll("\\.", "/");
		if (ld.getDomainModelProject() != null) {
			String fileContent = BuilderTemplates.INITIALIZER_CLASS_TEMPLATE;
			fileContent = fileContent.replaceAll(Pattern.quote("${package.name}"), packageName);
			fileContent = fileContent.replaceAll(Pattern.quote("${language.name.toupperfirst}"), languageToUpperFirst);
			StringBuilder sb = new StringBuilder();
			sb.append("// TODO\n");
			fileContent = fileContent.replaceAll(Pattern.quote("${initializer.content}"), sb.toString());
			IFile file = project.getFile(Activator.EXTENSION_GENERATED_CLASS_FOLDER_NAME + folderName + "/"
					+ languageToUpperFirst + Activator.INITIALIZER_CLASS_NAMEPART + ".java");
			ResourceUtil.writeFile(file, fileContent);
		}
		// update plugin.xml
		IFile pluginfile = project.getFile(PluginXMLHelper.PLUGIN_FILENAME);
		PluginXMLHelper.createEmptyTemplateFile(pluginfile, false);
		PluginXMLHelper helper = new PluginXMLHelper();
		helper.loadDocument(pluginfile);
		Element gemocExtensionPoint = helper.getOrCreateExtensionPoint(Activator.GEMOC_LANGUAGE_EXTENSION_POINT_NAME);
		helper.updateXDSMLDefinitionAttributeInExtensionPoint(gemocExtensionPoint,
				Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_INITIALIZER_ATT, packageName + "."
						+ languageToUpperFirst + Activator.INITIALIZER_CLASS_NAMEPART);
		helper.saveDocument(pluginfile);

	}

	/**
	 * create or replace existing CodeExecutorClass by an implementation that is
	 * able to execute method from the concrete DSA
	 * 
	 * @param project
	 * @param ld
	 */
	protected void updateCodeExecutorClass(IProject project, LanguageDefinition ld) {
		// TODO remove possible previous classes
		// create the java class
		String languageToUpperFirst = ld.getName().substring(0, 1).toUpperCase() + ld.getName().substring(1);
		String packageName = project.getName() + ".xdsml.api.impl";
		String folderName = packageName.replaceAll("\\.", "/");
		if (ld.getDomainModelProject() != null) {
			String fileContent = BuilderTemplates.CODEEXECUTOR_CLASS_TEMPLATE;
			fileContent = fileContent.replaceAll(
					Pattern.quote("${package.name}"), packageName);
			fileContent = fileContent.replaceAll(
					Pattern.quote("${language.name.toupperfirst}"),
					languageToUpperFirst);
			/*StringBuilder sb = new StringBuilder();
			sb.append("// TODO\n");
			sb.append("\t\tSystem.out.println(\"will call \"+ methodName + \" on \"+ target.toString());");
			fileContent = fileContent.replaceAll(
					Pattern.quote("${execute.content}"), sb.toString()); */
			
			
			StringBuilder sbContent = new StringBuilder();
			StringBuilder sbImplementContent = new StringBuilder();
			StringBuilder sbAdditionalOperations = new StringBuilder();
			
			if(ld.getDsaProject() instanceof K3DSAProject){
				sbContent.append("// add K3 DSA specific executor\n");
				sbContent.append("\t\taddExecutor(new org.gemoc.gemoc_language_workbench.extensions.k3.dsa.impl.Kermeta3AspectsCodeExecutor(this,\n");
				sbContent.append("\t\t\t\""+ld.getDsaProject().getProjectName()+"\"));\n");
				
				sbImplementContent.append("\n\t\timplements org.gemoc.gemoc_language_workbench.extensions.k3.dsa.api.IK3DSAExecutorClassLoader ");
				
				sbAdditionalOperations.append("@Override\n"+
"	public Class<?> getClassForName(String className) throws ClassNotFoundException {\n"+
"		return Class.forName(className);\n"+
"	}\n"+
"	@Override\n"+
"	public java.io.InputStream getResourceAsStream(String resourceName) {\n"+
"		//this.getClass().getResourceAsStream(resourceName);\n"+
"		return Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName);\n"+	
"	}");
			}
			else{
				sbContent.append("\t\t// TODO add DSA specific executor for "+ld.getDsaProject().eClass().getName()+"\n");	
			}
			

			sbContent.append("\t\t// fall back executor : search classic java method\n");
			sbContent.append("\t\taddExecutor(new org.gemoc.execution.engine.commons.dsa.executors.JavaCodeExecutor());");
			fileContent = fileContent.replaceAll(
					Pattern.quote("${constructor.content}"), sbContent.toString());
			
			fileContent = fileContent.replaceAll(
					Pattern.quote("${implements.content}"), sbImplementContent.toString());
			
			fileContent = fileContent.replaceAll(
					Pattern.quote("${additional.operations}"), sbAdditionalOperations.toString());
			
			IFile file = project
					.getFile(Activator.EXTENSION_GENERATED_CLASS_FOLDER_NAME
							+ folderName + "/" + languageToUpperFirst
							+ Activator.CODEEXECUTOR_CLASS_NAMEPART + ".java");
			ResourceUtil.writeFile(file, fileContent);
		}
		// update plugin.xml
		IFile pluginfile = project.getFile(PluginXMLHelper.PLUGIN_FILENAME);
		PluginXMLHelper.createEmptyTemplateFile(pluginfile, false);
		PluginXMLHelper helper = new PluginXMLHelper();
		helper.loadDocument(pluginfile);
		Element gemocExtensionPoint = helper.getOrCreateExtensionPoint(Activator.GEMOC_LANGUAGE_EXTENSION_POINT_NAME);
		helper.updateXDSMLDefinitionAttributeInExtensionPoint(gemocExtensionPoint,
				Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_CODEEXECUTOR_ATT, packageName + "."
						+ languageToUpperFirst + Activator.CODEEXECUTOR_CLASS_NAMEPART);
		helper.saveDocument(pluginfile);

	}

	/**
	 * create or replace existing InitializerClass by an implementation that is
	 * able to initialize all required components
	 * 
	 * @param project
	 * @param ld
	 */
	protected void updateECL_QVTO(final IProject project,
			final ECLFile ecliFilePath, String rootElement) {
		
		
		final URI uri = URI.createPlatformResourceURI(
				ecliFilePath.getLocationURI(), true);
		final IFolder qvtoFolder = project.getFolder("qvto-gen");

		String folderPath = qvtoFolder.getLocation().toOSString();
		final File folder = new File(folderPath);

		final List<String> arguments = new ArrayList<String>();
		LanguageDefinition ld = EObjectUtil.eContainerOfType(ecliFilePath, LanguageDefinition.class);
		String qvtoFileName = ld != null ? ld.getName() + "_toCCSL.qvto" : uri.lastSegment().replace(".ecl",
				"_toCCSL.qvto");
		arguments.add(qvtoFileName);

		// create QVTO file
		ISafeRunnable runnable = new ISafeRunnable() {
			@Override
			public void handleException(Throwable e) {
				Activator.error(e.getMessage(), e);
			}

			@Override
			public void run() throws Exception {

				ResourceUtil.createFolder(qvtoFolder, true, true, null);

				try {
					System.out.println("launching ecl to qvto:\n\turi=" + uri + "\n\tfolder=" + folder + "\n\targs="
							+ arguments);
					AcceleoLauncherForEclToQvto launcher = new AcceleoLauncherForEclToQvto(uri, folder, arguments);
					launcher.doGenerate(new BasicMonitor());
					qvtoFolder.refreshLocal(2, new NullProgressMonitor());
				} catch (IOException e) {
					Activator.error(e.getMessage(), e);
				}
			}
		};
		SafeRunner.run(runnable);

		// update plugin.xml
		IFile pluginfile = project.getFile(PluginXMLHelper.PLUGIN_FILENAME);
		PluginXMLHelper.createEmptyTemplateFile(pluginfile, false);
		PluginXMLHelper helper = new PluginXMLHelper();
		helper.loadDocument(pluginfile);
		Element gemocExtensionPoint = helper.getOrCreateExtensionPoint(Activator.GEMOC_LANGUAGE_EXTENSION_POINT_NAME);
		helper.updateXDSMLDefinitionAttributeInExtensionPoint(gemocExtensionPoint,
				Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_DSE_RESOURCE_PATH_ATT, ecliFilePath.getLocationURI());
		helper.updateXDSMLDefinitionAttributeInExtensionPoint(
				gemocExtensionPoint,
				Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_TO_CCSL_QVTO_FILE_PATH_ATT,
				qvtoFolder.getFullPath().toString()+"/"+qvtoFileName);
		helper.saveDocument(pluginfile);

	}

	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {
		try {
			// need to check if build is realy required because it seems to be
			// called on each eclipse startup ? more debug analysis required ...
			getProject().accept(new LanguageProjectResourceVisitor());
		} catch (CoreException e) {
		}
	}

	protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		// the visitor does the work.
		delta.accept(new LanguageProjectDeltaVisitor());
	}

}
