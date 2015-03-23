package org.gemoc.sample.tfsm.purek3.dsa;

import org.gemoc.sample.tfsm.EvaluateGuard;
import org.gemoc.sample.tfsm.EventGuard;
import org.gemoc.sample.tfsm.FSMClock;
import org.gemoc.sample.tfsm.State;
import org.gemoc.sample.tfsm.TFSM;
import org.gemoc.sample.tfsm.TemporalGuard;
import org.gemoc.sample.tfsm.TimedSystem;
import org.gemoc.sample.tfsm.Transition;

@SuppressWarnings("all")
public interface IVisitor {
  public abstract void beginVisit(final TimedSystem system);
  
  public abstract void endVisit(final TimedSystem system);
  
  public abstract void beginVisit(final TFSM tfsm);
  
  public abstract void endVisit(final TFSM tfsm);
  
  public abstract void beginVisit(final State state);
  
  public abstract void endVisit(final State state);
  
  public abstract void beginVisit(final Transition transition);
  
  public abstract void endVisit(final Transition transition);
  
  public abstract void beginVisit(final TemporalGuard guard);
  
  public abstract void endVisit(final TemporalGuard guard);
  
  public abstract void beginVisit(final EventGuard guard);
  
  public abstract void endVisit(final EventGuard guard);
  
  public abstract void beginVisit(final EvaluateGuard guard);
  
  public abstract void endVisit(final EvaluateGuard guard);
  
  public abstract void beginVisit(final FSMClock clock);
  
  public abstract void endVisit(final FSMClock clock);
}
