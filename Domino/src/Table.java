public class Table {

    protected TileList table = new TileList();


    public TileList getTable() {
        return table;
    }

    public boolean isTableEmpty() {
        if (table.isEmpty()) {
            return true;
        }
        return false;
    }

    public int getFarDreta() {
        int value = getTable().get(table.size()-1).getDreta();
        return value;
    }

    public int getFarEsquerra() {
        int value = getTable().get(0).getEsquerra();
        return value;
    }

    public void placeTileOnTable(int count) {
        int tilePos = Screen.askGetTileToPlace() -1;
        if (isTableEmpty()) {
            table.add(Game.totalPlayers[count].getHand().get(tilePos));
        } else {
            char tablePos = Screen.askGetTablePlacement();
            if (tablePos == 'E') {
                if (Game.totalPlayers[count].getHand().get(tilePos).getDreta() != getFarEsquerra()) {
                    Game.totalPlayers[count].getHand().get(tilePos).flipTile();
                }
                table.add(0, Game.totalPlayers[count].getHand().get(tilePos)); // .add(0, e) simula un .addFirst(), que no existeix a un List
            } else if (tablePos == 'D') {
                if (Game.totalPlayers[count].getHand().get(tilePos).getEsquerra() != getFarDreta()) {
                    Game.totalPlayers[count].getHand().get(tilePos).flipTile();
                }
                table.add(Game.totalPlayers[count].getHand().get(tilePos));
                // se empra .add() perque aquest ja afageix el nou element al final de la llista/array
            }
        }
        Game.totalPlayers[count].getHand().remove(tilePos);
    }

    public boolean canPlaceTileOnTable(int count) {

        if (isTableEmpty()) {
            return true;
        }

        int farDreta = getFarDreta();
        int farEsquerra = getFarEsquerra();

        for (int i = 0; i < Game.totalPlayers[count].getHand().size(); i++) {
            Tile tile = Game.totalPlayers[count].getHand().get(i);
            if (tile.getDreta() == farDreta || tile.getEsquerra() == farDreta ||
                    tile.getDreta() == farEsquerra || tile.getEsquerra() == farEsquerra) {
                return true;
            }
        }
        return false;
    }
}
