import java.util.Random;

public class Background {

    public void selectMode(){

    }

    public static void giveTiles() {
        for (int j = 0; j < Game.getNumberOfPlayers(); j++){

            for (int i = 0; i < 7; i++) {

                int randTile = new Random().nextInt(Bag.bagOfTiles.size());
                Tile temp = Bag.bagOfTiles.get(randTile);
                Bag.bagOfTiles.remove(randTile);
                Game.totalPlayers[j].setHand(temp);
            }
        }
    }

    public static int selectStarter() {
        for (int x = 6; x >= 0; x--) {
            for (int i = 0; i < Game.getNumberOfPlayers(); i++) {
                for (int j = 0; j < Game.totalPlayers[i].getHand().size(); j++) {
                    if (Game.totalPlayers[i].getHand().get(j).getEsquerra() == x && Game.totalPlayers[i].getHand().get(j).getDreta() == x) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    public static boolean canPlaceTileOnTable(int count) {

        if (Table.isTableEmpty()) {
            return true;
        }

        int farDreta = Table.getFarDreta();
        int farEsquerra = Table.getFarEsquerra();

        for (Tile tile : Game.totalPlayers[count].getHand()) {
            if (tile.getDreta() == farDreta || tile.getEsquerra() == farDreta ||
                tile.getDreta() == farEsquerra || tile.getEsquerra() == farEsquerra) {
                return true;
            }
        }
        return false;
    }

    public static boolean winCond(int points, char gameType) {
        switch (gameType) {
            case 'E':
            case 'M':
            case 'L':
                if (points >= 200){
                    return true;
                }
            case 'C':
            case 'V':
                if (points >= 100){
                    return true;
                }
            case 'X':
                if (points >= 121){
                    return true;
                }
            case 'P':
                if (points >= 20){
                    return true;
                }
            default:
                return false;
        }
    }
}
