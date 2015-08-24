package cnrs.luchogie.up.data.rendering.figure;

public abstract class InterpolatingFigureRenderer extends FigureRenderer
{
	private int stepCount = 20;

    public int getStepCount()
    {
        return stepCount;
    }

    public void setStepCount(int stepCount)
    {
		if ( stepCount < 0 )
			throw new IllegalArgumentException( "stepCount must be > 0" );

        this.stepCount = stepCount;
    }
}
