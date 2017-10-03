package ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CalculatorUI extends Application
{
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Calculator");
        stage.setScene(assemble());
        stage.show();
    }

    private Scene assemble()
    {
        GridPane gridPane = new GridPane();

        // calculator buttons
        Button num7 = new Button("7");
        Button num8 = new Button("8");
        Button num9 = new Button("9");
        Button num4 = new Button("4");
        Button num5 = new Button("5");
        Button num6 = new Button("6");
        Button num1 = new Button("1");
        Button num2 = new Button("2");
        Button num3 = new Button("3");
        Button num0 = new Button("0");

        Button enter = new Button("Enter");
        Button add = new Button("+");
        Button subtract = new Button("-");
        Button multiply = new Button("*");
        Button divide = new Button("/");

        Label output = new Label("");

        // adding first row of buttons - 7 8 9 +
        gridPane.add(num7, 0,0);
        gridPane.add(num8, 1, 0);
        gridPane.add(num9, 2, 0);
        gridPane.add(add, 3, 0);

        // adding second row of buttons - 4 5 6 -
        gridPane.add(num4, 0, 1);
        gridPane.add(num5, 1, 1);
        gridPane.add(num6, 2,1);
        gridPane.add(subtract, 3, 1);

        // adding third row of buttons
        gridPane.add(num1, 0,2);
        gridPane.add(num2, 1,2);
        gridPane.add(num3, 2,2);
        gridPane.add(multiply, 3,2);

        // adding the fourth row of buttons
        gridPane.add(num0, 0,3);
        gridPane.add(enter,1,3,2,1);
        gridPane.add(divide, 3,3);

        // adding output bar
        gridPane.add(output,0,0,4,1);

        return new Scene(gridPane, 250,200);
    }
}
