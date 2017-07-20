/*******************************************************************************
 * Copyright (c) 2015, 2017  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
package org.gemoc.sample.sigpml.xsigpml.aspects;

import cnrs.luchogie.up.InteractiveSwingPlotter;
import cnrs.luchogie.up.SwingPlotter;
import cnrs.luchogie.up.data.Figure;
import javax.swing.JFrame;

@SuppressWarnings("all")
public class AgentAspectAgentAspectProperties {
  public SwingPlotter plotter = new InteractiveSwingPlotter();
  
  public JFrame frame = new JFrame();
  
  public Figure figure = new Figure();
  
  public boolean hasBeenStopped = false;
  
  public boolean isCurrentlyExecuting;
}
