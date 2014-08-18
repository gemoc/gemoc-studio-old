package org.gemoc.dse.ecl.moc2as.ui.builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.gemoc.dse.ecl.moc2as.ui.Activator;
import org.gemoc.gemoc_commons.core.resources.GFile;
import org.gemoc.gemoc_commons.core.resources.Project;

import toools.io.file.RegularFile;
import fr.inria.aoste.timesquare.ecl.ecltoqvto.main.AcceleoLauncherForEclToQvto;

public class QVTOFileBuilder {

	static public void buildFrom(final IFile eclFile) {
		if (eclFile.getFileExtension().equals(".ecl")) {
			IProject project = eclFile.getProject();			
			IFile propertyFile = (IFile) eclFile.getProject().getFile("moc2as.properties");
			if(!propertyFile.exists())
			{
				//addMarker(resource.getProject(), "Missing moc2as.properties, cannot generate qvto", -1, IMarker.SEVERITY_ERROR);
				return;
			}
			try {
				Properties properties = new Properties();
				properties.load(propertyFile.getContents());
				String rootElement = properties.getProperty("rootElement");
				if(rootElement == null 
					|| rootElement.isEmpty())
				{
					//addMarker(eclFile, "rootElement not defined in moc2as.properties, cannot generate qvto", -1, IMarker.SEVERITY_WARNING);
					return;
				}
				String uristring = eclFile.getLocation().toOSString();
			    final URI uri = URI.createFileURI(uristring);
			    final IFolder qvtoFolder = Project.createFolder(project, "qvto-gen");		    		
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
							GFile.addMarker(eclFile, GemocDSEBuilder.MARKER_TYPE, e.getMessage(), IMarker.SEVERITY_ERROR);
							Activator.eclipseError(e.getMessage(), e);
						}
					}
				};
				SafeRunner.run(runnable);
			} catch (CoreException e1) {
				Activator.eclipseError(e1.getMessage(), e1);
			} catch (IOException e1) {
				//GFile.addMarker(eclFile, GemocDSEBuilder.MARKER_TYPE, e1.getMessage(), IMarker.SEVERITY_ERROR);
				Activator.eclipseError(e1.getMessage(), e1);
			}
		}
	}
	
}
