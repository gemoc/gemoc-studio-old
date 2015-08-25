package cnrs.luchogie.up;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;

import cnrs.luchogie.up.data.FigureUtilities;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.ui.UI;

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

public class InteractiveSwingPlotter extends SwingPlotter
{
	private JPopupMenu popup;
	private JMenuItem repaintMenuItem = new JMenuItem("Repaint");
	private JMenuItem saveMenuItem = new JMenuItem("Save as...");
	private JMenuItem controlPanelMenuItem = new JMenuItem("Control panel");
	private JMenu selectionMenu = new JMenu("Select");
	private JMenuItem selectionRectangularMenuItem = new JMenuItem("Rectangular area");
	private JMenuItem selectionVicinityMenuItem = new JMenuItem("Vicinity");

	public Rectangle2D selectionRectangle;
	private int selectionMode = SELECTION_MODE_VICINITY;
	private int selectionTarget = SELECTION_TARGET_POINT;

	private List userSelectionList;

	public static final int SELECTION_MODE_RECTANGULAR_AREA = 1;
	public static final int SELECTION_MODE_VICINITY = 2;
	public static final int SELECTION_TARGET_POINT = 1;
	public static final int SELECTION_TARGET_FIGURE = 2;

	public InteractiveSwingPlotter()
	{
		popup = new JPopupMenu();
		popup.setInvoker(this);
		popup.add(repaintMenuItem);
		selectionMenu.add(selectionRectangularMenuItem);
		selectionMenu.add(selectionVicinityMenuItem);
		popup.add(selectionMenu);
		popup.add(saveMenuItem);
		popup.addSeparator();
		popup.add(controlPanelMenuItem);

		selectionRectangularMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				setSelectionMode(SELECTION_MODE_RECTANGULAR_AREA);
			}
		});

		selectionVicinityMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				setSelectionMode(SELECTION_MODE_VICINITY);
			}
		});

		repaintMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				repaint(0);
			}
		});

		saveMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				FileFilter filter = new FileFilter() {
					public boolean accept(File file)
					{
						if (file.isDirectory())
						{
							return true;
						}
						else
						{
							String name = file.getName();
							int pos = name.lastIndexOf('.');

							if (pos <= 0)
							{
								return false;
							}
							else
							{
								String ext = name.substring(pos + 1).toLowerCase();
								return ext.equals("jpg") || ext.equals("png") || ext.equals("svg") || ext.equals("dat") || ext.equals("eps");
							}
						}
					}

					public String getDescription()
					{
						return "JPEG (.jpg), PNG (.png), SVG (.svg), PostScript (.eps) or GNUplot (.dat) files";
					}
				};

				chooser.setFileFilter(filter);
				int returnVal = chooser.showSaveDialog(InteractiveSwingPlotter.this);

				if (returnVal == JFileChooser.APPROVE_OPTION)
				{
					File file = chooser.getSelectedFile();
					FilePlotter imgFactory = new FilePlotter();
					imgFactory.setGraphics2DPlotter(getGraphics2DPlotter());

					try
					{
						java.awt.Dimension size = getSize();
						imgFactory.plotFile(file, size.width, size.height);
					}
					catch (IOException ex)
					{
						JOptionPane.showMessageDialog(InteractiveSwingPlotter.this, "I/O error while writing file", "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (Exception ex)
					{
						if (ex.getMessage() == null || ex.getMessage().length() == 0)
						{
							ex.printStackTrace();
							JOptionPane.showMessageDialog(InteractiveSwingPlotter.this, ex.getClass().getName(), "Error", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(InteractiveSwingPlotter.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});

		controlPanelMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				new UI(InteractiveSwingPlotter.this);
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e)
			{
				if (selectionRectangle != null && selectionMode == SELECTION_MODE_RECTANGULAR_AREA)
				{
					java.awt.Point point = e.getPoint();
					point.x -= getGraphics2DPlotter().figureGraphicsX;
					point.y -= getGraphics2DPlotter().figureGraphicsY;
					double x = getGraphics2DPlotter().getSpace().getXDimension().convertToDimensionCoordonateSystem((int) point.getX());
					double y = getGraphics2DPlotter().getSpace().getYDimension().convertToDimensionCoordonateSystem((int) point.getY());
					double x1 = selectionRectangle.getX();
					double y1 = selectionRectangle.getY();
					double x2 = x;
					double y2 = y;
					selectionRectangle = new Rectangle2D.Double(x1, y1, x2 - x1, y2 - y1);
					// Collection selectedPoints =
					// FigureUtilities.getPointsIn(selectionRectangle,
					// getGraphics2DPlotter().getFigure());
					userSelectionList.clear();
					// userSelectionList.addAll(selectedPoints);
					// fireSelectionChanged(InteractiveSwingPlotter.this,
					// selectedPoints);
					repaint(0);
				}
			}
		});

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e)
			{
				if (popup.isVisible())
				{
					popup.setVisible(false);
				}
				else
				{
					if ((e.getModifiersEx() & InputEvent.BUTTON1_DOWN_MASK) != 0)
					{
						java.awt.Point point = e.getPoint();
						point.x -= getGraphics2DPlotter().figureGraphicsX;
						point.y -= getGraphics2DPlotter().figureGraphicsY;
						double x = getGraphics2DPlotter().getSpace().getXDimension().convertToDimensionCoordonateSystem((int) point.getX());
						double y = getGraphics2DPlotter().getSpace().getYDimension().convertToDimensionCoordonateSystem((int) point.getY());

						if (selectionMode == SELECTION_MODE_RECTANGULAR_AREA)
						{
							selectionRectangle = new Rectangle2D.Double(x, y, 0, 0);
						}
						else if (selectionMode == SELECTION_MODE_VICINITY)
						{
							if (getGraphics2DPlotter().getFigure() != null)
							{
								Point closestPoint = FigureUtilities.getClosestPoint(new Point(x, y), getGraphics2DPlotter().getFigure());
								fireSelectionChanged(InteractiveSwingPlotter.this, Collections.singleton(closestPoint));
								double xd = getGraphics2DPlotter().getSpace().getXDimension().getLogicalIntervalRepresentedByOnePixel() * 10;
								double yd = getGraphics2DPlotter().getSpace().getYDimension().getLogicalIntervalRepresentedByOnePixel() * 10;
								selectionRectangle = new Rectangle2D.Double(closestPoint.getX() - xd / 2, closestPoint.getY() - yd / 2, xd, yd);
								repaint(0);
							}
						}
					}
					else if ((e.getModifiersEx() & InputEvent.BUTTON3_DOWN_MASK) != 0)
					{
						if ((e.getModifiersEx() & InputEvent.BUTTON1_DOWN_MASK) == 0)
						{
							java.awt.Point p = e.getPoint();
							SwingUtilities.convertPointToScreen(p, InteractiveSwingPlotter.this);
							popup.setLocation(p);
							popup.setVisible(true);
						}
					}
				}
			}
		});
	}

	/**
	 * @see java.awt.Component#paint(Graphics)
	 */
	public void paint(Graphics g)
	{
		super.paint(g);

		if (selectionRectangle != null)
		{
			int x1 = getGraphics2DPlotter().getSpace().getXDimension().convertToGraphicsCoordonateSystem(selectionRectangle.getX());
			int y1 = getGraphics2DPlotter().getSpace().getYDimension().convertToGraphicsCoordonateSystem(selectionRectangle.getY());
			int x2 = getGraphics2DPlotter().getSpace().getXDimension()
					.convertToGraphicsCoordonateSystem(selectionRectangle.getX() + selectionRectangle.getWidth());
			int y2 = getGraphics2DPlotter().getSpace().getYDimension()
					.convertToGraphicsCoordonateSystem(selectionRectangle.getY() + selectionRectangle.getHeight());
			x1 += getGraphics2DPlotter().figureGraphicsX;
			y1 += getGraphics2DPlotter().figureGraphicsY;
			x2 += getGraphics2DPlotter().figureGraphicsX;
			y2 += getGraphics2DPlotter().figureGraphicsY;
			if (x1 > x2)
			{
				int tmp = x1;
				x1 = x2;
				x2 = tmp;
			}
			if (y1 > y2)
			{
				int tmp = y1;
				y1 = y2;
				y2 = tmp;
			}
			Color color = Color.darkGray;

			if (selectionMode == SELECTION_MODE_RECTANGULAR_AREA)
			{
				g.setColor(color);
				g.drawRect(x1, y1, x2 - x1, y2 - y1);
				color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 64);
				g.setColor(color);
				g.fillRect(x1, y1, x2 - x1, y2 - y1);
			}
			else if (selectionMode == SELECTION_MODE_VICINITY)
			{
				g.setColor(color);
				g.drawRect(x1, y1, x2 - x1, y2 - y1);
				g.drawLine(x1, y1, x2, y2);
				g.drawLine(x1, y2, x2, y1);
				color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 64);
				g.setColor(color);
				g.fillRect(x1, y1, x2 - x1, y2 - y1);
			}
		}
	}

	public int getSelectionMode()
	{
		return selectionMode;
	}

	public int getSelectionTarget()
	{
		return selectionTarget;
	}

	public void setSelectionMode(int i)
	{
		selectionMode = i;
		selectionRectangle = null;
	}

	public void setSelectionTarget(int i)
	{
		selectionTarget = i;
	}

	public List getUserSelection()
	{
		return userSelectionList;
	}

	private void fireSelectionChanged(InteractiveSwingPlotter sp, Collection p)
	{
		Iterator listeners = getListeners().iterator();

		while (listeners.hasNext())
		{
			InteractiveSwingPlotterListener l = (InteractiveSwingPlotterListener) listeners.next();
			l.pointsSelected(sp, p);
		}
	}
}
