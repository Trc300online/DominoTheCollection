import java.util.Random;

public class Bag {
    public TileList bagOfTiles = new TileList();
    private Game game;
    private Table mesa;

    public Bag(Game game, Table mesa) {
        this.game = game;
        this.mesa = mesa;
    }

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
        bagOfTiles.remove(temp);
        return temp;
    }

    public void giveTiles() {
        for (int j = 0; j < game.getNumberOfPlayers(); j++){

            if (!game.players[j].isEmptyHand()) {
                game.players[j].hand.clear();
            }
            if (!mesa.isTableEmpty()) {
                mesa.table.clear();
            }

            for (int i = 0; i < 7; i++) {

                int randTile = new Random().nextInt(bagOfTiles.size());
                Tile temp = bagOfTiles.get(randTile);
                bagOfTiles.remove(temp);
                game.players[j].setHand(temp);
            }
        }
    }

    public TileList getAll() {
        return bagOfTiles;
    }
}
