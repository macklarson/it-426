public class GameMaster
{
    private static GameMaster singleton;

    public static GameMaster instance()
    {
        if (singleton == null)
        {
            singleton = new GameMaster();
        }

        return singleton;
    }


}
