package layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GridLayoutPractice extends Application
{
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Practicing with GridPane!");
        stage.setScene(assemble());
        stage.show();
    }

    private Scene assemble()
    {
        // assemble our controls in a grid
        GridPane gridPane = new GridPane();

        // set spacing around elements
        gridPane.setHgap(20); // pixels horizontally
        gridPane.setVgap(10); // pixels vertically
        gridPane.setPadding(new Insets(10));

        // define column and row constraints
        gridPane.getColumnConstraints().addAll(new ColumnConstraints(80),
                new ColumnConstraints(80), new ColumnConstraints(80));


        // create dummy controls and add to grid
        CheckBox box1 = new CheckBox("Fun!");
        CheckBox box2 = new CheckBox("Sadness!");
        CheckBox box3 = new CheckBox("Nothing!");

        // add first row of check boxes
        gridPane.add(box1, 0, 0);
        gridPane.add(box2, 1, 0);
        gridPane.add(box3, 2,0);

        // add second row
        Button button = new Button("Click me!");
        button.setPrefWidth(Double.MAX_VALUE);  // fill the width of the parent grid pane (aka Scene I think)
        gridPane.add(button, 0, 1,3,1);

        // add third row
        TextArea area = new TextArea("Type a lot of information here....");
        Text text = new Text("Lots of information located here.");
        text.setWrappingWidth(80); // wrap text beyond the width of the column

        gridPane.add(area, 0,2, 2, 1);
        gridPane.add(text, 2, 2);

        return new Scene(gridPane, 300, 260);
    }


}
