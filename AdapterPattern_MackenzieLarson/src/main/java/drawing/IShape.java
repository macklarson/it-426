package drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public interface IShape
{
    //method chaining

    /**
     * Sets the thickness of the edge of the shape
     * @param value number for thickness
     * @return the shape with the specified thickness
     */
    public IShape setThickness(double value);
    public IShape setColor(Color value);
    public IShape setFilled(boolean value);

    //getters
    public double getX();
    public double getY();
    public double getThickness();
    public Color getColor();
    public boolean getFilled();

    //draw the shape
    public void drawShape(GraphicsContext graphics);
}
