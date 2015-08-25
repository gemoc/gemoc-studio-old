package cnrs.luchogie.up.data.rendering.point;



import cnrs.luchogie.up.data.DataElement;
import cnrs.luchogie.up.data.Point;
import cnrs.luchogie.up.system.Dimension;
import cnrs.luchogie.up.system.Space;

public class XLineRenderer extends PointRenderer
{

 
    public void drawImpl(DataElement object, Space space)
    {
        Point point = (Point) object;
        Dimension xDimension = space.getXDimension();
        int x = xDimension.convertToGraphicsCoordonateSystem(point.getX());
        space.getFigureGraphics().drawLine(x, 0, x, 250);
    }

    public String getPublicName()
    {
        return "X line";
    }

}