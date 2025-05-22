import java.math.BigDecimal;
import java.math.RoundingMode;

public class GamePonce extends Game{

    @Override
    public void playGame() {
        setUpGame();
        int count = 0;

        // deal tiles from bag to hand
        int PlayerPoints = 0;

        while (!winCond(pointsCalculator(PlayerPoints))){ // pointsCalculator()

            Bag.createBag();
            Background.giveTiles();
            count = Background.selectStarter();
            int skippedPlayers = 0;
            boolean roundContinue = true;
            boolean firstTime = true;

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
                    updatePlayerPoints(count, firstTime, skippedPlayers);
                    firstTime = false;
                } else {
                    Table.placeTileOnTable(count);
                    skippedPlayers = 0;
                }

                if (totalPlayers[count].isEmptyHand() || skippedPlayers == totalPlayers.length - 1){
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
        if (points >= 20) {
            return true;
        }
        return false;
    }

    private void updatePlayerPoints(int count, boolean firstTime, int skippedPlayers) {
        int pointsToAdd = (firstTime || skippedPlayers == totalPlayers.length - 1) ? 2 : 1;
        int previousPlayerIndex = (count - 1 >= 0) ? count - 1 : totalPlayers.length - 1;
        totalPlayers[previousPlayerIndex].setPoints(totalPlayers[previousPlayerIndex].getPoints() + pointsToAdd);
    }

    public int pointsCalculator(int points) {

        double pointsD = points/10.0;

        return (int) new BigDecimal(pointsD).setScale(0, RoundingMode.HALF_DOWN).doubleValue();
    }
}
