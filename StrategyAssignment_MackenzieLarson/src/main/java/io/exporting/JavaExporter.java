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
//    PartsDatabase data;
   CarPart[] parts;
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
            parts = database.getParts().toArray(new CarPart[0]);

            Collection<CarPart> parts = database.getParts();

            iterator = parts.iterator();

            // while loop
            while (iterator.hasNext())
            {
                //System.out.println("value= " + iterator.next());
                objOut.writeObject(parts);
            }

            //objOut.writeObject(parts);


            //            for (int i = 0; i < parts.length; i++)
            //            {
            //                //System.out.println(parts[i]);
            //                objOut.writeObject(parts[i]);
            //            }

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
