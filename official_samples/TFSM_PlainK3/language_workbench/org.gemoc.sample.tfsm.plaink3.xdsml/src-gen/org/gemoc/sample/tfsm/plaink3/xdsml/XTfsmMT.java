package org.gemoc.sample.tfsm.plaink3.xdsml;

import fr.inria.diverse.melange.lib.IModelType;
import java.io.IOException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Factory;

@SuppressWarnings("all")
public interface XTfsmMT extends IModelType {
  public abstract EList<EObject> getContents();
  
  public abstract Tfsm_plaink3Factory getTfsm_plaink3Factory();
  
  public abstract void save(final String uri) throws IOException;
}
