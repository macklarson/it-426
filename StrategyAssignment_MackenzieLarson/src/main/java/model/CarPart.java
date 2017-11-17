/**
 * Mackenzie Larson
 * 11/17/2017
 * CarPart.java
 */

package model;

import io.importing.JavaImporter;

import java.io.*;

/**
 * Stores a car part
 *
 * @author Mackenzie Larson
 * @verion 1.0
 */
public class CarPart implements Serializable
{
    private String id;
    private String manufacturer;
    private double listPrice;
    private String[] categories;
    private JavaImporter importer = new JavaImporter();

    public CarPart()
    {
        //do nothing - leave this method here...
    }

    /**
     * Hold a car part object
     * @param id id of part
     * @param manufacturer who makes the part
     * @param listPrice price of part
     * @param categories category of part
     */
    public CarPart(String id, String manufacturer, double listPrice, String[] categories)
    {
        this.id = id;
        this.manufacturer = manufacturer;
        this.listPrice = listPrice;
        this.categories = categories;
    }

    /**
     * Retrieves car part ID
     * @return car part ID
     */
    public String getId()
    {
        return id;
    }

    /**
     * Retrieves car part manufacturer
     * @return car part manufacturer
     */
    public String getManufacturer()
    {
        return manufacturer;
    }

    /**
     * Retrieves price of part
     * @return price of part
     */
    public double getListPrice()
    {
        return listPrice;
    }

    /**
     * Retrieves list of categories
     * @return list of categories
     */
    public String[] getCategories()
    {
        return categories;
    }

    /**
     * sets the part ID
     * @param id part ID
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * sets the manufacturer name
     * @param manufacturer
     */
    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    /**
     * sets the price of the part
     * @param listPrice price of part
     */
    public void setListPrice(double listPrice)
    {
        this.listPrice = listPrice;
    }

    /**
     * sets a list of categories for part
     * @param categories categories which the part belongs to
     */
    public void setCategories(String[] categories)
    {
        this.categories = categories;
    }


    public void writeObjectToFile()
    {

//        try {
//            FileOutputStream fileOut = new FileOutputStream(new File("files/parts.dat"));
//            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
//
//            // Write Hike objects to file
//            for (int i = 0; i < carParts.size(); i++)
//            {
//                objOut.writeObject(carParts.get(i));
//            }
//
//            objOut.close();
//            fileOut.close();
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        } catch (IOException e) {
//            System.out.println("Error initializing stream");
//        }
    }

}
