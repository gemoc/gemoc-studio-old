package org.gemoc.sample.tfsm.purek3.dsa.ext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.EvaluateGuard;
import org.gemoc.sample.tfsm.EventGuard;
import org.gemoc.sample.tfsm.FSMClock;
import org.gemoc.sample.tfsm.State;
import org.gemoc.sample.tfsm.TFSM;
import org.gemoc.sample.tfsm.TemporalGuard;
import org.gemoc.sample.tfsm.TimedSystem;
import org.gemoc.sample.tfsm.Transition;
import org.gemoc.sample.tfsm.purek3.dsa.FSMClockAspect;
import org.gemoc.sample.tfsm.purek3.dsa.IVisitor;
import org.gemoc.sample.tfsm.purek3.dsa.StateAspect;
import org.gemoc.sample.tfsm.purek3.dsa.TFSMAspect;
import org.gemoc.sample.tfsm.purek3.dsa.TransitionAspect;

@SuppressWarnings("all")
public class MyVisitor implements IVisitor {
  private int _stepNumber = 0;
  
  private int _lastStateChangeStepNumber = 0;
  
  private boolean isFirstExecutionStep() {
    return (this._stepNumber == 0);
  }
  
  public void beginVisit(final TFSM tfsm) {
    try {
      InputOutput.println();
      boolean _isFirstExecutionStep = this.isFirstExecutionStep();
      if (_isFirstExecutionStep) {
        TFSMAspect.Init(tfsm);
      }
      State _currentState = TFSMAspect.currentState(tfsm);
      String _name = _currentState.getName();
      String _plus = ((("Step " + Integer.valueOf(this._stepNumber)) + " - current state: ") + _name);
      InputOutput.<String>println(_plus);
      Thread.sleep(1000);
      this._stepNumber++;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void endVisit(final TFSM tfsm) {
  }
  
  public void beginVisit(final FSMClock clock) {
    FSMClockAspect.ticks(clock);
    Integer _numberOfTicks = FSMClockAspect.numberOfTicks(clock);
    this._stepNumber = (_numberOfTicks).intValue();
  }
  
  public void endVisit(final FSMClock clock) {
  }
  
  public void beginVisit(final State state) {
    StateAspect.onEnter(state);
  }
  
  public void endVisit(final State state) {
    StateAspect.onLeave(state);
  }
  
  public void beginVisit(final Transition transition) {
  }
  
  public void endVisit(final Transition transition) {
  }
  
  public void beginVisit(final TemporalGuard guard) {
    int _afterDuration = guard.getAfterDuration();
    int _plus = (_afterDuration + this._lastStateChangeStepNumber);
    boolean _equals = (_plus == this._stepNumber);
    if (_equals) {
      EObject _eContainer = guard.eContainer();
      final Transition transitionToFire = ((Transition) _eContainer);
      String _name = transitionToFire.getName();
      String _plus_1 = ("fire transition " + _name);
      InputOutput.<String>println(_plus_1);
      TransitionAspect.fire(transitionToFire);
      this._lastStateChangeStepNumber = this._stepNumber;
    }
  }
  
  public void endVisit(final TemporalGuard guard) {
  }
  
  public void beginVisit(final EventGuard guard) {
  }
  
  public void endVisit(final EventGuard guard) {
  }
  
  public void beginVisit(final EvaluateGuard guard) {
  }
  
  public void endVisit(final EvaluateGuard guard) {
  }
  
  public void beginVisit(final TimedSystem system) {
  }
  
  public void endVisit(final TimedSystem system) {
  }
}
