package cnrs.luchogie.up.data;

import java.util.*;

import cnrs.luchogie.up.data.event.FigureListener;
import cnrs.luchogie.up.data.rendering.DataElementRenderer;
import cnrs.luchogie.up.data.rendering.figure.FigureRenderer;
import cnrs.luchogie.up.data.rendering.point.*;
import cnrs.luchogie.up.system.Space;

/**
 * <p>
 * A figure is a container. Basically a figure in a sequence of points. A figure
 * can model what you want. For example if you have to display a curve (with
 * data that come for a multiple measurement of a physical event), you can
 * create a figure and add it each point to it. If you want each point to be
 * connected to the previous and next points, you have to set a
 * ConnectedPointFigureRenderer to the figure.
 * </p>
 * 
 * <p>
 * A figure also contains children figure: this is a recursive data structure.
 * This allow you to build a well organized data structure and display complex
 * stuff. For example, if you have to display the map of your house, you can
 * create a houseAndGarden figure that will contain garden and a house figure.
 * The house figure may contain a kitchen figure, a livingRoom figure, a
 * parentsRoom figure, a childrenRoom figure and a garage figure... Each figure
 * deleguates its painting to a dedicated (or shared, depends on what you want)
 * renderer.
 * </p>
 * 
 * <p>
 * The deep of the tree is not limited.
 * </p>
 * 
 * 
 * @author Luc Hogie
 */
public class Figure extends DataElement
{
	private List<Point> pointList = new ArrayList<Point>();
	private List<Figure> figureList = new ArrayList<Figure>();
	private String name = "fig-" + hashCode();

	public Figure compress()
	{
		Figure res = (Figure) clone();
		return res;
	}

	
	/**
	 * @see cnrs.luchogie.up.data.DataElement#addRenderer(DataElementRenderer)
	 */
	public void addRenderer(DataElementRenderer renderer)
	{
		if (renderer instanceof FigureRenderer)
		{
			super.addRenderer(renderer);
		}
		else if (renderer instanceof PointRenderer)
		{
			int pointCount = getPointCount();

			for (int i = 0; i < pointCount; ++i)
			{
				getPointAt(i).addRenderer(renderer);
			}
		}
		else
		{
			throw new IllegalArgumentException("this is not a FigureRenderer nor a PointRenderer");
		}
	}

	/**
	 * Recursively adds a renderer to the figure and its subfigure.
	 * 
	 * @param renderer
	 */
	public void addRendererRecursively(DataElementRenderer renderer)
	{
		addRenderer(renderer);
		int figureCount = getFigureCount();

		for (int i = 0; i < figureCount; ++i)
		{
			getFigureAt(i).addRendererRecursively(renderer);
		}
	}

	/**
	 * Gets the number of point in this figure.
	 * 
	 * @return int
	 */
	public int getPointCount()
	{
		return pointList.size();
	}

	/**
	 * Gets the point at the given position.
	 * 
	 * @param index
	 * @return Point
	 */
	public Point getPointAt(int index)
	{
		return pointList.get(index);
	}

	/**
	 * Insert the given point at the given position.
	 * 
	 * @param p
	 * @param position
	 */
	public void insertPoint(Point point, int position)
	{
		if (point == null) throw new IllegalArgumentException("trying to insert a null point");

		pointList.add(position, point);
		firePointInserted(this, point, position);
	}

	/**
	 * Appends the given point to the figure.
	 * 
	 * @param p
	 */
	public void addPoint(Point p)
	{
		insertPoint(p, getPointCount());
	}

	/**
	 * Removes the point at the given position.
	 * 
	 * @param i
	 * @return Point
	 */
	public Point removePointAt(int i)
	{
		Point point = (Point) pointList.remove(i);
		firePointRemoved(this, point, i);
		return point;
	}

	/**
	 * Remove all the points that figure contain.
	 */
	public void removeAllPoints()
	{
		while (getPointCount() > 0)
		{
			removePointAt(0);
		}
	}

	/**
	 * Inserts the given figure at the given position.
	 * 
	 * @param figure
	 * @param position
	 */
	public void insertFigure(Figure figure, int position)
	{
		if (figure == null) throw new IllegalArgumentException("null figure");

		figureList.add(position, figure);
		fireFigureInserted(this, figure, position);
	}

	/**
	 * Append the given figure to this figure.
	 * 
	 * @param figure
	 */
	public void addFigure(Figure figure)
	{
		insertFigure(figure, getFigureCount());
	}

	/**
	 * Removes the figure at the given position.
	 * 
	 * @param i
	 * @return Point
	 */
	public Figure removeFigureAt(int i)
	{
		Figure figure = figureList.remove(i);
		fireFigureRemoved(this, figure, i);
		return figure;
	}

	/**
	 * Remove all the figures that figure contain.
	 */
	public void removeAllFigures()
	{
		while (getFigureCount() > 0)
		{
			removeFigureAt(0);
		}
	}

	/**
	 * Gets the figure at the given index.
	 * 
	 * @param index
	 * @return Figure
	 */
	public Figure getFigureAt(int index)
	{
		return figureList.get(index);
	}

	/**
	 * Gets the number of subfigure in this figure.
	 * 
	 * @return int
	 */
	public int getFigureCount()
	{
		return figureList.size();
	}

	/**
	 * Gets the extremums of the figure.
	 * 
	 * @return Extremi
	 */
	public Extremi getExtremums()
	{
		Extremi extrems = null;
		int figureCount = getFigureCount();

		for (int i = 0; i < figureCount; ++i)
		{
			Extremi subFigureExtremums = getFigureAt(i).getExtremums();

			if (subFigureExtremums != null)
			{
				if (extrems == null)
				{
					extrems = (Extremi) subFigureExtremums.clone();
				}
				else
				{
					if (extrems.minX > subFigureExtremums.minX) extrems.minX = subFigureExtremums.minX;
					if (extrems.minY > subFigureExtremums.minY) extrems.minY = subFigureExtremums.minY;
					if (extrems.maxX < subFigureExtremums.maxX) extrems.maxX = subFigureExtremums.maxX;
					if (extrems.maxY < subFigureExtremums.maxY) extrems.maxY = subFigureExtremums.maxY;
				}
			}
		}

		int pointCount = getPointCount();

		if (pointCount > 0)
		{
			if (extrems == null)
			{
				Point firstPoint = getPointAt(0);
				extrems = new Extremi();
				extrems.minX = firstPoint.getX();
				extrems.minY = firstPoint.getY();
				extrems.maxX = firstPoint.getX();
				extrems.maxY = firstPoint.getY();
			}

			for (int i = 1; i < pointCount; ++i)
			{
				Point p = getPointAt(i);
				if (extrems.minX > p.getX()) extrems.minX = p.getX();
				if (extrems.minY > p.getY()) extrems.minY = p.getY();
				if (extrems.maxX < p.getX()) extrems.maxX = p.getX();
				if (extrems.maxY < p.getY()) extrems.maxY = p.getY();
			}
		}

		return extrems;
	}

	/**
	 * @see java.lang.Object#clone()
	 */
	public Object clone()
	{
		Figure figure = new Figure();
		int pointCount = getPointCount();

		for (int i = 0; i < pointCount; ++i)
		{
			figure.addPoint((Point) getPointAt(i).clone());
		}

		int rendererCount = getRendererCount();

		for (int i = 0; i < rendererCount; ++i)
		{
			figure.addRenderer(getRendererAt(i));
		}

		return figure;
	}

	/**
	 * @see cnrs.luchogie.up.data.DataElement#translate(double, double)
	 */
	public void translate(double x, double y)
	{
		for (Point p : pointList)
		{
			p.translate(x, y);
		}

		for (Figure p : figureList)
		{
			p.translate(x, y);
		}
	}

	/**
	 * @see cnrs.luchogie.up.data.DataElement#draw(Space)
	 */
	public void draw(Space space)
	{
		super.draw(space);
		int pointCount = getPointCount();

		for (int i = 0; i < pointCount; ++i)
		{
			getPointAt(i).draw(space);
		}

		int figureCount = getFigureCount();

		for (int i = 0; i < figureCount; ++i)
		{
			getFigureAt(i).draw(space);
		}
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		buf.append("# points: " + pointList.toString());
		buf.append(", figures: " + figureList.toString() + '#');
		return buf.toString();
	}

	public class Extremi
	{
		public double minX, minY, maxX, maxY;

		public Object clone()
		{
			Extremi e = new Extremi();
			e.minX = minX;
			e.minY = minY;
			e.maxX = maxX;
			e.maxY = maxY;
			return e;
		}
	}

	private void firePointInserted(Figure figure, Point point, int position)
	{
		Collection listeners = getListeners();

		if (listeners != null)
		{
			Iterator i = listeners.iterator();

			while (i.hasNext())
			{
				((FigureListener) i.next()).pointInserted(figure, point, position);
			}
		}
	}

	private void firePointRemoved(Figure figure, Point point, int position)
	{
		Collection listeners = getListeners();

		if (listeners != null)
		{
			Iterator i = listeners.iterator();

			while (i.hasNext())
			{
				((FigureListener) i.next()).pointRemoved(figure, point, position);
			}
		}
	}

	private void fireFigureInserted(Figure figure, Figure subFigure, int position)
	{
		Collection listeners = getListeners();

		if (listeners != null)
		{
			Iterator i = listeners.iterator();

			while (i.hasNext())
			{
				((FigureListener) i.next()).figureInserted(figure, subFigure, position);
			}
		}
	}

	private void fireFigureRemoved(Figure figure, Figure subFigure, int position)
	{
		Collection listeners = getListeners();

		if (listeners != null)
		{
			Iterator i = listeners.iterator();

			while (i.hasNext())
			{
				((FigureListener) i.next()).figureRemoved(figure, subFigure, position);
			}
		}
	}

	/**
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param string
	 */
	public void setName(String string)
	{
		if (name == null) throw new NullPointerException("null name is not allowed");

		name = string;
	}

	public Collection<Figure> retrieveAllFigures()
	{
		List<Figure> list = new ArrayList<Figure>();
		list.add(this);

		// the list grows all along the looping
		for (int i = 0; i < list.size(); ++i)
		{
			list.addAll(list.get(i).figureList);
		}

		return list;
	}

	public Collection<Point> retrieveAllPoints()
	{
		Collection<Point> points = new ArrayList<Point>();
		Iterator<Figure> figures = retrieveAllFigures().iterator();

		while (figures.hasNext())
		{
			Figure f = (Figure) figures.next();
			points.addAll(f.pointList);
		}

		return points;
	}

	public void sortX()
	{
		Collections.sort(pointList, new Comparator()
		{
			public int compare(Object p1, Object p2)
			{
				return Double.compare(((Point) p1).getX(), ((Point) p2).getX());
			}
		});
	}


	public void retainOnlyLastPoints(int n)
	{
	   while (getPointCount() > n)
	   {
	       removePointAt(0);
	   }
	}
}
