package cnrs.luchogie.up.data;

/**
 * @author Luc Hogie
 */

import java.util.*;

import cnrs.luchogie.up.data.event.DataElementListener;
import cnrs.luchogie.up.data.rendering.*;
import cnrs.luchogie.up.system.*;

/**
 * <p>
 * A <code>DataElement</code> is the central notion of the system: this is what
 * will be graphically rendered.
 * </p>
 * 
 * <p>
 * A <code>DataElement</code> can be a single point or a figure (a list of
 * points and subfigures).
 * </p>
 * 
 * <p>
 * The rendering of this data element is made by its renderers. A
 * <code>DataElement</code> defines a list of renderers that will, sequencely,
 * render it on a graphical pane.
 * </p>
 * 
 * @author Luc Hogie
 */

public abstract class DataElement implements Cloneable
{
	private List<DataElementRenderer> rendererList;
	private Collection<DataElementListener> listeners;

	public void addListener(DataElementListener l)
	{
		if (l == null)
			throw new IllegalArgumentException("null point listener");

		if (listeners == null)
		{
			listeners = new Vector<DataElementListener>();
		}

		listeners.add(l);
	}

	public void removeListener(DataElementListener l)
	{
		listeners.remove(l);

		if (listeners.isEmpty())
		{
			listeners = null;
		}
	}

	public Collection<DataElementListener> getListeners()
	{
		if (listeners == null)
		{
			return null;
		}
		else
		{
			return Collections.unmodifiableCollection(listeners);
		}
	}

	/**
	 * Gets the number of renderers that will draw the data element.
	 * 
	 * @return int
	 */
	public int getRendererCount()
	{
		if (rendererList == null)
		{
			return 0;
		}
		else
		{
			return rendererList.size();
		}
	}

	/**
	 * Gets the renderer at the given position.
	 * 
	 * @param i
	 * @return DataElementRenderer
	 */
	public DataElementRenderer getRendererAt(int i)
	{
		if (rendererList == null)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		else
		{
			return (DataElementRenderer) rendererList.get(i);
		}
	}

	/**
	 * Appends the given renderer.
	 * 
	 * @param renderer
	 */
	public void addRenderer(DataElementRenderer renderer)
	{
		if (renderer == null)
			throw new IllegalArgumentException("null renderer");

		if (rendererList == null)
		{
			rendererList = new Vector<DataElementRenderer>();
		}

		rendererList.add(renderer);
	}

	/**
	 * Removes the given renderer. If the renderer is not found, nothing
	 * happens.
	 * 
	 * @param renderer
	 */
	public void removeRenderer(DataElementRenderer renderer)
	{
		rendererList.remove(renderer);

		if (rendererList.isEmpty())
		{
			rendererList = null;
		}
	}

	public void removeAllRenderers()
	{
		rendererList = null;
	}

	/**
	 * Draw the data element on the given space. The process is trivial,
	 * sequencely, each renderer is asked to draw the data element on the space.
	 * That's all! The draw process is so delegated to each renderer.
	 * 
	 * @param space
	 */
	public void draw(Space space)
	{
		int rendererCount = getRendererCount();

		for (int i = 0; i < rendererCount; ++i)
		{
			DataElementRenderer renderer = rendererList.get(i);
			renderer.draw(this, space);
		}
	}

	/**
	 * Translate the data element according to the given values.
	 * 
	 * @param x
	 * @param y
	 */
	public abstract void translate(double x, double y);
}
