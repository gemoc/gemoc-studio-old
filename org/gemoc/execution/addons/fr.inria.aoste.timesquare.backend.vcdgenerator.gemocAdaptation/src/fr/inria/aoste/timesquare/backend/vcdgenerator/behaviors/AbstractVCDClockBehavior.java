package fr.inria.aoste.timesquare.backend.vcdgenerator.behaviors;

import fr.inria.aoste.timesquare.backend.manager.visible.Behavior;
import fr.inria.aoste.timesquare.backend.manager.visible.ClockBehavior;
import fr.inria.aoste.timesquare.backend.vcdgenerator.ScoreBoard;

/**
 * 
 * AbstractVCDClockBehavior class<BR>
 * This class implements ClockBehavior and defines an overlay
 * to it, as it is this class that will be extended
 * by the actual behaviors, in a very similar fashion
 * to the one used in the Duration model.
 * 
 * @author ybondue
 * @version 1.0.0
 * @since Stage DUT Yann Bondue 2011
 *
 */
public abstract class AbstractVCDClockBehavior implements ClockBehavior {
	
	/** The field allowing a behavior to write in the VCD. */
	protected ScoreBoard _scoreBoard;
	/** The "!" + clockNumber field */
	protected String _pCode;
	/** This field specifies if the behavior's variable has already been initialized. */
	protected boolean _initialized = false;

	public boolean isInitialized() {
		return _initialized;
	}

	public void setInitialized(boolean initialized) {
		this._initialized = initialized;
	}

	public String getPCode() {
		return this._pCode;
	}
	
	public void setPCode(String pCode) {
		this._pCode = pCode;
	}

	public void setScoreBoard(ScoreBoard scoreBoard) {
		this._scoreBoard = scoreBoard;
	}

	@Override
	public boolean behaviorEquals(Behavior behavior) {
		//return this.equals(behavior);
		if (this == behavior)
			return true;
		return false;
	}
	
	protected String sanitizeClockName(String name) {
		StringBuilder sb = new StringBuilder(name);
		for (int i = 0 ; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if ( ! Character.isLetterOrDigit(c) && c != '-' && c != '_') {
				sb.setCharAt(i, '_');
			}
		}
		return sb.toString();
	}
	
	/**
	 * initialize method<BR>
	 * This method has to be overridden by every behaviors,
	 * it specifies how every behavior acts at the beginning
	 * of the simulation.<BR>
	 * Most of the time, in the VCD Generation context, this
	 * method is where the behaviors create the variable
	 * that represents them in the ScoreBoard.
	 * 
	 * @since 1.0.0
	 */
	public abstract void initialize();
	
	/**
	 * end method<BR>
	 * This method has to be overridden by every behaviors,
	 * it specifies how every behavior ends.<BR>
	 * Most of the time, in the VCD Generation context, this
	 * method is where the behaviors set their clock in a
	 * dead state.
	 * 
	 * @since 1.0.0
	 */
	public abstract void end();
	
	/**
	 * aNewStep method<BR>
	 * This method has to be overridden by every behaviors,
	 * it specifies how every behavior acts at the beginning
	 * of a new step.<BR>
	 * Most of the time, in the VCD Generation context, this
	 * method is where the behaviors set their clock in a
	 * ready state to compute the next step.
	 * 
	 * @since 1.0.0
	 */
	public abstract void aNewStep();
	
	/**
	 * aPostNewStep method<BR>
	 * This method has to be overridden by every behaviors,
	 * it specifies how every behavior acts at the end of a
	 * new step.<BR>
	 * Most of the time, in the VCD Generation context, this
	 * method is where the behaviors set their clock in a
	 * end state to finish to compute the current step.
	 * 
	 * @since 1.0.0
	 */
	public abstract void aPostNewStep();
}
