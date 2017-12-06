/**
 * Mackenzie Larson
 * 12/5/2017
 * Launcher.java
 */

package launchers;

import javafx.application.Application;
import ui.DoodlePad;

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
    public static void main(String[] args) { Application.launch(DoodlePad.class, args); }
}