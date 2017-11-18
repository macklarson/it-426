/* Mackenzie Larson
    11/17/2017
    JavaExporter.java
 */

package io.exporting;

import io.IExporter;
import model.CarPart;
import model.PartsDatabase;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;

/**
 * Exports a Java file
 *
 * @author Mackenzie Larson
 * @version 1.0
 */
public class JavaExporter implements IExporter
{
    Iterator<CarPart> iterator;

    /**
     * Writes Java object to a file
     *
     * @param database stores car parts
     * @return true if exported successfully
     */
    @Override
    public boolean exportParts(PartsDatabase database)
    {
        try {
            FileOutputStream fileOut = new FileOutputStream(new File("files/parts.dat"));
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            Collection<CarPart> parts = database.getParts();

            iterator = parts.iterator();

            while (iterator.hasNext())
            {
                CarPart carPart = iterator.next();
                objOut.writeObject(carPart);
            }

            objOut.close();
            fileOut.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }

        return true;
    }
}