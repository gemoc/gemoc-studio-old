package fr.inria.aoste.timesquare.backend.emfexecution.manager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
//import org.gemoc.gemoc_language_workbench.api.utils.LanguageInitializer;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

import com.google.inject.Injector;

import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping;
import fr.inria.aoste.timesquare.backend.emfexecution.CodeExecutionHelper;
import fr.inria.aoste.timesquare.backend.emfexecution.behaviors.EmfExecutionBehavior;
import fr.inria.aoste.timesquare.backend.emfexecution.persistentoptions.EmfExecutionPersistentOptions;
import fr.inria.aoste.timesquare.backend.manager.visible.BehaviorConfigurator;
import fr.inria.aoste.timesquare.backend.manager.visible.BehaviorManager;
import fr.inria.aoste.timesquare.backend.manager.visible.ClockBehavior;
import fr.inria.aoste.timesquare.backend.manager.visible.ClockEntity;
import fr.inria.aoste.timesquare.backend.manager.visible.ConfigurationHelper;
import fr.inria.aoste.timesquare.backend.manager.visible.PersistentOptions;
import fr.inria.aoste.timesquare.backend.manager.visible.RelationBehavior;
import fr.inria.aoste.timesquare.backend.ui.internal.EmfExecutionConfigurationActivator;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity;
import fr.inria.aoste.timesquare.ccslkernel.model.utils.CCSLKernelUtils;
import fr.inria.aoste.timesquare.launcher.core.inter.ISolverForBackend;
import fr.inria.aoste.timesquare.trace.util.ReferenceNameBuilder;
import fr.inria.aoste.trace.ModelElementReference;



public class EmfCodeExecutionManager<RichMainClass> extends BehaviorManager {
	private ArrayList<EmfExecutionBehavior> _behaviorList;
	private String _modelFilename;
	private EObject _modelRoot = null;
	protected CodeExecutionHelper ceh = null;
	private EPackage _mmpackage;
	private Map<String, Clock> forcedClockMap = new HashMap<String, Clock>();
	
	protected ModelLoader modelLoader;
//	protected LanguageInitializer languageInitializer;
	protected CodeExecutor languageDSAExecutor;
	
	protected String modelUriString=null;
	protected String confUriString=null;

	
	public String getConfigurationIFile() {
		return _modelFilename;
	}

	public void setModelFileName(String confFilename) {
		confUriString = confFilename;
		initLoaderAndExecutor();
		
		EMFExecutionConfiguration confModel = loadEMFExecutionConfiguration(confFilename);
		for(ForcedClockMapping mapping: confModel.getForcedClockMappings()){
			String ClkToEvaluate = CCSLKernelUtils.getQualifiedName(mapping.getClock(), "::");
			//String ClkToAvoid = CCSLKernelUtils.getQualifiedName(mapping.getClockToAvoidWhenTrue(), "::");
			forcedClockMap.put(ClkToEvaluate, mapping.getClockToAvoidWhenTrue());
		}
		
	}
	
	private EMFExecutionConfiguration loadEMFExecutionConfiguration(String filename) {
		if (filename == null || filename.isEmpty()) {
			return null;
 		}
		String language = EmfExecutionConfigurationActivator.FR_INRIA_AOSTE_TIMESQUARE_BACKEND_EMFEXECUTIONCONFIGURATION;
		Injector injector = EmfExecutionConfigurationActivator.getInstance().getInjector(language);
		XtextResourceSetProvider provider = injector.getInstance(XtextResourceSetProvider.class);

		XtextResourceSet resourceSet = (XtextResourceSet) provider
				.get(findContainingProject(filename));
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		URI uri = URI.createPlatformResourceURI(filename, true);
		XtextResource resource = (XtextResource) resourceSet.getResource(uri, true);
		List<Diagnostic> errors = resource.getErrors();
		if (!errors.isEmpty()) {
			System.err.println(errors);
			return null;
		}
		return (EMFExecutionConfiguration) resource.getContents().get(0);
 	}
	
		private IProject findContainingProject(String filename) {
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IWorkspaceRoot root = workspace.getRoot();
				IPath path = root.getLocation();
				path = path.append(new Path(filename));
				IFile file = (IFile) root.findMember(filename);
				return (file != null ? file.getProject() : null);
			}

	
	
	private void initLoaderAndExecutor() {
		
		if (modelUriString == null || modelUriString.isEmpty()) {
			retrieveModelURIString(_helper);
			if (modelUriString == null || modelUriString.isEmpty()) {
				return;
			}
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
				_modelRoot = modelLoader.loadModel(modelUriString).getContents().get(0);
			}
//			Object oinitializer=null;
//			try {
//				oinitializer = confElement.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_INITIALIZER_ATT);
//			} catch (CoreException e) {
//				e.printStackTrace();
//			}
//			if(oinitializer instanceof LanguageInitializer){
//				this.languageInitializer = (LanguageInitializer) oinitializer;
//			}

			Object oexecutor=null;
			try {
				oexecutor = confElement.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_EXECUTOR_ATT);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			if(oexecutor instanceof CodeExecutor){
				this.languageDSAExecutor = (CodeExecutor) oexecutor;
			}
			
		}
		return;
	}

	@Override
	public void clear() {
		_behaviorList.clear();
		super.clear();
	}


	public EmfCodeExecutionManager() {
		ceh = new CodeExecutionHelper(null);
	}

	@Override
	public void beforeExecution(ConfigurationHelper helper, IPath folderin,
			String namefilein, ISolverForBackend solver) {
		ceh.setConfigurationHelper(helper,solver);

	}

	@Override
	public void end(ConfigurationHelper helper) {
		for (EmfExecutionBehavior b : _behaviorList) {
			b.finish();
		}
		_behaviorList.clear();
		ceh.clear();
		ceh = null;
	}

	public String _getid() {
		return "emfexecution";
	}

	@Override
	public String getPluginName() {
		return "EMF Code Execution";
	}

	@Override
	public void init(ConfigurationHelper helper) {
		super.init(helper);
		_behaviorList = new ArrayList<EmfExecutionBehavior>();
	}
	
	private void retrieveModelURIString(ConfigurationHelper helper){
		//retrieve the URI of the domain model linked to CCSL
		for (ClockEntity ce : helper.getClocks()) {
			if (ce.getReferencedElement().size() > 0  ){//not in main block
				if (! (ce.getReferencedElement().get(0) instanceof EOperation)){
					modelUriString = ce.getReferencedElement().get(0).eResource().getURI().toPlatformString(false);
					break;
				}
			}
		}
		return;
	}

	
	public void manageBehavior(ConfigurationHelper helper) {
		initLoaderAndExecutor();
		//create the behavior
		for (ClockEntity ce : helper.getClocks()) {
			if (ce.getReferencedElement().size() > 1){// if linked to an object AND an operation
				String ClkToEvaluate = CCSLKernelUtils.getQualifiedName(ce.getClock(), "::");
				Clock clockToAvoid = forcedClockMap.get(ClkToEvaluate);
				ArrayList<ClockEntity> clocksToAvoid = new ArrayList<ClockEntity>();
				if (clockToAvoid!=null){
					clocksToAvoid.add(findClockEntity(clockToAvoid));
				}
				addBehavior(ce, clocksToAvoid);
			}
		}
	}

	private ClockEntity findClockEntity(ConcreteEntity clock) {
		String clockPath = CCSLKernelUtils.getQualifiedName(clock, "::");

		for (ClockEntity ce : _helper.getClocks()) {
			ModelElementReference mer = ce.getModelElementReference();
			String path = ReferenceNameBuilder.buildQualifiedName(mer, "::");
			if (clockPath.compareTo(path) == 0) {
				return ce;
			}
		}
		return null;
	}

	private Object invokeMethod(EObject eo, String methodName){
		Object res=null;
		try {
			res = languageDSAExecutor.invoke(eo, methodName, null);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		} 
		_helper.println(res.toString());
		return res;
	}
	
	private String getQualifiedName(EObject eo){
		String res = getSimpleName(eo);
		EObject tmp = eo.eContainer();
		while (tmp != null){
			res= getSimpleName(tmp)+"::"+res;
			tmp = tmp.eContainer();
		}
		return res;
	}
	
	private String getSimpleName(EObject eo){
		Object res=null;
		try {
			Class<?> params[] = new Class[0];
			Method m = eo.getClass().getMethod("getName", params);
			
			res = m.invoke(eo);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//res =  invokeMethod(eo, "getName");
		return (String)res;
	}
	
	public void addBehavior(ClockEntity ce, ArrayList<ClockEntity> clockToForce) {
		
		EObject linkedOperation = ce.getReferencedElement().get(1);
		if(linkedOperation.eIsProxy()){
			linkedOperation = EcoreUtil2.resolve(linkedOperation, _mmpackage.eResource());
		}
		if (linkedOperation instanceof EOperation){
			String linkedElementQN = getQualifiedName(ce.getReferencedElement().get(0));
			String operationName = getSimpleName(linkedOperation);
			TreeIterator<EObject> modelIterator = _modelRoot.eAllContents();
			EmfExecutionBehavior behavior = createBehavior(operationName, linkedElementQN, modelIterator, clockToForce);
			EmfExecutionPersistentOptions options = new EmfExecutionPersistentOptions(operationName,linkedElementQN, clockToForce, modelUriString);
			_helper.addBehavior(ce, _helper.getTicksState(), this.getPluginName(), behavior, options);
			_behaviorList.add(behavior);
		}
	}


	private EmfExecutionBehavior createBehavior(String operationName, String linkedElementQualifiedName, TreeIterator<EObject> modelIterator, ArrayList<ClockEntity> clockToForce){
		while(modelIterator.hasNext()){
			EObject modelElement = modelIterator.next();
			String modelElementQualifiedName = getQualifiedName(modelElement);
			if (modelElementQualifiedName.compareTo(linkedElementQualifiedName)==0){
				System.out.println(modelElementQualifiedName);
				System.out.println(operationName);
				// ClocktoForce? or ClocktoAvoid?????
				EmfExecutionBehavior behavior = new EmfExecutionBehavior(modelElement, operationName, clockToForce, _helper);
				behavior.setCe(ceh);
				return behavior;
			}
		}
		return null;
	}
	
	@Override
	public BehaviorConfigurator<?> getConfigurator(ConfigurationHelper configurationHelper) {

		return new CodeExecutorConfigurator(configurationHelper, this);
	}

	protected HashMap<String, Object> getData() {
		return ceh.getData();
	}


	

	@Override
	public ClockBehavior redoClockBehavior(ConfigurationHelper helper, PersistentOptions persistentOptions) {
	
		EmfExecutionPersistentOptions options = (EmfExecutionPersistentOptions) persistentOptions;
		String operationName = options.getMethodName();
		String linkedElementQN = options.getObjectQualifiedName();
		
		modelUriString = options.getJarFilePath();
		if(_modelRoot == null){
			initLoaderAndExecutor();
		}
		TreeIterator<EObject> modelIterator = _modelRoot.eAllContents();
		ArrayList<ClockEntity> clocksToForce = new ArrayList<ClockEntity>();
		for(String clockQualifiedName: options.getClocksQualifiedNameToForce()){
			ClockEntity ce = getClock(helper, clockQualifiedName);
			clocksToForce.add(ce); //Clock to force????? just not be avoid???
		}
		EmfExecutionBehavior behavior = createBehavior(operationName, linkedElementQN, modelIterator, clocksToForce);
		_behaviorList.add(behavior);
		return behavior;
	}
	
	private static ClockEntity getClock(ConfigurationHelper helper, String clockName) {

		for (ClockEntity clock : helper.getClocks()) {
			if (clock.getName().compareTo(clockName) == 0)
				return clock;
		}
		return null;
	}

	@Override
	public RelationBehavior redoRelationBehavior(ConfigurationHelper helper,
			PersistentOptions persistentOptions) {
		return null;
	}

	@Override
	public ClockBehavior redoAssertBehavior(ConfigurationHelper helper,
			PersistentOptions persistentOptions) {
		return null;
	}

}
