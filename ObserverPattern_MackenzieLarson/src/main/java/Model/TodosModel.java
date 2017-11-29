/**
 * Mackenzie Larson
 * 11/28/2017
 * TodoModel.java
 */

package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.UUID;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Mackenzie Larson
 * @version 1.0
 *
 * Responsible for saving all tasks to file using JSON
 */
public class TodosModel extends Observable
{
    private ArrayList<Todo> taskList = new ArrayList<>();

    /**
     * Gets task list
     * @return the array of tasks
     */
    public ArrayList<Todo> getTaskList()
    {
        return taskList;
    }

    /**
     * Adds a new task
     * @param task
     * @throws ExistingRecordException if there are duplicate records
     */
    public void addNewTask(Todo task) throws ExistingRecordException
    {
        for (int i = 0; i < taskList.size(); i++)
        {
            if (taskList.get(i).getId().equals(task.getId()))
            {
                throw new ExistingRecordException();
            }
        }

        taskList.add(task);
        writeTasksToFile();
        setChanged();
        notifyObservers(taskList);
    }

    /**
     * deletes the task after being checked
     * @param id id of task
     * @return true if the id matches
     * @throws MissingRecordsException
     */
    public boolean deleteTask(UUID id) throws MissingRecordsException
    {
        for (int i = 0; i < taskList.size(); i++)
        {
            if (taskList.get(i).getId().equals(id))
            {
                taskList.remove(i);
                writeTasksToFile();

                setChanged();
                notifyObservers(taskList);

                return true;
            }
        }

        throw new MissingRecordsException();
    }

    /**
     * Writes tasks to file with JSON
     * @return true when task added to file
     */
    private boolean writeTasksToFile()
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Todo[] json = taskList.toArray(new Todo[0]);

        try (FileWriter writer = new FileWriter("src/main/resources/files/todo.json")) {
            gson.toJson(json, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * Reads tasks from file with JSON
     */
    public void readTasksFromFile()
    {
        taskList.clear();
        Gson gson = new Gson();

        try (Reader reader = new FileReader("src/main/resources/files/todo.json")) {

            Todo[] tasks = gson.fromJson(reader, Todo[].class);

            if (tasks.length >= 0)
            {
                for (Todo task : tasks)
                {
                    taskList.add(task);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Exception for if a record is not found
     */
    public class MissingRecordsException extends Exception
    {
        @Override
        public String getMessage()
        {
            return super.getMessage();
        }
    }

    /**
     * Exception for duplicate records
     */
    public class ExistingRecordException extends Exception
    {
        @Override
        public String getMessage()
        {
            return super.getMessage();
        }
    }
}