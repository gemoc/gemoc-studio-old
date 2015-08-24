/*
 * Created on May 1, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cnrs.luchogie.up.data.rendering.figure;

import java.awt.Color;

import cnrs.luchogie.up.data.DataElement;
import cnrs.luchogie.up.data.Figure;
import cnrs.luchogie.up.system.Space;
import cnrs.luchogie.up.system.Utilities;

/**
 * @author luc.hogie
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CamembertFigureRenderer extends FigureRenderer
{

	protected void drawImpl(DataElement object, Space space)
	{
		Figure figure = (Figure) object;

		// if this figure is a camembert
		if (figure.getFigureCount() > 0 && figure.getPointCount() == 0)
		{
			double sum = getSum(figure);
			double startAngle = 0;

			int radiusInPixel = Math.min(space.getXDimension().getGraphicsSize(space.getFigureGraphics()), space.getYDimension().getGraphicsSize(space.getFigureGraphics()));

			int x = space.getXDimension().convertToGraphicsCoordonateSystem(-1);
			int y = space.getYDimension().convertToGraphicsCoordonateSystem(1);
			int w = (int) (2 / space.getXDimension().getLogicalIntervalRepresentedByOnePixel());
			int h = (int) (2 / space.getYDimension().getLogicalIntervalRepresentedByOnePixel());
			space.getFigureGraphics().drawArc(x, y, w, h, 0, 360);


			for (int i = 0; i < figure.getFigureCount(); ++i)
			{
				Figure f = figure.getFigureAt(i);
				double rate = f.getPointCount() / sum;
//				int angle = (int) (2 * Math.PI * rate);
				double angle = (int) (360 * rate);
				//space.getFigureGraphics().setColor()
				System.out.println("drawing arc " + angle);



				Color color = (Color) Utilities.colorList.get(i);
				space.getFigureGraphics().setColor(color);
				space.getFigureGraphics().fillArc(x, y, w, h, (int) startAngle, (int) angle);
				startAngle += angle;
				
				color = (Color) Utilities.colorList.get(i);
				space.getFigureGraphics().setColor(color);
				space.getFigureGraphics().drawArc(x, y, w, h, (int) startAngle, (int) angle);

				int x1 = space.getXDimension().convertToGraphicsCoordonateSystem(0);
				int y1 = space.getYDimension().convertToGraphicsCoordonateSystem(0);
				int x2 = space.getXDimension().convertToGraphicsCoordonateSystem(Math.cos(Math.PI * startAngle / 180));
				int y2 = space.getYDimension().convertToGraphicsCoordonateSystem(Math.sin(Math.PI * startAngle / 180));
				space.getFigureGraphics().drawLine(x1, y1, x2, y2);

			}
			
		}
	}





	private double getSum(Figure figure)
	{
		double sum = 0;
		
		for (int i = 0; i < figure.getFigureCount(); ++i)
		{
			sum += figure.getFigureAt(i).getPointCount();
		}
		
		return sum;
	}

    public String getPublicName()
    {
        return "Pie-chart";
    }

}
