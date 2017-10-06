/*
 * Mackenzie Larson
 * 10/6/2017
 * Calculator App Part 1
 * Launcher.java
 */

package launch;

import javafx.application.Application;
import ui.CalculatorUI;

/**
 * @author Mackenzie Larson
 * @version 1.0
 *
 * Runs the classes for the calculator applicaton
 */
public class Launcher
{
    /**
     * Launches the CalculatorUI class
     * @param args
     */
    public static void main(String[] args)
    {
        Application.launch(CalculatorUI.class, args);
    }
}
