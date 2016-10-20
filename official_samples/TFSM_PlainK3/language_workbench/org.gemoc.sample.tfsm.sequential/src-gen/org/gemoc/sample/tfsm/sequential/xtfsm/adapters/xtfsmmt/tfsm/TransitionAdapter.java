package org.gemoc.sample.tfsm.sequential.xtfsm.adapters.xtfsmmt.tfsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.tfsm.sequential.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory;
import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.Transition;
import org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.FSMEvent;
import org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.Guard;
import org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.State;

@SuppressWarnings("all")
public class TransitionAdapter extends EObjectAdapter<Transition> implements org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.Transition {
  private XTfsmMTAdaptersFactory adaptersFactory;
  
  public TransitionAdapter() {
    super(org.gemoc.sample.tfsm.sequential.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory.getInstance());
    adaptersFactory = org.gemoc.sample.tfsm.sequential.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory.getInstance();
  }
  
  @Override
  public String getName() {
    return adaptee.getName();
  }
  
  @Override
  public void setName(final String o) {
    adaptee.setName(o);
  }
  
  @Override
  public String getAction() {
    return adaptee.getAction();
  }
  
  @Override
  public void setAction(final String o) {
    adaptee.setAction(o);
  }
  
  @Override
  public State getSource() {
    return (State) adaptersFactory.createAdapter(adaptee.getSource(), eResource);
  }
  
  @Override
  public void setSource(final State o) {
    if (o != null)
    	adaptee.setSource(((org.gemoc.sample.tfsm.sequential.xtfsm.adapters.xtfsmmt.tfsm.StateAdapter) o).getAdaptee());
    else adaptee.setSource(null);
  }
  
  @Override
  public State getTarget() {
    return (State) adaptersFactory.createAdapter(adaptee.getTarget(), eResource);
  }
  
  @Override
  public void setTarget(final State o) {
    if (o != null)
    	adaptee.setTarget(((org.gemoc.sample.tfsm.sequential.xtfsm.adapters.xtfsmmt.tfsm.StateAdapter) o).getAdaptee());
    else adaptee.setTarget(null);
  }
  
  @Override
  public Guard getOwnedGuard() {
    return (Guard) adaptersFactory.createAdapter(adaptee.getOwnedGuard(), eResource);
  }
  
  @Override
  public void setOwnedGuard(final Guard o) {
    if (o != null)
    	adaptee.setOwnedGuard(((org.gemoc.sample.tfsm.sequential.xtfsm.adapters.xtfsmmt.tfsm.GuardAdapter) o).getAdaptee());
    else adaptee.setOwnedGuard(null);
  }
  
  private EList<FSMEvent> generatedEvents_;
  
  @Override
  public EList<FSMEvent> getGeneratedEvents() {
    if (generatedEvents_ == null)
    	generatedEvents_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getGeneratedEvents(), adaptersFactory, eResource);
    return generatedEvents_;
  }
  
  @Override
  public void fire() {
    org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TransitionAspect.fire(adaptee);
  }
  
  @Override
  public void visit() {
    org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TransitionVisitorAspect.visit(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static String ACTION_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.eINSTANCE.getTransition();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__NAME:
    		return getName();
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__SOURCE:
    		return getSource();
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__TARGET:
    		return getTarget();
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__OWNED_GUARD:
    		return getOwnedGuard();
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__GENERATED_EVENTS:
    		return getGeneratedEvents();
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__ACTION:
    		return getAction();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__SOURCE:
    		return getSource() != null;
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__TARGET:
    		return getTarget() != null;
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__OWNED_GUARD:
    		return getOwnedGuard() != null;
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__GENERATED_EVENTS:
    		return getGeneratedEvents() != null && !getGeneratedEvents().isEmpty();
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__ACTION:
    		return getAction() != ACTION_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__SOURCE:
    		setSource(
    		(org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.State)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__TARGET:
    		setTarget(
    		(org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.State)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__OWNED_GUARD:
    		setOwnedGuard(
    		(org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.Guard)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__GENERATED_EVENTS:
    		getGeneratedEvents().clear();
    		getGeneratedEvents().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.TRANSITION__ACTION:
    		setAction(
    		(java.lang.String)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
