import java.util.ArrayList;

public class Table {

    protected static ArrayList<Tile> table = new ArrayList<>();


    public static ArrayList<Tile> getTable() {
        return table;
    }

    public static boolean isTableEmpty() {
        if (table.isEmpty()) {
            return true;
        }
        return false;
    }

    public static int getFarDreta() {
        int value = getTable().get(table.size()-1).getDreta();
        return value;
    }

    public static int getFarEsquerra() {
        int value = getTable().get(0).getEsquerra();
        return value;
    }

    public static void placeTileOnTable(int count) {
        int tilePos = Screen.askGetTileToPlace() -1;
        if (isTableEmpty()) {
            table.add(Game.totalPlayers[count].getHand().get(tilePos));
        } else {
            char tablePos = Screen.askGetTablePlacement();
            if (tablePos == 'E') {
                if (Game.totalPlayers[count].getHand().get(tilePos).getDreta() != getFarEsquerra()) {
                    Game.totalPlayers[count].getHand().get(tilePos).flipTile();
                }
                table.addFirst(Game.totalPlayers[count].getHand().get(tilePos));
            } else if (tablePos == 'D') {
                if (Game.totalPlayers[count].getHand().get(tilePos).getEsquerra() != getFarDreta()) {
                    Game.totalPlayers[count].getHand().get(tilePos).flipTile();
                }
                table.addLast(Game.totalPlayers[count].getHand().get(tilePos));
            }
        }
        Game.totalPlayers[count].getHand().remove(tilePos);
    }
}
