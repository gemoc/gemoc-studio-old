package org.gemoc.sample.legacytfsm.xstfsm;

import fr.inria.diverse.melange.lib.IModelType;
import java.io.IOException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmFactory;

@SuppressWarnings("all")
public interface XSTFSMMT extends IModelType {
  public abstract EList<EObject> getContents();
  
  public abstract TfsmFactory getTfsmFactory();
  
  public abstract void save(final String uri) throws IOException;
}
