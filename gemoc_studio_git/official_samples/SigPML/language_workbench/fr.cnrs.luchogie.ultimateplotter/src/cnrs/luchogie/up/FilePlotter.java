package cnrs.luchogie.up;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author luc.hogie
 * Created on Jun 4, 2004
 */
public class FilePlotter extends DelegPlotter
{
	public void plotFile(File file, int width, int height)
		throws IOException
	{
	    List<Integer> l = Arrays.asList(new Integer[] {1, 2});
	    
		String name = file.getName();
		int pos = name.lastIndexOf('.');
							
		if ( pos <= 0 )
		{
			throw new IllegalArgumentException("file " + name + " has no extension");
		}
		else
		{
			String ext = name.substring(pos + 1).toLowerCase(); 
			byte[] data = getData(ext, width, height);
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write(data);
			bos.flush();
			bos.close();
			fos.flush();
			fos.close();
		}
	}

	private byte[] getData(String fileExt, int width, int height)
	{
		if ( fileExt.equals("jpg") )
		{
			BitmapFilePlotter plotter = new BitmapFilePlotter();
			plotter.setGraphics2DPlotter(getGraphics2DPlotter());
			return plotter.getJPEGData(width, height);
		}
		else if ( fileExt.equals("png") )
		{
			BitmapFilePlotter plotter = new BitmapFilePlotter();
			plotter.setGraphics2DPlotter(getGraphics2DPlotter());
			return plotter.getPNGData(width, height);
		}
/*		else if ( fileExt.equals("svg") )
		{
			return getSVGText(width, height).toString().getBytes();
		}
*/		else if ( fileExt.equals("dat") )
		{
			GNUPlotFilePlotter plotter = new GNUPlotFilePlotter();
			plotter.setGraphics2DPlotter(getGraphics2DPlotter());
			return plotter.getGNUplotData().getBytes();
		}
//		else if ( fileExt.equals("eps") )
//		{
//			EPSPlotter plotter = new EPSPlotter();
//			plotter.setGraphics2DPlotter(getGraphics2DPlotter());
//			return plotter.getEPSData(width, height);
//		}
		else
		{
			throw new IllegalArgumentException("file extension not registered");
		}
	}

}
