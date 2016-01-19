package org.gemoc.sample.tfsm.xdsml;

import fr.inria.diverse.melange.lib.IModelType;
import java.io.IOException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public interface TfsmMT extends IModelType {
  public abstract EList<EObject> getContents();
  
  public abstract org.gemoc.sample.tfsm.xdsml.tfsmmt.tfsm_plaink3.Tfsm_plaink3Factory getFactory();
  
  public abstract void save(final String uri) throws IOException;
}
