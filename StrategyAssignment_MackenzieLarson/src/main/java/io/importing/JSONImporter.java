/**
 * Mackenzie Larson
 * 11/17/2017
 * JSONImporter.java
 */

package io.importing;

import com.google.gson.Gson;
import io.IImporter;
import model.CarPart;
import model.PartsDatabase;
import netscape.security.ParameterizedTarget;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;

/**
 * Writes a java object with JSON
 *
 * @author Mackenzie Larson
 * @version 1.0
 */
public class JSONImporter implements IImporter
{
    /**
     * Writes a java object with JSON
     * @param database stores a car part object
     * @return true if imported successfully
     */
    @Override
    public boolean importParts(PartsDatabase database)
    {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("files/parts.json")) {

            database.clear();

            CarPart[] carPart = gson.fromJson(reader, CarPart[].class);

            for (int i = 0; i < carPart.length; i++)
            {
                database.addPart(carPart[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
