package cnrs.luchogie.up.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;

import cnrs.luchogie.up.SwingPlotter;
import cnrs.luchogie.up.data.Figure;
import cnrs.luchogie.up.data.FigureFactory;
import cnrs.luchogie.up.data.rendering.figure.ConnectedLineFigureRenderer;

public class PopupWindow
{
    public static void main(String[] args)
    {
        List<Double> xList = new Vector<Double>();
        xList.add(4d);
        xList.add(1d);
        xList.add(3d);

        List<Double> yList = new Vector<Double>();
        yList.add(1d);
        yList.add(4d);
        yList.add(3d);
        
        popupWindows(xList, yList);
    }

    public static void popupWindows(List<Double> x, List<Double> y)
    {
        popupWindows(x, y, "", "", "");
    }

    public static void popupWindows(List<Double> x, List<Double> y, String title, String xLegend, String yLegend)
    {
        JFrame frame = new JFrame();
        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        double ratio = 0.5; 
        frame.setSize((int) (ss.width * ratio), (int) (ss.height * ratio));
        frame.setLocation(ss.width / 2 - frame.getSize().width / 2, ss.height / 2 - frame.getSize().height / 2);

        SwingPlotter plotter = new SwingPlotter();
        Figure figure = FigureFactory.createFigure(x, y);
        figure.addRenderer(new ConnectedLineFigureRenderer());
        plotter.getGraphics2DPlotter().setFigure(figure);
        plotter.getGraphics2DPlotter().getSpace().getLegend().setText(title);
        plotter.getGraphics2DPlotter().getSpace().getXDimension().getLegend().setText(xLegend);
        plotter.getGraphics2DPlotter().getSpace().getYDimension().getLegend().setText(yLegend);
        frame.getContentPane().setLayout(new GridLayout(1, 1));
        frame.getContentPane().add(plotter);
        frame.setVisible(true);
    }
}
