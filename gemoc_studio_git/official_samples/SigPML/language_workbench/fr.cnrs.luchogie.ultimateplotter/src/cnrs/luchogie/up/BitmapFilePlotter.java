package cnrs.luchogie.up;


import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The user may want to get an image object or the data of an
 * image file (PNG, JPEG, SVG...) for, for instance, return it to a 
 * HTTP-client that will have to draw the image on the web page
 * it will show.
 * 
 * @author Luc Hogie
 */
public class BitmapFilePlotter extends DelegPlotter
{

	/**
	 * Creates a PNG-encoded byte array of an image with the given dimension.
	 * @param width
	 * @param height
	 * @return byte[]
	 */
	public byte[] getPNGData( int width, int height )
	{
		AWTImagePlotter imagePlotter = new AWTImagePlotter();
		imagePlotter.setGraphics2DPlotter(getGraphics2DPlotter());
		Image image = imagePlotter.getAWTImage(width, height);
		return createImageData( (RenderedImage) image, "PNG" );
	}
	
	/**
	 * Creates a JPEG-encoded byte array of an image with the given dimension.
	 * Warning! The JPEG is format is definitively adapted 
	 * to photographies, and only photographies. The JPEG image
	 * returned by the bitmap image factory will be ugly.
	 * 
	 * @param width
	 * @param height
	 * @return byte[]
	 */
	public byte[] getJPEGData( int width, int height )
	{
		AWTImagePlotter imagePlotter = new AWTImagePlotter();
		imagePlotter.setGraphics2DPlotter(getGraphics2DPlotter());
		Image image = imagePlotter.getAWTImage(width, height);
		return createImageData( (RenderedImage) image, "JPEG" );
	}


	private byte[] createImageData( RenderedImage image, String type )
	{
		try
		{
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write( image, type, os );
			os.close();
			image = null;
			return os.toByteArray();
		}
		catch ( IOException ex )
		{
			throw new IllegalStateException( "I/O error shouldn't have occured" );
		}
	}

}
