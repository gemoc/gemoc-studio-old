package fr.inria.aoste.timesquare.backend.vcdgenerator.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.DefaultEngineAddon;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

import fr.inria.aoste.timesquare.backend.manager.visible.ClockEntity;
import fr.inria.aoste.timesquare.backend.manager.visible.ConfigurationHelper;
import fr.inria.aoste.timesquare.backend.manager.visible.PersistentOptions;
import fr.inria.aoste.timesquare.backend.manager.visible.TraceHelper;
import fr.inria.aoste.timesquare.backend.vcdgenerator.ScoreBoard;
import fr.inria.aoste.timesquare.backend.vcdgenerator.behaviors.AbstractVCDClockBehavior;
import fr.inria.aoste.timesquare.backend.vcdgenerator.behaviors.VCDGeneratorClockBehavior;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity;
import fr.inria.aoste.timesquare.trace.util.HelperFactory;
import fr.inria.aoste.timesquare.trace.util.TimeBase;
import fr.inria.aoste.timesquare.trace.util.adapter.AdapterRegistry;
import fr.inria.aoste.timesquare.utils.console.ErrorConsole;
import fr.inria.aoste.timesquare.utils.pluginhelpers.PluginHelpers;
import fr.inria.aoste.timesquare.vcd.antlr.editors.VcdMultiPageEditor;
import fr.inria.aoste.timesquare.vcd.menu.Mode;
import fr.inria.aoste.timesquare.vcd.model.ICommentCommand;
import fr.inria.aoste.timesquare.vcd.model.command.DateCommand;
import fr.inria.aoste.timesquare.vcd.model.command.SimulationCommand;
import fr.inria.aoste.timesquare.vcd.model.command.TimeScaleCommand;
import fr.inria.aoste.timesquare.vcd.model.command.VersionCommand;
import fr.inria.aoste.timesquare.vcd.model.comment.ScaleCommand;
import fr.inria.aoste.timesquare.vcd.model.keyword.TimeUnit;
import fr.inria.aoste.timesquare.vcd.preferences.VcdColorPreferences;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.PhysicalBase;
import fr.inria.aoste.trace.TraceFactory;

/**
 * 
 * VCDGeneratorManager class<BR>
 * This class extends BehaviorManager and defines the specifications and basic
 * methods of the VCD Generation behavior.
 * 
 * @author ybondue
 * @version 2.0.0
 * @since Stage DUT Yann Bondue 2011
 * 
 * modified on February 2015 by julien deantoni to make it an gemoc engine addon
 * 
 */
public class VCDGeneratorManager extends DefaultEngineAddon{

	private final static String PLUGIN_NAME = "VCD Generation";
	private final static String VERSION_NAME = "2.1.0";

	/**
	 * This field allows access to all the behaviors of the simulation from
	 * anywhere.
	 */
	private Vector<AbstractVCDClockBehavior> _behaviorList;
	/** This field allows the Manager to write in the VCD output. */
	private ScoreBoard _scoreBoard;
	/** This field gives the Manager the means to edit the VCD output. */
	private VcdMultiPageEditor _vcdEditor;
	/** This field specifies the path to the output file. */
	private IPath _outputFilePath;
	/** This field specifies the name of the output file. */
	private String _outputFileName;
	/** This field specifies the color options for the VCD Viewer plug-in. */
	private VcdColorPreferences _myColorAPI;

	/**
	 * This field specifies whether the pulses will be generated during this
	 * simulation.
	 */
	private boolean _pulses = false;
	/**
	 * This field specifies whether the ghosts will be generated during this
	 * simulation.
	 */
	private boolean _ghosts = false;
	/**
	 * This field is required for updating the VCD output, it remembers the size
	 * of the ScoreBoard since the last time the updating algorithm has been
	 * applied.
	 */
	private int previousSize = 0;

	/**
	 * 
	 */
	private boolean _launchVCDViewer = true;

	/**
	 * This field specifies the number of the step that is currently being
	 * computed.
	 */
	private int _currentStep = 0;

	private String _durationModelFilename;
	
	public String getPluginName() {
		return PLUGIN_NAME;
	}

	public String get_durationModelFilename() {
		return _durationModelFilename;
	}

	public void set_durationModelFilename(String _durationModelFilename) {
		this._durationModelFilename = _durationModelFilename;
	}

	private ISolver _solver = null;
	
	@Override
	public void engineAboutToStart(IExecutionEngine engine) {
		_solver = engine.getExecutionContext().getExecutionPlatform().getSolver();
		_behaviorList = null;
		_behaviorList = new Vector<AbstractVCDClockBehavior>();
		for(ModelElementReference mer : _solver.getAllDiscreteClocks())
		{
			GemocClockEntity ced = new GemocClockEntity(mer);
			this.addVCDGeneratorBehavior(ced, true,	false,null);
		}
	}

	/**
	 * addVCDGeneratorBehavior method<BR>
	 * This methods adds a behavior to the list of behaviors that the simulation
	 * will have using the VCDGeneratorBehavior class constructor.<BR>
	 * For this class, it means adding a clock to the list of those which VCD
	 * will be generated. The behavior will have a name which is the same of the
	 * one of the ClockEntity (as returned by {@link ClockEntity#getName()}).
	 * This is necessary as this assumption of identical names is used both in
	 * this function and in
	 * {@link #getClock(ConfigurationHelper, VCDGeneratorClockBehavior)} when
	 * called either from
	 * {@link #beforeExecution(ConfigurationHelper, IPath, String)} or from
	 * {@link #redoClockBehavior(ConfigurationHelper, PersistentOptions)}.
	 * 
	 * @param clockEntity
	 *            The Clock chosen by the user in the GUI, see ClockEntity for
	 *            more details about the types that this includes.
	 * @param pulses
	 *            A boolean indicating if the user has chosen to generate the
	 *            pulses.
	 * @param ghosts
	 *            A boolean indicating if the user has chosen to generate the
	 *            ghosts.
	 * @param ced
	 * @see fr.inria.aoste.timesquare.backend.manager.visible.ClockEntity
	 * @since 1.0.0
	 */
	public void addVCDGeneratorBehavior(GemocClockEntity clockEntity, boolean pulses, boolean ghosts,
			GemocClockEntity discretize) {
		addVCDGeneratorBehavior(
				new VCDGeneratorClockBehavior(pulses, ghosts, clockEntity.getName(),
						(discretize != null ? AdapterRegistry.getAdapter(
								discretize.getModelElementReference()).getUID(
								discretize.getModelElementReference()) : "")), clockEntity,
				discretize);
	}

	/**
	 * addVCDGeneratorBehavior method<BR>
	 * This methods adds a behavior to the list of behaviors that the simulation
	 * will have.<BR>
	 * For this class, it means adding a clock to the list of those which VCD
	 * will be generated.
	 * 
	 * @param behavior
	 *            The behavior that is going to be added.
	 * @param clockEntity
	 *            The Clock chosen by the user in the GUI, see ClockEntity for
	 *            more details about the types that this includes.
	 * @see fr.inria.aoste.timesquare.backend.vcdgenerator.behaviors.VCDGeneratorClockBehavior
	 * @since 1.0.0
	 */
	private void addVCDGeneratorBehavior(VCDGeneratorClockBehavior behavior,
			GemocClockEntity clockEntity, GemocClockEntity discretize) {

		addVCDGeneratorBehavior(behavior);


	}

	private String discretize = null;

	/**
	 * addVCDGeneratorBehavior method<BR>
	 * This methods adds a behavior to the list of behaviors that the simulation
	 * will have.<BR>
	 * For this class, it means adding a clock to the list of those which VCD
	 * will be generated.<BR>
	 * This method has to set the _pulses and _ghosts fields for the Manager as
	 * these parameters will be used for every single behavior.
	 * 
	 * @param behavior
	 *            The behavior that is going to be added.
	 * @see fr.inria.aoste.timesquare.backend.vcdgenerator.behaviors.VCDGeneratorClockBehavior
	 * @since 1.0.0
	 */
	private void addVCDGeneratorBehavior(VCDGeneratorClockBehavior behavior) {

		this._behaviorList.add(behavior);
		if (behavior.isPulses())
			_pulses = true;
		if (behavior.isGhosts())
			_ghosts = true;
		discretize = behavior.getDiscretize();
	}



	/**
	 * getClock method<BR>
	 * This method returns the ClockEntity associated with the behavior passed
	 * by the user in parameter. The ClockEntity object and the behavior object
	 * must have the same name (as returned by the {@link ClockEntity#getName()}
	 * and {@link VCDGeneratorClockBehavior#getName()} calls on both objects)<BR>
	 * This is needed as the ClockEntity class may not be serialized as part of
	 * the VCDGeneratorPersistentOptions class.
	 * 
	 * @param helper
	 *            The ConfigurationHelper of the behavior manager
	 * @param behavior
	 *            The target behavior on which we require to get the clock.
	 * @return The ClockEntity associated with the <i>behavior</i> parameter.
	 * @since 1.1.0
	 */
	private GemocClockEntity getClock(VCDGeneratorClockBehavior behavior) {

		ArrayList<GemocClockEntity> allClocksEntities = new ArrayList<GemocClockEntity>();
		for (ModelElementReference mer : _solver.getAllDiscreteClocks()){
			allClocksEntities.add(new GemocClockEntity(mer));
		}
		
		for (GemocClockEntity clock : allClocksEntities) {
			if (clock.getName().compareTo(behavior.getName()) == 0)
				return clock;
		}
		return null;
	}

	/**
	 * Called directly when the DeleteAll button is pressed in the Launch
	 * configuration GUI. Also called from the
	 * {@link #init(ConfigurationHelper)} function for consistency of
	 * (re)initialization.
	 * 
	 * @see fr.inria.aoste.timesquare.backend.manager.view.View.DeleteAllButtonSelectionAdapter#widgetSelected(SelectionEvent)
	 */
	public void clear() {
		_behaviorList.clear();
	}



	private ScaleCommand scaleCommand;

	/**
	 * beforeExecution method<BR>
	 * This generates the VCD file header, which groups together :
	 * <ul>
	 * <li>The date of the simulation</li>
	 * <li>The version of the generator</li>
	 * <li>The current timescale</li>
	 * </ul>
	 * It then generates the VCD constraints :
	 * <ul>
	 * <li>The hidden constraint</li>
	 * <li>The xmi constraint</li>
	 * <li>The alias constraint</li>
	 * </ul>
	 * Lastly, it generates the relation constraint.<BR>
	 * It also sets the basic parameters options required for the generation.<BR>
	 * <BR>
	 * 
	 * @override
	 * @since 1.0.0
	 */
	@Override
	public void engineStarted(IExecutionEngine executionEngine) {
		
		IPath fin = executionEngine.getExecutionContext().getWorkspace().getExecutionPath();
		IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(fin);
//		IPath p = new Path(ResourcesPlugin.getWorkspace().getRoot().getLocation()+"/"+fin.toPortableString());
		IPath p = folder.getLocation();
		setOutputFile(p, "vcdFromSimu");
		_myColorAPI = VcdColorPreferences.createColor();
		_scoreBoard = ScoreBoard.getScoreboard(_outputFileName, _myColorAPI);

		fileHeader();

		int i = 0;
		for (AbstractVCDClockBehavior behavior : _behaviorList) {
			/*
			 * Special treatments for behaviors begin here
			 */

			if (behavior instanceof VCDGeneratorClockBehavior) {
				((VCDGeneratorClockBehavior) behavior).setClock(getClock(
						(VCDGeneratorClockBehavior) behavior));
				((VCDGeneratorClockBehavior) behavior).setPulses(_pulses);
				((VCDGeneratorClockBehavior) behavior).setGhosts(_ghosts);
			} // Special treatment for VCDGeneratorClockBehaviors

			/*
			 * Special treatments for behaviors end here
			 */

			// Generic treatment for VCDGenerationClockBehaviors. Also suitable
			// for DurationClockBehaviors.
			behavior.setScoreBoard(_scoreBoard);
			if (behavior.getPCode() == null)
				behavior.setPCode("!" + ++i);
			if (!behavior.isInitialized())
				behavior.initialize();

		}
//		for (PhysicalBase lpb : helper.getPhysicalBases()) {
//			Reference r = lpb.getRelatedDenseClock();
//			if (r instanceof ModelElementReference) {
//				EObject eo = ((ModelElementReference) r).getElementRef().get(0);
//				String s = AdapterRegistry.getAdapter(eo).getUID(eo);
//				if (s != null && s.equals(discretize)) {
//					pb = lpb;
//					try {
//						TimeBase tb = AdapterRegistry.getAdapter(eo).getDiscretyzeByValue(eo)
//								.get(0);
//						physical = tb;
//					} catch (Exception e) {
//						physical = new TimeBase(1.0);
//					}
//				}
//			}
//		}
		if (pb == null) {
			scaleCommand = new ScaleCommand(0.10d);
		} else {
			scaleCommand = new ScaleCommand(physical.getBase(), physical.getUnitname());//
		}
		_scoreBoard.getVcdModel().addDefinition(scaleCommand);
		createFileCreationThread();

		createVCDUpdateThread();

	}

	/**
	 * end method<BR>
	 * This generates the last part of the VCD : the step where all clocks are
	 * killed.<BR>
	 * This method also erases most Java references and frees memory.
	 * 
	 * @override
	 * @since 1.0.0
	 */
	@Override
	public void engineAboutToStop(IExecutionEngine engine) {
		_currentStep++;
		if (_scoreBoard != null)
		{
			int instant = _currentStep * 10;
			// Representation of the end of the simulation
			SimulationCommand sc = _scoreBoard.tick(instant);
			for (AbstractVCDClockBehavior behavior : _behaviorList) {
				behavior.end();
			}
			StepManager sm = new StepManager();
			sm.simCommand = sc;
			sm.fixed = false;
			if (hmism != null)
				hmism.put(_currentStep, sm);
			lsstep.add(sm);
			if (pb != null) {
				updateDate(pb);
			}
			createEndThread();
			_myColorAPI = null;
			if (_scoreBoard != null)
				ScoreBoard.removeScoreboard(_scoreBoard);
			_scoreBoard = null;
			for (AbstractVCDClockBehavior b : _behaviorList) {
				b.setScoreBoard(null);
			}
			_behaviorList.clear();
			_behaviorList = null;
			hmism.clear();
			lsstep.clear();
			hmism = null;
			lsstep = null;
			_vcdEditor = null;
		}
	}

	
	private int step = -1;
	/**
	 * aNewStep method<BR>
	 * This generates the steps numbers on the output and updates the VCD
	 * output.
	 * 
	 * @override
	 * @since 1.0.0
	 */
	@Override
	public void logicalStepExecuted(IExecutionEngine engine, LogicalStep logicalStepExecuted){
		if (_scoreBoard == null)
			return;

//		step++;
//		int date = step;
//		_currentStep = step;
//		int instant = step * 10;

		_currentStep++;
		int date = _currentStep;
		int instant = _currentStep * 10;
		
		StepManager sm = new StepManager();
		SimulationCommand sc = _scoreBoard.tick(instant);
		sm.simCommand = sc;
		sm.fixed = false;
		hmism.put(date, sm);
		lsstep.add(sm);
		
		
		
		ArrayList<AbstractVCDClockBehavior> alreadyDone = new ArrayList<AbstractVCDClockBehavior>();
		
		for(MSEOccurrence occ : logicalStepExecuted.getMseOccurrences()){
			Clock c = (Clock) occ.getMse().getSolverEvent();
			for (AbstractVCDClockBehavior b : _behaviorList){
				if (b instanceof VCDGeneratorClockBehavior){
					VCDGeneratorClockBehavior vb = (VCDGeneratorClockBehavior)b;
					ConcreteEntity ce = ((GemocClockEntity)vb.getClock())._ce;
					ModelElementReference mer = ((GemocClockEntity)vb.getClock())._mer;
					if (ce.getName() == c.getName()){
						alreadyDone.add(b);
						EventOccurrence eocc = TraceFactory.eINSTANCE.createEventOccurrence();
						eocc.setFState(FiredStateKind.TICK);
						eocc.setReferedElement(mer);
						TraceHelper th = new TraceHelper(eocc, vb.getClock());
						vb.run(th);
						
					}
				}
			}
		}
		
		
		for (AbstractVCDClockBehavior b : _behaviorList){
			if (alreadyDone.contains(b)){
				continue;
			}
			if (b instanceof VCDGeneratorClockBehavior){
				VCDGeneratorClockBehavior vb = (VCDGeneratorClockBehavior)b;
				EventOccurrence eocc = TraceFactory.eINSTANCE.createEventOccurrence();
				eocc.setFState(FiredStateKind.NO_TICK);
				TraceHelper th = new TraceHelper(eocc, vb.getClock());
				vb.run(th);
				
			}
			b.aPostNewStep();
		}
				
		createVCDUpdateThread();
	}


	/**
	 * setOutputFile method<BR>
	 * This method sets the _outputFilePath and _outputFileName fields, these
	 * fields specify the location and the name of the file that will be
	 * generated.
	 * 
	 * @param path
	 *            The path to the folder containing the file.
	 * @param name
	 *            The name of the file that will be created (Without the
	 *            extension).
	 * @see IPath
	 * @since 1.0.0
	 */
	private void setOutputFile(IPath path, String name) {

		this._outputFilePath = path;
		this._outputFileName = name;
	}

	TimeScaleCommand tc;

	/**
	 * fileHeader method<BR>
	 * This method generates the header of the VCD file. It is comprised of the
	 * Date, Version and TimeScale of the current session.
	 * 
	 * @since 1.0.0
	 */
	private void fileHeader() {

		_scoreBoard.getVcdModel().addDefinition(new DateCommand(new Date().toString()));
		_scoreBoard.getVcdModel().addDefinition(new VersionCommand(PLUGIN_NAME, VERSION_NAME));
		tc = new TimeScaleCommand();
		tc.set(1, TimeUnit.tick);
		_scoreBoard.getVcdModel().addDefinition(tc);
	}

	
	/**
	 * createFileCreationThread method<BR>
	 * This method creates an instance of the FileCreationThread.
	 * 
	 * @see FileCreationThread
	 * @since 1.0.0
	 */
	private void createFileCreationThread() {

		try {
			Thread thread = new FileCreationThread();
			Display.getDefault().syncExec(thread);
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * createVCDUpdateThread method<BR>
	 * This method creates an instance of the VCD Updating Thread
	 * 
	 * @see UpdateThread
	 * @since 1.0.0
	 */
	private void createVCDUpdateThread() {

		if (_scoreBoard != null) {
			try {
				Thread thread = new UpdateThread();
				Display.getDefault().syncExec(thread);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * createEndThread method<BR>
	 * This method creates an instance of the End thread.
	 * 
	 * @since 1.0.0
	 * @see EndThread
	 */
	private void createEndThread() {

		try {
			Thread thread = new EndThread();
			Display.getDefault().syncExec(thread);
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * finalize method<BR>
	 * The aim of this override is to ensure that there won't be any memory
	 * leaks due to the scoreBoard.
	 * 
	 * @override
	 * @since 1.0.0
	 */
	@Override
	public void engineStopped(IExecutionEngine engine) {
		// System.out.println("Finalize VCDGeneratorManager");
		engineAboutToStop(engine);
		if (_scoreBoard != null)
			ScoreBoard.removeScoreboard(_scoreBoard);
		super.engineStopped(engine);
	}

	/**
	 * 
	 * UpdateThread class<BR>
	 * This class allows the instantiation of threads that refresh the VCD
	 * Editor view using updating methods in order for the view to be up to date
	 * with the steps representation
	 * 
	 * @author ybondue
	 * @version 1.0.0
	 * @since Stage DUT Yann Bondue 2011
	 * @see UpdateThread#run()
	 * 
	 */
	private class UpdateThread extends Thread {

		/**
		 * Standard Thread constructor.
		 */
		protected UpdateThread() {
			super("Update VCD Thread");
		}

		/**
		 * run method<BR>
		 * This method operates updating processes to the VCD Editor.
		 * 
		 * @override
		 * @since 1.0.0
		 */
		@Override
		public void run() {
			if (_scoreBoard != null
				&& _vcdEditor != null) 
			{
				int currentSize = _scoreBoard.getSize();
				try {
					_vcdEditor.update2(previousSize, currentSize+1, false);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//previousSize = currentSize;			
				_vcdEditor.setSimulationProgress(currentSize/10);
			}
		}
	}

	/**
	 * 
	 * FileCreationThread class<BR>
	 * This thread creates the file at the location specified within the
	 * _outputFilePath and _outputFileName fields, it also sets the basic
	 * options for the VCDEditor field.<BR>
	 * To set the fields used within this method, see the setOutputFile method.
	 * 
	 * @author ybondue
	 * @version 1.0.0
	 * @since Stage DUT Yann Bondue 2011
	 * @see VCDGeneratorManager#setOutputFile(IPath, String)
	 * @see FileCreationThread#run()
	 * 
	 */
	private class FileCreationThread extends Thread {

		/**
		 * Standard Thread constructor.
		 */
		protected FileCreationThread() {
			super("File Creation Thread");
		}

		/**
		 * run method<BR>
		 * This method creates the VCD file and sets the basic parameters of the
		 * VCD Editor.
		 * 
		 * @override
		 * @since 1.0.0
		 */
		@Override
		public void run() {
			/*
			 * TODO The creation of the VCD viewer should be optional and there
			 * should be a related settings in the GUI. On some long
			 * simulations, the VCD display consumes too much time and renders
			 * the whole application quite unusable.
			 */
			IFile file = PluginHelpers.touchFile(_outputFilePath, _outputFileName + ".vcd");
			_vcdEditor = VcdMultiPageEditor.createNewVcdMultiPageEditor(_scoreBoard.getVcdModel(),
					file, _myColorAPI);
			if (_vcdEditor != null) {
				_vcdEditor.setSimulation(true);
				_vcdEditor.getTraceCollector().setPartial(true);
				_vcdEditor.setGhostMode(Mode.bool2Mode(_ghosts));
				_vcdEditor.setSimulationProgress(2);
			}
		}
	}

	/**
	 * 
	 * EndThread class<BR>
	 * This class allows the instantiation of a thread which goal is to erase
	 * Java references and free allocated memory, it also sets the VCD Editor in
	 * its ending phase.
	 * 
	 * @author ybondue
	 * @version 1.0.0
	 * @since Stage DUT Yann Bondue 2011
	 * @see EndThread#run()
	 * 
	 */
	private class EndThread extends Thread {

		/**
		 * Standard Thread constructor.
		 */
		protected EndThread() {
			super("End VCD Thread");
		}

		/**
		 * run method<BR>
		 * This method operates memory freeing processes.
		 * 
		 * @override
		 * @since 1.0.0
		 */
		@Override
		public void run() {
			try {
				if (_vcdEditor != null) {
					_vcdEditor.syncModel2Text();
					_vcdEditor.setFocus();
					int currentSize = _scoreBoard.getSize();
					_vcdEditor.update2(previousSize, currentSize, true);
					if (_vcdEditor.getTraceCollector() != null)
						_vcdEditor.getTraceCollector().setPartial(false);
					_vcdEditor.setSimulation(false);
					_vcdEditor.doSave(null);
					_vcdEditor.vcdMultiPageEditorRefresh();
				}
				ScoreBoard.removeScoreboard(_scoreBoard);
				_scoreBoard = null;
				_myColorAPI = null;
				if (_vcdEditor != null)
					_vcdEditor.setActiveVCDPage();
			} catch (Throwable t) {
				t.printStackTrace();
			}
			_scoreBoard = null;
			_myColorAPI = null;
		}
	}

	PhysicalBase pb = null;
	TimeBase physical = null;

	private static class StepManager {
		SimulationCommand simCommand;
		boolean fixed;
	}

	private HashMap<Integer, StepManager> hmism = new HashMap<Integer, StepManager>();
	private List<StepManager> lsstep = new ArrayList<StepManager>();

	public int updateDate(PhysicalBase pb) {
		try {
			scaleCommand.setBase(physical.getBase() / 100);
			Boolean firstSimulationFixed = lsstep.get(0).fixed;

			int intervalLenght = HelperFactory.getMaxInterval(pb) + 1;
			// System.err.println(" Linearize  ..." + (intervalLenght-1));
			int intervalLenghtRef = intervalLenght;
			if (intervalLenght % 10 != 0) {
				intervalLenght = intervalLenght / 10 + 10;
			}

			int scaleUnit = 0;
			if (intervalLenghtRef < 6) {
				scaleUnit = intervalLenght / 5;
			} else {
				scaleUnit = intervalLenght / 10;
			}

			int currentSimulationTime = -1;
			int currentIntervalUnit = 0;

			for (StepManager sm : lsstep) {
				if (sm == null) {
					continue;
				}
				if (firstSimulationFixed) {
					if (currentSimulationTime == -1) {
						currentSimulationTime += 1;
						sm.simCommand.setTime(0);
					} else {
						if (sm.fixed) {
							currentIntervalUnit += intervalLenght;
							currentSimulationTime = currentIntervalUnit;
							sm.simCommand.setTime(currentSimulationTime * 10);
						} else {
							currentSimulationTime += scaleUnit;
							sm.simCommand.setTime(currentSimulationTime * 10);
						}
					}
				} else {
					if (currentSimulationTime == -1) {
						currentSimulationTime += 1;
						sm.simCommand.setTime(0);

					} else {
						if (sm.fixed) {
							currentIntervalUnit += intervalLenght;
							currentSimulationTime = currentIntervalUnit;
							sm.simCommand.setTime(currentSimulationTime * 10);
						} else {
							currentSimulationTime += scaleUnit;
							sm.simCommand.setTime(currentSimulationTime * 10);
						}
					}

				}

			}

		} catch (Throwable e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	public boolean is_launchVCDViewer() {
		return _launchVCDViewer;
	}

	public void set_launchVCDViewer(boolean _launchVCDViewer) {
		this._launchVCDViewer = _launchVCDViewer;
	}

}
