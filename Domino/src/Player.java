import java.util.ArrayList;

public class Player {
    protected TileList hand = new TileList();
    protected int Points = 0;

    public void setHand(Tile ficha) {
        hand.add(ficha);
    }

    public TileList getHand() {
        return hand;
    }

    public boolean isEmptyHand() {
        if (hand.isEmpty()){
            return true;
        }
        return false;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        Points = points;
    }
}
