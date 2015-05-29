package org.gemoc.sigpmlextended.k3dsa;

import cnrs.luchogie.up.InteractiveSwingPlotter;
import cnrs.luchogie.up.SwingPlotter;
import cnrs.luchogie.up.data.Figure;
import javax.swing.JFrame;

@SuppressWarnings("all")
public class AgentAspectAgentAspectProperties {
  public SwingPlotter plotter = new InteractiveSwingPlotter();
  
  public JFrame frame = new JFrame();
  
  public Figure figure = new Figure();
  
  public int currentExecCycle = 0;
}
