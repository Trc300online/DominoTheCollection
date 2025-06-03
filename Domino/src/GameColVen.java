public class GameColVen extends Game{

    public GameColVen(int numberOfPlayers, char mode, char gameType, Screen screen) {
        super(numberOfPlayers, mode, gameType, screen);
    }

    @Override
    public void playGame() {
        setUpGame();
        int count = 0;

        // deal tiles from bag to hand
        int PlayerPoints = 0;

        while (!winCond(PlayerPoints)){

            bossa.createBag();
            bossa.giveTiles();
            count = selectStarter();
            int skippedPlayers = 0;
            boolean roundContinue = true;

            while (roundContinue){

                Player jugadorActual = players[count];

                Screen.printTable();
                Screen.spacer();
                Screen.printPlayerHand(count);
                if (!mesa.canPlaceTileOnTable(jugadorActual.getHand()) && !jugadorActual.isEmptyHand()){
                    Screen.errorMng(2);
                    Screen.spacer();
                    if (bossa.canSteal()) {
                        jugadorActual.setHand(bossa.steal());  //
                    }
                    skippedPlayers++;
                } else {

                    Tile tempTile = jugadorActual.hand.get(Screen.askGetTileToPlace() -1);
                    mesa.placeTileOnTable(tempTile);
                    jugadorActual.hand.remove(tempTile);
                    skippedPlayers = 0;
                }

                if (jugadorActual.isEmptyHand() || skippedPlayers == players.length - 1){
                    jugadorActual.setPoints(totalPoints(count, mode));
                    int maxPointsTeam1 = Math.max(team1[0].getPoints(), team1[1].getPoints());
                    team1[0].setPoints(maxPointsTeam1);
                    team1[1].setPoints(maxPointsTeam1);

                    int maxPointsTeam2 = Math.max(team2[0].getPoints(), team2[1].getPoints());
                    team2[0].setPoints(maxPointsTeam2);
                    team2[1].setPoints(maxPointsTeam2);

                    Screen.showScore(count);
                    roundContinue = false;
                }
                if (count + 1 > players.length -1) {
                    count = 0;
                } else {
                    count++;
                }
            }

            PlayerPoints = getTopPlayer();
        }
        Screen.winMsg(mode, count);
    }

    @Override
    public boolean winCond(int points) {
        if (points >= 100) {
            return true;
        }
        return false;
    }
}
