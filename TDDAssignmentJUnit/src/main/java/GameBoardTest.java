import javafx.scene.control.Cell;
import junit.framework.TestCase;

public class GameBoardTest extends TestCase
{
    public GameBoardTest(String name)
    {
        super(name);
    }

    public void testAddCell()
    {
        GameBoard gameboard = new GameBoard();
        assertEquals(0, gameboard.getCellNumber());
        Cell cell = new Cell();
        gameboard.addCell(cell);
        assertEquals(1, gameboard.getCellNumber());
    }


}
