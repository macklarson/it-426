package ui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DoodlePad extends Application
{
    private Stage stage;
    private static final int WIN_WIDTH = 425;
    private static final int WIN_HEIGHT = 300;
    private static final int BTN_WIDTH = 20;
    private static final int BTN_HEIGHT = 20;
    private static final int COLOR_WIDTH = 70;
    private static final int COLOR_HEIGHT = 28;
    private static ImageView circ = new ImageView ("images/circle.png");
    private static ImageView lines = new ImageView ("images/line.png");
    private static ImageView rect = new ImageView ("images/rectangle.png");
    private static ImageView tri = new ImageView ("images/triangle.png");


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
    public static Scene getScene()
    {
        VBox box = new VBox();
        box.setPadding(new Insets(10));

        HBox options = new HBox();
        options.setSpacing(5);

        ToggleButton circle = createShapeButton(circ);
        ToggleButton rectangle = createShapeButton(rect);
        ToggleButton triangle = createShapeButton(tri);
        ToggleButton line = createShapeButton(lines);

        ToggleGroup group = new ToggleGroup();
        circle.setToggleGroup(group);
        rectangle.setToggleGroup(group);
        triangle.setToggleGroup(group);
        line.setToggleGroup(group);

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.PINK);
        colorPicker.setStyle("-fx-color-label-visible: false;");
        colorPicker.setMaxHeight(COLOR_HEIGHT);
        colorPicker.setMaxWidth(COLOR_WIDTH);

        CheckBox fill = new CheckBox("Fill");
        fill.setStyle("-fx-font-size: 10px;");

        Text thickness = new Text("Thickness");
        thickness.setStyle("-fx-font-size: 10px;");

        TextField thickNum = new TextField("");
        thickNum.setPrefWidth(28);
        thickNum.setPrefHeight(20);

        Slider slider = new Slider(1, 10, 5);
        slider.setMaxWidth(70);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(1);

        slider.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue)
            {
                thickNum.setText(String.valueOf(newValue.intValue()));
            }
        });

        HBox canvasBox = new HBox();
        canvasBox.setStyle("-fx-background-color: lightgray");
        Canvas canvas = new Canvas(300, 250);
        canvasBox.getChildren().add(canvas);

        options.getChildren().addAll(circle, rectangle, triangle, line, colorPicker, fill,
                thickness, thickNum, slider);
        box.getChildren().addAll(options, canvasBox);

        //togglegroup.getselectedtoggle

        return new Scene(box, WIN_WIDTH, WIN_HEIGHT);
    }

    public static ToggleButton createShapeButton(ImageView shape)
    {
        ToggleButton button = new ToggleButton();
        shape.setFitWidth(BTN_WIDTH);
        shape.setFitHeight(BTN_HEIGHT);
        button.setGraphic(shape);

        return button;

    }
}

