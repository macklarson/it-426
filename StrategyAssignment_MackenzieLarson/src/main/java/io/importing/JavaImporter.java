/**
 * Mackenzie Larson
 * 11/17/2017
 * JavaImporter.java
 */

package io.importing;

import io.IImporter;
import model.CarPart;
import model.PartsDatabase;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Imports a Java object to a file
 *
 * @author Mackenzie Larson
 * @version 1.0
 */
public class JavaImporter implements IImporter
{
    Iterator<CarPart> iterator;

    /**
     * Imports a java object to a file
     * @param database stores a car part object
     * @return true if imported successfully
     */
    @Override
    public boolean importParts(PartsDatabase database)
    {
        try (FileInputStream fileIn = new FileInputStream(new File("files/parts.dat"));
             ObjectInputStream objIn = new ObjectInputStream(fileIn)) {

            database.clear();

            while (true)
            {
                CarPart carPart = (CarPart) objIn.readObject();
                database.addPart(carPart);
            }

        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (EOFException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }
}
