package Controller;

import Model.TodosModel;
import View.TodoViewAddTask;
import View.TodoViewTasks;
import View.TodoViewWelcomePage;
import javafx.application.Application;
import javafx.stage.Stage;

public class TodoController extends Application
{
    private static Stage stage;
    private static TodosModel todo = new TodosModel();

    public void start(Stage stage)
    {
        this.stage = stage;
        stage.setTitle("Task List");
        stage.setScene(TodoViewWelcomePage.getScene());
        stage.show();
    }

    /**
     * This method decides which scene to load based off the button pressed
     *
     * @param buttonName The button that was pressed elsewhere in the program
     */
    public static void switchScenes(String buttonName)
    {
        switch (buttonName)
        {
            case "View": stage.setScene(TodoViewTasks.getScene()); break;

            case "+": stage.setScene(TodoViewAddTask.getScene()); break;

            case "Finish": stage.setScene(TodoViewTasks.getScene()); break;
        }

        stage.show();
    }

    public TodosModel getTodo()
    {
        return todo;
    }
}
