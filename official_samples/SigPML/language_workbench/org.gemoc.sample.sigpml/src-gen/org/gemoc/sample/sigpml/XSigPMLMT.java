package org.gemoc.sample.sigpml;

import fr.inria.diverse.melange.lib.IModelType;
import java.io.IOException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlFactory;

@SuppressWarnings("all")
public interface XSigPMLMT extends IModelType {
  public abstract EList<EObject> getContents();
  
  public abstract SigpmlFactory getSigpmlFactory();
  
  public abstract void save(final String uri) throws IOException;
}
