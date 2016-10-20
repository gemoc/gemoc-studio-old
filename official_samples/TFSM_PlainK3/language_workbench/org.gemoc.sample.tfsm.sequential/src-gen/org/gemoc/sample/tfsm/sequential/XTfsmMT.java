package org.gemoc.sample.tfsm.sequential;

import fr.inria.diverse.melange.lib.IModelType;
import java.io.IOException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmFactory;

@SuppressWarnings("all")
public interface XTfsmMT extends IModelType {
  public abstract EList<EObject> getContents();
  
  public abstract TfsmFactory getTfsmFactory();
  
  public abstract void save(final String uri) throws IOException;
}
