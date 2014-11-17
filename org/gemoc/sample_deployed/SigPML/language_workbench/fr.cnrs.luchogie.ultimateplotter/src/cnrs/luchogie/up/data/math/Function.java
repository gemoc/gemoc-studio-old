package cnrs.luchogie.up.data.math;

import cnrs.luchogie.up.data.*;

/**
 * <p>
 * The function class is a facility class usable to generate figure that
 * represent mathematical curves.
 * </p>
 * 
 * @author Luc Hogie
 */

public abstract class Function
{
    private double[] definitionValues;

    /**
     * Evaluate the function at the given position. The return element is not a
     * single number but a point. This allow the modelisation of parametric
     * functions.
     * 
     * @param d
     * @return Point
     */
    public abstract Point evaluate(double d);

    /**
     * Sets the set of values on which the function is defined.
     * 
     * @return double[]
     */
    public double[] getDefinitionValues()
    {
	return definitionValues;
    }

    /**
     * Sets the set of values on which the function is defined. Note that allow
     * only to modelise descrete functions. This is not a problem because the
     * goal of Up is the representation and the representing a non-discrete
     * function is, anyway, a discrete process.
     * 
     * @param values
     */
    public void setDefinitionValues(double[] values)
    {
	definitionValues = values;
    }

    /**
     * Sets a definition interval for the function. In this interval, the
     * definition set is made of 100 points in the interval.
     * 
     * @param start
     * @param end
     */
    public void setDefinitionValues(double start, double end)
    {
	setDefinitionValues(start, end, (end - start) / 100);
    }

    /**
     * Sets a definition interval for the function with the given step.
     * 
     * @param start
     * @param end
     * @param step
     */
    public void setDefinitionValues(double start, double end, double step)
    {
	if (!(start < end))
	    throw new IllegalArgumentException("start must be strictly inferior to end");

	int sz = (int) ((end - start) / step);
	double[] array = new double[sz];
	double t = start;

	for (int i = 0; i < sz; ++i)
	{
	    array[i] = t;
	    t += step;
	}

	setDefinitionValues(array);
    }

    /**
     * Creates a figure that is the representation of the function on its
     * interval.
     * 
     * @return Figure
     */
    public Figure createFigure()
    {
	Figure f = new Figure();
	double[] xList = getDefinitionValues();

	if (xList != null)
	{
	    for (double x : xList)
	    {
		Point p = evaluate(x);
		f.addPoint(p);
	    }
	}

	return f;
    }
}
