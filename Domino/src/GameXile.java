public class GameXile extends Game{

    public GameXile(int numberOfPlayers, char mode, char gameType, Screen screen) {
        super(numberOfPlayers, mode, gameType, screen);
    }

    @Override
    public void playGame() {
        setUpGame();
        int count;

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
                        jugadorActual.setHand(bossa.steal());
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
                    if (mode != 'I') {
                        int maxPointsTeam1 = Math.max(team1[0].getPoints(), team1[1].getPoints());
                        team1[0].setPoints(maxPointsTeam1);
                        team1[1].setPoints(maxPointsTeam1);

                        int maxPointsTeam2 = Math.max(team2[0].getPoints(), team2[1].getPoints());
                        team2[0].setPoints(maxPointsTeam2);
                        team2[1].setPoints(maxPointsTeam2);
                    }
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
        Screen.winMsg(mode, getBottomPlayer());
    }

    @Override
    public boolean winCond(int points) {
        if (points >= 121) {
            return true;
        }
        return false;
    }

    public int getBottomPlayer() {
        int points = players[0].getPoints();
        int player = -1;
        for (int i = 1; i < players.length - 1; i++) {
            if (players[i - 1].getPoints() < players[i].getPoints()
                    && players[i - 1].getPoints() < points) {
                player = i-1;
            } else {
                player = i;
            }
        }

        return player;
    }
}
