package fr.inria.aoste.timesquare.backend.emfexecution.behaviors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Permission;
import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;

import fr.inria.aoste.timesquare.backend.emfexecution.Activator;
import fr.inria.aoste.timesquare.backend.emfexecution.CodeExecutionHelper;
import fr.inria.aoste.timesquare.backend.manager.visible.Behavior;
import fr.inria.aoste.timesquare.backend.manager.visible.ClockBehavior;
import fr.inria.aoste.timesquare.backend.manager.visible.ClockEntity;
import fr.inria.aoste.timesquare.backend.manager.visible.ConfigurationHelper;
import fr.inria.aoste.timesquare.backend.manager.visible.TraceHelper;
import fr.inria.aoste.timesquare.ccslkernel.model.utils.CCSLKernelUtils;
import fr.inria.aoste.timesquare.trace.util.ReferenceNameBuilder;
import fr.inria.aoste.trace.ModelElementReference;

public class EmfExecutionBehavior implements ClockBehavior {

	transient private ArrayList<ModelElementReference> _mersToForce=null;
    private ArrayList<String> _clockQualifiedNameToForce= null;
    
	protected Method _method;
	protected String _methodName;
	public ConfigurationHelper _confHelper = null;
	protected CodeExecutionHelper ce = null;
	protected EObject _o = null;


	public final CodeExecutionHelper getCe() {
		return ce;
	}

	public EObject getEObject(){
		return _o;
	}
	
	public final void setCe(CodeExecutionHelper ce) {
		this.ce = ce;
	}

	public IStatus createStatusError(String message, Throwable throwable) {
		IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, throwable);
		Activator.getDefault().getLog().log(status);
		return status;
	}

	public EmfExecutionBehavior(EObject o, String methodName, ArrayList<ClockEntity> clocksToForce, ConfigurationHelper helper) {
		_confHelper = helper;
		try {
			this._o = o;
			this._methodName = methodName;
			this._method = o.getClass().getMethod(methodName);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		additionalInitiation(clocksToForce);		
	}

	private void additionalInitiation(ArrayList<ClockEntity> clocksToForce){
		_mersToForce = new ArrayList<ModelElementReference>();
		_clockQualifiedNameToForce = new ArrayList<String>();
		if(clocksToForce != null){
			for(ClockEntity ce: clocksToForce){
				ModelElementReference mer = ce.getModelElementReference();
				_mersToForce.add(mer);
				_clockQualifiedNameToForce.add(ReferenceNameBuilder.buildQualifiedName(mer, "::"));
			}
		}
	}
	
	public static class ExitException extends SecurityException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1460964248465204534L;
		public final int status;

		public ExitException(int status) {
			super("from benoit: There is no escape !");
			this.status = status;
		}
	}

	public static class NoExitSecurityManager extends SecurityManager {

		public Thread t = null;

		public NoExitSecurityManager(Thread thread) {
			super();
			t = thread;

		}

		public void checkPermission(Permission perm, Object context) {

			// super.checkPermission(perm, context);
		}

		public void checkPermission(Permission perm) {

			// super.checkPermission(perm);
		}

		@Override
		public void checkExit(int status) {
			if (Thread.currentThread() == t) {
				super.checkExit(status);
				throw new ExitException(status);
			}
		}
	}


	
	public void execute(ArrayList<ModelElementReference> mersToForce) {
		//begin retrieve language name:
		String languageName = "";
		for (ClockEntity ce : _confHelper.getClocks()) {
			if (ce.getReferencedElement().size() > 0  ){//not in main block
				if (! (ce.getReferencedElement().get(0) instanceof EOperation)){
					String modelUriString = ce.getReferencedElement().get(0).eResource().getURI().toPlatformString(false);
					languageName = modelUriString.substring(modelUriString.lastIndexOf('.')+1, modelUriString.length());
					break;
				}
			}
		}
		//end retrieve language name
		
		
		//retrieve Executor
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
	
				Object oexecutor=null;
				try {
					oexecutor = confElement.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_EXECUTOR_ATT);
				} catch (CoreException e) {
					e.printStackTrace();
				}
				CodeExecutor languageDSAExecutor = null;
				if(oexecutor instanceof CodeExecutor){
					languageDSAExecutor = (CodeExecutor) oexecutor;
				}
			
			
			
			
			Object res = null;
			try {
				
				res = languageDSAExecutor.invoke(_o, _methodName, null);
			
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new IllegalStateException(e);
			} 
			
			
			//ce.println(res.toString());
			if (res instanceof Boolean){
				Boolean boolRes = (Boolean)res;
				if (boolRes.booleanValue()){
					for(ModelElementReference mer : mersToForce){
						ce.getSolver().forceClockAbsence(mer);
					}
				}else{
					for(ModelElementReference mer : mersToForce){
						ce.getSolver().forceClockPresence(mer);
					}
				}
				//	System.out.println("res of "+m+ " is "+res);
			}


		}
	}

	public boolean behaviorEquals(Behavior behavior) {
		if (behavior == this) {
			return true;
		}
		if (behavior == null) {
			return false;
		}
		if (behavior.getClass() != this.getClass()) {
			return false;
		}
		try {
			EmfExecutionBehavior ceb = (EmfExecutionBehavior) behavior;
			String itsMethodName = null;
			itsMethodName = ceb.getMethodName();
			if (_methodName.compareTo((itsMethodName)) != 0){
				return false;
			}
			if (CCSLKernelUtils.getQualifiedName(_o).compareTo(CCSLKernelUtils.getQualifiedName(ceb.getEObject())) != 0){
				return false;
			}

		} catch (Throwable e) {
			e.printStackTrace();
			createStatusError("behavior comparison failled", e);
		}
		return true;
	}

	public Method getMethod() {
		return _method;
	}

	public void setMethod(Method method) {
		_method = method;
	}

	public String getMethodName() {
		return _methodName;
	}

	public void setMethodName(String _methodName) {
		this._methodName = _methodName;
	}

	public final String getDescription() {
		String name = getClass().getSimpleName();

		StringBuilder sb = new StringBuilder();
		for (char c : name.toCharArray()) {

			if (Character.isUpperCase(c))
				sb.append(" ");
			sb.append(c);
		}
		sb.append(" : ");
		sb.append(_o.getClass().getName()).append(" ");
		sb.append(_methodName);
		return sb.toString();
	}

	public void finish() {
	}

	@Override
	public void run(TraceHelper helper) {
		execute(_mersToForce); 
	}

	@Override
	public void runWithWrongActivationState(TraceHelper helper) {
		// TODO Auto-generated method stub
		
	}

}
