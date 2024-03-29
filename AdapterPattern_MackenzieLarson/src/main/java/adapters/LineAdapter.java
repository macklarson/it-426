/**
 * Mackenzie Larson
 * 12/7/2017
 * LineAdapter.java
 */
package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Line;

/**
 * @author Mackenzie Larson
 * @version 1.0
 *
 * stores an instance of one of the Line class and implement the IShape interface
 */
public class LineAdapter implements IShape
{
    private Line line;

    /**
     * Constructor for LineAdapter
     * @param line
     */
    public LineAdapter(Line line)
    {
        this.line = line;
    }

    @Override
    public IShape setThickness(double value)
    {
        line = new Line(getX(), getY(), line.getX2(), line.getY2(), value, getColor(), getFilled());
        return this;
    }

    @Override
    public IShape setColor(Color value)
    {
        line = new Line(getX(), getY(), line.getX2(), line.getY2(), getThickness(), value, getFilled());
        return this;
    }

    @Override
    public IShape setFilled(boolean value)
    {
        line = new Line(getX(), getY(), line.getX2(), line.getY2(), getThickness(), getColor(), value);
        return this;
    }

    @Override
    public double getX()
    {
        return line.getX();
    }

    @Override
    public double getY()
    {
        return line.getY();
    }

    @Override
    public double getThickness()
    {
        return line.getThickness();
    }

    @Override
    public Color getColor()
    {
        return line.getColor();
    }

    @Override
    public boolean getFilled()
    {
        return line.isFill();
    }

    @Override
    public void drawShape(GraphicsContext graphics)
    {
        graphics.setLineWidth(getThickness());
        graphics.setStroke(getColor());
        graphics.strokeLine(getX(), getY(), line.getX2(), line.getY2());
    }
}
