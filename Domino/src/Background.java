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

}
