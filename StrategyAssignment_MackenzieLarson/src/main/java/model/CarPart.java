package model;

import io.importing.JavaImporter;

import java.io.*;
import java.util.ArrayList;

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

    public CarPart(String id, String manufacturer, double listPrice, String[] categories)
    {
        this.id = id;
        this.manufacturer = manufacturer;
        this.listPrice = listPrice;
        this.categories = categories;
    }

    public String getId()
    {
        return id;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public double getListPrice()
    {
        return listPrice;
    }

    public String[] getCategories()
    {
        return categories;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public void setListPrice(double listPrice)
    {
        this.listPrice = listPrice;
    }

    public void setCategories(String[] categories)
    {
        this.categories = categories;
    }

    public void readObjectFromFile()
    {

    }

    public void writeObjectToFile()
    {
        importer.importParts();

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
