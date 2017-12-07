package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Circle;
import shapes.Triangle;

public class TriangleAdapter implements IShape
{
    private Triangle triangle;

    public TriangleAdapter(Triangle triangle)
    {
        this.triangle = triangle;
    }

    @Override
    public IShape setThickness(double value)
    {
        triangle = new Triangle(getX(), getY(), triangle.getWidth(), triangle.getHeight(), value, getColor(), getFilled());
        return this;
    }

    @Override
    public IShape setColor(Color value)
    {
        triangle = new Triangle(getX(), getY(), triangle.getWidth(), triangle.getHeight(), getThickness(), value, getFilled());
        return this;
    }

    @Override
    public IShape setFilled(boolean value)
    {
        triangle = new Triangle(getX(), getY(), triangle.getWidth(), triangle.getHeight(), getThickness(), getColor(), value);
        return this;
    }

    @Override
    public double getX()
    {
        return triangle.getX();
    }

    @Override
    public double getY()
    {
        return triangle.getY();
    }

    @Override
    public double getThickness()
    {
        return triangle.getThickness();
    }

    @Override
    public Color getColor()
    {
        return triangle.getColor();
    }

    @Override
    public boolean getFilled()
    {
        return triangle.isFill();
    }

    @Override
    public void drawShape(GraphicsContext graphics)
    {
        graphics.setLineWidth(getThickness());
        graphics.setStroke(getColor());
        graphics.strokePolygon(new double[] {getX(), getX() + triangle.getWidth(), getX() + triangle.getWidth() * 2},
                new double[] {getY(), getY() - triangle.getHeight(), getY()}, 3);

        if (getFilled())
        {
            graphics.setFill(getColor());
            graphics.fillPolygon(new double[] {getX(), getX() + triangle.getWidth(), getX() + triangle.getWidth() * 2},
                    new double[] {getY(), getY() - triangle.getHeight(), getY()}, 3);
        }
    }
}
