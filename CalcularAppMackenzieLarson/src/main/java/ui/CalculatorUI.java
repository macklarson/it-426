/*
 * Mackenzie Larson
 * 10/6/2017
 * Calculator App Part 1
 * CalculatorUI.java
 */

package ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Mackenzie Larson
 * @version 1.0
 * CalculatorUI.java
 *
 * The UI for a calculator application
 */
public class CalculatorUI extends Application
{
    private static final int BUTTON_HEIGHT = 25;
    private static final int BUTTON_WIDTH = 26;

    /**
     * Constructor to set up the application
     * @param stage holds the application
     */
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Calculator");
        stage.setScene(assemble());
        stage.show();
    }

    /**
     * Builds the calculator, adds buttons to GridPane
     * @return Scene contains the grid pane of buttons
     */
    private Scene assemble()
    {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 0, 10));
        gridPane.setStyle("-fx-background-color: #BCA9F5"); // background color of calculator
        gridPane.setAlignment(Pos.CENTER); // center calculator on screen

        // creating calculator buttons
        Button num1 = createButton("1", "#DF01D7");
        Button num2 = createButton("2", "#A901DB");
        Button num3 = createButton("3", "#7401DF");
        Button num4 = createButton("4", "#B404AE");
        Button num5 = createButton("5", "#8904B1");
        Button num6 = createButton("6", "#5F04B4");
        Button num7 = createButton("7", "#8A0868");
        Button num8 = createButton("8", "#6A0888");
        Button num9 = createButton("9", "#4B088A");
        Button num0 = createButton("0", "#FF00FF");

        Button add = createButton("+", "#9A2EFE");
        Button subtract = createButton("-", "#9A2EFE");
        Button multiply = createButton("*", "#9A2EFE");
        Button divide = createButton("/", "#9A2EFE");

        Button enter = createEnterButton("Enter", 25, 62, "#BE81F7");

        // creating output bar
        HBox output = new HBox();
        output.setAlignment(Pos.CENTER_RIGHT);
        output.setStyle("-fx-border-width: 3px; " +
                "-fx-border-color: #BE81F7; " +
                "-fx-background-color: white; "); // sets border and color
        output.setPadding(new Insets(0,5,0,0)); // shifts text slightly left
        output.getChildren().addAll(new Label("74"));

        // adding first row of buttons: 7 8 9 +
        gridPane.add(num7, 0,0);
        gridPane.add(num8, 1, 0);
        gridPane.add(num9, 2, 0);
        gridPane.add(add, 3, 0);

        // adding second row of buttons: 4 5 6 -
        gridPane.add(num4, 0, 1);
        gridPane.add(num5, 1, 1);
        gridPane.add(num6, 2,1);
        gridPane.add(subtract, 3, 1);

        // adding third row of buttons: 1, 2, 3, *
        gridPane.add(num1, 0,2);
        gridPane.add(num2, 1,2);
        gridPane.add(num3, 2,2);
        gridPane.add(multiply, 3,2);

        // adding the fourth row of buttons: 0, enter, /
        gridPane.add(num0, 0,3);
        gridPane.add(enter,1,3,2,1);
        gridPane.add(divide, 3,3);

        // adding output to screen
        gridPane.add(output,0,4,4,1);

        return new Scene(gridPane, 240, 200);
    }

    /**
     * Creates a button
     * Sets the text, size, color, and color change on click
     * @param text text that will appear on button
     * @param color color that the button will turn on click
     * @return Button the calculator button
     */
    public Button createButton(String text, String color)
    {
        Button button = new Button();

        button.setText(text);
        button.setPrefHeight(BUTTON_HEIGHT);
        button.setPrefWidth(BUTTON_WIDTH);
        button.setStyle("-fx-background-color: #AC58FA");

        // changes buttons color on click
        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                button.setStyle("-fx-background-color:" + color + "; -fx-text-fill: white");
            }
        });

        return button;
    }

    /**
     * Creates the Enter button and its attributes
     * @param text text on button
     * @param height height of button
     * @param width width of button
     * @param color color of button
     * @return Button the created button
     */
    public Button createEnterButton(String text, int height, int width, String color)
    {
        Button button = new Button();

        button.setText(text);
        button.setPrefHeight(height);
        button.setPrefWidth(width);
        button.setStyle("-fx-background-color:"+color);

        // changes text color of button on click
        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                button.setStyle("-fx-background-color:" + color + "; -fx-text-fill: white");
            }
        });

        return button;
    }
}
