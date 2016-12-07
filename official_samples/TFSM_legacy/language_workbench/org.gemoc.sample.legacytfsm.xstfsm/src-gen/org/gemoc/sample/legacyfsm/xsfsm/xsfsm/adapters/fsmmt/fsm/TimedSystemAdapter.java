package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.fsmmt.fsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.legacyfsm.fsm.FSMClock;
import org.gemoc.sample.legacyfsm.fsm.FSMEvent;
import org.gemoc.sample.legacyfsm.fsm.TimeFSM;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.fsmmt.FSMMTAdaptersFactory;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimedSystem;

@SuppressWarnings("all")
public class TimedSystemAdapter extends EObjectAdapter<TimedSystem> implements org.gemoc.sample.legacyfsm.fsm.TimedSystem {
  private FSMMTAdaptersFactory adaptersFactory;
  
  public TimedSystemAdapter() {
    super(org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.fsmmt.FSMMTAdaptersFactory.getInstance());
    adaptersFactory = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.fsmmt.FSMMTAdaptersFactory.getInstance();
  }
  
  @Override
  public String getName() {
    return adaptee.getName();
  }
  
  @Override
  public void setName(final String o) {
    adaptee.setName(o);
  }
  
  private EList<TimeFSM> fsms_;
  
  @Override
  public EList<TimeFSM> getFsms() {
    if (fsms_ == null)
    	fsms_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getFsms(), adaptersFactory, eResource);
    return fsms_;
  }
  
  private EList<FSMClock> globalClocks_;
  
  @Override
  public EList<FSMClock> getGlobalClocks() {
    if (globalClocks_ == null)
    	globalClocks_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getGlobalClocks(), adaptersFactory, eResource);
    return globalClocks_;
  }
  
  private EList<FSMEvent> globalEvents_;
  
  @Override
  public EList<FSMEvent> getGlobalEvents() {
    if (globalEvents_ == null)
    	globalEvents_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getGlobalEvents(), adaptersFactory, eResource);
    return globalEvents_;
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.legacyfsm.fsm.FsmPackage.eINSTANCE.getTimedSystem();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.TIMED_SYSTEM__NAME:
    		return getName();
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.TIMED_SYSTEM__FSMS:
    		return getFsms();
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.TIMED_SYSTEM__GLOBAL_CLOCKS:
    		return getGlobalClocks();
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.TIMED_SYSTEM__GLOBAL_EVENTS:
    		return getGlobalEvents();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.TIMED_SYSTEM__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.TIMED_SYSTEM__FSMS:
    		return getFsms() != null && !getFsms().isEmpty();
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.TIMED_SYSTEM__GLOBAL_CLOCKS:
    		return getGlobalClocks() != null && !getGlobalClocks().isEmpty();
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.TIMED_SYSTEM__GLOBAL_EVENTS:
    		return getGlobalEvents() != null && !getGlobalEvents().isEmpty();
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.TIMED_SYSTEM__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.TIMED_SYSTEM__FSMS:
    		getFsms().clear();
    		getFsms().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.TIMED_SYSTEM__GLOBAL_CLOCKS:
    		getGlobalClocks().clear();
    		getGlobalClocks().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.TIMED_SYSTEM__GLOBAL_EVENTS:
    		getGlobalEvents().clear();
    		getGlobalEvents().addAll((Collection) newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
