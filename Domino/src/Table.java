public class Table {

    protected static TileList table = new TileList();


    public static TileList getTable() {
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
                } else if (Game.totalPlayers[count].getHand().get(tilePos).getDreta() == getFarDreta()) {
                    table.add(0, Game.totalPlayers[count].getHand().get(tilePos)); // .add(0, e) simula un .addFirst(), que no existeix a un List
                } else {
                    Screen.errorMng(5);
                }
            } else if (tablePos == 'D') {
                if (Game.totalPlayers[count].getHand().get(tilePos).getEsquerra() != getFarDreta()) {
                    Game.totalPlayers[count].getHand().get(tilePos).flipTile();
                } else if (Game.totalPlayers[count].getHand().get(tilePos).getEsquerra() == getFarEsquerra()) {
                    table.add(Game.totalPlayers[count].getHand().get(tilePos));
                } else {
                    Screen.errorMng(5);
                }
                // se empra .add() perque aquest ja afageix el nou element al final de la llista/array
            } else {
                Screen.errorMng(4);
            }
        }
        Game.totalPlayers[count].getHand().remove(tilePos);
    }
}
