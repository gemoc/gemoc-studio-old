package cnrs.luchogie.up.data.rendering.figure;

import cnrs.luchogie.up.data.rendering.DataElementRenderer;

/**
 * @author Luc Hogie
 */
public abstract class FigureRenderer extends DataElementRenderer
{
	private boolean shownPointReductionEnabled = false;

	public boolean isShownPointReductionEnabled()
	{
		return shownPointReductionEnabled;
	}

	public void setShownPointReductionEnabled(boolean b)
	{
		shownPointReductionEnabled = b;
	}

}
