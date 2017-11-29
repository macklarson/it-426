/**
 * Mackenzie Larson
 * 11/29/2017
 * TodoViewAddTask.java
 */

package View;

import Controller.TodoController;
import Model.TodosModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * @author Mackenzie Larson
 * @version 1.0
 *
 * UI for adding a task
 */
public class TodoViewAddTask
{
    private static final int WIN_WIDTH = 300;
    private static final int WIN_HEIGHT = 300;
    public static final int PANEL_PADING = 10;

    /**
     * GUI for adding a new task
     * @return the scene
     */
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
        finish.setStyle("-fx-focus-color: transparent;");
        finish.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        finish.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if(!newTask.getText().equals(""))
                {
                    TodoController.addTask(newTask.getText());
                }

                TodoController.switchScenes(finish.getText());
            }
        });

        box.getChildren().addAll(title, newTask, finish);

        return new Scene(box, WIN_WIDTH, WIN_HEIGHT);
    }
}