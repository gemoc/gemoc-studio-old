package org.gemoc.executionmodel.create.popup.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.SaveOptions.Builder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

import com.google.inject.Injector;

import fr.inria.aoste.timesquare.ccslkernel.parser.xtext.ExtendedCCSLStandaloneSetup;


public class ExecutionModelGenerator implements IObjectActionDelegate {
	private IFile modelFile=null;
	private XtextResourceSet aModelResourceSet=null;
	private XtextResourceSet outputResourceSet=null;
	private String qvtoUriString;
	private ModelLoader modelLoader;
	private String modelUriString;
	/**
	 * Constructor for Action1.
	 */
	public ExecutionModelGenerator() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * just initialization stuff from xtext for an ecl resource
	 */
	private void initializeXtext(){
		ExtendedCCSLStandaloneSetup ess= new ExtendedCCSLStandaloneSetup();
		Injector injector = ess.createInjector();
		// instanciate a resource set
		aModelResourceSet = injector.getInstance(XtextResourceSet.class);
		outputResourceSet = injector.getInstance(XtextResourceSet.class);
		//set.setClasspathURIContext(getClasspathURIContext());
		aModelResourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		ExtendedCCSLStandaloneSetup.doSetup();
	}
	
	private void doQvToTransfo(){
		initializeXtext();
		//qvto uri
			    URI transformationURI = URI.createPlatformPluginURI(qvtoUriString, false);
			    //model resource
			    URI modelUri = URI.createPlatformResourceURI(modelUriString,false);
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

			   
			    //transformationURI is the URI of qvto file
				TransformationExecutor executor = new TransformationExecutor(transformationURI);

				//inResource have the vaule of inModel
				ModelExtent input = new BasicModelExtent(modelResource.getContents());
				ModelExtent output = new BasicModelExtent();

				ExecutionContextImpl context = new ExecutionContextImpl();

				ExecutionDiagnostic diagnostic = executor.execute(context, input, output);
				System.out.println(diagnostic);
				//output resource saving
				int numberOfCharToRemove = modelUriString.length() - modelUri.fileExtension().length() -1;
			    String outputPathString = modelUriString.substring(0, numberOfCharToRemove)+ "_executionModel.extendedCCSL";
			    URI outputUri = URI.createPlatformResourceURI(outputPathString,false);
			    Resource outputResource=null;
			    try{
			    	outputResource = outputResourceSet.createResource(outputUri);
			    }catch( Exception e){
			    	System.out.println(e);
			    	outputResource = outputResourceSet.createResource(outputUri);

			    //	outputResource = outputResourceSet.getResource(outputUri,true);
			    };
			    outputResource.getContents().addAll(output.getContents());
			    try {
					outputResource.save(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
	
	
	private void createCCSLModel() {
		if (modelUriString == null || modelUriString.isEmpty()) {
			return;
		}
		//use the extension of the model file
		String languageName = modelUriString.substring(modelUriString.lastIndexOf('.')+1, modelUriString.length());
		
		IConfigurationElement confElement = null;
		IConfigurationElement[] confElements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.gemoc.gemoc_language_workbench.xdsml");
		// retrieve the extension for the chosen language
		for (int i = 0; i < confElements.length; i++) {
			if(confElements[i].getAttribute("name").equals(languageName)){
				confElement =confElements[i];
			}
		}
		
		// get the extension objects
		if(confElement != null){
			Object omodelLoader=null;
			try {
				omodelLoader = confElement.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_LOADMODEL_ATT);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			if(omodelLoader instanceof ModelLoader){
				this.modelLoader = (ModelLoader) omodelLoader;
			}
			
			Object oexecutor=null;
			try {
				oexecutor = confElement.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_EXECUTOR_ATT);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			if(oexecutor instanceof CodeExecutor){
			}
			
			//get the Qvto file
			qvtoUriString = confElement.getAttribute(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_TO_CCSL_QVTO_FILE_PATH_ATT);
			doQvToTransfo();
		}
		return;
	}
	
	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
	    modelUriString = modelFile.getProject().getName()+"/"+modelFile.getProjectRelativePath().toOSString();
		
		initializeXtext();

		createCCSLModel();

	}

	/**path
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		modelFile=null;
		if (selection instanceof TreeSelection) {
			TreeSelection ts = (TreeSelection) selection;
			Iterator it = ts.iterator();
			while(it.hasNext()){
				Object o = it.next();
				if (o instanceof IFile) {
//					IFile f = (IFile)o;
//					if (f.getFileExtension().compareTo("qvto")==0){
//						qvtoFile = (IFile) o;
//					}else{
						modelFile = (IFile) o;
//					}
					
					
				}
			}
			
		}
	}

}
