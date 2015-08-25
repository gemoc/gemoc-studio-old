package cnrs.luchogie.up.data.rendering.point;

import cnrs.luchogie.up.data.*;
import cnrs.luchogie.up.system.*;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.*;
import java.net.URL;


/**
 * @author Luc Hogie
 */
public class ImagePointRenderer extends PointRenderer
{
	private Image image;

	/**
	 * @see org.lucci.plt.data.DataRenderer#draw(DataObject, Space)
	 */
	public void drawImpl(DataElement object, Space space)
	{
		ImageObserver imageObserver = space.getImageObserver();

		if ( image != null && imageObserver != null )
		{
			Point point = (Point) object;
			Dimension xDimension = space.getXDimension();
			Dimension yDimension = space.getYDimension();

			int px = xDimension.convertToGraphicsCoordonateSystem(point.getX());
			int py = yDimension.convertToGraphicsCoordonateSystem(point.getY());
			int x = px - image.getWidth(imageObserver) / 2 + getXShift();
			int y = py - image.getHeight(imageObserver) / 2 + getYShift();
			space.getFigureGraphics().drawImage( image, x, y, imageObserver );
		}
	}

	public Image getImage()
	{
		return image;
	}

	public void setImage(Image image)
	{
		this.image = image;
	}

	public void setImage(URL url)
	{
		setImage(Toolkit.getDefaultToolkit().createImage(url));
	}
    
    public String getPublicName()
    {
        return "image";
    }

}
