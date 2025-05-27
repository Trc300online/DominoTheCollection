public class GameColVen extends Game{

    @Override
    public void playGame() {
        setUpGame();
        int count = 0;

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
                    int maxPointsTeam1 = Math.max(team1[0].getPoints(), team1[1].getPoints());
                    team1[0].setPoints(maxPointsTeam1);
                    team1[1].setPoints(maxPointsTeam1);

                    int maxPointsTeam2 = Math.max(team2[0].getPoints(), team2[1].getPoints());
                    team2[0].setPoints(maxPointsTeam2);
                    team2[1].setPoints(maxPointsTeam2);

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
