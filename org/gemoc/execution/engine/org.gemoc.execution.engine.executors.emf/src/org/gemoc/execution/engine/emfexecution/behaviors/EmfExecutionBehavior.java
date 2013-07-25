package org.gemoc.execution.engine.emfexecution.behaviors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Permission;
import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.gemoc.execution.engine.emfexecution.Activator;
import org.gemoc.execution.engine.emfexecution.CodeExecutionHelper;

import fr.inria.aoste.timesquare.backend.manager.visible.Behavior;
import fr.inria.aoste.timesquare.backend.manager.visible.ClockBehavior;
import fr.inria.aoste.timesquare.backend.manager.visible.ClockEntity;
import fr.inria.aoste.timesquare.backend.manager.visible.ConfigurationHelper;
import fr.inria.aoste.timesquare.backend.manager.visible.TraceHelper;
import fr.inria.aoste.timesquare.ccslkernel.model.utils.CCSLKernelUtils;
import fr.inria.aoste.timesquare.trace.util.ReferenceNameBuilder;
import fr.inria.aoste.trace.ModelElementReference;

public class EmfExecutionBehavior implements ClockBehavior {

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
            this.t = thread;

        }

        @Override
        public void checkExit(int status) {
            if (Thread.currentThread() == this.t) {
                super.checkExit(status);
                throw new ExitException(status);
            }
        }

        @Override
        public void checkPermission(Permission perm) {

            // super.checkPermission(perm);
        }

        @Override
        public void checkPermission(Permission perm, Object context) {

            // super.checkPermission(perm, context);
        }
    }

    transient private ArrayList<ModelElementReference> _mersToForce = null;
    private ArrayList<String> _clockQualifiedNameToForce = null;
    protected Method _method;
    protected String _methodName;
    public ConfigurationHelper _confHelper = null;

    protected CodeExecutionHelper ce = null;

    protected EObject _o = null;

    public EmfExecutionBehavior(EObject o, String methodName, ArrayList<ClockEntity> clocksToForce,
            ConfigurationHelper helper) {
        this._confHelper = helper;
        try {
            this._o = o;
            this._methodName = methodName;
            this._method = o.getClass().getMethod(methodName);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        this.additionalInitiation(clocksToForce);
    }

    private void additionalInitiation(ArrayList<ClockEntity> clocksToForce) {
        this._mersToForce = new ArrayList<ModelElementReference>();
        this._clockQualifiedNameToForce = new ArrayList<String>();
        if (clocksToForce != null) {
            for (ClockEntity ce : clocksToForce) {
                ModelElementReference mer = ce.getModelElementReference();
                this._mersToForce.add(mer);
                this._clockQualifiedNameToForce.add(ReferenceNameBuilder.buildQualifiedName(mer, "::"));
            }
        }
    }

    @Override
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
            if (this._methodName.compareTo((itsMethodName)) != 0) {
                return false;
            }
            if (CCSLKernelUtils.getQualifiedName(this._o).compareTo(CCSLKernelUtils.getQualifiedName(ceb.getEObject())) != 0) {
                return false;
            }

        } catch (Throwable e) {
            e.printStackTrace();
            this.createStatusError("behavior comparison failled", e);
        }
        return true;
    }

    public IStatus createStatusError(String message, Throwable throwable) {
        IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, throwable);
        Activator.getDefault().getLog().log(status);
        return status;
    }

    public void execute(ArrayList<ModelElementReference> mersToForce) {

        // SecurityManager security = System.getSecurityManager();

        // System.setSecurityManager(new
        // NoExitSecurityManager(Thread.currentThread()));
        try {
            // it is possible to get the result here !
            Object res = this._method.invoke(this._o);
            this.ce.println(res.toString());
            if (res instanceof Boolean) {
                Boolean boolRes = (Boolean) res;
                if (boolRes.booleanValue()) {
                    for (ModelElementReference mer : mersToForce) {
                        this.ce.getSolver().forceClockAbsence(mer);
                    }
                } else {
                    for (ModelElementReference mer : mersToForce) {
                        this.ce.getSolver().forceClockPresence(mer);
                    }
                }
                // System.out.println("res of "+m+ " is "+res);
            }

        } catch (Throwable e) {
            if (e instanceof InvocationTargetException) {
                try {
                    this._method = this._o.getClass().getMethod("EMFRENAME" + this._methodName); // bad
                                                                                                 // fix
                                                                                                 // due
                                                                                                 // to
                                                                                                 // kermeta
                                                                                                 // bad
                                                                                                 // fix
                    Object res = this._method.invoke(this._o);
                    this.ce.println(res.toString());
                    this.ce.println(res.toString());
                    if (res instanceof Boolean) {
                        Boolean boolRes = (Boolean) res;
                        if (boolRes.booleanValue()) {
                            for (ModelElementReference mer : mersToForce) {
                                this.ce.getSolver().forceClockAbsence(mer);
                            }
                        } else {
                            for (ModelElementReference mer : mersToForce) {
                                this.ce.getSolver().forceClockPresence(mer);
                            }
                        }
                        // System.out.println("res of "+m+ " is "+res);
                    }
                } catch (SecurityException e1) {
                    e1.printStackTrace();
                } catch (NoSuchMethodException e1) {
                    e1.printStackTrace();
                } catch (IllegalArgumentException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (InvocationTargetException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public void finish() {
    }

    public final CodeExecutionHelper getCe() {
        return this.ce;
    }

    @Override
    public final String getDescription() {
        String name = this.getClass().getSimpleName();

        StringBuilder sb = new StringBuilder();
        for (char c : name.toCharArray()) {

            if (Character.isUpperCase(c)) {
                sb.append(" ");
            }
            sb.append(c);
        }
        sb.append(" : ");
        sb.append(this._o.getClass().getName()).append(" ");
        sb.append(this._methodName);
        return sb.toString();
    }

    public EObject getEObject() {
        return this._o;
    }

    public Method getMethod() {
        return this._method;
    }

    public String getMethodName() {
        return this._methodName;
    }

    @Override
    public void run(TraceHelper helper) {
        this.execute(this._mersToForce); // OJOJOJOJJOOJOJJOOJ
    }

    @Override
    public void runWithWrongActivationState(TraceHelper helper) {
    }

    public final void setCe(CodeExecutionHelper ce) {
        this.ce = ce;
    }

    public void setMethod(Method method) {
        this._method = method;
    }

    public void setMethodName(String _methodName) {
        this._methodName = _methodName;
    }

}
