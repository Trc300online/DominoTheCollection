import java.util.Random;

public class Background {

    public static void giveTiles() {
        for (int j = 0; j < Game.getNumberOfPlayers(); j++){

            if (!Game.totalPlayers[j].isEmptyHand()) {
                Game.totalPlayers[j].hand.clear();
            }
            if (!Table.isTableEmpty()) {
                Table.table.clear();
            }

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

        for (int i = 0; i < Game.totalPlayers[count].getHand().size(); i++) {
            Tile tile = Game.totalPlayers[count].getHand().get(i);
            if (tile.getDreta() == farDreta || tile.getEsquerra() == farDreta ||
                tile.getDreta() == farEsquerra || tile.getEsquerra() == farEsquerra) {
                return true;
            }
        }
        return false;
    }

    public static int totalPoints(int count, char mode) {
        int points = 0;
        if (mode != 'I') {
            if (Game.team1[0] == Game.totalPlayers[count] || Game.team1[1] == Game.totalPlayers[count]) {
                for (int i = 0; i < Game.team2.length; i++) {
                    for (int j = 0; j < Game.team2[i].getHand().size(); j++) {
                        points += Game.team2[i].getHand().get(j).getValue();
                    }
                }
            } else if (Game.team2[0] == Game.totalPlayers[count] || Game.team2[1] == Game.totalPlayers[count]) {
                for (int i = 0; i < Game.team1.length; i++) {
                    for (int j = 0; j < Game.team1[i].getHand().size(); j++) {
                        points += Game.team1[i].getHand().get(j).getValue();
                    }
                }
            }
        } else {
            for (int i = 0; i < Game.totalPlayers.length; i++) {
                for (int j = 0; j < Game.totalPlayers[i].getHand().size(); j++) {
                    if (i != count) {
                        points += Game.totalPlayers[i].getHand().get(j).getValue();
                    }
                }
            }
        }
        return points;
    }

    public static int getTopPlayer() {
        int points = 0;
        for (int i = 1; i < Game.totalPlayers.length - 1; i++) {
            if (Game.totalPlayers[i - 1].getPoints() > Game.totalPlayers[i].getPoints()) {
                points = Game.totalPlayers[i - 1].getPoints();
            }
        }
        return points;
    }
}
