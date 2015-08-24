package cnrs.luchogie.up;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.border.Border;

import cnrs.luchogie.up.UpDemo.WindowHandler;
import cnrs.luchogie.up.data.Figure;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.data.math.Function;
import cnrs.luchogie.up.data.rendering.figure.ConnectedLineFigureRenderer;
import cnrs.luchogie.up.system.Space;

/**
 * The SwingPlotter is a Swing component on which a graphical representation
 * will be plotted.
 * 
 * The SwingPlotter may be or may be not buffered. When it is, the full refresh
 * is slow but you can fastly move the widget, make it visible/unvisible. It
 * will be extremely fastly repainted. If the buffer is disabled, the graphical
 * representation is not stored and so it has to be recalculated for each
 * repaint process. This is useful when the content of the data change often and
 * the component has to be updated (eg: animations).
 * 
 * It has the ability to be periodically repainted: this allow the user to
 * program an animation. If the user want the widget to be repainted according
 * to a strict period, he has to define the <i>task</i>. The SwingPlotter
 * calculates the duration of the task and waits only the remaining time
 * (remaining = period - task duration) before repating the component. The
 * constrainst is that the task must execute faster than one period. If the user
 * do not want a strict period, he can do whatever on the figure and call
 * SwingPlotter.repaint(0) at any time.
 * 
 * @author Luc Hogie
 */

public class SwingPlotter extends JComponent
{
    // the image used as buffer for fast repaints
    private boolean redrawNeeded = true;
    private boolean imageBufferedUsed = false;
    private Image image;

    private CyclicTask cyclicTask;

    private Graphics2DPlotter painter = new Graphics2DPlotter();

    private Collection<SwingPlotterListener> listeners = new Vector<SwingPlotterListener>();

    public SwingPlotter()
    {
	painter.getSpace().setImageObserver(this);
	painter.getSpace().setBackgroundColor(Color.white);
	setDoubleBuffered(false);
	super.setBorder(null);
    }

    public Graphics2DPlotter getGraphics2DPlotter()
    {
	return painter;
    }

    public void setGraphics2DPlotter(Graphics2DPlotter p)
    {
	if (p == null)
	    throw new IllegalArgumentException("painter set to null");

	this.painter = p;
    }

    /**
     * @see java.awt.Component#setForeground(Color)
     */
    public void setForeground(Color fg)
    {
	throw new IllegalStateException("this method shouldn't be used. Use Space.setColor() instead");
    }

    /**
     * @see java.awt.Component#getForeground()
     */
    public Color getForeground()
    {
	return painter.getSpace().getColor();
    }

    /**
     * @see java.awt.Component#setBackground(Color)
     */
    public void setBackground(Color bg)
    {
	throw new IllegalStateException("this method shouldn't be used. Use Space.setBackgroundColor() instead");
    }

    /**
     * @see java.awt.Component#getBackground()
     */
    public Color getBackground()
    {
	Space space = painter.getSpace();
	return space.getBackgroundColor();
    }

    /**
     * @see java.awt.Component#paint(Graphics)
     */
    public void paint(Graphics g)
    {
	java.awt.Dimension size = getSize();

	if (g.getClipBounds().getSize().equals(size))
	{
	    firePaintStarting(this);

	    if (isImageBufferedUsed())
	    {
		if (isUpdateNeeded())
		{
		    setUpdateNeeded(false);
		    image = createImage(size.width, size.height);
		    Graphics imageGraphics = image.getGraphics();
		    imageGraphics.setClip(0, 0, size.width, size.height);
		    drawOnGraphics(imageGraphics);
		}

		g.drawImage(image, 0, 0, Color.white, this);
	    }
	    else
	    {
		drawOnGraphics(g);
	    }

	    firePaintFinished(this);
	}
	else
	{
	    repaint(0);
	}
    }

    public static void main(String[] args)
    {
	Function function = new Function() {
	    public Point evaluate(double t)
	    {
		return new Point(t * Math.cos(t), Math.sin(t));
	    }
	};

	function.setDefinitionValues(0, 2 * Math.PI, Math.PI / 100);
	Figure figure = function.createFigure();
	figure.addRenderer(new ConnectedLineFigureRenderer());

	SwingPlotter plotter = new InteractiveSwingPlotter();
	plotter.getGraphics2DPlotter().setFigure(figure);

	Space space = plotter.getGraphics2DPlotter().getSpace();

	space.getLegend().setText("x = t cos(t) ; y = sin(t)");

	JFrame frame = new JFrame("Up demo");
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int side = (int) (screenSize.getHeight() * 0.3);
	frame.setSize(side, side);
	frame.setLocation((int) (screenSize.getWidth() - side) / 2, (int) (screenSize.getHeight() - side) / 2);

	frame.getContentPane().setLayout(new BorderLayout());
	frame.getContentPane().add(BorderLayout.CENTER, plotter);

	frame.setVisible(true);

    }

    private void drawOnGraphics(Graphics g)
    {
	painter.paint((Graphics2D) g);
    }

    /**
     * Gets if the component has to be updated.
     * 
     * @return boolean
     */
    public boolean isUpdateNeeded()
    {
	if (redrawNeeded)
	{
	    return true;
	}
	else
	{
	    // the first time, the image does not exist
	    if (image == null)
	    {
		return true;
	    }
	    else
	    {
		// if the size of the component has changed
		if (image.getHeight(this) != getSize().height || image.getWidth(this) != getSize().width)
		{
		    return true;
		}
		else
		{
		    return false;
		}
	    }
	}
    }

    /**
     * Sets if the component has to be updated. The update is needed if the data
     * has changed.
     * 
     * @param b
     */
    public void setUpdateNeeded(boolean b)
    {
	redrawNeeded = b;
    }

    /**
     * Gets if the image buffering is used. This allow very fast repaint. This
     * is useful if the component if moved, hidden, made visible very
     * frequently.
     * 
     * @return boolean
     */
    public boolean isImageBufferedUsed()
    {
	return imageBufferedUsed;
    }

    /**
     * Sets if the image buffering is used. This allow very fast repaint. This
     * is useful if the component if moved, hidden, made visible very
     * frequently.
     * 
     * @param imageBufferedUsed
     *            The imageBufferedUsed to set
     */
    public void setImageBufferedUsed(boolean imageBufferedUsed)
    {
	this.imageBufferedUsed = imageBufferedUsed;
    }

    /**
     * Gets the task that is periodically invoked. The task is invoked and then
     * the repaint process is called.
     * 
     * @return Runnable
     */
    public CyclicTask getCyclicTask()
    {
	return cyclicTask;
    }

    /**
     * Sets the task that is periodically invoked. The task is invoked and then
     * the repaint process is called.
     * 
     * @param cyclicTask
     */
    public void setCyclicTask(CyclicTask cyclicTask)
    {
	this.cyclicTask = cyclicTask;
	cyclicTask.setPlotter(this);
    }

    private void firePaintStarting(SwingPlotter sp)
    {
	Iterator listeners = this.listeners.iterator();

	while (listeners.hasNext())
	{
	    SwingPlotterListener l = (SwingPlotterListener) listeners.next();
	    l.paintStarting(sp);
	}
    }

    private void firePaintFinished(SwingPlotter sp)
    {
	Iterator listeners = this.listeners.iterator();

	while (listeners.hasNext())
	{
	    SwingPlotterListener l = (SwingPlotterListener) listeners.next();
	    l.paintFinished(sp);
	}
    }

    public void setBorder(Border b)
    {
	if (b != null)
	{
	    // throw new
	    // IllegalStateException("bordering is not allowed on a swing plotter");
	}
    }

    public Collection<SwingPlotterListener> getListeners()
    {
	return listeners;
    }

    public static SwingPlotter display(Figure figure)
    {
	SwingPlotter plotter = new SwingPlotter();
	plotter.getGraphics2DPlotter().setFigure(figure);
	final JFrame frame = new JFrame("Up demo");
	plotter.getGraphics2DPlotter().getSpace().getXDimension().getLowerBoundAxis().setVisible(false);
	plotter.getGraphics2DPlotter().getSpace().getXDimension().getUpperBoundAxis().setVisible(false);
	plotter.getGraphics2DPlotter().getSpace().getYDimension().getLowerBoundAxis().setVisible(false);
	plotter.getGraphics2DPlotter().getSpace().getYDimension().getUpperBoundAxis().setVisible(false);
	frame.addWindowListener(new WindowListener() {

	    public void windowActivated(WindowEvent e)
	    {
		// TODO Auto-generated method stub

	    }

	    public void windowClosed(WindowEvent e)
	    {
		// TODO Auto-generated method stub

	    }

	    public void windowClosing(WindowEvent e)
	    {
		frame.dispose();

	    }

	    public void windowDeactivated(WindowEvent e)
	    {
		// TODO Auto-generated method stub

	    }

	    public void windowDeiconified(WindowEvent e)
	    {
		// TODO Auto-generated method stub

	    }

	    public void windowIconified(WindowEvent e)
	    {
		// TODO Auto-generated method stub

	    }

	    public void windowOpened(WindowEvent e)
	    {
		// TODO Auto-generated method stub

	    }
	});
	java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int side = (int) (screenSize.getHeight() * 0.5);
	frame.setSize(side, side);
	frame.setLocation((int) (screenSize.getWidth() - side) / 2, (int) (screenSize.getHeight() - side) / 2);
	Container contentPane = frame.getContentPane();
	contentPane.setLayout(new BorderLayout());
	contentPane.add(BorderLayout.CENTER, plotter);
	frame.setVisible(true);
	return plotter;
    }
}
