/*
 * Created on Mar 3, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cnrs.luchogie.up.data;



import java.util.List;
import java.util.Map;

import toools.math.Distribution;


import cnrs.luchogie.up.data.rendering.figure.ConnectedLineFigureRenderer;
import cnrs.luchogie.up.data.rendering.point.HistogramPointRenderer;

/**
 * @author luc.hogie
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FigureFactory
{
	public static Figure createFigure(double[] data)
	{
		Figure figure = new Figure();
		
		for (int i = 0; i < data.length; ++i)
		{
			figure.addPoint(new Point(i, data[i]));
		}

		return figure;
	}

	public static <A extends Number, B extends Number> Figure createFigure(Map<A , B> map)
	{
		Figure figure = new Figure();

		for (Map.Entry<A, B> entry : map.entrySet())
		{
			double x = entry.getKey().doubleValue();
			double y = entry.getValue().doubleValue();
			figure.addPoint(new Point(x, y));
		}

		return figure;
	}

//	public static Figure createFigure(List<Number> x, List<Number> y)
	public static Figure createFigure(List<? extends Number> xList, List<? extends Number> yList)
	{
		if (xList.size() != yList.size())
			throw new IllegalArgumentException("the two lists do not have the same size");
		
		Figure figure = new Figure();
		int size = xList.size();

		for (int i = 0; i < size; ++i)
		{
			Number xi = xList.get(i);
			Number yi = yList.get(i);
			
			if (xi != null && yi != null)
			{
				double x = xi.doubleValue();
				double y = yi.doubleValue();
				figure.addPoint(new Point(x, y));
			}
		}		

		figure.addRenderer(new ConnectedLineFigureRenderer());
		return figure;
	}
	
	public  static <T extends Number> Figure createFigure(Distribution<T> distribution)
	{
	    Figure figure = new Figure();
	    
	    for (T t : distribution.getOccuringObjects())
	    {
	        figure.addPoint(new Point(t.doubleValue(), distribution.getRelativeNumberOfOccurences(t)));	        
	    }

	    figure.addRenderer(new HistogramPointRenderer());
	    return figure;
	}
}
