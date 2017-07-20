/*******************************************************************************
 * Copyright (c) 2015, 2016  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
package org.gemoc.sample.tfsm.concurrent;

import fr.inria.diverse.melange.lib.IModelType;
import java.io.IOException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmFactory;

@SuppressWarnings("all")
public interface XTfsmMT extends IModelType {
  public abstract EList<EObject> getContents();
  
  public abstract TfsmFactory getTfsmFactory();
  
  public abstract void save(final String uri) throws IOException;
}
