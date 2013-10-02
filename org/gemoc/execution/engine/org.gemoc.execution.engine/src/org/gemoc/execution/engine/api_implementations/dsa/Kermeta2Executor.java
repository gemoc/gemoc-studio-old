package org.gemoc.execution.engine.api_implementations.dsa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.Activator;
import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dsa.Executor;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

/**
 * An executor that can call methods contained in compiled EMF code (like
 * Kermeta's).
 * 
 * @author flatombe
 */
public class Kermeta2Executor implements Executor {

    private DomainSpecificAction lastExecutedAction;
    private Resource modelResource;

    public Kermeta2Executor(Resource modelResource) {
        this.lastExecutedAction = null;
        this.modelResource = modelResource;
    }
    
    private Object executeWithEInvoke(EObject eObject, EOperation operation){
        EObject richEObject = null;
        Object eInvokeResult = null;
        FeedbackData res = null;

        try {
            Activator.getMessagingSystem()
                    .debug("Trying to einvoke the EOperation (" + operation.toString() + ") on the EObject (" + eObject.toString() + ")", Activator.PLUGIN_ID);
            eInvokeResult = eObject.eInvoke(operation, null);
            
        } catch (InvocationTargetException e) {
            Activator.getMessagingSystem().debug("Caught an InvocationTargetException", Activator.PLUGIN_ID);
            if (e.getCause() instanceof UnsupportedOperationException) {
                Activator
                        .getMessagingSystem()
                        .debug("Cause of the InvocationTargetException is an UnsupportedOperationException, let's find the richEObject",
                                Activator.PLUGIN_ID);
                String linkedElementQualifiedName = this.getQualifiedName(eObject);
                Iterator<EObject> modelIterator = this.modelResource.getContents().get(0).eAllContents();
                while (modelIterator.hasNext()) {
                    EObject modelElement = modelIterator.next();
                    String modelElementQualifiedName = this.getQualifiedName(modelElement);
                    if (modelElementQualifiedName.equals(linkedElementQualifiedName)) {
                        richEObject = modelElement;
                        break;
                    }
                }
                try {
                    eInvokeResult = richEObject.eInvoke(operation, null);
                } catch (InvocationTargetException f) {
                    Activator
                            .getMessagingSystem()
                            .debug("Caught an InvocationTargetException while trying to call the EOperation on the richEObject. Please fix your DSA implementation. The cause exception stacktrace is available in the error log view.",
                                    Activator.PLUGIN_ID);
                    Activator.error("Nested exception thrown by the DSA implementation", f.getCause());
                }
            } else {
                Activator
                        .getMessagingSystem()
                        .debug("Caught an InvocationTargetException while trying to call the EOperation on the EObject. Please fix your DSA implementation. The cause exception stacktrace is available in the error log view.",
                                Activator.PLUGIN_ID);
                Activator.error("Nested exception thrown by the DSA implementation", e.getCause());
            }
        }
        Activator
        .getMessagingSystem()
        .debug("Result of the eInvokation: " + eInvokeResult.toString(),
                Activator.PLUGIN_ID);

        //res = DataConverter.convertToFeedbackData(eInvokeResult);
        return eInvokeResult;
    }
    
    private Object executeWithInvoke(EObject eObject, EOperation operation){
        Object res = null;
        Method method = null;
        try{try{
            method = eObject.getClass().getMethod("EMFRENAME"+ operation.getName());
            Activator.getMessagingSystem().debug("méthode de nom hacked : " + method.toString(), Activator.PLUGIN_ID);

        } catch (NoSuchMethodException e) {
            String errorMessage = "NoSuchMethodException when trying to execute the method corresponding to an EOperation";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            try {
                method = eObject.getClass().getMethod(operation.getName());
                Activator.getMessagingSystem().debug("méthode de nom normal : " + method.toString(), Activator.PLUGIN_ID);
            } catch (NoSuchMethodException e1) {
                Activator.getMessagingSystem().error("suchmethodexception balbal", Activator.PLUGIN_ID);
            }
        }
            res = method.invoke(eObject, (Object[]) null);
            
            
         
            return res;
            } catch (SecurityException e) {
      String errorMessage = "SecurityException when trying to execute the method corresponding to an EOperation";
      Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
      Activator.error(errorMessage, e);
      return null;
  } catch (IllegalArgumentException e) {
      String errorMessage = "IllegalArgumentException when trying to execute the method corresponding to an EOperation";
      Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
      Activator.error(errorMessage, e);
      return null;
  } catch (IllegalAccessException e) {
      String errorMessage = "IllegalAccessException when trying to execute the method corresponding to an EOperation";
      Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
      Activator.error(errorMessage, e);
      return null;
  } catch (InvocationTargetException e) {
      String errorMessage = "InvocationTargetException when trying to execute the method corresponding to an EOperation";
      Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
      Activator.error(errorMessage, e);
      Activator.error("Nested Exception", e.getCause());
      return null;
}
        
    }
    
    
    public FeedbackData execute(EObject eObject, EOperation operation) {
        Activator.getMessagingSystem().info(
                "Executing EOperation of name " + operation.getName() + " on eobject " + eObject.toString()
                        + " or on one of its heirs if the method is not implemented in EMF.", Activator.PLUGIN_ID);
        
        FeedbackData res = null;
        //Object eInvokeResult = this.executeWithEInvoke(eObject, operation);
        Object invokeResult = this.executeWithInvoke(eObject, operation);
        Activator
        .getMessagingSystem()
        .debug("Result of the invokation: " + invokeResult.toString(),
                Activator.PLUGIN_ID);
        
        return res;
        

        
        
        /*try {
            realObject = this.getMethod(eObject, operation);
            Method method = realObject.getClass().getMethod(operation);
            Activator.getMessagingSystem().debug("The real object which we will use: " + realObject.toString(),
                    Activator.PLUGIN_ID);
            Activator.getMessagingSystem().debug("The method is the following: " + method.toString(),
                    Activator.PLUGIN_ID);
            Activator.getMessagingSystem().debug("-Declaring Class: " + method.getDeclaringClass().toString(),
                    Activator.PLUGIN_ID);
            Activator.getMessagingSystem().debug("-Class: " + method.getClass().toString(), Activator.PLUGIN_ID);
            Activator.getMessagingSystem().debug("-Return type: " + method.getReturnType().toString(),
                    Activator.PLUGIN_ID);
            return DataConverter.convertToFeedbackData(method.invoke(realObject));
        } catch (SecurityException e) {
            String errorMessage = "SecurityException when trying to invoke a Domain Specific Action";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        } catch (NoSuchMethodException e) {
            String errorMessage = "NoSuchMethodException when trying to invoke a Domain Specific Action";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        } catch (IllegalAccessException e) {
            String errorMessage = "IllegalAccessException when trying to invoke a Domain Specific Action";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        } catch (IllegalArgumentException e) {
            String errorMessage = "IllegalArgumentException when trying to invoke a Domain Specific Action";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        } catch (InvocationTargetException e) {
            try {
                Activator.getMessagingSystem().debug("InvocationTargetException : " + e.getCause().getMessage(),
                        Activator.PLUGIN_ID);
                Activator.error("InvocationTargetException on " + operation, e.getCause());
                Activator.getMessagingSystem().debug(
                        "Could not find method " + operation + " so let's try with the EMF hack!", Activator.PLUGIN_ID);
                Method method = this.getMethodEmfHack(realObject, operation);
                Activator.getMessagingSystem().debug(
                        "EMFHACK::The real object which we will use: " + realObject.toString(), Activator.PLUGIN_ID);
                Activator.getMessagingSystem().debug("EMFHACK::The method is the following: " + method.toString(),
                        Activator.PLUGIN_ID);
                Activator.getMessagingSystem().debug(
                        "EMFHACK::-Declaring Class: " + method.getDeclaringClass().toString(), Activator.PLUGIN_ID);
                Activator.getMessagingSystem().debug("EMFHACK::-Class: " + method.getClass().toString(),
                        Activator.PLUGIN_ID);
                Activator.getMessagingSystem().debug("EMFHACK::-Return type: " + method.getReturnType().toString(),
                        Activator.PLUGIN_ID);
                return (FeedbackData) method.invoke(realObject);
            } catch (IllegalArgumentException e1) {
                String errorMessage = "IllegalArgumentException when trying to invoke a Domain Specific Action";
                Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
                Activator.error(errorMessage, e1);
                return null;
            } catch (IllegalAccessException e1) {
                String errorMessage = "IllegalAccessException when trying to invoke a Domain Specific Action";
                Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
                Activator.error(errorMessage, e1);
                return null;
            } catch (InvocationTargetException e1) {
                String errorMessage = "InvocationTargetException when trying to invoke a Domain Specific Action";
                Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
                Activator.error(errorMessage, e1);
                return null;
            }
        }*/
    }

    
    
    @Override
    public FeedbackData execute(DomainSpecificAction dsa) {
        Activator.getMessagingSystem().debug(
                "Executing Domain Specific Action : " + dsa.toString(), Activator.PLUGIN_ID);
        Activator.getMessagingSystem().debug(
                "EObj: " + ((EmfAction) dsa).getTarget().toString(), Activator.PLUGIN_ID);
        Activator.getMessagingSystem().debug(
                "EObj: " + ((EmfAction) dsa).getTarget().eClass().toString(), Activator.PLUGIN_ID);
        Activator.getMessagingSystem().debug(
                "EObj: " + ((EmfAction) dsa).getTarget().eClass().getEAllOperations().toString(), Activator.PLUGIN_ID);
        
        
        Activator.getMessagingSystem().debug(
                "EOp: " + ((EmfAction) dsa).getOperation().toString(), Activator.PLUGIN_ID);
        Activator.getMessagingSystem().debug(
                "EOp: " + ((EmfAction) dsa).getOperation().getEContainingClass().toString(), Activator.PLUGIN_ID);
        Activator.getMessagingSystem().debug(
                "EOp: " + ((EmfAction) dsa).getOperation().getEContainingClass().getEAllOperations().toString(), Activator.PLUGIN_ID);
        
        
        
        Activator.getMessagingSystem().debug(
                "Retrieving EObject in the DSA with the name: " + dsa.getTargetQualifiedName(), Activator.PLUGIN_ID);
        
        EObject eObject = getEObjectFromName(dsa.getTargetQualifiedName());
        
        Activator.getMessagingSystem().debug(
                "EObject found: " + eObject.toString(), Activator.PLUGIN_ID);
        Activator.getMessagingSystem().debug(
                "Retrieving EOperation in the DSA with the name: " + dsa.getMethodQualifiedName(), Activator.PLUGIN_ID);
        
        EOperation eOperation = getEOperationFromName(eObject, dsa.getMethodQualifiedName());
        
        Activator.getMessagingSystem().debug(
                "EOperation found: " + eOperation.toString(), Activator.PLUGIN_ID);
        
        FeedbackData feedback = this.execute(eObject, eOperation);
        
        this.lastExecutedAction = dsa;
        return feedback;
    }
    
    
    
    private EObject getEObjectFromName(String name){
        Iterator<EObject> modelIterator = this.modelResource.getContents().get(0).eAllContents();
        while (modelIterator.hasNext()) {
            EObject modelElement = modelIterator.next();
            String modelElementQualifiedName = this.getQualifiedName(modelElement);
            if (modelElementQualifiedName.equals(name)) {
                return modelElement;
            }
        }
        Activator.getMessagingSystem().warn(
                "Returning Null in getEObjectFromName for name: " + name, Activator.PLUGIN_ID);
        return null;
    }
    
    private EOperation getEOperationFromName(EObject eObject, String name){
    	Activator.getMessagingSystem().debug("Analyzing the content of the EObject:", Activator.PLUGIN_ID);
    	Activator.getMessagingSystem().debug(eObject.toString(), Activator.PLUGIN_ID);
    	Activator.getMessagingSystem().debug(eObject.eClass().toString(), Activator.PLUGIN_ID);
    	Activator.getMessagingSystem().debug(eObject.eClass().getInstanceClassName(), Activator.PLUGIN_ID);
    	Activator.getMessagingSystem().debug(eObject.eClass().getInstanceTypeName(), Activator.PLUGIN_ID);
    	Activator.getMessagingSystem().debug(eObject.eClass().getEOperations().toString(), Activator.PLUGIN_ID);
    	Activator.getMessagingSystem().debug(eObject.eClass().getOperationCount() + "", Activator.PLUGIN_ID);
    	Activator.getMessagingSystem().debug(eObject.eClass().getEAllOperations().toString(), Activator.PLUGIN_ID);
        for(EOperation eOperation : eObject.eClass().getEAllOperations()) {
            String modelElementQualifiedName = this.getQualifiedName(eOperation);
            Activator.getMessagingSystem().debug(
                    "modelElementQualifiedName: " + modelElementQualifiedName, Activator.PLUGIN_ID);
            String modelElementEMFHackedQualifiedName = this.getEmfHackQualifiedNameFromQualifiedName(modelElementQualifiedName);
            Activator.getMessagingSystem().debug(
                    "modelElementEMFHackedQualifiedName: " + modelElementEMFHackedQualifiedName, Activator.PLUGIN_ID);
            String linkedElementEMFHackedQualifiedName = this.getEmfHackQualifiedNameFromQualifiedName(name);
            Activator.getMessagingSystem().debug(
                    "linkedElementEMFHackedQualifiedName " + linkedElementEMFHackedQualifiedName, Activator.PLUGIN_ID);
            Activator.getMessagingSystem().debug(modelElementEMFHackedQualifiedName + " == " + linkedElementEMFHackedQualifiedName + " ? : " + modelElementEMFHackedQualifiedName.equals(linkedElementEMFHackedQualifiedName), Activator.PLUGIN_ID);
            if (modelElementEMFHackedQualifiedName.equals(linkedElementEMFHackedQualifiedName)) {
                return eOperation;
            }
        }
        for(EOperation eOperation : eObject.eClass().getEAllOperations()) {
            String modelElementQualifiedName = this.getQualifiedName(eOperation);
            if (modelElementQualifiedName.equals(name)) {
                return eOperation;
            }
        }
        
        Activator.getMessagingSystem().warn(
                "Returning Null in getEOperationFromName for name: " + name, Activator.PLUGIN_ID);
        return null;
    }
    
    private String getEmfHackQualifiedNameFromQualifiedName(String qualifiedName){
        String[] splits = qualifiedName.split("::");
        splits[splits.length-1] = "EMFRENAME" + splits[splits.length-1];
        String res = splits[0];
        for(int i = 1; i<splits.length; i++){
            res += "::" + splits[i];
        }
        return res;
    }

    /*private EObject getMethod(Object object, String methodFullName) {
        try {
            String linkedElementQualifiedName = this.getQualifiedName(object);
            Iterator<EObject> modelIterator = this.modelRoot.eAllContents();
            while (modelIterator.hasNext()) {
                EObject modelElement = modelIterator.next();
                String modelElementQualifiedName = this.getQualifiedName(modelElement);
                if (modelElementQualifiedName.equals(linkedElementQualifiedName)) {
                    return modelElement;
                }
            }
            // method = eo.getClass().getMethod(methodFullName);
            return null;
        } catch (SecurityException e) {
            String errorMessage = "SecurityException when trying to retrieve method from its full name"
                    + object.toString() + "." + methodFullName;
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        }
    }*/

    private String getQualifiedName(EObject eo) {
        String res = getSimpleName(eo);
        EObject tmp = eo.eContainer();
        while (tmp != null) {
            res = getSimpleName(tmp) + "::" + res;
            tmp = tmp.eContainer();
        }
        return res;
    }

    private String getSimpleName(EObject eo) {
        return this.invokeGetNameOnEObject(eo);
    }

    private String invokeGetNameOnEObject(EObject eObjectMethod) {
        Method method;
        try {
            method = eObjectMethod.getClass().getMethod("getName");
            Object res = method.invoke(eObjectMethod);
            if (res instanceof String) {
                return (String) res;
            } else {
                return null;
            }
        } catch (SecurityException e) {
            String errorMessage = "SecurityException when trying to get the qualified name of an object";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        } catch (IllegalArgumentException e) {
            String errorMessage = "IllegalArgumentException when trying to get the qualified name of an object";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        } catch (NoSuchMethodException e) {
            String errorMessage = "NoSuchMethodException when trying to get the qualified name of an object";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        } catch (IllegalAccessException e) {
            String errorMessage = "IllegalAccessException when trying to get the qualified name of an object";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        } catch (InvocationTargetException e) {
            String errorMessage = "InvocationTargetException when trying to get the qualified name of an object";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        }
    }

    /*public Method getMethodEmfHack(EObject eo, String methodFullName) {
        try {
            return this.getMethod(eo, "EMFRENAME" + methodFullName).getClass().getMethod(methodFullName);
        } catch (SecurityException e) {
            String errorMessage = "SecurityException when trying to use EmfHack";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        } catch (NoSuchMethodException e) {
            String errorMessage = "NoSuchMethodException when trying to use EmfHack";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        }
    }*/

    @Override
    public FeedbackData execute(DomainSpecificEvent dse) {
        Activator.getMessagingSystem().debug("EMFExecuting the action from DomainSpecificEvent " + dse.toString(),
                Activator.PLUGIN_ID);
        return this.execute(dse.getAction());
    }

    public String toString() {
        return this.getClass().getName() + "@[lastExecutedAction=" + lastExecutedAction.toString() + " ; modelRoot="
                + modelResource.toString() + "]";
    }

	@Override
	public void setModel(Resource modelResource) {
		this.modelResource = modelResource;		
	}

}
