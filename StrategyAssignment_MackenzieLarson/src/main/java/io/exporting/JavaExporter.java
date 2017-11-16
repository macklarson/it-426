package io.exporting;

import io.IExporter;
import model.CarPart;

public class JavaExporter implements IExporter
{
    CarPart carPart = new CarPart();

    @Override
    public boolean exportParts()
    {
        return false;
    }
}
