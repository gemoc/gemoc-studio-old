package cnrs.luchogie.up.data.rendering.figure;

import java.awt.Polygon;

import cnrs.luchogie.up.data.*;
import cnrs.luchogie.up.system.*;


public class BezierCurveFigureRenderer
	extends TimLambertsCodeBasedInterpolatingFigureRenderer
{
	public void drawImpl(DataElement object, Space space)
	{
		init((Figure)object, space);

		Polygon pol = new Polygon();
		java.awt.Point q = p(0, 0);
		pol.addPoint(q.x, q.y);

		for (int i = 0; i < pts.npoints - 3; i += 3)
		{
			int STEPS = getStepCount();

			for (int j = 1; j <= STEPS; j++)
			{
				q = p(i, j / (float)STEPS);
				pol.addPoint(q.x, q.y);
			}
		}

		space.getFigureGraphics().drawPolyline(pol.xpoints, pol.ypoints, pol.npoints);
	}


	static float b(int i, float t)
	{
		switch (i)
		{
			case 0:
				return (1 - t) * (1 - t) * (1 - t);
			case 1:
				return 3 * t * (1 - t) * (1 - t);
			case 2:
				return 3 * t * t * (1 - t);
			case 3:
				return t * t * t;
		}

		return 0; //we only get here if an invalid i is specified
	}

	java.awt.Point p(int i, float t)
	{
		float px = 0;
		float py = 0;

		for (int j = 0; j <= 3; j++)
		{
			px += b(j, t) * pts.xpoints[ i + j ];
			py += b(j, t) * pts.ypoints[ i + j ];
		}

		return new java.awt.Point((int)Math.round(px), (int)Math.round(py));
	}
    public String getPublicName()
    {
        return "Bezier";
    }

}