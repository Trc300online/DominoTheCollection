import java.util.Random;

public class Bag {
    public static TileList bagOfTiles = new TileList();

    public static void createBag() {
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                bagOfTiles.add(new Tile(i, j));
            }
        }
    }

    public static boolean canSteal() {
        return !bagOfTiles.isEmpty();
    }

    public static void steal(int count) {
        int randTile = new Random().nextInt(bagOfTiles.size());
        Tile temp = bagOfTiles.get(randTile);
        bagOfTiles.remove(randTile);
        Game.totalPlayers[count].setHand(temp);
    }

}
