package org.gemoc.gemoc_language_workbench.ui.builder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

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
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.pde.internal.ui.wizards.tools.ConvertProjectToPluginOperation;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.impl.confFactoryImpl;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.builder.pde.PluginXMLHelper;
import org.gemoc.gemoc_language_workbench.utils.pde.ManifestChanger;
import org.gemoc.gemoc_language_workbench.utils.resource.ResourceUtil;
import org.osgi.framework.BundleException;

public class ToggleNatureAction implements IObjectActionDelegate {

	private ISelection selection;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		if (selection instanceof IStructuredSelection) {
			for (Iterator it = ((IStructuredSelection) selection).iterator(); it
					.hasNext();) {
				Object element = it.next();
				IProject project = null;
				if (element instanceof IProject) {
					project = (IProject) element;
				} else if (element instanceof IAdaptable) {
					project = (IProject) ((IAdaptable) element)
							.getAdapter(IProject.class);
				}
				if (project != null) {
					toggleNature(project);
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
	public void toggleNature(IProject project) {
		try {
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();

			for (int i = 0; i < natures.length; ++i) {
				if (GemocLanguageDesignerNature.NATURE_ID.equals(natures[i])) {
					// Remove the nature
					String[] newNatures = new String[natures.length - 1];
					System.arraycopy(natures, 0, newNatures, 0, i);
					System.arraycopy(natures, i + 1, newNatures, i,
							natures.length - i - 1);
					description.setNatureIds(newNatures);
					project.setDescription(description, null);
					return;
				}
			}

			// add java nature
			if(!project.hasNature(JavaCore.NATURE_ID)){
				IJavaProject javaProject = JavaCore.create(project);
				addNature(project, JavaCore.NATURE_ID, null);
				//CoreUtility.createFolder(project.getFolder(new Path("src"));, true, true, new SubProgressMonitor(monitor, 2));*
				ResourceUtil.createFolder(project.getFolder(new Path("src/main/java")), true, true, new NullProgressMonitor());
				ResourceUtil.createFolder(project.getFolder(new Path("src/main/xdsml-java-gen")), true, true, new NullProgressMonitor());
				addJavaResources(project);
			}
				
			//  add the plugin nature (not removed)
			if(!project.hasNature("org.eclipse.pde.PluginNature")){

				IRunnableWithProgress convertOperation;
				convertOperation = new ConvertProjectToPluginOperation(new IProject[]{project}, false);
				try {
					convertOperation.run(new NullProgressMonitor());
					// complement manifest
					IFile manifestFile = project.getFile(new Path("META-INF/MANIFEST.MF"));
					ManifestChanger mfChanger = new ManifestChanger(manifestFile);	
					
					mfChanger.addPluginDependency(Activator.PLUGIN_ID, "0.1.0", true, true);
					mfChanger.addPluginDependency("org.eclipse.emf.ecore.xmi", "2.8.0", true, true);
					mfChanger.addSingleton();
					mfChanger.addAttributes("Bundle-RequiredExecutionEnvironment","JavaSE-1.6");
					
					mfChanger.writeManifest(manifestFile);
					
					PluginXMLHelper.createEmptyTemplateFile(project.getFile(PluginXMLHelper.PLUGIN_FILENAME), false);
					
				} catch (InvocationTargetException e) {
					Activator.error("cannot add org.eclipse.pde.PluginNature nature to project due to "+e.getMessage(), e);
				} catch (InterruptedException e) {
					Activator.error("cannot add org.eclipse.pde.PluginNature nature to project due to "+e.getMessage(), e);
				} catch (IOException e) {
					Activator.error("cannot add org.eclipse.pde.PluginNature nature to project due to "+e.getMessage(), e);
				} catch (BundleException e) {
					Activator.error("cannot add org.eclipse.pde.PluginNature nature to project due to "+e.getMessage(), e);
				}
				
				
			}
			

					
			// Add the nature
			addAsMainNature(project, GemocLanguageDesignerNature.NATURE_ID, null);
			addMissingResourcesToNature(project);
		} catch (CoreException e) {
			Activator.warn("Problem while adding Gemoc Language nature to project. "+e.getMessage(), e);
		}
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
	
	private void addMissingResourcesToNature(IProject project) {
		IFile configFile = project.getFile(new Path(Activator.GEMOC_PROJECT_CONFIGURATION_FILE)); 
		if(!configFile.exists()){
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		    Map<String, Object> m = reg.getExtensionToFactoryMap();
		    m.put(Activator.GEMOC_PROJECT_CONFIGURATION_FILE_EXTENSION, new XMIResourceFactoryImpl());

		    // Obtain a new resource set
		    ResourceSet resSet = new ResourceSetImpl();

		    // Create the resource
		    Resource resource = resSet.createResource(URI.createURI(configFile.getLocationURI().toString()));
		    // Creates default root elements,
		    GemocLanguageWorkbenchConfiguration gemocLanguageWorkbenchConfiguration = confFactoryImpl.eINSTANCE.createGemocLanguageWorkbenchConfiguration();
		    LanguageDefinition ld =confFactoryImpl.eINSTANCE.createLanguageDefinition();
		    ld.setName(project.getName());
		    gemocLanguageWorkbenchConfiguration.getLanguageDefinitions().add(ld);
		    resource.getContents().add(gemocLanguageWorkbenchConfiguration);
		    			
			
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
	
	public static final String CLASSPATH_TEMPLATE= "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
"<classpath>\n"+
"	<classpathentry kind=\"src\" path=\"src/main/java\"/>\n"+
"	<classpathentry kind=\"src\" path=\"src/main/xdsml-java-gen\"/>\n"+
"	<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6\"/>\n"+
"	<classpathentry kind=\"output\" path=\"bin\"/>\n"+
"</classpath>";
	
	private void addJavaResources(IProject project) {
		final IFile file = project.getFile(new Path(".classpath")); 
		if(!file.exists()){	
			try {
				InputStream stream = new ByteArrayInputStream(CLASSPATH_TEMPLATE.getBytes());
				if (file.exists()) {
					file.setContents(stream, true, true, null);
				} else {
					file.create(stream, true, null);
				}
				stream.close();
			} catch (IOException e) {
				Activator.error(e.getMessage(), e);
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}
		}
	}
	

	

}
