package Controller;

import Model.Todo;
import Model.TodosModel;
import View.TodoViewAddTask;
import View.TodoViewTasks;
import View.TodoViewWelcomePage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.UUID;

public class TodoController
{
    //private static Stage stage = TodoViewWelcomePage.getStage();
    private static TodosModel todo = new TodosModel();

    public TodoController()
    {
        todo.readTasksFromFile();
        TodoViewTasks viewTasks = new TodoViewTasks();
        todo.addObserver(viewTasks);
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
            case "View": TodoViewWelcomePage.getStage().setScene(TodoViewTasks.getScene()); break;

            case "+": TodoViewWelcomePage.getStage().setScene(TodoViewAddTask.getScene()); break;

            case "Finish": TodoViewWelcomePage.getStage().setScene(TodoViewTasks.getScene()); break;
        }
    }

    public static ArrayList<Todo> getTodo()
    {
        return todo.getTaskList();
    }

    public static void addTask(String task)
    {
        Todo todoObject = new Todo(task);
        try
        {
            todo.addNewTask(todoObject);
        }
        catch (TodosModel.ExistingRecordException e)
        {
            e.printStackTrace();
        }
    }

    public static void deleteTask(UUID id)
    {
        try
        {
            todo.deleteTask(id);
        }
        catch (TodosModel.MissingRecordsException exception)
        {
            exception.printStackTrace();
        }
    }
}
