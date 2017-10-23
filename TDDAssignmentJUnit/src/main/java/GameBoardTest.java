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

    public void testSingleton()
    {
        GameMaster instance1 = GameMaster.instance();
        assertNotNull(instance1);
        GameMaster instance2 = GameMaster.instance();
        assertNotNull(instance2);
        assertSame(instance1, instance2);
    }


}
