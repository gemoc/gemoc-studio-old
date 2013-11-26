package org.gemoc.execution.engine.api_standard_implementations.moc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SafeRunner;
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

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.google.inject.Injector;

import fr.inria.aoste.timesquare.ccslkernel.parser.xtext.ExtendedCCSLStandaloneSetup;
import fr.inria.aoste.timesquare.ecl.ecltoqvto.main.AcceleoLauncherForEclToQvto;

// TODO: here the code to generate the .extendedccsl from ecl + xmi
public class EclToCcslTranslator implements ModelOfExecutionBuilder {
	private XtextResourceSet aModelResourceSet = null;
	private XtextResourceSet outputResourceSet = null;
	private Resource result = null;

	@Override
	public Resource build(final Resource domainSpecificEventsResource,
			final Resource modelResource) {
		throw new NotImplementedException();
//
//		Activator.getMessagingSystem().debug(
//				"### Trying to generate the qvto and extendedCCSL...",
//				Activator.PLUGIN_ID);
//		Activator.getMessagingSystem().debug(
//				"Entering build with : " + "\n"
//						+ domainSpecificEventsResource.toString() + "\n"
//						+ modelResource.toString(), Activator.PLUGIN_ID);
//
//		final URI uri = domainSpecificEventsResource.getURI();
//		// final URI uri =
//		// URI.createFileURI("/home/flatombe/thesis/gemoc/git/gemoc-dev/org/gemoc/sample/tfsm_k3/org.gemoc.sample.tfsm.dse/ecl/TFSM.ecl");
//
//		Activator.getMessagingSystem().debug("URI of the DSE : " + uri,
//				Activator.PLUGIN_ID);
//		// final IFolder qvtoFolder = ((IFile) domainSpecificEventsResource)
//		// .getProject().getFolder("qvto-gen");
//		final IFile file = ResourcesPlugin
//				.getWorkspace()
//				.getRoot()
//				.getFile(
//						new Path(domainSpecificEventsResource.getURI()
//								.toString()));
//		Activator.getMessagingSystem().debug("file : " + file,
//				Activator.PLUGIN_ID);
//		final IProject project = file.getProject();
//		Activator.getMessagingSystem().debug("project : " + project,
//				Activator.PLUGIN_ID);
//		final IFolder qvtoFolder = project.getFolder("qvto-gen");
//
//		Activator.getMessagingSystem().debug("QVTO folder : " + qvtoFolder,
//				Activator.PLUGIN_ID);
//		final File folder = new File(qvtoFolder.getLocation().toOSString());
//		Activator.getMessagingSystem().debug("Folder OS String : " + folder,
//				Activator.PLUGIN_ID);
//		final List<String> arguments = new ArrayList<String>();
//		arguments.add(uri.lastSegment().replace(".ecl", "_toCCSL.qvto"));
//		Activator.getMessagingSystem().debug("Arguments : " + arguments,
//				Activator.PLUGIN_ID);
//
//		ISafeRunnable runnable = new ISafeRunnable() {
//			@Override
//			public void handleException(Throwable e) {
//				Activator.error(e.getMessage(), e);
//			}
//
//			@Override
//			public void run() throws Exception {
//
//				ResourceUtil.createFolder(qvtoFolder, true, true, null);
//
//				try {
//
//					// Generate QVTO
//					Activator.getMessagingSystem().debug(
//							"Generating qvto from ecl:\n\turi=" + uri
//									+ "\n\tfolder=" + folder + "\n\targs="
//									+ arguments, Activator.PLUGIN_ID);
//					AcceleoLauncherForEclToQvto launcher = new AcceleoLauncherForEclToQvto(
//							uri, folder, arguments);
//					launcher.doGenerate(new BasicMonitor());
//					qvtoFolder.refreshLocal(2, new NullProgressMonitor());
//
//					String qvtoURIString = "";
//
//					// Generate extendedCCSL
//
//					String modelURIString = ((IFile) modelResource)
//							.getProject().getName()
//							+ "/"
//							+ ((IFile) modelResource).getProjectRelativePath()
//									.toOSString();
//					initializeXtext();
//					result = createCCSLModel(qvtoURIString, modelURIString);
//
//				} catch (IOException e) {
//					Activator.error(e.getMessage(), e);
//				}
//			}
//		};
//		SafeRunner.run(runnable);
//
//		Activator.getMessagingSystem().debug(
//				"### ...Done ! : " + result.getURI().toString(),
//				Activator.PLUGIN_ID);
//		return result;
	}

	private void initializeXtext() {
		ExtendedCCSLStandaloneSetup ess = new ExtendedCCSLStandaloneSetup();
		Injector injector = ess.createInjector();
		// instanciate a resource set
		aModelResourceSet = injector.getInstance(XtextResourceSet.class);
		outputResourceSet = injector.getInstance(XtextResourceSet.class);
		// set.setClasspathURIContext(getClasspathURIContext());
		aModelResourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
				Boolean.TRUE);
		ExtendedCCSLStandaloneSetup.doSetup();
	}

	private Resource doQvToTransfo(String qvtoURIString, String modelURIString) {
		initializeXtext();
		// qvto uri
		URI transformationURI = URI.createPlatformPluginURI(qvtoURIString,
				false);
		// model resource
		URI modelUri = URI.createPlatformResourceURI(modelURIString, false);
		Resource modelResource = aModelResourceSet.getResource(modelUri, true);

		HashMap<Object, Object> saveOptions = new HashMap<Object, Object>();
		Builder aBuilder = SaveOptions.newBuilder();
		SaveOptions anOption = aBuilder.getOptions();
		anOption.addTo(saveOptions);
		try {
			modelResource.load(saveOptions);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// transformationURI is the URI of qvto file
		TransformationExecutor executor = new TransformationExecutor(
				transformationURI);

		// inResource have the vaule of inModel
		ModelExtent input = new BasicModelExtent(modelResource.getContents());
		ModelExtent output = new BasicModelExtent();

		ExecutionContextImpl context = new ExecutionContextImpl();

		ExecutionDiagnostic diagnostic = executor.execute(context, input,
				output);
		System.out.println(diagnostic);
		// output resource saving
		int numberOfCharToRemove = modelURIString.length()
				- modelUri.fileExtension().length() - 1;
		String outputPathString = modelURIString.substring(0,
				numberOfCharToRemove) + "_executionModel.extendedCCSL";
		URI outputUri = URI.createPlatformResourceURI(outputPathString, false);
		Resource outputResource = null;
		try {
			outputResource = outputResourceSet.createResource(outputUri);
		} catch (Exception e) {
			System.out.println(e);
			outputResource = outputResourceSet.createResource(outputUri);

			// outputResource = outputResourceSet.getResource(outputUri,true);
		}
		;
		outputResource.getContents().addAll(output.getContents());
		try {
			outputResource.save(null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outputResource;
	}

	private Resource createCCSLModel(String qvtoURIString, String modelURIString) {
		// use the extension of the model file
		String languageName = modelURIString.substring(
				modelURIString.lastIndexOf('.') + 1, modelURIString.length());

		return doQvToTransfo(qvtoURIString, modelURIString);
	}

}