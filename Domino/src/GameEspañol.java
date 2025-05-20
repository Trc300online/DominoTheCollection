public class GameEspañol extends Game{

    public GameEspañol(char mode) {
        super();
    }

    @Override
    public void playGame() {
        setUpGame();

        char gameMode = gameType;
        // deal tiles from bag to hand
        int PlayerPoints = 0;

        while (!Background.winCond(PlayerPoints, gameMode)){

            Bag.createBag();
            Background.giveTiles();
            int count = Background.selectStarter();
            int skippedPlayers = 0;
            boolean roundContinue = true;

            while (roundContinue){
                Screen.printTable();
                Screen.spacer();
                Screen.printPlayerHand(count);
                if (!Background.canPlaceTileOnTable(count) && !totalPlayers[count].isEmptyHand()){
                    Screen.errorMng(2);
                    Screen.spacer();
                    if (Bag.canSteal()) {
                        Bag.steal(count);
                    }
                    skippedPlayers++;
                } else {
                    Table.placeTileOnTable(count);
                }

                if (totalPlayers[count].isEmptyHand() || skippedPlayers == totalPlayers.length){
                    totalPlayers[count].setPoints(Background.totalPoints(count));
                    Screen.showScore(count);
                    roundContinue = false;
                }
                if (count + 1 > totalPlayers.length -1) {
                    count = 0;
                } else {
                    count++;
                }
            }

            PlayerPoints = Background.getTopPlayer();
        }
    }
}
