package SaveAndLoad;

public interface GameDAO {

    void saveGame(GameState gameState, String fileName);
    GameState loadGame(String fileName);

}
