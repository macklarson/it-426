/**
 * Mackenzie Larson
 * 11/29/2017
 * TodoViewTasks.java
 */

package View;

import Controller.TodoController;
import Model.Todo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Mackenzie Larson
 * @version 1.0
 *
 * UI for viewing all tasks in the list, checking them off
 */
public class TodoViewTasks implements Observer
{
    private static final int WIN_WIDTH = 300;
    private static final int WIN_HEIGHT = 300;
    private static final int BTN_WIDTH = 50;
    private static final int BTN_HEIGHT = 30;
    public static final int PANEL_PADING = 20;

    private static TodoController controller = new TodoController();
    private static ArrayList<Todo> todos = controller.getTodo();

    /**
     * the scene for viewing all tasks in the list
     * @return the scene
     */
    public static Scene getScene()
    {
        VBox box = new VBox();
        HBox tasks = new HBox();

        box.setPadding(new Insets(PANEL_PADING));
        box.setSpacing(10);
        box.setStyle("-fx-background-color: lightpink");

        Label title = new Label("Tasks");
        title.setPrefWidth(220);
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        Button addTask = new Button("+");
        addTask.setStyle("-fx-focus-color: transparent; -fx-font-size: 15px");
        addTask.setPrefWidth(BTN_WIDTH);
        addTask.setPrefHeight(BTN_HEIGHT);

        addTask.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                TodoController.switchScenes(addTask.getText());
            }
        });

        tasks.getChildren().addAll(title, addTask);
        box.getChildren().addAll(tasks);

        if (todos.size() == 0)
        {
            Text noTasks = new Text("There are no tasks currently. Add a task by clicking the + button above.");
            noTasks.setWrappingWidth(250);
            noTasks.setStyle("-fx-font-size: 15px;");
            box.getChildren().add(noTasks);
        }
        else
        {
            for (Todo todo : todos)
            {
                CheckBox checkBox = new CheckBox(todo.getTask());
                box.getChildren().add(checkBox);

                checkBox.setOnAction(new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent event)
                    {
                        controller.deleteTask(todo.getId());
                    }
                });
            }
        }

        return new Scene(box, WIN_WIDTH, WIN_HEIGHT);
    }

    /**
     * updates UI
     * @param observable
     * @param argruments
     */
    @Override
    public void update(Observable observable, Object argruments)
    {
        todos = (ArrayList<Todo>) argruments;
        controller.switchScenes("View");
    }
}
