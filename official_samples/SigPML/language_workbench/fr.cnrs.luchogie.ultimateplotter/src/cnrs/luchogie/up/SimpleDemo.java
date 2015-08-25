package cnrs.luchogie.up;

import javax.swing.JFrame;

import cnrs.luchogie.up.data.Figure;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.data.rendering.figure.ConnectedLineFigureRenderer;

public class SimpleDemo
{
	public static void main(String[] args)
	{
		SwingPlotter plotter = new InteractiveSwingPlotter();

		Figure f = new Figure();
		f.addPoint(new Point(1,  1));
		f.addPoint(new Point(1,  2));
		f.addPoint(new Point(3, 4));
		f.addRenderer(new ConnectedLineFigureRenderer());
		
		plotter.getGraphics2DPlotter().setFigure(f);
		
		JFrame frame = new JFrame();
		frame.setContentPane(plotter);
		frame.setSize(400,  400);
		frame.setVisible(true);
	}

}
