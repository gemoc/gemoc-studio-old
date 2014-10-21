package org.gemoc.gemoc_language_workbench.ui.dse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.gemoc.commons.eclipse.core.resources.Marker;
import org.gemoc.commons.eclipse.core.resources.Project;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import toools.io.file.RegularFile;
import fr.inria.aoste.timesquare.ecl.ecltoqvto.main.AcceleoLauncherForEclToQvto;

public class GemocDSEBuilder extends IncrementalProjectBuilder {

	class SampleDeltaVisitor implements IResourceDeltaVisitor {
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
				processResource(resource);
				break;
			case IResourceDelta.REMOVED:
				// handle removed resource
				break;
			case IResourceDelta.CHANGED:
				// handle changed resource
				processResource(resource);
				break;
			}
			//return true to continue visiting children.
			return true;
		}
	}

	class Moc2ASProjectResourceVisitor implements IResourceVisitor {
		public boolean visit(IResource resource) {
			processResource(resource);
			//return true to continue visiting children.
			return true;
		}
	}

	/*class ECLErrorHandler extends DefaultHandler {
		
		private IFile file;

		public ECLErrorHandler(IFile file) {
			this.file = file;
		}

		private void addMarker(SAXParseException e, int severity) {
			ECLMoc2ASBuilder.this.addMarker(file, e.getMessage(), e
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
	}*/

	public static final String BUILDER_ID = "org.gemoc.gemoc_language_workbench.ui.dse_builder";

	public static final String MARKER_TYPE = "org.gemoc.gemoc_language_workbench.ui.dse_problem";

	// private SAXParserFactory parserFactory;

	private void addMarker(IResource resource, String message, int lineNumber, int severity) {
		try {
			Marker.addMarker(resource, MARKER_TYPE, message, severity);
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
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

	protected void clean(IProgressMonitor monitor) throws CoreException {
		// delete markers set and files created
		Marker.removeMarkers(getProject(), MARKER_TYPE);
	}

	protected void processResource(IResource resource){
		if (resource instanceof IFile && resource.getName().equals("moc2as.properties")) {
			checkProjectProperties((IFile) resource);
		}
		else if (resource instanceof IProject)  {
			checkProjectMinimalContent((IProject) resource);
		}
		else if(resource instanceof IFile && resource.getName().endsWith(".ecl")){
			updateQVTOFromECL(resource);
		}
	}
	
	protected void checkProjectMinimalContent(IProject project) {
		deleteMarkers(project);
		IFile propertyFile = (IFile) project.getFile("moc2as.properties");
		if(!propertyFile.exists())
		{
			addMarker(project, "Missing moc2as.properties, cannot generate qvto", -1, IMarker.SEVERITY_ERROR);
			return;
		}
	}
	
	protected void checkProjectProperties(IFile propertyFile) {
		checkProjectMinimalContent(propertyFile.getProject());
		deleteMarkers(propertyFile);
		Properties properties = new Properties();
		try {
			properties.load(propertyFile.getContents());
		
			String rootElement = properties.getProperty("rootElement");
			if(rootElement==null || rootElement.isEmpty()){
				addMarker(propertyFile, "rootElement not defined in moc2as.properties, cannot generate qvto", -1, IMarker.SEVERITY_ERROR);
				return;
			}
		} catch (IOException e1) {
			Activator.error(e1.getMessage(), e1);
		} catch (CoreException e1) {
			Activator.error(e1.getMessage(), e1);
		}
	}
	
	void updateQVTOFromECL(IResource resource) {		
		if (resource instanceof IFile && resource.getName().endsWith(".ecl")) {
			IProject project = resource.getProject();
			final IFile eclFile = (IFile) resource;
			deleteMarkers(eclFile);
			
			
			IFile propertyFile = (IFile) resource.getProject().getFile("moc2as.properties");
			if(!propertyFile.exists()){
				//addMarker(resource.getProject(), "Missing moc2as.properties, cannot generate qvto", -1, IMarker.SEVERITY_ERROR);
				return;
			}
			try {
				Properties properties = new Properties();
				properties.load(propertyFile.getContents());
				String rootElement = properties.getProperty("rootElement");
				if(rootElement==null || rootElement.isEmpty()){
					//addMarker(eclFile, "rootElement not defined in moc2as.properties, cannot generate qvto", -1, IMarker.SEVERITY_WARNING);
					return;
				}
				String uristring = eclFile.getLocation().toOSString();
			    final URI uri = URI.createFileURI(uristring);
			    
			    String genFolder = "qvto-gen";
			    final IFolder modelingFolder = Project.createFolder(project, genFolder + "/modeling");			    	
			    final IFolder languageFolder = Project.createFolder(project, genFolder + "/language");			    	

			    final String qvtoFileName = eclFile.getFullPath()
			    					.removeFileExtension()
			    					.addFileExtension("qvto")
			    					.lastSegment();
//			    uri.lastSegment().replace(".ecl",	"_toCCSL.qvto");
//			    final IFile modelingFile = modelingFolder.getFile(new )
			    
			    
//				final IFolder qvtoFolder = project.getFolder("qvto-gen");
//				if(!qvtoFolder.exists()) qvtoFolder.create(true, true, null);
			

//				String folderPath = qvtoFolder.getLocation().toOSString();
	//			final File folder = new File(folderPath);
	
			    
			    
			    
				final List<String> arguments = new ArrayList<String>();
				//LanguageDefinition ld = EObjectUtil.eContainerOfType(ecliFilePath, LanguageDefinition.class);
				//String qvtoFileName = uri.lastSegment().replace(".ecl",	"_toCCSL.qvto");
				arguments.add(qvtoFileName);
				arguments.add(rootElement); 
				// create QVTO file
				ISafeRunnable runnable = new ISafeRunnable() {
					@Override
					public void handleException(Throwable e) {
						Activator.error(e.getMessage(), e);
					}
	
					@Override
					public void run() throws Exception {
	
						//ResourceUtil.createFolder(qvtoFolder, true, true, null);
	
						try {
							System.out.println("launching ecl to qvto:\n\turi=" + uri + "\n\tfolder=" + languageFolder + "\n\targs="
									+ arguments);
							AcceleoLauncherForEclToQvto launcher = new AcceleoLauncherForEclToQvto(uri, new File(languageFolder.getLocation().toOSString()), arguments);
							launcher.doGenerate(new BasicMonitor());
							
							IFile qvtoFileForLanguage = languageFolder.getFile(qvtoFileName);
							qvtoFileForLanguage.refreshLocal(0, new NullProgressMonitor());

							IFile qvtoFileForModeling = modelingFolder.getFile(qvtoFileName);
									
							RegularFile reg_qvtoFileForLanguage = new RegularFile(qvtoFileForLanguage.getLocation().toOSString());
							RegularFile reg_qvtoFileForModeling = new RegularFile(qvtoFileForModeling.getLocation().toOSString());
							
							String qvtoLanguageContent = new String(reg_qvtoFileForLanguage.getContent());
							String qvtoModelingContent = qvtoLanguageContent.replaceAll("platform:/resource", "platform:/plugin");
							reg_qvtoFileForModeling.setContent(qvtoModelingContent.getBytes());
								
							qvtoFileForModeling.refreshLocal(0, new NullProgressMonitor());
									
									
//									.refreshLocal(0, new NullProgressMonitor());
							
							
//							qvtoFolder.refreshLocal(2, new NullProgressMonitor());
							
							
							
							
							
						} catch (IOException e) {
							addMarker(eclFile, e.getMessage(), -1, IMarker.SEVERITY_ERROR);
							Activator.error(e.getMessage(), e);
						}
					}
				};
				SafeRunner.run(runnable);
			} catch (CoreException e1) {

				Activator.error(e1.getMessage(), e1);
			} catch (IOException e1) {

				addMarker(eclFile, e1.getMessage(), 0, IMarker.SEVERITY_ERROR);
				Activator.error(e1.getMessage(), e1);
			}
		}
	}

	private void deleteMarkers(IResource file) {
		try {
			Marker.removeMarkers(file, MARKER_TYPE);
		} catch (CoreException ce) {
		}
	}

	protected void fullBuild(final IProgressMonitor monitor)
			throws CoreException {
		try {
			getProject().accept(new Moc2ASProjectResourceVisitor());
		} catch (CoreException e) {
		}
	}

	protected void incrementalBuild(IResourceDelta delta,
			IProgressMonitor monitor) throws CoreException {
		// the visitor does the work.
		delta.accept(new SampleDeltaVisitor());
	}
}
