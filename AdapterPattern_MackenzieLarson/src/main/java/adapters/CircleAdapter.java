package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Circle;

public class CircleAdapter implements IShape
{
    private Circle circle;

    public CircleAdapter(Circle circle)
    {
        this.circle = circle;
    }

    @Override
    public IShape setThickness(double value)
    {
        circle = new Circle(circle.getRadius(), getX(), getY(), value, getColor(), getFilled());
        return this;
    }

    @Override
    public IShape setColor(Color value)
    {
        circle = new Circle(circle.getRadius(), getX(), getY(), getThickness(), value, getFilled());
        return this;
    }

    @Override
    public IShape setFilled(boolean value)
    {
        circle = new Circle(circle.getRadius(), getX(), getY(), getThickness(), getColor(), value);
        return this;
    }

    @Override
    public double getX()
    {
        return circle.getX();
    }

    @Override
    public double getY()
    {
        return circle.getY();
    }

    @Override
    public double getThickness()
    {
        return circle.getThickness();
    }

    @Override
    public Color getColor()
    {
        return circle.getColor();
    }

    @Override
    public boolean getFilled()
    {
        return circle.isFill();
    }

    @Override
    public void drawShape(GraphicsContext graphics)
    {
        graphics.setLineWidth(getThickness());
        graphics.setStroke(getColor());
        graphics.strokeOval(getX(), getY(), circle.getRadius(), circle.getRadius());

        if (getFilled())
        {
            graphics.setFill(getColor());
            graphics.fillOval(getX(), getY(), circle.getRadius(), circle.getRadius());
        }
    }
}
