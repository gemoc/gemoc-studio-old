package org.gemoc.gemoc_language_workbench.ui.builder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.xml.parsers.SAXParserFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
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
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.builder.pde.PluginXMLHelper;
import org.jdom2.Element;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class GemocLanguageDesignerBuilder extends IncrementalProjectBuilder {

	class LanguageProjectDeltaVisitor implements IResourceDeltaVisitor {
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
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
			//return true to continue visiting children.
			return true;
		}
	}

	class LanguageProjectResourceVisitor implements IResourceVisitor {
		public boolean visit(IResource resource) {
			updateProjectPersistentProperties(resource);
			updateProjectPluginConfiguration(resource);
			//return true to continue visiting children.
			return true;
		}
	}

	class XMLErrorHandler extends DefaultHandler {
		
		private IFile file;

		public XMLErrorHandler(IFile file) {
			this.file = file;
		}

		private void addMarker(SAXParseException e, int severity) {
			GemocLanguageDesignerBuilder.this.addMarker(file, e.getMessage(), e
					.getLineNumber(), severity);
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

	private SAXParserFactory parserFactory;

	private void addMarker(IFile file, String message, int lineNumber,
			int severity) {
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
	 *      java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor)
			throws CoreException {
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

	
	private void updateProjectPersistentProperties(IResource resource){
		if (resource instanceof IFile && resource.getName().equals(Activator.GEMOC_PROJECT_CONFIGURATION_FILE)) {
			IFile file = (IFile) resource;
			IProject project = file.getProject();
			try {
				if(file.exists()){

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
						if(eObject instanceof org.gemoc.gemoc_language_workbench.conf.DomainModelProject){
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_DOMAINMODEL), "true");
						}
						if(eObject instanceof org.gemoc.gemoc_language_workbench.conf.DSAProject){
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_DSA), "true");
						}
						if(eObject instanceof org.gemoc.gemoc_language_workbench.conf.DSEProject){
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_DSE), "true");
						}
						if(eObject instanceof org.gemoc.gemoc_language_workbench.conf.MoCProject){
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_MOC), "true");
						}
						if(eObject instanceof org.gemoc.gemoc_language_workbench.conf.EditorProject){
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_EDITOR), "true");
						}
						if(eObject instanceof org.gemoc.gemoc_language_workbench.conf.AnimatorProject){
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_ANIMATOR), "true");
						}
					}
				}
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}
			
		}
	}
	
	private void removePersistentProperties(IResource resource){
		if (resource instanceof IFile && resource.getName().equals(Activator.GEMOC_PROJECT_CONFIGURATION_FILE)) {
			IFile file = (IFile) resource;
			resetPersistentProperties(file.getProject());
		}
	}
	private void resetPersistentProperties(IProject project ){
		try {
			project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_DOMAINMODEL), null);
			project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_DSA), null);
			project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_DSE), null);
			project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_MOC), null);
			project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_EDITOR), null);
			project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_ANIMATOR), null);
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Update plugin.xml according to the model
	 * @param resource
	 */
	private void updateProjectPluginConfiguration(IResource resource){
		if (resource instanceof IFile && resource.getName().equals(Activator.GEMOC_PROJECT_CONFIGURATION_FILE)) {
			IFile file = (IFile) resource;
			IProject project = file.getProject();
		//	try {
				if(file.exists()){

					
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
						/*if(eObject instanceof org.gemoc.gemoc_language_workbench.conf.DomainModelProject){
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_DOMAINMODEL), "true");
						}
						if(eObject instanceof org.gemoc.gemoc_language_workbench.conf.DSAProject){
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_DSA), "true");
						}
						if(eObject instanceof org.gemoc.gemoc_language_workbench.conf.DSEProject){
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_DSE), "true");
						}
						if(eObject instanceof org.gemoc.gemoc_language_workbench.conf.MoCProject){
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_MOC), "true");
						}
						if(eObject instanceof org.gemoc.gemoc_language_workbench.conf.EditorProject){
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_EDITOR), "true");
						}
						if(eObject instanceof org.gemoc.gemoc_language_workbench.conf.AnimatorProject){
							project.setPersistentProperty(new QualifiedName(Activator.PLUGIN_ID, Activator.GEMOC_PROJECT_PROPERTY_HAS_ANIMATOR), "true");
						}*/
						if(eObject instanceof LanguageDefinition){
							changePluginLanguageName(project, ((LanguageDefinition)eObject).getName());
						}
					}
				}
			/*} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}*/
			
		}
	}
	
	
	private void changePluginLanguageName(IProject project, final String languageName){
		IFile pluginfile = project.getFile(PluginXMLHelper.PLUGIN_FILENAME);
		PluginXMLHelper.createEmptyTemplateFile(pluginfile, false);
		PluginXMLHelper helper = new PluginXMLHelper();
		helper.loadDocument(pluginfile);
		Element gemocExtensionPoint = helper.getOrCreateExtensionPoint(Activator.GEMOC_LANGUAGE_EXTENSION_POINT_NAME);
		helper.updateXDSMLDefinitionInExtensionPoint(gemocExtensionPoint, languageName);
		helper.saveDocument(pluginfile);		
	}
	
	private void deleteMarkers(IFile file) {
		try {
			file.deleteMarkers(MARKER_TYPE, false, IResource.DEPTH_ZERO);
		} catch (CoreException ce) {
		}
	}

	protected void fullBuild(final IProgressMonitor monitor)
			throws CoreException {
		try {
			// need to check if build is realy required because it seems to be called on each eclipse startup ? more debug analysis required ...
			getProject().accept(new LanguageProjectResourceVisitor());
		} catch (CoreException e) {
		}
	}


	protected void incrementalBuild(IResourceDelta delta,
			IProgressMonitor monitor) throws CoreException {
		// the visitor does the work.
		delta.accept(new LanguageProjectDeltaVisitor());
	}
	
	
	
	//TODO move to othe place
	public String readFully(InputStream inputStream, String encoding)
	        throws IOException {
	    return new String(readFully(inputStream), encoding);
	}    

	private byte[] readFully(InputStream inputStream)
	        throws IOException {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    byte[] buffer = new byte[1024];
	    int length = 0;
	    while ((length = inputStream.read(buffer)) != -1) {
	        baos.write(buffer, 0, length);
	    }
	    return baos.toByteArray();
	}


	
	
}
