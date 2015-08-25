package cnrs.luchogie.up.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Graduation extends BoundedSpaceElement
{
    private Map<Double, GlyphVector> glyphVectors = new HashMap<Double, GlyphVector>();

    private double step = 1;

    private boolean autoStep = true;

    private int dedicatedPixelCount = 0;

    private GraduationStepProperties stepProperties = new GraduationStepProperties();

    private int stepPixelInterval = 40;

    private int pixelCountBetweenAxisLineAndText = 5;

    private Font font = new Font(null, Font.PLAIN, 9);

    private Collection<Double> shownSteps;

    public Axis getParentAxis()
    {
        return (Axis) getParent();
    }

    /**
     * Gets the number of pixels of the area where the graduation labels are
     * drawn.
     * 
     * @return int
     */
    public int getDedicatedPixelCount()
    {
        if (isVisible())
        {
            return dedicatedPixelCount;
        }
        else
        {
            return 5;
        }
    }

    /**
     * Sets the number of pixels of the area where the graduation labels are
     * drawn.
     * 
     * @param dedicatedPixelCount
     */
    public void setDedicatedPixelCount(int dedicatedPixelCount)
    {
        if (dedicatedPixelCount < 0)
            throw new IllegalArgumentException("dedicated pixel count < 0");

        this.dedicatedPixelCount = dedicatedPixelCount;
    }

    /**
     * Gets if the graduation is automatically stepped: if the number and the
     * position of graduation labels are automatically defined.
     * 
     * @return boolean
     */
    public boolean isAutoStepped()
    {
        return autoStep;
    }

    /**
     * Sets if the graduation has to be automatically stepped: if the number and
     * the position of graduation labels are automatically defined.
     * 
     * @param autoStep
     */
    public void setAutoStepped(boolean autoStep)
    {
        this.autoStep = autoStep;
    }

    /**
     * Gets the step used to display the graduation labels.
     * 
     * @return double
     */
    public double getStep()
    {
        return this.step;
    }

    /**
     * Sets the step used to display the graduation labels.
     * 
     * @param step
     */
    public void setStep(double step)
    {
        if (step <= 0)
            throw new IllegalArgumentException("step <= 0");

        this.step = step;
        setAutoStepped(false);
    }

    /**
     * Returns the stepInPixel.
     * 
     * @return int
     */
    public int getStepInPixel()
    {
        return stepPixelInterval;
    }

    /**
     * Sets the stepInPixel. This interval may not be strictly respected: it is
     * used for automatic stepping, it helps the system to calculate the best
     * step. Setting this property means that you want the plotter to use a
     * stepping of, nearly, <code>n</code> pixels.
     * 
     * @param stepPixelInterval
     *            The stepPixelInterval to set
     */
    public void setStepInPixel(int stepPixelInterval)
    {
        if (stepPixelInterval <= 0)
            throw new IllegalArgumentException("step pixel interval must be > 0");

        this.stepPixelInterval = stepPixelInterval;
        setAutoStepped(true);
    }

    /**
     * Returns the pixelCountBetweenAxisLineAndText.
     * 
     * @return int
     */
    public int getPixelCountBetweenAxisLineAndText()
    {
        return pixelCountBetweenAxisLineAndText;
    }

    /**
     * Sets the pixelCountBetweenAxisLineAndText.
     * 
     * @param pixelCountBetweenAxisLineAndText
     *            The pixelCountBetweenAxisLineAndText to set
     */
    public void setPixelCountBetweenAxisLineAndText(int pixelCountBetweenAxisLineAndText)
    {
        this.pixelCountBetweenAxisLineAndText = pixelCountBetweenAxisLineAndText;
    }

    public Font getFont()
    {
        return font;
    }

    public void setFont(Font font)
    {
        if (font == null)
            throw new IllegalArgumentException("graduation font cannot be set to null");

        this.font = font;
    }

    /**
     * Returns the stepProperties.
     * 
     * @return GraduationStepProperties
     */
    public GraduationStepProperties getStepProperties()
    {
        return stepProperties;
    }

    /**
     * Sets the stepProperties.
     * 
     * @param stepProperties
     *            The stepProperties to set
     */
    public void setStepProperties(GraduationStepProperties stepProperties)
    {
        if (stepProperties == null)
            throw new NullPointerException("stepProperties cannot be set to null");

        this.stepProperties = stepProperties;
    }

    public void update(double size, Graphics2D spaceGraphics)
    {
        Dimension dimension = getParentAxis().getParentDimension();

        if (isMinimumIsAutomatic())
        {
            setMin(dimension.getMin());
            setMinimumIsAutomatic(true);
        }

        if (isMaximumIsAutomatic())
        {
            setMax(dimension.getMax());
            setMaximumIsAutomatic(true);
        }

        if (isAutoStepped())
        {
            double stepCount = Math.max(0, size / getStepInPixel());
            double range = dimension.getMax() - dimension.getMin();
            step = range / stepCount;
            step = normalizeStep(step);
        }

        shownSteps = null;
        glyphVectors = null;
        createGlyphVectors(spaceGraphics, spaceGraphics.getFontRenderContext());
    }

    private Collection<Double> getShownSteps()
    {
        if (shownSteps == null)
        {
            shownSteps = new ArrayList<Double>();
            Dimension dimension = getParentAxis().getParentDimension();

            double max = Math.min(getMax(), dimension.getMax());

            for (double i = 0; i <= max; i += getStep())
            {
 //               i = lucci.math.MathsUtilities.round(i, 0);

                if (i >= dimension.getMin())
                {
                    shownSteps.add(i);
                }
            }

            double min = Math.max(getMin(), dimension.getMin());

            for (double i = -getStep(); i >= min; i -= getStep())
            {
//                i = lucci.math.MathsUtilities.round(i, 0);

                if (i <= dimension.getMax())
                {
                    shownSteps.add(i);
                }
            }
        }
        
        return shownSteps;
    }

    protected void draw(Graphics2D spaceGraphics, Graphics2D figureGraphics)
    {
        if (isVisible())
        {
            // if the origin axis is too near to the primary axis, the
            // graduation steps
            // of the origin axis are not displayed : this prevents an ugly
            // effect that text
            // drawn over another
            if (!graduationStepsMustBeHidden(figureGraphics))
            {
                Axis axis = getParentAxis();

                for (double i : getShownSteps())
                {
                    if (((Dimension) axis.getParent()).getOrientation() == Dimension.ORIENTATION_X)
                    {
                        drawHorizontalAxisGraduationStep(spaceGraphics, i);
                    }
                    else
                    {
                        drawVerticalAxisGraduationStep(spaceGraphics, i);
                    }
                }
            }
        }
    }

//    private DecimalFormat numberFormatter = new DecimalFormat("##0.#####E0");

    private void drawHorizontalAxisGraduationStep(Graphics2D spaceGraphics, double value)
    {
        Space space = (Space) getParent().getParent().getParent();
        Dimension xDimension = space.getXDimension();
        Dimension yDimension = space.getYDimension();

        int x = xDimension.convertToGraphicsCoordonateSystem(value) + yDimension.getLowerBoundAxis().getGraduation().getDedicatedPixelCount();
        int y = getHorizontalAxisY(spaceGraphics);

        if (stepProperties.getLineLengthAt(value) > 0)
        {
            setGraphicsColor(spaceGraphics, stepProperties.getLineColorAt(value));

            if (((Axis) getParent()).getPosition() == Axis.UPPER_BOUND)
            {
                spaceGraphics.drawLine(x, y, x, y + stepProperties.getLineLengthAt(value));
            }
            else
            {
                spaceGraphics.drawLine(x, y, x, y - stepProperties.getLineLengthAt(value));
            }
        }

//        GlyphVector gv = this.glyphVectors.get(numberFormatter.format(value));
        GlyphVector gv = this.glyphVectors.get(value);

        if (gv != null)
        {
            Rectangle2D r = gv.getPixelBounds(null, 0, 0);
            int textWidth = (int) r.getWidth();
            int textHeight = (int) r.getHeight();
            setGraphicsColor(spaceGraphics, stepProperties.getTextColorAt(value));
            int shift = getPixelCountBetweenAxisLineAndText();

            // only the upper bound X axis graduation is drawn on the top of the
            // axis line
            if (((Axis) getParent()).getPosition() == Axis.UPPER_BOUND)
            {
                spaceGraphics.drawGlyphVector(gv, x - textWidth / 2, y - shift);
            }
            else
            {
                int xshift = 0;

                if (((Axis) getParent()).getPosition() == Axis.ORIGIN)
                {
                    if (value == 0)
                    {
                        if (space.getYDimension().getOriginAxis().getLine().isVisible())
                        {
                            xshift = -textWidth / 2 - 5;
                        }
                    }
                    else if (value == ((Dimension) getParent().getParent()).getMin())
                    {
                        if (space.getYDimension().getLowerBoundAxis().getLine().isVisible())
                        {
                            xshift = textWidth / 2 + 1;
                        }
                    }
                    else if (value == ((Dimension) getParent().getParent()).getMax())
                    {
                        if (space.getYDimension().getUpperBoundAxis().getLine().isVisible())
                        {
                            xshift = -textWidth / 2 - 2;
                        }
                    }
                }

                spaceGraphics.drawGlyphVector(gv, x - textWidth / 2 + xshift, y + textHeight + shift);
            }
        }
    }

    
    
    private int getHorizontalAxisY(Graphics2D graphics)
    {
        int position = ((Axis) getParent()).getPosition();

        if (position == Axis.LOWER_BOUND)
        {
            return (int) graphics.getClipBounds().getHeight() - 1 - getDedicatedPixelCount();
        }
        else if (position == Axis.UPPER_BOUND)
        {
            return getDedicatedPixelCount();
        }
        else
        {
            Dimension dimension = (Dimension) getParent().getParent();
            return dimension.getUpperBoundAxis().getGraduation().getDedicatedPixelCount() + dimension.getSiblingDimension().convertToGraphicsCoordonateSystem(0);
        }
    }

  private void drawVerticalAxisGraduationStep(Graphics2D graphics, double value)
  {
      Space space = (Space) getParent().getParent().getParent();
      Dimension xDimension = space.getXDimension();
      Dimension yDimension = space.getYDimension();
      int x = getVerticalAxisX(graphics);
      int y = yDimension.convertToGraphicsCoordonateSystem(value) + xDimension.getUpperBoundAxis().getGraduation().getDedicatedPixelCount();

      if (stepProperties.getLineLengthAt(value) > 0)
      {
          setGraphicsColor(graphics, stepProperties.getLineColorAt(value));

          if (((Axis) getParent()).getPosition() == Axis.UPPER_BOUND)
          {
              graphics.drawLine(x, y, x - stepProperties.getLineLengthAt(value), y);
          }
          else
          {
              graphics.drawLine(x, y, x + stepProperties.getLineLengthAt(value), y);
          }
      }

      GlyphVector gv = this.glyphVectors.get(value);
      
      if (gv != null)
      {
          int shift = getPixelCountBetweenAxisLineAndText();
          Rectangle2D r = gv.getPixelBounds(null, 0, 0);
          int textWidth = (int) r.getWidth();
          int textHeight = (int) r.getHeight();
          setGraphicsColor(graphics, stepProperties.getTextColorAt(value));

          if (((Axis) getParent()).getPosition() == Axis.UPPER_BOUND)
          {
              graphics.drawGlyphVector(gv, x + shift, y + textHeight / 2);
          }
          else
          {
              int yshift = 0;

              if (((Axis) getParent()).getPosition() == Axis.ORIGIN)
              {
                  if (value == 0)
                  {
                      if (xDimension.getOriginAxis().getLine().isVisibleAt(0))
                      {
                          if (xDimension.getOriginAxis().getGraduation().isVisibleAt(0))
                          {
                              // if the text of the two dimension is the same
                              // at the (0, 0) point
                              if (space.getXDimension().getOriginAxis().getGraduation().getStepProperties().getTextAt(0f).equals(getStepProperties().getTextAt(0f)))
                              {
                                  return;
                              }
                              else
                              {
                                  yshift = -5;
                              }
                          }
                      }
                  }
                  else if (value == yDimension.getMin())
                  {
                      if (space.getXDimension().getLowerBoundAxis().getLine().isVisible())
                      {
                          yshift = -textHeight / 2 - 1;
                      }
                  }
                  else if (value == yDimension.getMax())
                  {
                      if (space.getXDimension().getLowerBoundAxis().getLine().isVisible())
                      {
                          yshift = textHeight / 2 + 3;
                      }
                  }
              }

              graphics.drawGlyphVector(gv, x - textWidth - shift, y + textHeight / 2 + yshift);
          }
      }
  }

    

    /**
     * This method will be invoked only the Y dimension.
     */
    private int getVerticalAxisX(Graphics2D graphics)
    {
        int position = ((Axis) getParent()).getPosition();

        if (position == Axis.LOWER_BOUND)
        {
            return getDedicatedPixelCount();
        }
        else if (position == Axis.UPPER_BOUND)
        {
            return (int) graphics.getClipBounds().getWidth() - 1 - getDedicatedPixelCount();
        }
        else
        {
            Dimension dimension = (Dimension) getParent().getParent();
            return ((Dimension) getParent().getParent()).getLowerBoundAxis().getGraduation().getDedicatedPixelCount() + dimension.getSiblingDimension().convertToGraphicsCoordonateSystem(0);
        }
    }

    private boolean graduationStepsMustBeHidden(Graphics2D graphics)
    {
        Axis axis = (Axis) getParent();
        Dimension dimension = (Dimension) axis.getParent();

        if (axis.getPosition() == Axis.ORIGIN)
        {
            if (dimension.getLowerBoundAxis().getGraduation().isVisible() || dimension.getUpperBoundAxis().getGraduation().isVisible())
            {
                // if the origin is included in the dimension
                if (dimension.getMin() < 0 && 0 < dimension.getMax())
                {
                    // calculates the number of pixels used by the negative area
                    // of the sibbling dimension
                    Dimension sibblingDimension = dimension.getSiblingDimension();
                    int size = sibblingDimension.getGraphicsSize(graphics);
                    double negativeArrayRate = -sibblingDimension.getMin() / (sibblingDimension.getMax() - sibblingDimension.getMin());
                    size = (int) ((float) size * negativeArrayRate);

                    Graduation lowerBoundAxisGraduation = dimension.getLowerBoundAxis().getGraduation();
                    if (lowerBoundAxisGraduation.isVisible())
                    {
                        // if less than 50 pixels are dedicated to the negative
                        // area of the
                        // dimension, it's better the graduation step not to be
                        // displayed
                        return size < 50;
                    }
                    else
                    {
                        // the lower bound axis graduation is not visible, so
                        // the origin bound axis graduation HAS to be shown
                        // BUT if the text may be cutted by the limit of the
                        // graphics, it's better that it's invisible
                        return size < 1.5 * getPixelCountBetweenAxisLineAndText() + getFont().getSize();
                    }
                }
                else
                {
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    private void createGlyphVectors(Graphics2D spaceGraphics, FontRenderContext frc)
    {
        this.glyphVectors = new HashMap<Double, GlyphVector>();
        this.dedicatedPixelCount = 0;

        for (double thisStep : getShownSteps())
        {
            String text = stepProperties.getTextAt(thisStep);

            if (text == null)
            {
                text = "";
            }

            // text = simplify(text);
            GlyphVector gv = font.createGlyphVector(frc, text);
            glyphVectors.put(thisStep, gv);
            java.awt.Dimension dimension = gv.getPixelBounds(frc, 0, 0).getSize();
            int size = getParentAxis().getParentDimension().getOrientation() == Dimension.ORIENTATION_X ? dimension.height : dimension.width;

            if (size > this.dedicatedPixelCount)
            {
                this.dedicatedPixelCount = size;
            }
        }

        this.dedicatedPixelCount += getPixelCountBetweenAxisLineAndText();
    }


    private String simplify(String text)
    {
        if (text.endsWith("000000000000"))
        {
            text = text.substring(text.length() - 12) + 'T';
        }
        else if (text.endsWith("000000000"))
        {
            text = text.substring(text.length() - 9) + 'G';
        }
        else if (text.endsWith("000000"))
        {
            text = text.substring(text.length() - 6) + 'M';
        }
        else if (text.endsWith("000"))
        {
            text = text.substring(text.length() - 3) + 'K';
        }

        return text;
    }

    private double normalizeStep(double step)
    {
        double intlog = Math.floor(Math.log(step) / Math.log(10));
        step = step * Math.pow(10, -intlog);
        step = Math.round(step);

        switch ((int) step)
        {
        case 1:
            step = 1;
            break;
        case 2:
            step = 2;
            break;
        case 3:
            step = 2.5;
            break;
        case 4:
            step = 5;
            break;
        case 5:
            step = 5;
            break;
        case 6:
            step = 5;
            break;
        case 7:
            step = 5;
            break;
        case 8:
            step = 10;
            break;
        case 9:
            step = 10;
            break;
        }

        return step * Math.pow(10, intlog);
    }

    private void setGraphicsColor(Graphics2D graphics, Color color)
    {
        if (color == null)
        {
            color = getColor();
        }

        graphics.setColor(color);
    }

    public String toString()
    {
        return "Graduation";
    }
}
