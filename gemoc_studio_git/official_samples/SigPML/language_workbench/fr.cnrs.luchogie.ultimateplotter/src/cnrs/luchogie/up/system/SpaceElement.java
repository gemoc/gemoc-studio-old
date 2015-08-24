package cnrs.luchogie.up.system;

import java.awt.*;

/**
 * @author Luc Hogie
 * 
 *         <p>
 *         A GraphicalElement is a object that will be painted on the user
 *         graphics. All painted objects are not GraphicalElements. Only objects
 *         that are used to paint the space (everything but not the user data)
 *         are GraphicalElements.
 *         </p>
 * 
 *         <p>
 *         GraphicalElement is a recursive structure. This allow the inheritance
 *         of properties such as color, visibility...
 *         </p>
 * 
 *         <p>
 *         The root GraphicalElement is the space itself. Its direct children
 *         are the 2 dimensions (X and Y) which also have some children (the 3
 *         axis...)
 *         </p>
 */
public class SpaceElement
{
    private boolean visible = true;
    private Color color = null;
    private SpaceElement parent = null;

    /**
     * @returns the parent graphical element of this object. May be null if this
     *          object is the root element of the tree (if it's a Space object).
     */
    public SpaceElement getParent()
    {
	return parent;
    }

    /**
     * Sets the parent for this GraphicalElement. It can be set to null.
     */
    public void setParent(SpaceElement parent)
    {
	this.parent = parent;
    }

    /**
     * Sets if the graphical element is visible or not. If the parent graphical
     * element is not visible, this object will not be visible: the visible
     * property is inherited.
     */
    public boolean isVisible()
    {
	if (parent != null && !parent.isVisible())
	{
	    return false;
	}
	else
	{
	    return visible;
	}
    }

    /**
     * Sets the visibility for this object.
     */
    public void setVisible(boolean visible)
    {
	this.visible = visible;
    }

    /**
     * @return the color of the graphical element. If the color has never be
     *         set, the color of the parent graphical element is returned. If
     *         there is no parent, the default color is black. So, the returned
     *         color cannot be null. The color property is inherited.
     */
    public Color getColor()
    {
	if (color == null)
	{
	    if (parent == null)
	    {
		return Color.black;
	    }
	    else
	    {
		return parent.getColor();
	    }
	}
	else
	{
	    return color;
	}
    }

    /**
     * Sets the color for this object. If it is set to null, the color of the
     * parent graphial element will be used. If there is no parent defined, the
     * color will be set to the default color black.
     */
    public void setColor(Color color)
    {
	this.color = color;
    }
}