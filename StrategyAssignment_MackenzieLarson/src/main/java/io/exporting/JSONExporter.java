/* Mackenzie Larson
    11/17/2017
    JSONExporter.java
 */

package io.exporting;

import io.IExporter;
import model.PartsDatabase;

/**
 * Exports Java object with JSON
 *
 * @author Mackenzie Larson
 * @version 1.0
 */
public class JSONExporter implements IExporter
{
    /**
     * Exports Java object with JSON
     * @param database stores car parts
     * @return true if file exported successfully
     */
    @Override
    public boolean exportParts(PartsDatabase database)
    {
        return false;
    }
}
