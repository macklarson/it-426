package io.importing;

import io.IImporter;
import model.CarPart;

import java.io.*;
import java.util.ArrayList;

public class JavaImporter implements IImporter
{
    private ArrayList<CarPart> carParts = new ArrayList<>();

    @Override
    public boolean importParts()
    {
        try (FileInputStream fileIn = new FileInputStream(new File("files/parts.dat"));
             ObjectInputStream objIn = new ObjectInputStream(fileIn)){

            carParts.clear();

            while (true)
            {
                CarPart part = (CarPart) objIn.readObject();

                carParts.add(part);
            }

        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (EOFException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return true;
    }
}
