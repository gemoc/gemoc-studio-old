package fr.inria.aoste.timesquare.backend.vcdgenerator.behaviors;

import org.eclipse.emf.ecore.EObject;

import fr.inria.aoste.timesquare.backend.manager.visible.ClockEntity;
import fr.inria.aoste.timesquare.backend.manager.visible.TraceHelper;
import fr.inria.aoste.timesquare.backend.vcdgenerator.ScoreBoard;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.Block;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Expression;
import fr.inria.aoste.timesquare.trace.util.ReferenceNameBuilder;
import fr.inria.aoste.timesquare.vcd.model.BinaryVectorValueChange;
import fr.inria.aoste.timesquare.vcd.model.ICommentCommand;
import fr.inria.aoste.timesquare.vcd.model.Value;
import fr.inria.aoste.timesquare.vcd.model.keyword.VarType;
import fr.inria.aoste.trace.EnableStateKind;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;
import fr.inria.aoste.trace.ModelElementReference;

/**
 * 
 * VCDGeneratorBehavior class<BR>
 * This class extends AbstractVCDClockBehavior and defines how
 * a clock behaves in order for its VCD to be generated.<BR>
 * Two booleans indicate if the user has chosen to display
 * the pulses and/or the ghosts in VCD.
 * 
 * @author ybondue
 * @version 1.1.0
 * @since Stage DUT Yann Bondue 2011
 *
 */
public class VCDGeneratorClockBehavior extends AbstractVCDClockBehavior {
	
	/** A boolean indicating if the user has chosen to generate the pulses for this clock. */
	private boolean _pulses;
	/** A boolean indicating if the user has chosen to generate the ghosts for this clock. */
	private boolean _ghosts;
	/** The field specifying if this clock is a timer or not. */
	private boolean	_timer;
	/** The field specifying if this clock is dead or not. */
	private boolean _dead;
	/** The clockName field : used as the name of the behavior and must be the same as the name of the ClockEntity
	 *  associated with the behavior. Both names are obtained with the getName() call on each object. */
	protected String _name;
	/** The field specifying the clockEntity of this behavior. */
	private ClockEntity _clock;
	/** Pragma for clock to XMI */
	private ICommentCommand _xmiCommentCommand = null;
	/** The clockName + clockName.hashCode() field : it is used as the clock name in the VCD file and, as such, must be
	 *  free of all characters not allowed in this context. Use {@link AbstractVCDClockBehavior#sanitizeClockName()} to
	 *  set its value. The visible name in the VCD editor will be specified through a alias comment in the VCD file and
	 *  the aliased name is the result of the call of {@link AdapterRegistry#getAliasName()} on the 
	 *  ModelElementReference object {@link #modelElementReference} of the Clock associated with the behavior */
	final private String _uniqueName;
	
	private ModelElementReference modelElementReference = null;
	
	private String _discretize = null;
	private boolean _wasBorn = true;
	/**
	 * Standard constructor
	 * 
	 * @param pulses A boolean indicating if the user has chosen to generate the pulses.
	 * @param ghosts A boolean indicating if the user has chosen to generate the ghosts.
	 * @param name The name of the clock.
	 * @param clock The EObject containing the ClockEntity.
	 * @since 1.0.0
	 */
	public VCDGeneratorClockBehavior(boolean pulses, boolean ghosts, String name, String discretize) {
		this._pulses = pulses;
		this._ghosts = ghosts;
		this._dead = false;
		this._name = name;
		this._uniqueName = sanitizeClockName(name);
		this._scoreBoard = null;
		this._discretize=discretize;
	}
	
	/**
	 * isPulses getter
	 * 
	 * @return The boolean indicating if the user has chosen to generate the pulses for this clock.
	 * @since 1.0.0
	 */
	public boolean isPulses() {
		return _pulses;
	}

	/**
	 * isGhosts getter
	 * 
	 * @return The boolean indicating if the user has chosen to generate the ghosts for this clock.
	 * @since 1.0.0
	 */
	public boolean isGhosts() {
		return _ghosts;
	}
	
	/**
	 * isTimer getter
	 * 
	 * @return The boolean indicating whether this clock is a timer or not.
	 * @since 1.0.0
	 */
	public boolean isTimer() {
		return _timer;
	}
	
	/**
	 * isDead getter
	 * 
	 * @return The boolean indicating whether this clock is dead or not.
	 * @since 1.0.0
	 */
	public boolean isDead() {
		return _dead;
	}
	
	/**
	 * getPCode getter
	 * 
	 * @return The string representing the identity of the clock as a variable within the VCD.
	 * @since 1.0.0
	 */
	public String getPCode() {
		return _pCode;
	}

	/**
	 * getName getter
	 * 
	 * @return The name of the clock
	 * @since 1.0.0
	 */
	public String getName() {
		return _name;
	}

	public String getDiscretize() {
		return _discretize;
	}

	/**
	 * getUniqueName getter
	 * 
	 * @return The unique name of the clock,
	 * obtained by appending the name's hash code
	 * to the name itself.
	 * @since 1.0.0
	 */
	public String getUniqueName() {
		return _uniqueName;
	}
	
	/**
	 * getClock getter
	 * 
	 * @return The ClockEntity representing this
	 * behavior's Clock
	 * @since 1.1.0
	 */
	public ClockEntity getClock() {
		return (ClockEntity) _clock;
	}
	
	/**
	 * setPulses setter<BR>
	 * This setter is required as pulses will be generated for
	 * a clock even if the user has chosen not to if at least
	 * one of the clocks for which the VCD is to be generated
	 * has been set to generate the pulses.
	 * 
	 * @param pulses The boolean indicating if the user has chosen to generate the pulses for this clock.
	 * @since 1.0.0
	 */
	public void setPulses(boolean pulses) {
		this._pulses = pulses;
	}
	
	/**
	 * setGhosts setter<BR>
	 * This setter is required as ghosts will be generated for
	 * a clock even if the user has chosen not to if at least
	 * one of the clocks for which the VCD is to be generated
	 * has been set to generate the ghosts.
	 * 
	 * @param ghosts The boolean indicating if the user has chosen to generate the shosts for this clock.
	 * @since 1.0.0
	 */
	public void setGhosts(boolean ghosts) {
		this._ghosts = ghosts;
	}

	/**
	 * setPCode setter<BR>
	 * 
	 * @param pCode The string representing the identity of the clock as a variable within the VCD.
	 * @since 1.0.0
	 */
	public void setPCode(String pCode) {
		this._pCode = pCode;
	}

	/**
	 * setTimer setter
	 * 
	 * @param timer The boolean indicating whether this clock is a timer or not.
	 * @since 1.0.0
	 */
	public void setTimer(boolean timer) {
		this._timer = timer;
	}
	
	/**
	 * setClock setter<BR>
	 * 
	 * @param clock The ClockEntity contained by an EObject reference.
	 * @since 1.0.0
	 */
	public void setClock(ClockEntity clock) {
		if (clock != null)
		{
			_clock = clock;
			modelElementReference = clock.getModelElementReference();
		}
	}

	/**
	 * setScoreBoard setter
	 * It is necessary that the Behavior has access to a way of
	 * writing in the VCD output, and due to the backend plug-in
	 * interfaces, the scoreBoard can't be set in the constructor.
	 * 
	 * @param scoreBoard The score board from the BehaviorManager which will allow the
	 * behavior to write in the VCD.
	 * @since 1.0.0
	 */
	public void setScoreBoard(ScoreBoard scoreBoard) {
		this._scoreBoard = scoreBoard;
	}

	@Override
	public String getDescription() {
		return "This clock's VCD will be generated.";
	}

	@Override
	public boolean equals(Object o) {
		
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		
		VCDGeneratorClockBehavior other = (VCDGeneratorClockBehavior)o;
		
		if ((this._pCode.equals(other._pCode)) && (this._uniqueName.equals(other._uniqueName)))
			return true;
		return false;
	}
	
	
	@Override
	public int hashCode() {		
		int x= _pCode!=null ? _pCode.hashCode() : 0;
		x+= _uniqueName!=null ? _uniqueName.hashCode() : 0;
		return x;
	}

	/**
	 * run method<BR>
	 * This method is called when a clock TICKS or DOESNOTTICK
	 * and also if the clock is undetermined or is dead, as these
	 * are also represented in VCD.<BR>
	 * It is here that we add the value change to the VCD.
	 * 
	 * @override
	 * @since 1.0.0
	 */
	@Override
	public void run(TraceHelper helper) {

		EventOccurrence eventOccurrence = helper.getClockState();
		if (_pCode != null)
			clockValueChangeGeneration(eventOccurrence);
	}

	/**
	 * runWithWrongActivationState method<BR>
	 * <i>This method's semantics is irrelevant to the VCD Generation.</i>
	 * 
	 * @override
	 * @since 1.0.0
	 */
	@Override
	public void runWithWrongActivationState(TraceHelper helper) {}
	
	/**
	 * clockValueChangeGeneration method<BR>
	 * This method generates the value change blocks
	 * for this behavior (<i>e.g. : </i>The value +
	 * _pCode (0!1) block).
	 * 
	 * @since 1.0.0
	 */
	private void clockValueChangeGeneration(EventOccurrence eventOccurrence) {
		
		_wasBorn =eventOccurrence.isWasBorn();
		_dead = eventOccurrence.isIsClockDead();
		
		if (_timer) {
			if (eventOccurrence.getFState() == FiredStateKind.TICK)
				_scoreBoard.add(new BinaryVectorValueChange("X", _pCode));
			if (eventOccurrence.getFState() == FiredStateKind.NO_TICK)
				_scoreBoard.add(new BinaryVectorValueChange("Z", _pCode));
		} else {
			if (eventOccurrence.getFState() == FiredStateKind.TICK) {
				_scoreBoard.addScalarValueChange(Value._1, _pCode);
				_scoreBoard.getVcdModel().getClocklistener().putDataonTickClock(_name, eventOccurrence.getCounter(), "clockstate", eventOccurrence);
				
			}
			if (eventOccurrence.getFState() == FiredStateKind.NO_TICK) {
				if (_dead || !_wasBorn) {
					_scoreBoard.addScalarValueChange(Value._z, _pCode);
				}
				else {
					if ((eventOccurrence.getEState() == EnableStateKind.FREE) || (eventOccurrence.getEState() == EnableStateKind.INDETERMINED))
						_scoreBoard.addScalarValueChange(Value._x, _pCode);
					else
						_scoreBoard.addScalarValueChange(Value._0, _pCode);
				}
			}
		}
	}

	@Override
	public void end() {
		_scoreBoard.addScalarValueChange(Value._z, _pCode);
	}

	/**
	 * aNewStep method<BR>
	 * <i>Unnecessary in this context.</i>.
	 * 
	 * @override
	 * @since 1.0.0
	 */
	@Override
	public void aNewStep() {}

	@Override
	public void aPostNewStep() {
		
		if (!_timer) {
			if (_dead || !_wasBorn)
				_scoreBoard.addScalarValueChange(Value._z, _pCode);
			else
				_scoreBoard.addScalarValueChange(Value._0, _pCode);
		}
	}

	@Override
	public void initialize() {
		if ( clockIsHiddenInVCD(modelElementReference)) { 
			_scoreBoard.getVcdModel().createCommentClock("hide", _uniqueName);
		}
		_scoreBoard.addVar(_uniqueName, VarType.event, _pCode);
		
		String alias = ReferenceNameBuilder.buildQualifiedName(modelElementReference);
		if (alias.compareTo(_uniqueName) != 0) {
			ICommentCommand icc = _scoreBoard.getVcdModel().createCommentClock("alias", _uniqueName);
			if (icc != null)
				icc.setString(2, "\"" + alias + "\"");
		}
		this.setInitialized(true);
	}
	
	/* TODO Find a better way to implement this functionnality.
	 * This implementation is a quick hack, previously done using the {@link IModelAdapter#isHidden()} function which
	 * does not exist no more.
	 */
	private boolean clockIsHiddenInVCD(ModelElementReference modelElementReference) {
		EObject r = modelElementReference.getElementRef().get(modelElementReference.getElementRef().size() - 1);
		if (r instanceof Clock || r instanceof Expression) {
			if (r.eContainer() != null && r.eContainer() instanceof Block) {
				return false;
			}
			else {
				return true;
			}
		}
		return false;
	}
	
}
