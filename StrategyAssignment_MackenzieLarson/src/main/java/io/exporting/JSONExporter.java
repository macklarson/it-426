/* Mackenzie Larson
    11/17/2017
    JSONExporter.java
 */

package io.exporting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.IExporter;
import model.CarPart;
import model.PartsDatabase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/**
 * Exports Java object with JSON
 *
 * @author Mackenzie Larson
 * @version 1.0
 */
public class JSONExporter implements IExporter
{
    Iterator<CarPart> iterator;

    /**
     * Exports Java object with JSON
     * @param database stores car parts
     * @return true if file exported successfully
     */
    @Override
    public boolean exportParts(PartsDatabase database)
    {
        try (FileWriter writer = new FileWriter("files/parts.json")) {

            Collection<CarPart> parts = database.getParts();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(parts);

            gson.toJson(parts, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
