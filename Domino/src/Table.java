import java.util.ArrayList;

public class Table {

    protected static ArrayList<Tile> table = new ArrayList<>();


    public static ArrayList<Tile> getTable() {
        return table;
    }

    public static boolean isTableEmpty() {
        if (table.isEmpty()) {
            return true;
        }
        return false;
    }

    public static int getFarDreta() {
        int value = getTable().get(table.size()-1).getDreta();
        return value;
    }

    public static int getFarEsquerra() {
        int value = getTable().get(0).getEsquerra();
        return value;
    }
}
