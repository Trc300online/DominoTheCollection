package MainStrc;

import java.io.Serializable;

public class Player implements Serializable {
    protected TileList hand = new TileList();
    protected int Points = 0;

    public void setHand(Tile ficha) {
        hand.add(ficha);
    }

    public TileList getHand() {
        return hand;
    }

    public boolean isEmptyHand() {
        return hand.isEmpty();
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        Points = points;
    }
}
