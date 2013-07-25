package org.gemoc.execution.engine.core.impl.emf.ecl.ccsl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.gemoc.execution.engine.actions.impl.methodref.MethodReferenceAction;
import org.gemoc.execution.engine.core.BasicExecutionEngine;
import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.executors.impl.emf.EmfExecutor;
import org.gemoc.execution.engine.feedback.policy.impl.easygoing.EasyGoingFeedbackPolicy;
import org.gemoc.execution.engine.solvers.impl.ccsl.CcslSolver;

import fr.inria.aoste.timesquare.backend.manager.visible.ClockEntity;

/**
 * An implementation of the engine using the EMF Executor, the ECL events, the
 * CCSL solver and the EasyGoing Feedback Policy.
 * 
 * @author flatombe
 * 
 */
public class EmfEclCcslExecutionEngine extends BasicExecutionEngine {

    public EmfEclCcslExecutionEngine() {
        super();
        this.solver = new CcslSolver();
        this.executor = new EmfExecutor();
        this.feedbackPolicy = new EasyGoingFeedbackPolicy();

        // TODO : création des DSE (et DSA) associées à partir des infos du ECL.
        this.events = new ArrayList<DomainSpecificEvent>();

    }

    private String getSimpleName(EObject eo) {
        Object res = null;
        res = this.invokeMethod(eo, "getName");
        return (String) res;
    }

    private Object invokeMethod(EObject eo, String methodName) {
        Method m = null;
        Object res = null;
        try {
            m = eo.getClass().getMethod(methodName);
            res = m.invoke(eo);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            try {
                m = eo.getClass().getMethod("EMFRENAME" + methodName); // dirty
                                                                       // fix
                                                                       // due to
                                                                       // kermeta
                                                                       // dirty
                                                                       // fix
                                                                       // :-/
                                                                       // ask
                                                                       // Didier
                res = m.invoke(eo);
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

        return res;
    }

    // TODO : comment fournir à l'instanciation d'une DSA les bons objets?
    public void truc(ClockEntity ce) {
        EObject linkedOperation = ce.getReferencedElement().get(1);
        if (linkedOperation instanceof EOperation) {
            String operationName = this.getSimpleName(linkedOperation);
            MethodReferenceAction action = new MethodReferenceAction(eobject, operationName);
        }
    }
}
