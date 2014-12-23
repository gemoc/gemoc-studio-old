package org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.tests;

import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeClock;
import fr.inria.aoste.timesquare.ccslkernel.runtime.simulation.CCSLStepExecutionEngine;
import fr.inria.aoste.timesquare.ccslkernel.runtime.exceptions.SimulationException;
import fr.inria.aoste.timesquare.ccslkernel.runtime.simulation.CCSLSimulationEngine;
import org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.models.TrafficControlModel;
import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;

public class TrafficControlTests {


    @Test
    public void test()
                throws SimulationException {
        TrafficControlModel model = new TrafficControlModel();
        assertNotNull(model);
        assertNotNull(model.getEntryBlock());
        CCSLSimulationEngine engine = new CCSLSimulationEngine(model);
        engine.initSimulation();
        CCSLStepExecutionEngine stepEngine = new CCSLStepExecutionEngine(engine);
        // First simulation step.
        stepEngine.executeStep();
        Set<RuntimeClock> firedClocks = stepEngine.getFiredClocks();
        // Second simulation step. The CCSLStepExecutionEngine object can be reused.
        stepEngine.executeStep();
        // Third simulation step.
        stepEngine.executeStep();
        engine.endSimulation();
    }

}
