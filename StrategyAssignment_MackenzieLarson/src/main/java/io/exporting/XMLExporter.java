/**
 * Mackenzie Larson
 * 11/17/2017
 * XMLExporter.java
 */
package io.exporting;

import io.IExporter;
import model.PartsDatabase;

/**
 * Writes java objects to a file with XML
 *
 * @author Mackenzie Larson
 * @version 1.0
 */
public class XMLExporter implements IExporter
{
    /**
     * Writes Java objects to a file with XML
     * @param database stores car part objects
     * @return true if exported succesfully
     */
    @Override
    public boolean exportParts(PartsDatabase database)
    {
        return false;
    }
}
