package org.gemoc.eclmoc.moc2as.builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

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
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.gemoc.eclmoc.moc2as.Activator;

import toools.io.file.RegularFile;
import fr.inria.aoste.timesquare.ecl.ecltoqvto.main.AcceleoLauncherForEclToQvto;

public class ECLMoc2ASBuilder extends IncrementalProjectBuilder {

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

	public static final String BUILDER_ID = "org.gemoc.eclmoc.moc2as.eclMoc2ASBuilder";

	private static final String MARKER_TYPE = "org.gemoc.eclmoc.moc2as.eclMoc2AsProblem";

	// private SAXParserFactory parserFactory;

	private void addMarker(IProject project, String message, int lineNumber,
			int severity) {
		try {
			IMarker marker = project.createMarker(MARKER_TYPE);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, severity);
			/*if (lineNumber == -1) {
				lineNumber = 1;
			}
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);*/
		} catch (CoreException e) {
			Activator.eclipseError(e.getMessage(), e);
		}
	}
	
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
			Activator.eclipseError(e.getMessage(), e);
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
		getProject().deleteMarkers(MARKER_TYPE, true, IResource.DEPTH_INFINITE);
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
		if(!propertyFile.exists()){
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
			Activator.eclipseError(e1.getMessage(), e1);
		} catch (CoreException e1) {
			Activator.eclipseError(e1.getMessage(), e1);
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
				final URI uri = URI.createPlatformResourceURI(
						eclFile.getLocationURI().toString(), true);
				final IFolder qvtoFolder = project.getFolder("qvto-gen");
				if(!qvtoFolder.exists())
				
				qvtoFolder.create(true, true, null);
			

				String folderPath = qvtoFolder.getLocation().toOSString();
				final File folder = new File(folderPath);
	
				final List<String> arguments = new ArrayList<String>();
				//LanguageDefinition ld = EObjectUtil.eContainerOfType(ecliFilePath, LanguageDefinition.class);
				String qvtoFileName = uri.lastSegment().replace(".ecl",	"_toCCSL.qvto");
				arguments.add(qvtoFileName);
				arguments.add(rootElement); 
				// create QVTO file
				ISafeRunnable runnable = new ISafeRunnable() {
					@Override
					public void handleException(Throwable e) {
						Activator.eclipseError(e.getMessage(), e);
					}
	
					@Override
					public void run() throws Exception {
	
						//ResourceUtil.createFolder(qvtoFolder, true, true, null);
	
						try {
							System.out.println("launching ecl to qvto:\n\turi=" + uri + "\n\tfolder=" + folder + "\n\targs="
									+ arguments);
							AcceleoLauncherForEclToQvto launcher = new AcceleoLauncherForEclToQvto(uri, folder, arguments);
							launcher.doGenerate(new BasicMonitor());
							qvtoFolder.refreshLocal(2, new NullProgressMonitor());
							
							
							RegularFile qvtoFile = new RegularFile(launcher.getTargetFolder()+"/" +arguments.get(0));
							String qvtoContent = new String(qvtoFile.getContent());
							qvtoContent = qvtoContent.replaceAll("platform:/resource", "platform:/plugin");
							qvtoFile.setContent(qvtoContent.getBytes());
							
							
							
						} catch (IOException e) {
							addMarker(eclFile, e.getMessage(), -1, IMarker.SEVERITY_ERROR);
							Activator.eclipseError(e.getMessage(), e);
						}
					}
				};
				SafeRunner.run(runnable);
			} catch (CoreException e1) {

				Activator.eclipseError(e1.getMessage(), e1);
			} catch (IOException e1) {

				addMarker(eclFile, e1.getMessage(), 0, IMarker.SEVERITY_ERROR);
				Activator.eclipseError(e1.getMessage(), e1);
			}
		}
	}

	private void deleteMarkers(IResource file) {
		try {
			file.deleteMarkers(MARKER_TYPE, false, IResource.DEPTH_ZERO);
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
