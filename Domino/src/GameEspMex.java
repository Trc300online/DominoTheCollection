public class GameEspMex extends Game{

    @Override
    public void playGame() {
        setUpGame();
        int count = 0;

        // deal tiles from bag to hand
        int PlayerPoints = 0;

        while (!winCond(PlayerPoints)){

            bossa.createBag();
            bossa.giveTiles();
            count = Background.selectStarter();
            int skippedPlayers = 0;
            boolean roundContinue = true;

            while (roundContinue){
                Screen.printTable();
                Screen.spacer();
                Screen.printPlayerHand(count);
                if (!mesa.canPlaceTileOnTable(count) && !players[count].isEmptyHand()){
                    Screen.errorMng(2);
                    Screen.spacer();
                    if (bossa.canSteal()) {
                        bossa.steal(count);
                    }
                    skippedPlayers++;
                } else {

                    Tile tempTile = players[count].hand.get(Screen.askGetTileToPlace() -1);
                    mesa.placeTileOnTable(tempTile);
                    players[count].hand.remove(tempTile);
                    skippedPlayers = 0;
                }

                if (players[count].isEmptyHand() || skippedPlayers == players.length - 1){
                    players[count].setPoints(Background.totalPoints(count, mode));
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

            PlayerPoints = Background.getTopPlayer();
        }
        Screen.winMsg(mode, count);
    }

    @Override
    public boolean winCond(int points) {
        if (points >= 200) {
            return true;
        }
        return false;
    }
}
