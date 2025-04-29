import java.util.ArrayList;

public class Player {
    protected ArrayList<Tile> hand = new ArrayList<>();

    public void setHand(Tile ficha) {
        hand.add(ficha);
    }

    public ArrayList<Tile> getHand() {
        return hand;
    }
}
