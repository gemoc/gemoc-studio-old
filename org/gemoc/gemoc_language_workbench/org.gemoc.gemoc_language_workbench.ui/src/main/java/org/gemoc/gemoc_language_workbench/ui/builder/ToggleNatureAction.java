package org.gemoc.gemoc_language_workbench.ui.builder;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.gemoc.commons.eclipse.core.resources.NatureToggling;
import org.gemoc.commons.eclipse.core.resources.Project;
import org.gemoc.commons.eclipse.pde.ManifestChanger;
import org.gemoc.commons.eclipse.pde.ui.PluginConverter;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtensionPoint;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.impl.confFactoryImpl;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.builder.pde.PluginXMLHelper;
import org.jdom2.Element;
import org.osgi.framework.BundleException;

public class ToggleNatureAction implements IObjectActionDelegate {

	private ISelection selection;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) 
	{
		if (selection instanceof IStructuredSelection) 
		{
			for (Iterator<?> it = ((IStructuredSelection) selection).iterator(); it.hasNext();) 
			{
				Object element = it.next();
				IProject project = null;
				if (element instanceof IProject) {
					project = (IProject) element;
				} else if (element instanceof IAdaptable) {
					project = (IProject) ((IAdaptable) element).getAdapter(IProject.class);
				}
				if (project != null) {
					// [FT] Use the AskLanguaeName wizard here because the name of the project may contain some bad characters.
					toggleNature(project, project.getName());
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * Toggles sample nature on a project
	 * 
	 * @param project
	 *            to have sample nature added or removed
	 */
	public void toggleNature(IProject project, String languageName) 
	{
		try 
		{
			NatureToggling result = Project.toggleNature(project, GemocLanguageDesignerNature.NATURE_ID);
			switch (result) {
				case Added:
					Project.addJavaNature(project);
					addPluginNature(project);
					addGemocNature(project, languageName);
					break;
				case Removed:
					break;	
				default:
					break;
			}
		} 
		catch (CoreException | IOException e) 
		{
			Activator.error("Problem while adding Gemoc Language nature to project. " + e.getMessage(), e);
		} 
	}
	
	public static void addNature(IProject project,String natureID, IProgressMonitor monitor) throws CoreException {
		if (monitor != null && monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
		if (!project.hasNature(natureID)) {
			IProjectDescription description = project.getDescription();
			String[] prevNatures= description.getNatureIds();
			String[] newNatures= new String[prevNatures.length + 1];
			System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
			newNatures[prevNatures.length]= natureID;
			description.setNatureIds(newNatures);
			project.setDescription(description, monitor);
		} else {
			if (monitor != null) {
				monitor.worked(1);
			}
		}
	}

	private void addPluginNature(IProject project) throws CoreException {
		if(!project.hasNature("org.eclipse.pde.PluginNature")) 
		{
			try {
				// create first the plugin.xml file
				PluginXMLHelper.createEmptyTemplateFile(project.getFile(PluginXMLHelper.PLUGIN_FILENAME), false);					
				// convert to plugin and add necessary entries in the build.properties
				PluginConverter.convert(project);
				// complement manifest
				ManifestChanger changer = new ManifestChanger(project);
				changer.addPluginDependency(org.gemoc.gemoc_language_workbench.api.Activator.PLUGIN_ID, "0.1.0", true, true);
				changer.addPluginDependency("org.eclipse.emf.ecore.xmi", "2.8.0", true, true);				
				changer.addPluginDependency("org.gemoc.gemoc_language_workbench.api");
				changer.addPluginDependency("org.gemoc.execution.engine");
				changer.addPluginDependency("org.gemoc.execution.engine.commons");
				changer.addSingleton();
				changer.addAttributes("Bundle-RequiredExecutionEnvironment","JavaSE-1.6");
				changer.commit();					
			} 
			catch (InvocationTargetException | InterruptedException | IOException | BundleException e) 
			{
				Activator.error("cannot add org.eclipse.pde.PluginNature nature to project due to " + e.getMessage(), e);
			}								
		}
	}
	
	private void addGemocNature(IProject project, String languageName)
			throws CoreException {
		addAsMainNature(project, GemocLanguageDesignerNature.NATURE_ID, null);
		addMissingResourcesToNature(project, languageName);
		createTemplateCodeExecutorClass(project, languageName);
	}

	// add the nature making sure this will be the first
	public static void addAsMainNature(IProject project, String natureID, IProgressMonitor monitor) throws CoreException{
		if (monitor != null && monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
		if (!project.hasNature(natureID)) {
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 1, natures.length);
			newNatures[0] = natureID;
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
		} else {
			if (monitor != null) {
				monitor.worked(1);
			}
		}
	}
	
	private void addMissingResourcesToNature(IProject project, String languageName) {
		IFile configFile = project.getFile(new Path(Activator.GEMOC_PROJECT_CONFIGURATION_FILE)); 
		if(!configFile.exists()) {
			Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
		    Map<String, Object> m = registry.getExtensionToFactoryMap();
		    m.put(Activator.GEMOC_PROJECT_CONFIGURATION_FILE_EXTENSION, new XMIResourceFactoryImpl());

		    // Obtain a new resource set
		    ResourceSet resSet = new ResourceSetImpl();

		    // Create the resource
		    Resource resource = resSet.createResource(URI.createURI(configFile.getLocationURI().toString()));
		    // Creates default root elements,
		    LanguageDefinition ld = confFactoryImpl.eINSTANCE.createLanguageDefinition();
		    ld.setName(languageName);
		    resource.getContents().add(ld);	
			
			try {
				resource.save(null);
			} catch (IOException e) {
				Activator.error(e.getMessage(), e);
			}
		}
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}			
	}
	
	
	
	/**
	 * 
	 * If no code executor is defined in the plugin.xml
	 * create or replace existing CodeExecutorClass by an implementation that is
	 * able to execute method from the concrete DSA
	 * 
	 * @param project
	 * @param ld
	 */
	protected void createTemplateCodeExecutorClass(IProject project, String languageDefinitionName) {
		IFile pluginfile = project.getFile(PluginXMLHelper.PLUGIN_FILENAME);
		if(!pluginfile.exists()) PluginXMLHelper.createEmptyTemplateFile(pluginfile, false);
		PluginXMLHelper helper = new PluginXMLHelper();
		helper.loadDocument(pluginfile);
		Element gemocExtensionPoint = helper.getOrCreateExtensionPoint(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT);
		String currentExecutor = helper.getXDSMLDefinitionAttributeInExtensionPointValue(gemocExtensionPoint,
				LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_CODEEXECUTOR_ATT);
		if(currentExecutor == null || currentExecutor.isEmpty()){
		
			// TODO remove possible previous classes
			// create the java class
			String languageToUpperFirst = GemocLanguageDesignerBuilder.getLanguageNameWithFirstUpper(languageDefinitionName);
			String packageName = GemocLanguageDesignerBuilder.getPackageName(languageDefinitionName);
			String folderName = GemocLanguageDesignerBuilder.getFolderName(languageDefinitionName);
			
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
			
			sbContent.append("// add K3 DSA specific executor\n");
			sbContent.append("\t\taddExecutor(new org.gemoc.gemoc_language_workbench.extensions.k3.dsa.impl.Kermeta3AspectsCodeExecutor(this,\n");
			sbContent.append("\t\t\tgetDSAProjectName()));\n");
				
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
			
			GemocLanguageDesignerBuilder.writeFile(file, fileContent);
			//ResourceUtil.writeFile(file, fileContent);
			
			// update plugin.xml
			
			helper.updateXDSMLDefinitionAttributeInExtensionPoint(gemocExtensionPoint,
					LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_CODEEXECUTOR_ATT, packageName + "."
							+ languageToUpperFirst + Activator.CODEEXECUTOR_CLASS_NAMEPART);
			helper.saveDocument(pluginfile);
		}

	}

}
