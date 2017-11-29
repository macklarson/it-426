/**
 * Mackenzie Larson
 * 11/29/2017
 * Launcher.java
 */

package Launch;

import View.TodoViewWelcomePage;
import javafx.application.Application;

/**
 * This class is the entry point for the program. The main method
 * handles user input accordingly
 *
 * @author Mackenzie Larson
 * @version 1.0
 */
public class Launcher
{
    /**
     * This is the entry point to the application.
     *
     * @param args 
     */
    public static void main(String[] args) { Application.launch(TodoViewWelcomePage.class, args); }
}
