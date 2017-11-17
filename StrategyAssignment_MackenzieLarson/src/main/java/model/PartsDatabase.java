/**
 * Mackenzie Larson
 * 11/17/2017
 * PartsDatabase.java
 */

package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * Holds a database of car part objects
 *
 * @author Mackenzie Larson
 * @version 1.0
 */
public class PartsDatabase
{
    private Collection<CarPart> parts;

    /**
     * Initializes the list of car parts
     */
    public PartsDatabase()
    {
        parts = new ArrayList<CarPart>();
    }

    /**
     * adds new part to the database
     * @param part car part
     */
    public void addPart(CarPart part)
    {
        parts.add(part);
    }

    /**
     * Returns the entire list of parts and it's information
     * @return list of car parts
     */
    public Collection<CarPart> getParts()
    {
        return Collections.unmodifiableCollection(parts);
    }

    /**
     * Clears list of  parts
     */
    public void clear()
    {
        parts.clear();
    }
}
