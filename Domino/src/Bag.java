import java.util.Random;

public class Bag {
    public TileList bagOfTiles = new TileList();

    public void createBag() {
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                bagOfTiles.add(new Tile(i, j));
            }
        }
    }

    public boolean canSteal() {
        return !bagOfTiles.isEmpty();
    }

    public Tile steal() {
        int randTile = new Random().nextInt(bagOfTiles.size());
        Tile temp = bagOfTiles.get(randTile);
        bagOfTiles.remove(randTile);
        return temp;
    }

    public void giveTiles() {
        for (int j = 0; j < Game.getNumberOfPlayers(); j++){

            if (!Game.players[j].isEmptyHand()) {
                Game.players[j].hand.clear();
            }
            if (!Table.isTableEmpty()) {
                Table.table.clear();
            }

            for (int i = 0; i < 7; i++) {

                int randTile = new Random().nextInt(bagOfTiles.size());
                Tile temp = bagOfTiles.get(randTile);
                bagOfTiles.remove(randTile);
                Game.players[j].setHand(temp);
            }
        }
    }
}
