import java.util.ArrayList;

public class GameBoard
{
    ArrayList cells = new ArrayList();

    public void addCell(Cell cell)
    {
        cells.add(cell);
    }

    public int getCellNumber()
    {
        return cells.size();
    }


}
