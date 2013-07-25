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
        for(Truc truc : entréeECL){
            EclEvent event = new EclEvent(truc)
            events.add(event);
        }
    }
}
