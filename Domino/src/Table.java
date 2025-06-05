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

    public void placeTileOnTable(Tile ficha) {
        if (isTableEmpty()) {
            table.add(ficha);
        } else {
            char tablePos = Screen.askGetTablePlacement();
            if (tablePos == 'E') {
                if (ficha.getDreta() != getFarEsquerra()) {
                    ficha.flipTile();
                }
                table.add(0, ficha); // .add(0, e) simula un .addFirst(), que no existeix a un List
            } else if (tablePos == 'D') {
                if (ficha.getEsquerra() != getFarDreta()) {
                    ficha.flipTile();
                }
                table.add(ficha);
                // se empra .add() perque aquest ja afageix el nou element al final de la llista/array
            }
        }
    }

    public boolean canPlaceTileOnTable(TileList hand) {

        if (isTableEmpty()) {
            return true;
        }

        int farDreta = getFarDreta();
        int farEsquerra = getFarEsquerra();

        for (int i = 0; i < hand.size(); i++) {
            Tile tile = hand.get(i);
            if (tile.getDreta() == farDreta || tile.getEsquerra() == farDreta ||
                    tile.getDreta() == farEsquerra || tile.getEsquerra() == farEsquerra) {
                return true;
            }
        }
        return false;
    }
}
