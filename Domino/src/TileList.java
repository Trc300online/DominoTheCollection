import java.util.ArrayList;
import java.util.List;

public class TileList {

    List<Tile> tiles = new ArrayList<>();

    public void add(Tile ficha) {
        tiles.add(ficha);
    }
    public void add(int pos, Tile ficha) {
        tiles.add(ficha);
    }

    public int size() {
        return tiles.size();
    }

    public Tile get(int j) {
        return tiles.get(j);
    }

    public void clear() {
        tiles.clear();
    }

    public void remove(int tilePos) {
        tiles.remove(tilePos);
    }
    public void remove(Tile ficha) {
        tiles.remove(ficha);
    }

    public boolean isEmpty() {
        if (tiles.isEmpty()){
            return true;
        }
        return false;
    }
}
