/**
 * Mackenzie Larson
 * 11/17/2017
 * IImporter.java
 */

package io;

import model.PartsDatabase;

/**
 * Imports all CarPart objects from a text file to the application
 *
 * @author Mackenzie Larson
 * @version 1.0
 */
public interface IImporter
{
    /**
     * Imports all CarPart objects from a text file to the application
     *
     * @param database stores a car part object
     * @return  false if the file does not exist or is empty, otherwise true.
     */
    public boolean importParts(PartsDatabase database);
}
