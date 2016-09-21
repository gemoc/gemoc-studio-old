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
