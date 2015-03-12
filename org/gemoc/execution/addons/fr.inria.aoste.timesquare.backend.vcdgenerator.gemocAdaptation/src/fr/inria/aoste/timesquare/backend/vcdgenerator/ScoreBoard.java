/*
 * 
 * @author : Benoit Ferrero
 * INRIA/I3S Aoste 
 * Copyright  2007-2008
 */
package fr.inria.aoste.timesquare.backend.vcdgenerator;

//package fr.inria.signal.capture;

import java.util.HashMap;

import fr.inria.aoste.timesquare.vcd.model.ScalarValueChange;
import fr.inria.aoste.timesquare.vcd.model.VCDDefinitions;
import fr.inria.aoste.timesquare.vcd.model.Value;
import fr.inria.aoste.timesquare.vcd.model.ValueChange;
import fr.inria.aoste.timesquare.vcd.model.command.ScopeCommand;
import fr.inria.aoste.timesquare.vcd.model.command.SimulationCommand;
import fr.inria.aoste.timesquare.vcd.model.command.VarCommand;
import fr.inria.aoste.timesquare.vcd.model.keyword.ScopeType;
import fr.inria.aoste.timesquare.vcd.model.keyword.VarType;
import fr.inria.aoste.timesquare.vcd.model.visitor.TraceCollector;
import fr.inria.aoste.timesquare.vcd.model.visitor.VarCollector;
import fr.inria.aoste.timesquare.vcd.preferences.VcdColorPreferences;
import fr.inria.aoste.timesquare.vcd.view.VcdFactory;

final public class ScoreBoard {
	/*
	 * A static registry of all the created ScoreBoard objects, indexed by their names (stored in the scoreBoardId field)
	 */
	private static final HashMap<String, ScoreBoard> map = new HashMap<String, ScoreBoard>();
	/*
	 * Link to the model of the VCD
	 */
	private VCDDefinitions vcdModel;
	private VcdFactory factory  ;
	private ScopeCommand scope;

	/**
	 * Used to store the last {@link SimulationCommand} object created at the last call of {@link #tick(int)}.
	 */
	private SimulationCommand sim = null;
	private VarCollector vc;
	private TraceCollector tc;
	/*
	 * The name of the VCD : same as the name of the associated .vcd file.
	 */
	private String scoreBoardId;




	private ScoreBoard(VcdColorPreferences mca) { // int step
		// this.step = step;
		// vcdModel
		factory = new VcdFactory(mca);
		vcdModel = new VCDDefinitions();
		vcdModel.setFactory(factory);
		vcdModel.setScope(scope = new ScopeCommand(ScopeType.module, "top"));
		//	vcdModel.addSimulation(sim = new SimulationCommand(0)); // step
		vc = new VarCollector(vcdModel.getArraylistDeclarationCommand());
		vcdModel.visit(vc);
		tc = new TraceCollector(vc, factory);
		vcdModel.visit(tc);

	}

	/*private ScoreBoard(VCDDefinitions vcdin, VcdColorPreferences mca) { // int step
		// this.step = step;
		// vcdModel
		factory = new VcdFactory(mca);
		vcdModel = vcdin;
		if (vcdModel == null)
			vcdModel = new VCDDefinitions();
		vcdModel.setScope(scope = new ScopeCommand(ScopeType.module, "default"));
	//	vcdModel.addSimulation(sim = new SimulationCommand(0)); // step
		vc = new VarCollector(vcdModel.getDecls());
		vcdModel.visit(vc);
		tc = new TraceCollector(vc, factory);
		vcdModel.visit(tc);
		vcdModel.setFactory(factory);
	}*/

	public void start() {
		for (String id : changes.keySet())
			changes.put(id, -1);
	}

	public SimulationCommand tick(int tick) {
		// tick++;
		vcdModel.addSimulation(sim = new SimulationCommand(tick, vcdModel));// tick *step
		return sim;
	}

	public int getSize() {
		return vcdModel.getArraylistSimulationCommand().size();
	}

	/** @return id */
	public String addVar(String name, String id) {
		// String id = "*"+name+nbVar;
		scope.addChild(new VarCommand(VarType.integer, 1, id, name));
		// changes.put(id, tick);
		return id;
	}

	public String addVar(String name, VarType vt ,String id) {
		// String id = "*"+name+nbVar;
		scope.addChild(new VarCommand(vt, 1, id, name));
		// changes.put(id, tick);
		return id;
	}

	private HashMap<String, Integer> changes = new HashMap<String, Integer>();

	public void addScalarValueChange(Value v, String clockId) {

		add(v, clockId);
	}

	private void add(Value v, String id) {
		sim.addValueChange(new ScalarValueChange(v, id));
	}

	public void add(ValueChange v) {
		sim.addValueChange(v);
	}

	static public ScoreBoard getScoreboard(String id, VcdColorPreferences mca) {
		ScoreBoard res = map.get(id);
		// if (res == null)
		{
			res = new ScoreBoard(mca);
			res.setId(id);
			map.put(id, res);
		}
		return res;
	}

	static public void removeScoreboard(String id) 
	{			
		map.remove(id);		
	}
	static public void removeScoreboard(ScoreBoard sc) 
	{			
		if ( sc!=null)
			map.remove(sc.getId());		
	}

	public VCDDefinitions getVcdModel() {
		return vcdModel;
	}

	protected void setId(String id) {
		this.scoreBoardId = id;
	}

	public String getId() {
		return scoreBoardId;
	}
}
