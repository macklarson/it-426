/**
 * Mackenzie Larson
 * 11/17/2017
 * XMLExporter.java
 */
package io.exporting;

import io.IExporter;
import model.CarPart;
import model.PartsDatabase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;
import java.util.Collection;

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
     * @return  Returns false if there are no records to write
     */
    @Override
    public boolean exportParts(PartsDatabase database)
    {
        try {
            JAXBContext context = JAXBContext.newInstance(PartsDatabase.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(database, new File("files/parts.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return false;
    }
}
