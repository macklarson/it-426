/*
 * Mackenzie Larson
 * 10/6/2017
 * Calculator App Part 1
 * CalculatorUI.java
 */

package ui;

import calculator.Calculator;
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
    private static final int ENTER_WIDTH = 62;
    private String number = "";
    private String operator;
    private Label outputLabel = new Label();
    Calculator calc = new Calculator();

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
        Button num1 = createButton("1", "#DF01D7", true);
        Button num2 = createButton("2", "#A901DB", true);
        Button num3 = createButton("3", "#7401DF", true);
        Button num4 = createButton("4", "#B404AE", true);
        Button num5 = createButton("5", "#8904B1", true);
        Button num6 = createButton("6", "#5F04B4", true);
        Button num7 = createButton("7", "#8A0868", true);
        Button num8 = createButton("8", "#6A0888", true);
        Button num9 = createButton("9", "#4B088A", true);
        Button num0 = createButton("0", "#FF00FF", true);

        Button add = createButton("+", "#8904B1", false);
        Button subtract = createButton("-", "#8904B1", false);
        Button multiply = createButton("*", "#8904B1", false);
        Button divide = createButton("/", "#8904B1", false);
        Button enter = createButton("Enter", "#BE81F7", false);

        // creating output bar
        HBox output = new HBox();
        output.setAlignment(Pos.CENTER_RIGHT);
        output.setStyle("-fx-border-width: 3px; " +
                "-fx-border-color: #BE81F7; " +
                "-fx-background-color: white; "); // sets border and color
        output.setPadding(new Insets(0,5,0,0)); // shifts text slightly left
        output.getChildren().addAll(outputLabel);

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
     * @param buttonLabel text that will appear on button
     * @param color color that the button will turn on click
     * @param isNumber true if button is a number, false if not
     * @return Button the calculator button
     */
    public Button createButton(String buttonLabel, String color, boolean isNumber)
    {
        Button button = new Button();

        button.setText(buttonLabel);
        button.setPrefHeight(BUTTON_HEIGHT);
        button.setStyle("-fx-background-color:" + color + "; -fx-text-fill: white");

        if (buttonLabel.equals("Enter"))
        {
            button.setPrefWidth(ENTER_WIDTH);
        }
        else
        {
            button.setPrefWidth(BUTTON_WIDTH);
        }

        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                // if button is a number
                if (isNumber == true)
                {
                    handleNumberEntry(buttonLabel);
                }

                // if button is an operator
                else if (isNumber == false && !buttonLabel.equals("Enter"))
                {
                    outputLabel.setText(""); // clears text on screen
                    operator = buttonLabel;
                    number = ""; // resets previously stored first number

                    calc.storeOperator(operator); // stores the operator in Calculator
                }

                // if enter is clicked
                else
                {
                    calc.math();
                    outputLabel.setText(String.valueOf(calc.math()));

                    // stores the solution of the previous equation back to the first number
                    calc.storeFirstNumber(calc.math());
                }
            }
        });

        return button;
    }

    /**
     * Handles what happens when a number button is clicked
     * @param newDigit creates a multi number digit
     */
    private void handleNumberEntry(String newDigit)
    {
        // if an operator has been clicked
        if (operator != null)
        {
            number += newDigit;
            outputLabel.setText(number); // sets the text on the output label
            calc.storeNextNumber(Integer.parseInt(number)); // stores number in Calculator
        }
        // handles the first number of the equation
        else
        {
            number += newDigit;
            outputLabel.setText(number);
            calc.storeFirstNumber(Integer.parseInt(number)); // stores number
        }
    }
}