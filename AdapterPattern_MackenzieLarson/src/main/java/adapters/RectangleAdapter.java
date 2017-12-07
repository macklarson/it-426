/**
 * Mackenzie Larson
 * 12/7/2017
 * RectangleAdapter.java
 */
package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Rectangle;

/**
 * @author Mackenzie Larson
 * @version 1.0
 *
 * stores an instance of one of the Rectangle class and implement the IShape interface
 */
public class RectangleAdapter implements IShape
{
    private Rectangle rect;

    /**
     * Constructor for RectangleAdapter
     * @param rect
     */
    public RectangleAdapter(Rectangle rect)
    {
        this.rect = rect;
    }

    @Override
    public IShape setThickness(double value)
    {
        rect = new Rectangle(getX(), getY(), rect.getWidth(), rect.getHeight(), value, getColor(), getFilled());
        return this;
    }

    @Override
    public IShape setColor(Color value)
    {
        rect = new Rectangle(getX(), getY(), rect.getWidth(), rect.getHeight(), getThickness(), value, getFilled());
        return this;
    }

    @Override
    public IShape setFilled(boolean value)
    {
        rect = new Rectangle(getX(), getY(), rect.getWidth(), rect.getHeight(), getThickness(), getColor(), value);
        return this;
    }

    @Override
    public double getX()
    {
        return rect.getX();
    }

    @Override
    public double getY()
    {
        return rect.getY();
    }

    @Override
    public double getThickness()
    {
        return rect.getThickness();
    }

    @Override
    public Color getColor()
    {
        return rect.getColor();
    }

    @Override
    public boolean getFilled()
    {
        return rect.isFill();
    }

    @Override
    public void drawShape(GraphicsContext graphics)
    {
        graphics.setLineWidth(getThickness());
        graphics.setStroke(getColor());
        graphics.strokeRect(getX(), getY(), rect.getWidth(), rect.getHeight());

        if (getFilled())
        {
            graphics.setFill(getColor());
            graphics.fillRect(getX(), getY(), rect.getWidth(), rect.getHeight());
        }
    }
}
