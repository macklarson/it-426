/**
 * Mackenzie Larson
 * 11/28/2017
 * TodoModel.java
 */

package Model;

import java.util.ArrayList;
import java.util.Observable;

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
}
