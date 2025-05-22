import java.lang.invoke.VolatileCallSite;
import java.util.ArrayList;
import java.util.List;

public class TileList {

    List<Tile> tiles = new ArrayList<>();

    public void add(Tile ficha) {
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
}
