package cnrs.luchogie.up.data;



import java.awt.Color;
import java.util.List;
import java.util.Vector;

import cnrs.luchogie.up.data.rendering.figure.ConnectedLineFigureRenderer;
import cnrs.luchogie.up.data.rendering.figure.FigureRenderer;

/*
 * Created on Dec 30, 2004
 */

/**
 * @author luc.hogie
 */
public class CurveSet extends Figure
{
	private List renderers = new Vector();
	
	public CurveSet()
	{
		{
			ConnectedLineFigureRenderer r = new ConnectedLineFigureRenderer();
			r.setColor(Color.blue);
			renderers.add(r);
		}
		{
			ConnectedLineFigureRenderer r = new ConnectedLineFigureRenderer();
			r.setColor(Color.red);
			renderers.add(r);
		}
		{
			ConnectedLineFigureRenderer r = new ConnectedLineFigureRenderer();
			r.setColor(Color.green);
			renderers.add(r);
		}
		{
			ConnectedLineFigureRenderer r = new ConnectedLineFigureRenderer();
			r.setColor(Color.black);
			renderers.add(r);
		}
	}
	
	
	public void addFigure(Figure figure)
	{
		super.addFigure(figure);
		figure.addRenderer((FigureRenderer) renderers.get(getFigureCount() - 1));
	}
	
	public void addPoint(Point p)
	{
		throw new IllegalStateException("only figures can be added");
	}
}
