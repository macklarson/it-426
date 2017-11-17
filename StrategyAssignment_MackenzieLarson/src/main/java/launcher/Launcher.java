/**
 * Mackenzie Larson
 * 11/17/2017
 * Launcher.java
 */

package launcher;

import gui.PartsDatabaseUI;
import javafx.application.Application;

/**
 * Entry point to the application
 *
 * @author Mackenzie Larson
 * @version 1.0
 */
public class Launcher
{
    /**
     * Entry point to the application
     * @param args
     */
    public static void main(String[] args)
    {
        Application.launch(PartsDatabaseUI.class, args);
    }
}
