package loadmodel;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.modelexecution.operationalsemantics.ActivityDiagramStandaloneSetupGenerated;
import org.modelexecution.operationalsemantics.ad.sequential.xdsml.StandaloneSetup;
import org.modelexecution.operationalsemantics.ad.sequential.xdsml.xactivitydiagrammt.activitydiagram.Activity;

import com.google.inject.Injector;

public class Main {
	
	public static void main(String[] args) {
		
		/*
		 * Melange registrations
		 */
		StandaloneSetup.doSetup();
		
		/*
		 * Get XtextResourceSet 
		 */
		new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../"); //needed for platform:/resource in standalone mode 
		Injector injector = new ActivityDiagramStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		
		/*
		 * Load model with Melange (downcast + behavior)
		 */
//		Resource r = resourceSet.getResource(URI.createURI("melange:/resource/todel/model/test1.ad?lang=org.modelexecution.operationalsemantics.ad.sequential.xdsml.XActivityDiagram"), true);
		Resource r = resourceSet.getResource(URI.createURI("melange:/resource/todel/model/test1.ad?lang=org.modelexecution.operationalsemantics.ad.sequential.xdsml.XActivityDiagram&mt=org.modelexecution.operationalsemantics.ad.sequential.xdsml.XActivityDiagramMT"), true);
		EObject root = r.getContents().get(0);
		System.out.println(root);
		
		/*
		 * Run it!
		 */
		Activity activity = (Activity) root;
		activity.initializeModel(new BasicEList<String>());
		activity.main();
		
		System.out.println("Done");
	}
	
}
