package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TodoViewAddTask
{
    private static final int WIN_WIDTH = 300;
    private static final int WIN_HEIGHT = 300;
    public static final int PANEL_PADING = 10;

    public static Scene getScene()
    {
        VBox box = new VBox();

        box.setPadding(new Insets(PANEL_PADING));
        box.setSpacing(10);
        box.setStyle("-fx-background-color: lightpink");

        Label title = new Label("Add New Task");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        TextArea newTask = new TextArea();
        newTask.setStyle("-fx-focus-color: transparent");

        Button finish = new Button("Finish");


        box.getChildren().addAll(title, newTask, finish);

        return new Scene(box, WIN_WIDTH, WIN_HEIGHT);
    }

}
