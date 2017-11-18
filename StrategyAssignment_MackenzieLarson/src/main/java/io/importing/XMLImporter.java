/**
 * Mackenzie Larson
 * 11/17/2017
 * XMLImporter.java
 */

package io.importing;

import io.IImporter;
import model.CarPart;
import model.PartsDatabase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Imports a java object with XML
 *
 * @author Mackenzie Larson
 * @version 1.0
 */
public class XMLImporter implements IImporter
{
    /**
     * Imports a java object with XML
     *
     * @param database stores a car part object
     * @return  Returns false if there are no records to write
     */
    @Override
    public boolean importParts(PartsDatabase database)
    {
        try {
            JAXBContext context = JAXBContext.newInstance(PartsDatabase.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            PartsDatabase data = (PartsDatabase) unmarshaller.unmarshal(new File("files/parts.xml"));

            database.clear();

            for (CarPart part : data.getParts())
            {
                database.addPart(part);
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return false;
    }
}