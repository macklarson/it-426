/**
 * Mackenzie Larson
 * 11/29/2017
 * TodoController.java
 */
package Controller;

import Model.Todo;
import Model.TodosModel;
import View.TodoViewAddTask;
import View.TodoViewTasks;
import View.TodoViewWelcomePage;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Mackenzie Larson
 * @version 1.0
 *
 * Controls interactions between the user interface and model
 */
public class TodoController
{
    //private static Stage stage = TodoViewWelcomePage.getStage();
    private static TodosModel todo = new TodosModel();

    /**
     * Reads from the most current file
     * initializes the view
     */
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

    /**
     * Gives a list of tasks
     * @return list of tasks
     */
    public static ArrayList<Todo> getTodo()
    {
        return todo.getTaskList();
    }

    /**
     * Adds a task object
     *
     * @param task what the task is
     */
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

    /**
     * deletes a task based on ID
     * @param id id of the task
     */
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