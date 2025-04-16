import java.util.ArrayList;

public class Player {
    protected static ArrayList<Tile> hand = new ArrayList<>();

    public static void setHand(Tile ficha) {
        hand.add(ficha);
    }
}
