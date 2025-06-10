package MainStrc;

import java.util.ArrayList;
import java.util.List;

public class TileList {

    List<Tile> tiles = new ArrayList<>();

    public void add(Tile ficha) {
        tiles.add(ficha);
    }
    public void add(int pos, Tile ficha) {
        tiles.add(pos, ficha);
    }

    public void addAll(List list) {
        for (int i = 0; i < list.size(); i++) {
            this.add((Tile) list.get(i));
        }
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

    public void remove(Tile tile) {
        tiles.remove(tile);
    }

    public boolean isEmpty() {
        if (tiles.isEmpty()){
            return true;
        }
        return false;
    }
}
