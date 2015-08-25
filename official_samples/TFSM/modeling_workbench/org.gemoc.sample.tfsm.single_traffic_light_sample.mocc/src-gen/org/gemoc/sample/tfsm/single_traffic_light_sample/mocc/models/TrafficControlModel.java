package org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.models;

import fr.inria.aoste.timesquare.ccslkernel.runtime.AbstractRuntimeBlock;
import org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.TrafficControl.blocks.MainBlockBlock;
import fr.inria.aoste.timesquare.ccslkernel.runtime.AbstractRuntimeModel;
import fr.inria.aoste.timesquare.ccslkernel.runtime.IRuntimeContainer;

public class TrafficControlModel extends AbstractRuntimeModel {

    private MainBlockBlock mainblock = null;


    public TrafficControlModel() {
        super("TrafficControl");
        init();
    }

    public TrafficControlModel(IRuntimeContainer parent) {
        super("TrafficControl", parent);
        init();
    }

    protected void init() {
        if ( mainblock == null ) {
            mainblock = new MainBlockBlock(this, "mainBlock");
        }
    }

    @Override
    public AbstractRuntimeModel[] getImportedModels() {
        AbstractRuntimeModel[] subs = {  };
        return subs;
    }

    public MainBlockBlock getMainBlock() {
        if ( mainblock == null ) {
            mainblock = new MainBlockBlock(this, "mainBlock");
        }
        return mainblock;
    }

    @Override
    public AbstractRuntimeBlock[] getSubBlocks() {
        AbstractRuntimeBlock[] subs = { mainblock };
        return subs;
    }

    @Override
    public AbstractRuntimeBlock getEntryBlock() {
        return mainblock;
    }

}
