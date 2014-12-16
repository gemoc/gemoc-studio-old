package org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.main;

import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeClock;
import fr.inria.aoste.timesquare.ccslkernel.runtime.simulation.CCSLStepExecutionEngine;
import fr.inria.aoste.timesquare.ccslkernel.runtime.exceptions.SimulationException;
import fr.inria.aoste.timesquare.ccslkernel.runtime.simulation.CCSLSimulationEngine;
import org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.models.TrafficControlModel;
import java.util.Set;

public class TrafficControlMain {


    public static void main(String[] args)
                throws SimulationException {
        TrafficControlModel model = new TrafficControlModel();
        CCSLSimulationEngine engine = new CCSLSimulationEngine(model);
        engine.initSimulation();
        CCSLStepExecutionEngine stepEngine = new CCSLStepExecutionEngine(engine);
        // First simulation step.
        stepEngine.executeStep();
        Set<RuntimeClock> firedClocks = stepEngine.getFiredClocks();
        System.out.println(firedClocks);
        // Second simulation step. The CCSLStepExecutionEngine object can be reused.
        stepEngine.executeStep();
        // Third simulation step.
        stepEngine.executeStep();
        engine.endSimulation();
    }

}
