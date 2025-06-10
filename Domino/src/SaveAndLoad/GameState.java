package SaveAndLoad;
import java.io.Serializable;
import java.util.List;
import MainStrc.Player;
import MainStrc.Tile;

public class GameState implements Serializable {

    private static final long serialVersionUID = 1L;

    public Player[] players;
    public Player[] team1;
    public Player[] team2;
    public char mode;
    public char gameType;
    public int currentPlayerIndex;
    public List<Tile> table;
    public List<Tile> bag;

    public GameState(Player[] players, Player[] team1, Player[] team2,
                     char mode, char gameType, int currentPlayerIndex,
                     List<Tile> table, List<Tile> bag) {
        this.players = players;
        this.team1 = team1;
        this.team2 = team2;
        this.mode = mode;
        this.gameType = gameType;
        this.currentPlayerIndex = currentPlayerIndex;
        this.table = table;
        this.bag = bag;
    }

}
