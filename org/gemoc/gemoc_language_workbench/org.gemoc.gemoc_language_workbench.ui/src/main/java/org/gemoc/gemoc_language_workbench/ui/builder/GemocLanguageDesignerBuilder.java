package org.gemoc.gemoc_language_workbench.ui.builder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.gemoc.commons.eclipse.core.resources.GFile;
import org.gemoc.commons.eclipse.pde.ManifestChanger;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtensionPoint;
import org.gemoc.gemoc_language_workbench.conf.DSAProject;
import org.gemoc.gemoc_language_workbench.conf.DSEProject;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.ProjectKind;
import org.gemoc.gemoc_language_workbench.conf.SiriusEditorProject;
import org.gemoc.gemoc_language_workbench.conf.TreeEditorProject;
import org.gemoc.gemoc_language_workbench.conf.XTextEditorProject;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.builder.pde.PluginXMLHelper;
import org.jdom2.Element;
import org.osgi.framework.BundleException;

public class GemocLanguageDesignerBuilder extends IncrementalProjectBuilder {

	
	public GemocLanguageDesignerBuilder() {
		return;
	}
	
	
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
					updateProjectArtefacts(resource);
					checkConsistency(resource);
					break;
				case IResourceDelta.REMOVED:
					removePersistentProperties(resource);
					checkConsistency(resource);
					break;
				case IResourceDelta.CHANGED:
					updateProjectArtefacts(resource);
					checkConsistency(resource);
					break;
			}
			// return true to continue visiting children.
			return true;
		}

	}
	
	
	class LanguageProjectResourceVisitor implements IResourceVisitor {
		
		public boolean visit(IResource resource) {
			updateProjectArtefacts(resource);
			checkConsistency(resource);
			// return true to continue visiting children.
			return true;
		}

	}

	private void updateProjectArtefacts(IResource resource) {
		updateProjectPersistentProperties(resource);
		updateProjectPluginConfiguration(resource);
	}

	public static final String BUILDER_ID = "org.gemoc.gemoc_language_workbench.ui.gemocLanguageDesignerBuilder";

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
						if (eObject instanceof org.gemoc.gemoc_language_workbench.conf.MoCCProject) {
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

	public void checkConsistency(IResource resource){
		// TODO DVK, check consistency of plugin.xml according to existence of projects referenced in the xdsml  
	}
	
	
	/**
	 * Update plugin.xml according to the model
	 * 
	 * @param resource
	 */
	private void updateProjectPluginConfiguration(IResource resource) {
		if (resource instanceof IFile 
			&& resource.getName().equals(Activator.GEMOC_PROJECT_CONFIGURATION_FILE)) {
			IFile file = (IFile) resource;
			IProject project = file.getProject();
			// try {
			if (file.exists()) {
				Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
				Map<String, Object> m = registry.getExtensionToFactoryMap();
				m.put(Activator.GEMOC_PROJECT_CONFIGURATION_FILE_EXTENSION, new XMIResourceFactoryImpl());

				// Obtain a new resource set
				ResourceSet resSet = new ResourceSetImpl();

				// Create the resource
				Resource modelresource = resSet.getResource(URI.createURI(file.getLocationURI().toString()), true);
				// get buil option first
//				GemocLanguageWorkbenchConfiguration gemocLanguageWorkbenchConfiguration = (GemocLanguageWorkbenchConfiguration) modelresource.getContents().get(0);
//			    BuildOptions buildOptions = gemocLanguageWorkbenchConfiguration.getBuildOptions();
//			    if(buildOptions == null) buildOptions = confFactoryImpl.eINSTANCE.createBuildOptions();
			    // then look to all the content to do the work
				TreeIterator<EObject> it = modelresource.getAllContents();
				String languageRootElement = "";
				
				ManifestChanger manifestChanger = new ManifestChanger(project);
				try {
					while (it.hasNext()) {
						EObject eObject = (EObject) it.next();
						languageRootElement = updateManifestAndPlugin(project, languageRootElement, manifestChanger, eObject);
					}
					manifestChanger.commit();
					
				} catch (CoreException e) {
					Activator.error(e.getMessage(), e);				
				} catch (IOException e) {
					Activator.error(e.getMessage(), e);				
				} catch (BundleException e) {
					Activator.error(e.getMessage(), e);				
				} 
			}
		}
	}

	private String updateManifestAndPlugin(IProject project,
			String languageRootElement,
			ManifestChanger manifestChanger, EObject eObject)
			throws BundleException, IOException, CoreException {
		if (eObject instanceof DomainModelProject) {
			DomainModelProject domainModelProject = (DomainModelProject) eObject;
			updateDependenciesWithDomainProject(manifestChanger, domainModelProject);
			languageRootElement = domainModelProject.getDefaultRootEObjectQualifiedName();
		}
		if (eObject instanceof DSAProject) {
			DSAProject dsaProject = (DSAProject) eObject;
			updateDependenciesWithDSAProject(manifestChanger, dsaProject);
			updateCodeExecutorClass(project, (LanguageDefinition) eObject.eContainer());
		}

		if (eObject instanceof XTextEditorProject) {
			XTextEditorProject xtextProject = (XTextEditorProject) eObject;
			updateDependenciesWithXTextEditorProject(manifestChanger, xtextProject);
		}
		if (eObject instanceof DSEProject) {
			updateQVTO(project, ((DSEProject) eObject).getQvtoURI(), languageRootElement);			
		}

//		if (eObject instanceof LanguageDefinition) {
//			LanguageDefinition ld = (LanguageDefinition) eObject;
//			changePluginLanguageName(project, ld.getName());
//			if(buildOptions.isGenerateModelLoaderService()){							
//				updateModelLoaderClass(project, ld);
//			}
//			//updateInitializerClass(project, ld);
//			if(buildOptions.isGenerateCodeExecutorService()){
//				updateCodeExecutorClass(project, ld);
//			}
//			if(buildOptions.isGenerateSolverService()){
//				updateSolverClass(project, ld);
//			}
//		}
		return languageRootElement;
	}
	
	/**
	 * create or replace existing CodeExecutorClass by an implementation that is
	 * able to execute method from the concrete DSA
	 * 
	 * @param project
	 * @param ld
	 */
	protected void updateCodeExecutorClass(IProject project, LanguageDefinition ld) {
		// if codeExecutor null or empty, generate an executor class and updtae plugin.xml 
		if(ld.getDsaProject() != null ){
			if ( ld.getDsaProject().getCodeExecutorClass() == null || ld.getDsaProject().getCodeExecutorClass().isEmpty()){ 
				// create the java class
				String languageToUpperFirst = getLanguageNameWithFirstUpper(ld.getName());
				String packageName = getPackageName(ld.getName());
				String folderName = getFolderName(ld.getName());
				
				String fileContent = BuilderTemplates.CODEEXECUTOR_CLASS_TEMPLATE;
				fileContent = fileContent.replaceAll(
						Pattern.quote("${package.name}"), packageName);
				fileContent = fileContent.replaceAll(
						Pattern.quote("${language.name.toupperfirst}"),
						languageToUpperFirst);
				
				StringBuilder sbContent = new StringBuilder();
				StringBuilder sbImplementContent = new StringBuilder();
				StringBuilder sbAdditionalOperations = new StringBuilder();
					
					
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
				
				writeFile(file, fileContent);
				//ResourceUtil.writeFile(file, fileContent);
				
				// update plugin.xml with the generated codeexecutor
				setPluginCodeExecutorValue(project, packageName + "."	+ languageToUpperFirst + Activator.CODEEXECUTOR_CLASS_NAMEPART);
			} else {
				// update plugin.xml with the value in the xdsml
				setPluginCodeExecutorValue(project, ld.getDsaProject().getCodeExecutorClass());
			}
		}
	}

	protected void setPluginCodeExecutorValue(IProject project, String value){
		// update plugin.xml
		IFile pluginfile = project.getFile(PluginXMLHelper.PLUGIN_FILENAME);
		PluginXMLHelper.createEmptyTemplateFile(pluginfile, false);
		PluginXMLHelper helper = new PluginXMLHelper();
		helper.loadDocument(pluginfile);
		Element gemocExtensionPoint = helper.getOrCreateExtensionPoint(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT);
		helper.updateXDSMLDefinitionAttributeInExtensionPoint(gemocExtensionPoint,
				LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_CODEEXECUTOR_ATT, value);
		helper.saveDocument(pluginfile);
	}
	
	protected void changePluginLanguageName(IProject project, final String languageName) {
		IFile pluginfile = project.getFile(PluginXMLHelper.PLUGIN_FILENAME);
		PluginXMLHelper.createEmptyTemplateFile(pluginfile, false);
		PluginXMLHelper helper = new PluginXMLHelper();
		helper.loadDocument(pluginfile);
		Element gemocExtensionPoint = helper.getOrCreateExtensionPoint(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT);
		helper.updateXDSMLDefinitionInExtensionPoint(gemocExtensionPoint, languageName);
		helper.updateXDSMLDefinitionAttributeInExtensionPoint(gemocExtensionPoint,
				LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_XDSML_FILE_PATH_ATT, project.getFullPath()
						.toString() + "/project.xdsml");
		helper.saveDocument(pluginfile);
	}

	protected void updateDependenciesWithDomainProject(ManifestChanger connection, DomainModelProject domainModelProject) throws BundleException, IOException, CoreException {
		connection.addPluginDependency(domainModelProject.getProjectName());
		// TODO find a way to remove possible old domain model dependencies
	}

	protected void updateDependenciesWithDSAProject(ManifestChanger connection, DSAProject dsaPoject) throws BundleException, IOException, CoreException {
		if (dsaPoject.getProjectKind().equals(ProjectKind.ECLIPSE_PLUGIN)) {
			connection.addPluginDependency(dsaPoject.getProjectName());
			// TODO find a way to remove possible old domain model
			// dependencies
		} else {
			// TODO deal with maven project (ie. ensure copy of the jar and
			// use it as internal lib in manifest)
		}
		if (dsaPoject instanceof DSAProject) {
			connection.addPluginDependency(org.gemoc.gemoc_language_workbench.extensions.k3.Activator.PLUGIN_ID);
		}
	}

	protected void updateDependenciesWithXTextEditorProject(ManifestChanger connection, XTextEditorProject xtextEditorProject) throws BundleException, IOException, CoreException {
		connection.addPluginDependency(xtextEditorProject.getProjectName());
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
		String packageName = ld.getName() + ".xdsml.api.impl";
		String folderName = getFolderName(ld.getName());
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
				if(editorProject instanceof SiriusEditorProject){
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
			writeFile(file, fileContent);
		}
		// update plugin.xml
		IFile pluginfile = project.getFile(PluginXMLHelper.PLUGIN_FILENAME);
		PluginXMLHelper.createEmptyTemplateFile(pluginfile, false);
		PluginXMLHelper helper = new PluginXMLHelper();
		helper.loadDocument(pluginfile);
		if (ld.getDomainModelProject() != null) {
			Element gemocExtensionPoint = helper.getOrCreateExtensionPoint(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT);
			helper.updateXDSMLDefinitionAttributeInExtensionPoint(gemocExtensionPoint,
					LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_LOADMODEL_ATT, packageName + "."
						+ languageToUpperFirst + Activator.MODEL_LOADER_CLASS_NAMEPART);	
		}
		helper.saveDocument(pluginfile);

	}

	public static String getLanguageNameWithFirstUpper(String languageDefinitionName) {
		return languageDefinitionName.substring(0, 1).toUpperCase() + languageDefinitionName.substring(1);
	}
	public static String getPackageName(String languageDefinitionName) {
		return languageDefinitionName + ".xdsml.api.impl";
	}
	
	public static String getFolderName(String languageDefinitionName) {
		return getPackageName(languageDefinitionName).replaceAll("\\.", "/");
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
		String languageToUpperFirst = getLanguageNameWithFirstUpper(ld.getName());
		String packageName = getPackageName(ld.getName());
		String folderName = getFolderName(ld.getName());
		if (ld.getDomainModelProject() != null) {
			String fileContent = BuilderTemplates.INITIALIZER_CLASS_TEMPLATE;
			fileContent = fileContent.replaceAll(Pattern.quote("${package.name}"), packageName);
			fileContent = fileContent.replaceAll(Pattern.quote("${language.name.toupperfirst}"), languageToUpperFirst);
			StringBuilder sb = new StringBuilder();
			sb.append("// TODO\n");
			fileContent = fileContent.replaceAll(Pattern.quote("${initializer.content}"), sb.toString());
			IFile file = project.getFile(Activator.EXTENSION_GENERATED_CLASS_FOLDER_NAME + folderName + "/"
					+ languageToUpperFirst + Activator.INITIALIZER_CLASS_NAMEPART + ".java");
			writeFile(file, fileContent);
		}
		// update plugin.xml
		IFile pluginfile = project.getFile(PluginXMLHelper.PLUGIN_FILENAME);
		PluginXMLHelper.createEmptyTemplateFile(pluginfile, false);
		PluginXMLHelper helper = new PluginXMLHelper();
		helper.loadDocument(pluginfile);
		Element gemocExtensionPoint = helper.getOrCreateExtensionPoint(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT);
		helper.updateXDSMLDefinitionAttributeInExtensionPoint(gemocExtensionPoint,
				LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_INITIALIZER_ATT, packageName + "."
						+ languageToUpperFirst + Activator.INITIALIZER_CLASS_NAMEPART);
		helper.saveDocument(pluginfile);

	}
	


	public static void writeFile(IFile file, String fileContent) {
		try {
			GFile.writeFile(file, fileContent);
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
	}
	
	/**
	 * create or replace existing CodeExecutorClass by an implementation that is
	 * able to execute method from the concrete DSA
	 * 
	 * @param project
	 * @param ld
	 */
	protected void updateSolverClass(IProject project, LanguageDefinition ld) {
		// TODO remove possible previous classes
		// create the java class
		String languageToUpperFirst = getLanguageNameWithFirstUpper(ld.getName());
		String packageName = getPackageName(ld.getName());
		String folderName = getFolderName(ld.getName());
		if (ld.getDomainModelProject() != null) {
			String fileContent = BuilderTemplates.SOLVER_CLASS_TEMPLATE;
			fileContent = fileContent.replaceAll(Pattern.quote("${package.name}"), packageName);
			fileContent = fileContent.replaceAll(Pattern.quote("${language.name.toupperfirst}"), languageToUpperFirst);
			fileContent = fileContent.replaceAll(Pattern.quote("${constructor.content}"), "super();");						
			IFile file = project
					.getFile(Activator.EXTENSION_GENERATED_CLASS_FOLDER_NAME
							+ folderName + "/" + languageToUpperFirst
							+ Activator.SOLVER_CLASS_NAMEPART + ".java");
			writeFile(file, fileContent);
		}
		// update plugin.xml
		IFile pluginfile = project.getFile(PluginXMLHelper.PLUGIN_FILENAME);
		PluginXMLHelper.createEmptyTemplateFile(pluginfile, false);
		PluginXMLHelper helper = new PluginXMLHelper();
		helper.loadDocument(pluginfile);
		Element gemocExtensionPoint = helper.getOrCreateExtensionPoint(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT);
		helper.updateXDSMLDefinitionAttributeInExtensionPoint(gemocExtensionPoint,
				LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_SOLVER_ATT, packageName + "." + languageToUpperFirst + Activator.SOLVER_CLASS_NAMEPART);
		helper.saveDocument(pluginfile);
	}
	
//	protected void updateECL(final IProject project, final ECLFile ecliFilePath, String rootElement) {
//		// TODO check that the ecl file exists
//		// update plugin.xml
//		IFile pluginfile = project.getFile(PluginXMLHelper.PLUGIN_FILENAME);
//		PluginXMLHelper.createEmptyTemplateFile(pluginfile, false);
//		PluginXMLHelper helper = new PluginXMLHelper();
//		helper.loadDocument(pluginfile);
//		Element gemocExtensionPoint = helper.getOrCreateExtensionPoint(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT);
//		helper.updateXDSMLDefinitionAttributeInExtensionPoint(gemocExtensionPoint,
//				LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_DSE_RESOURCE_PATH_ATT, ecliFilePath.getLocationURI());
//		helper.saveDocument(pluginfile);
//
//	}
	protected void updateQVTO(final IProject project, final String qvtoFileLocationUri, String rootElement) {	
		// update plugin.xml
		IFile pluginfile = project.getFile(PluginXMLHelper.PLUGIN_FILENAME);
		PluginXMLHelper.createEmptyTemplateFile(pluginfile, false);
		PluginXMLHelper helper = new PluginXMLHelper();
		helper.loadDocument(pluginfile);
		Element gemocExtensionPoint = helper.getOrCreateExtensionPoint(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT);
		helper.updateXDSMLDefinitionAttributeInExtensionPoint(
				gemocExtensionPoint,
				LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_TO_CCSL_QVTO_FILE_PATH_ATT,
				qvtoFileLocationUri);
		helper.saveDocument(pluginfile);

		// TODO check that the qvto file exists
		// The qvto file could be generated here but it exists already a GemocDSEBuilder.
		//IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(qvtoFilePath.getLocationURI()));
		//updateECL_QVTO(file);
	}

//	protected void updateECL_QVTO(final IFile eclFile) {				
//		if (eclFile.exists()) {
//			QVTOFileBuilder.buildFrom(eclFile);
//		}
//	}

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
