import java.util.ArrayList;

public class Bag {
    public static ArrayList<Tile> bagOfTiles = new ArrayList<>();

    public static void createBag() {
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                bagOfTiles.add(new Tile(i, j));
            }
        }
    }

}
