/**
 * Mackenzie Larson
 * 11/17/2017
 * IExporter.java
 */

package io;

import model.PartsDatabase;

/**
 * Exports all CarPart objects in the application to a text file.
 *
 * @author Mackenzie Larson
 * @version 1.0
 */
public interface IExporter
{
    /**
     * Exports all CarPart objects in the application to a text file.
     * @param database stores a car part object
     * @return false if no records to right, otherwise true
     */
    public boolean exportParts(PartsDatabase database);
}
