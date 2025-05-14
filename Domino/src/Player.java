import java.util.ArrayList;

public class Player {
    protected ArrayList<Tile> hand = new ArrayList<>();
    protected int Points = 0;

    public void setHand(Tile ficha) {
        hand.add(ficha);
    }

    public ArrayList<Tile> getHand() {
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
