public class GameXile extends Game{

    @Override
    public void playGame() {
        setUpGame();
        int count;

        // deal tiles from bag to hand
        int PlayerPoints = 0;

        while (!winCond(PlayerPoints)){

            Bag.createBag();
            Background.giveTiles();
            count = Background.selectStarter();
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
                    skippedPlayers = 0;
                }

                if (totalPlayers[count].isEmptyHand() || skippedPlayers == totalPlayers.length){
                    totalPlayers[count].setPoints(Background.totalPoints(count, mode));
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
                if (count + 1 > totalPlayers.length -1) {
                    count = 0;
                } else {
                    count++;
                }
            }

            PlayerPoints = Background.getTopPlayer();
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
        int points = Game.totalPlayers[0].getPoints();
        int player = -1;
        for (int i = 1; i < Game.totalPlayers.length - 1; i++) {
            if (Game.totalPlayers[i - 1].getPoints() < Game.totalPlayers[i].getPoints()
                    && Game.totalPlayers[i - 1].getPoints() < points) {
                player = i-1;
            } else {
                player = i;
            }
        }

        return player;
    }
}
