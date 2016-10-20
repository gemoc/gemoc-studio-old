package org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt;

import fr.inria.diverse.melange.adapters.AdaptersFactory;
import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.WeakHashMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.AgentAdapter;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.ApplicationAdapter;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWCommunicationResourceAdapter;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWComputationalResourceAdapter;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWPlatformAdapter;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWRessourceAdapter;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWStorageResourceAdapter;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.InputPortAdapter;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.NamedElementAdapter;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.OutputPortAdapter;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.PlaceAdapter;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.PortAdapter;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.SystemAdapter;
import org.gemoc.sample.sigpml.xsigpml.sigpml.Agent;
import org.gemoc.sample.sigpml.xsigpml.sigpml.Application;
import org.gemoc.sample.sigpml.xsigpml.sigpml.HWCommunicationResource;
import org.gemoc.sample.sigpml.xsigpml.sigpml.HWComputationalResource;
import org.gemoc.sample.sigpml.xsigpml.sigpml.HWPlatform;
import org.gemoc.sample.sigpml.xsigpml.sigpml.HWRessource;
import org.gemoc.sample.sigpml.xsigpml.sigpml.HWStorageResource;
import org.gemoc.sample.sigpml.xsigpml.sigpml.InputPort;
import org.gemoc.sample.sigpml.xsigpml.sigpml.NamedElement;
import org.gemoc.sample.sigpml.xsigpml.sigpml.OutputPort;
import org.gemoc.sample.sigpml.xsigpml.sigpml.Place;
import org.gemoc.sample.sigpml.xsigpml.sigpml.Port;

@SuppressWarnings("all")
public class XSigPMLMTAdaptersFactory implements AdaptersFactory {
  private static XSigPMLMTAdaptersFactory instance;
  
  public static XSigPMLMTAdaptersFactory getInstance() {
    if (instance == null) {
    	instance = new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.XSigPMLMTAdaptersFactory();
    }
    return instance;
  }
  
  private WeakHashMap<EObject, EObjectAdapter> register;
  
  public XSigPMLMTAdaptersFactory() {
    register = new WeakHashMap();
  }
  
  public EObjectAdapter createAdapter(final EObject o, final Resource res) {
    if (o instanceof org.gemoc.sample.sigpml.xsigpml.sigpml.Application){
    	return createApplicationAdapter((org.gemoc.sample.sigpml.xsigpml.sigpml.Application) o, res);
    }
    if (o instanceof org.gemoc.sample.sigpml.xsigpml.sigpml.Agent){
    	return createAgentAdapter((org.gemoc.sample.sigpml.xsigpml.sigpml.Agent) o, res);
    }
    if (o instanceof org.gemoc.sample.sigpml.xsigpml.sigpml.InputPort){
    	return createInputPortAdapter((org.gemoc.sample.sigpml.xsigpml.sigpml.InputPort) o, res);
    }
    if (o instanceof org.gemoc.sample.sigpml.xsigpml.sigpml.OutputPort){
    	return createOutputPortAdapter((org.gemoc.sample.sigpml.xsigpml.sigpml.OutputPort) o, res);
    }
    if (o instanceof org.gemoc.sample.sigpml.xsigpml.sigpml.Place){
    	return createPlaceAdapter((org.gemoc.sample.sigpml.xsigpml.sigpml.Place) o, res);
    }
    if (o instanceof org.gemoc.sample.sigpml.xsigpml.sigpml.HWComputationalResource){
    	return createHWComputationalResourceAdapter((org.gemoc.sample.sigpml.xsigpml.sigpml.HWComputationalResource) o, res);
    }
    if (o instanceof org.gemoc.sample.sigpml.xsigpml.sigpml.HWStorageResource){
    	return createHWStorageResourceAdapter((org.gemoc.sample.sigpml.xsigpml.sigpml.HWStorageResource) o, res);
    }
    if (o instanceof org.gemoc.sample.sigpml.xsigpml.sigpml.HWCommunicationResource){
    	return createHWCommunicationResourceAdapter((org.gemoc.sample.sigpml.xsigpml.sigpml.HWCommunicationResource) o, res);
    }
    if (o instanceof org.gemoc.sample.sigpml.xsigpml.sigpml.HWPlatform){
    	return createHWPlatformAdapter((org.gemoc.sample.sigpml.xsigpml.sigpml.HWPlatform) o, res);
    }
    if (o instanceof org.gemoc.sample.sigpml.xsigpml.sigpml.System){
    	return createSystemAdapter((org.gemoc.sample.sigpml.xsigpml.sigpml.System) o, res);
    }
    
    return null;
  }
  
  public ApplicationAdapter createApplicationAdapter(final Application adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.ApplicationAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.ApplicationAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.ApplicationAdapter) adapter;
    }
  }
  
  public AgentAdapter createAgentAdapter(final Agent adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.AgentAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.AgentAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.AgentAdapter) adapter;
    }
  }
  
  public PortAdapter createPortAdapter(final Port adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.PortAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.PortAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.PortAdapter) adapter;
    }
  }
  
  public InputPortAdapter createInputPortAdapter(final InputPort adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.InputPortAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.InputPortAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.InputPortAdapter) adapter;
    }
  }
  
  public OutputPortAdapter createOutputPortAdapter(final OutputPort adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.OutputPortAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.OutputPortAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.OutputPortAdapter) adapter;
    }
  }
  
  public PlaceAdapter createPlaceAdapter(final Place adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.PlaceAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.PlaceAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.PlaceAdapter) adapter;
    }
  }
  
  public NamedElementAdapter createNamedElementAdapter(final NamedElement adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.NamedElementAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.NamedElementAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.NamedElementAdapter) adapter;
    }
  }
  
  public HWRessourceAdapter createHWRessourceAdapter(final HWRessource adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWRessourceAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWRessourceAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWRessourceAdapter) adapter;
    }
  }
  
  public HWComputationalResourceAdapter createHWComputationalResourceAdapter(final HWComputationalResource adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWComputationalResourceAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWComputationalResourceAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWComputationalResourceAdapter) adapter;
    }
  }
  
  public HWStorageResourceAdapter createHWStorageResourceAdapter(final HWStorageResource adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWStorageResourceAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWStorageResourceAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWStorageResourceAdapter) adapter;
    }
  }
  
  public HWCommunicationResourceAdapter createHWCommunicationResourceAdapter(final HWCommunicationResource adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWCommunicationResourceAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWCommunicationResourceAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWCommunicationResourceAdapter) adapter;
    }
  }
  
  public HWPlatformAdapter createHWPlatformAdapter(final HWPlatform adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWPlatformAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWPlatformAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWPlatformAdapter) adapter;
    }
  }
  
  public SystemAdapter createSystemAdapter(final org.gemoc.sample.sigpml.xsigpml.sigpml.System adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.SystemAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.SystemAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.SystemAdapter) adapter;
    }
  }
}
