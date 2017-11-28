package View;

import Controller.TodoController;
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

public class TodoViewTasks
{
    private static final int WIN_WIDTH = 300;
    private static final int WIN_HEIGHT = 300;
    private static final int BTN_WIDTH = 50;
    private static final int BTN_HEIGHT = 30;
    public static final int PANEL_PADING = 20;

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

//         t odo[] taskList = tasks.getArrayOfTasks();
//
//        for (int i = 0; i < taskList.length; i++)
//        {
//            CheckBox checkBox = new CheckBox(taskList[i].getTask());
//            checkBox.setSelected(taskList[i].isChecked());
//            checkBox.setPadding(new Insets(0,0,0, 20));
//            final String task = taskList[i].getTask();
//
//            checkBox.setOnAction(new EventHandler<ActionEvent>()
//            {
//                @Override
//                public void handle(ActionEvent event)
//                {
//                    tasks.changeChecked(task);
//                }
//            });
//
//            taskBox.getChildren().addAll(checkBox);
//        }

        CheckBox checkBox1 = new CheckBox("Vacuum");
        CheckBox checkBox2 = new CheckBox("Shopping");
        CheckBox checkBox3 = new CheckBox("Walk");
        CheckBox checkBox4 = new CheckBox("Relax");

        tasks.getChildren().addAll(title, addTask);
        box.getChildren().addAll(tasks, checkBox1, checkBox2, checkBox3, checkBox4);

        return new Scene(box, WIN_WIDTH, WIN_HEIGHT);
    }
}
