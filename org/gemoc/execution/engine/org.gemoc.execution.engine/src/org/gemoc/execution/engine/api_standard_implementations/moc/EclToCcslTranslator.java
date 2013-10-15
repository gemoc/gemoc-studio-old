package org.gemoc.execution.engine.api_standard_implementations.moc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.SaveOptions.Builder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.gemoc.execution.engine.Activator;
import org.gemoc.gemoc_language_workbench.api.moc.ModelOfExecutionBuilder;
import org.gemoc.gemoc_language_workbench.utils.resource.ResourceUtil;

import com.google.inject.Injector;

import fr.inria.aoste.timesquare.ccslkernel.parser.xtext.ExtendedCCSLStandaloneSetup;
import fr.inria.aoste.timesquare.ecl.ecltoqvto.main.AcceleoLauncherForEclToQvto;

public class EclToCcslTranslator implements ModelOfExecutionBuilder {
	private IFile qvtoFile = null;
	private XtextResourceSet aModelResourceSet = null;
	private XtextResourceSet outputResourceSet = null;

	// TODO fix this class
	public EclToCcslTranslator(final Resource domainSpecificEventsResource) {
		super();
		//
		// // Taken from
		// //
		// //
		// org.gemoc.gemoc_language_workbench.ui.builder.GemocLanguageDesignerBuilder
		// // create QVTO file
		//
		// IProject project =
		// WorkspaceSynchronizer.getFile(domainSpecificEventsResource).getProject();
		// final URI uri = domainSpecificEventsResource.getURI();
		// final IFolder qvtoFolder = project.getFolder("qvto-gen");
		//
		// String folderPath = qvtoFolder.getLocation().toOSString();
		// final File folder = new File(folderPath);
		//
		// final List<String> arguments = new ArrayList<String>();
		// String qvtoFileName = "truc_toCCSL.qvto";
		// arguments.add(qvtoFileName);
		//
		// ISafeRunnable runnable = new ISafeRunnable() {
		// @Override
		// public void handleException(Throwable e) {
		// Activator.error(e.getMessage(), e);
		// }
		//
		// @Override
		// public void run() throws Exception {
		//
		// ResourceUtil.createFolder(qvtoFolder, true, true, null);
		//
		// try {
		// Activator.getMessagingSystem().debug("launching ecl to qvto:\n\turi="
		// + uri + "\n\tfolder=" + folder + "\n\targs="
		// + arguments, Activator.PLUGIN_ID);
		// AcceleoLauncherForEclToQvto launcher = new
		// AcceleoLauncherForEclToQvto(uri, folder, arguments);
		// launcher.doGenerate(new BasicMonitor());
		// qvtoFolder.refreshLocal(2, new NullProgressMonitor());
		// } catch (IOException e) {
		// Activator.error(e.getMessage(), e);
		// }
		// }
		// };
		// SafeRunner.run(runnable);
		//
		// this.qvtoFile = (IFile)
		// ResourcesPlugin.getWorkspace().getRoot().findMember(qvtoFileName);
	}

	@Override
	public Resource build(Resource domainSpecificEventsResource, Resource modelResource) {
		// initializeXtext();
		//
		// URI modelURI = modelResource.getURI();
		// String modelUriString = modelURI.toPlatformString(true);
		//
		// // qvto uri
		// String qvtoUriString = qvtoFile.getLocation().toOSString();
		// URI transformationURI = URI.createFileURI(qvtoUriString);
		//
		// HashMap<Object, Object> saveOptions = new HashMap<Object, Object>();
		// Builder aBuilder = SaveOptions.newBuilder();
		// SaveOptions anOption = aBuilder.getOptions();
		// anOption.addTo(saveOptions);
		// try {
		// modelResource.load(saveOptions);
		// } catch (IOException e1) {
		// Activator.error("IOException", e1);
		// }
		//
		// // transformationURI is the URI of qvto file
		// TransformationExecutor executor = new
		// TransformationExecutor(transformationURI);
		//
		// // inResource have the vaule of inModel
		// ModelExtent input = new
		// BasicModelExtent(modelResource.getContents());
		// ModelExtent output = new BasicModelExtent();
		//
		// ExecutionContextImpl context = new ExecutionContextImpl();
		//
		// ExecutionDiagnostic diagnostic = executor.execute(context, input,
		// output);
		// System.out.println(diagnostic);
		// // output resource saving
		// int numberOfCharToRemove = modelUriString.length() -
		// modelURI.fileExtension().length() - 1;
		// String outputPathString = modelUriString.substring(0,
		// numberOfCharToRemove) + "_ModelOfExecution.extendedCCSL";
		// URI outputUri = URI.createPlatformResourceURI(outputPathString,
		// false);
		// Resource outputResource = null;
		// try {
		// outputResource = outputResourceSet.createResource(outputUri);
		// } catch (Exception e) {
		// System.out.println(e);
		// outputResource = outputResourceSet.createResource(outputUri);
		//
		// // outputResource = outputResourceSet.getResource(outputUri,true);
		// }
		// ;
		// outputResource.getContents().addAll(output.getContents());
		// try {
		// outputResource.save(null);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// return outputResource;
		return null;
	}

	/**
	 * just initialization stuff from xtext for an ecl resource
	 */
	private void initializeXtext() {
		ExtendedCCSLStandaloneSetup ess = new ExtendedCCSLStandaloneSetup();
		Injector injector = ess.createInjector();
		// instanciate a resource set
		aModelResourceSet = injector.getInstance(XtextResourceSet.class);
		outputResourceSet = injector.getInstance(XtextResourceSet.class);
		// set.setClasspathURIContext(getClasspathURIContext());
		aModelResourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		ExtendedCCSLStandaloneSetup.doSetup();
	}

}