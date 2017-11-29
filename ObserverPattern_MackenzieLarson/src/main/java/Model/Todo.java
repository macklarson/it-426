/**
 * Mackenzie Larson
 * 11/28/2017
 * Todo.java
 */
package Model;

import java.util.UUID;

/**
 * @author Mackenzie Larson
 * @version 1.0
 *
 * Simple class that holds data for a single task that will be displayed as
 * a list item.
 */
public class Todo
{
    private UUID id;
    private String message;

    /**
     * Constructor for to-do items, generates random UUID
     * @param message what the task is
     */
    public Todo(String message)
    {
        this.message = message;
        id = UUID.randomUUID();
    }

    /**
     * Getter for a task
     *
     * @return A String representation of the task
     */
    public String getTask()
    {
        return message;
    }

    /**
     * Setter for a task
     *
     * @param message The task being set
     */
    public void setTask(String message)
    {
        this.message = message;
    }
}
