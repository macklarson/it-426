/**
 * Mackenzie Larson
 * 12/7/2017
 * DoodlePad.java
 */
package ui;

import adapters.CircleAdapter;
import adapters.LineAdapter;
import adapters.RectangleAdapter;
import adapters.TriangleAdapter;
import drawing.IShape;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import shapes.Circle;
import shapes.Line;
import shapes.Rectangle;
import shapes.Triangle;

import java.util.Random;

/**
 * @author Mackenzie Larson
 * @version 1.0
 *  The UI for the doodle pad
 */
public class DoodlePad extends Application
{
    private Stage stage;
    public final int TEXT_FIELD_WIDTH = 28;
    public final int TEXT_FIELD_HEIGHT = 20;
    public final int SHAPE_RADIUS = 40;
    public final int SHAPE_WIDTH = 30;
    public final int SHAPE_HEIGHT = 30;
    public final int SLIDER_WIDTH = 70;
    private final int WIN_WIDTH = 425;
    private final int WIN_HEIGHT = 300;
    private final int BTN_WIDTH = 20;
    private final int BTN_HEIGHT = 20;
    private final int COLOR_WIDTH = 70;
    private final int COLOR_HEIGHT = 28;

    private ColorPicker colorPicker;
    private ToggleGroup group;
    private Slider slider;

    private int lowerBound = -100;
    private int upperBound = 200;

    private ImageView circ = new ImageView ("images/circle.png");
    private ImageView lines = new ImageView ("images/line.png");
    private ImageView rect = new ImageView ("images/rectangle.png");
    private ImageView tri = new ImageView ("images/triangle.png");

    /**
     * starts up the stage for the scene
     * @param stage
     */
    @Override
    public void start(Stage stage)
    {
        this.stage = stage;
        stage.setTitle("DoodlePad");
        stage.setScene(getScene());
        stage.show();
    }

    /**
     * The UI for the doodle pad
     * @return the scene
     */
    public Scene getScene()
    {
        VBox box = new VBox();
        box.setPadding(new Insets(10));

        HBox options = new HBox();
        options.setSpacing(5);

        // shape buttons
        ToggleButton circle = createShapeButton(circ);
        ToggleButton rectangle = createShapeButton(rect);
        ToggleButton triangle = createShapeButton(tri);
        ToggleButton line = createShapeButton(lines);

        // Toggle group
        group = new ToggleGroup();

        circle.setToggleGroup(group);
        circle.setUserData("circle");

        rectangle.setToggleGroup(group);
        rectangle.setUserData("rectangle");

        triangle.setToggleGroup(group);
        triangle.setUserData("triangle");

        line.setToggleGroup(group);
        line.setUserData("line");

        // Color Picker
        colorPicker = new ColorPicker();
        colorPicker.setValue(Color.BLUEVIOLET);
        colorPicker.setStyle("-fx-color-label-visible: false;");
        colorPicker.setMaxHeight(COLOR_HEIGHT);
        colorPicker.setMaxWidth(COLOR_WIDTH);

        // Check box
        CheckBox fill = new CheckBox("Fill");
        fill.setStyle("-fx-font-size: 10px;");

        // Thickness text
        Text thickness = new Text("Thickness");
        thickness.setStyle("-fx-font-size: 10px;");

        // Thickness slider
        slider = new Slider(1, 10, 1);
        slider.setMaxWidth(SLIDER_WIDTH);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(1);

        // Thickness text field
        TextField thickNum = new TextField("1");
        thickNum.setPrefWidth(TEXT_FIELD_WIDTH);
        thickNum.setPrefHeight(TEXT_FIELD_HEIGHT);

        slider.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue)
            {
                thickNum.setText(String.valueOf(newValue.intValue()));
            }
        });

        // creating the canvas
        HBox canvasBox = new HBox();
        canvasBox.setStyle("-fx-background-color: lightgrey");
        Canvas canvas = new Canvas(WIN_WIDTH - 10, WIN_HEIGHT - 10);
        canvasBox.getChildren().add(canvas);

        // adding everthing to the boxes
        options.getChildren().addAll(circle, rectangle, triangle, line, colorPicker, fill,
                thickness, thickNum, slider);
        box.getChildren().addAll(options, canvasBox);

        canvas.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                GraphicsContext graphics = canvas.getGraphicsContext2D();

                double x = event.getX();
                double y = event.getY();
                double radius = SHAPE_RADIUS;
                double width = SHAPE_WIDTH;
                double height = SHAPE_HEIGHT;

                IShape shape;
                Random random = new Random();

                if (group.getSelectedToggle().getUserData().equals("circle"))
                {
                    shape = new CircleAdapter(new Circle(radius, x, y, slider.getValue(),
                            colorPicker.getValue(), fill.isSelected()));
                    shape.drawShape(graphics);
                }
                else if (group.getSelectedToggle().getUserData().equals("triangle"))
                {
                    shape = new TriangleAdapter(new Triangle(x, y, width, height, slider.getValue(),
                            colorPicker.getValue(), fill.isSelected()));
                    shape.drawShape(graphics);
                }
                else if (group.getSelectedToggle().getUserData().equals("rectangle"))
                {
                    shape = new RectangleAdapter(new Rectangle(x, y, width, height, slider.getValue(),
                            colorPicker.getValue(), fill.isSelected()));
                    shape.drawShape(graphics);
                }
                else if (group.getSelectedToggle().getUserData().equals("line"))
                {
                    shape = new LineAdapter(new Line(x, y, x + (lowerBound + random.nextInt(upperBound)),
                            y + (lowerBound + random.nextInt(upperBound)), slider.getValue(),
                            colorPicker.getValue(), fill.isSelected()));
                    shape.drawShape(graphics);
                }
            }
        });

        return new Scene(box, WIN_WIDTH, WIN_HEIGHT);
    }

    /**
     * creates shape buttons
     * @param shape the image on the button
     * @return Toggle button for shape
     */
    public ToggleButton createShapeButton(ImageView shape)
    {
        ToggleButton button = new ToggleButton();
        shape.setFitWidth(BTN_WIDTH);
        shape.setFitHeight(BTN_HEIGHT);
        button.setGraphic(shape);

        return button;
    }
}