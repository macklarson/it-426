/**
 * Mackenzie Larson
 * 11/28/2017
 * TodoModel.java
 */

package Model;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.UUID;

import Controller.TodoController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Mackenzie Larson
 * @version 1.0
 *
 * Responsible for saving all tasks to disk
 */
public class TodosModel extends Observable
{
    private ArrayList<Todo> taskList = new ArrayList<>();

    public ArrayList<Todo> getTaskList()
    {
        return taskList;
    }

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

    public class MissingRecordsException extends Exception
    {
        @Override
        public String getMessage()
        {
            return super.getMessage();
        }
    }

    public class ExistingRecordException extends Exception
    {
        @Override
        public String getMessage()
        {
            return super.getMessage();
        }
    }
}
