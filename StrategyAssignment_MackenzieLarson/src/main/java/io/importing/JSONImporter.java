/**
 * Mackenzie Larson
 * 11/17/2017
 * JSONImporter.java
 */

package io.importing;

import io.IImporter;
import model.PartsDatabase;
import netscape.security.ParameterizedTarget;

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
        return false;
    }
}
