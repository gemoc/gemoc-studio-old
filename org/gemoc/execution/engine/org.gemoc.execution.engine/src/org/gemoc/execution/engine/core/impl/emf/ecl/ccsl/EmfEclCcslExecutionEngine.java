package org.gemoc.execution.engine.core.impl.emf.ecl.ccsl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.gemoc.execution.engine.core.BasicExecutionEngine;
import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.events.impl.ecl.EclEvent;
import org.gemoc.execution.engine.executors.impl.emf.EmfExecutor;
import org.gemoc.execution.engine.feedback.policy.impl.easygoing.EasyGoingFeedbackPolicy;
import org.gemoc.execution.engine.solvers.Step;
import org.gemoc.execution.engine.solvers.impl.ccsl.CcslSolver;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.impl.TimeModelFactoryImpl;
import fr.inria.aoste.trace.EventOccurrence;

/**
 * An implementation of the engine using the EMF Executor, the ECL events, the
 * CCSL solver and the EasyGoing Feedback Policy.
 * 
 * @author flatombe
 * 
 */
public class EmfEclCcslExecutionEngine extends BasicExecutionEngine {

    public EmfEclCcslExecutionEngine(IFile file, MessageConsoleStream out) {
        super();
        TimeModelPackage.eINSTANCE.eClass();

        // Register the XMI resource factory for the .website extension

        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("extendedCCSL", new TimeModelFactoryImpl());

        URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
        XtextResourceSet resourceSet = new XtextResourceSet();

        // Create new resource for this file
        Resource resource = resourceSet.createResource(uri);

        out.println("Resource loaded is: " + resource.toString());
        out.println("Resource contents: " + resource.getContents().toString());

        this.solver = new CcslSolver(resource, out);
        out.println("After solver initialization");

        this.executor = new EmfExecutor(out);
        out.println("After executor initialization");

        this.feedbackPolicy = new EasyGoingFeedbackPolicy(out);
        out.println("After policy initialization");

        this.out = out;

        // TODO : création des DSE (et DSA) associées à partir des infos du ECL.
        // c-a-d que le fichier ECL devrait permettre d'instancier correctement
        // les EclEvent (EclEvent étant liés à un domain specific concept (le
        // context), une dsa (éventuellement avec des arguments?) et les
        // horloges CCSL générées à partir du ECL.
        /*
         * this.events = new ArrayList<DomainSpecificEvent>(); for(Truc truc :
         * entréeECL){ EclEvent event = new EclEvent(truc) events.add(event); }
         */
    }

    /**
     * 
     * @param step
     * @return the list of Domain Specific Event which are triggered by the
     *         step.
     */
    protected List<DomainSpecificEvent> match(Step step) {
        List<DomainSpecificEvent> res = new ArrayList<DomainSpecificEvent>();
        for (EventOccurrence eventOccurrence : step.getEventOccurrences()) {
            res.add(new EclEvent(eventOccurrence));
        }
        return res;
    }

    public String toString() {
        return "EmfEclCcslExecutionEngine@[rounds=" + this.getRounds() + "]";
    }
}
