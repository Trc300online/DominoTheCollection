package MainStrc;

import SaveAndLoad.GameDAO;
import SaveAndLoad.GameDAOImpl;
import SaveAndLoad.GameState;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GamePonce extends Game {

    public GamePonce(int numberOfPlayers, char mode, char gameType) {
        super(numberOfPlayers, mode, gameType);
    }

    @Override
    public void playGame() {
        int count = 0;
        GameDAO dao = new GameDAOImpl();
        GameState carregat = null;

        if (screen.askLoadGame() == 'S') {
            carregat = dao.loadGame("partidaPonce.ser");
        }

        if (carregat != null){
            this.players = carregat.players;
            this.team1 = carregat.team1;
            this.team2 = carregat.team2;
            this.mode = carregat.mode;
            this.gameType = carregat.gameType;
            count = carregat.currentPlayerIndex;
            mesa.getTable().clear();
            mesa.getTable().tiles.addAll(carregat.table);
            bossa.getAll().clear();
            bossa.getAll().addAll(carregat.bag);
            System.out.println("Partida carregada correctament!");
        } else {
            setUpGame();
        }

        // deal tiles from bag to hand
        int PlayerPoints = 0;

        while (!winCond(pointsCalculator(PlayerPoints))){ // pointsCalculator()

            bossa.createBag();
            bossa.giveTiles();
            count = selectStarter();
            int skippedPlayers = 0;
            boolean roundContinue = true;
            boolean firstTime = true;

            while (roundContinue){

                Player jugadorActual = players[count];

                screen.printTable();
                screen.spacer();
                screen.printPlayerHand(count);
                if (!mesa.canPlaceTileOnTable(jugadorActual.getHand()) && !jugadorActual.isEmptyHand()){
                    screen.errorMng(2);
                    screen.spacer();
                    if (bossa.canSteal()) {
                        jugadorActual.setHand(bossa.steal());
                    }
                    skippedPlayers++;
                    updatePlayerPoints(count, firstTime, skippedPlayers);
                    firstTime = false;
                } else {

                    Tile tempTile = jugadorActual.hand.get(screen.askGetTileToPlace() -1);
                    mesa.placeTileOnTable(tempTile);
                    jugadorActual.hand.remove(tempTile);
                    skippedPlayers = 0;
                }

                if (jugadorActual.isEmptyHand() || skippedPlayers == players.length){
                    jugadorActual.setPoints(totalPoints(count, mode));
                    int maxPointsTeam1 = Math.max(team1[0].getPoints(), team1[1].getPoints());
                    team1[0].setPoints(maxPointsTeam1);
                    team1[1].setPoints(maxPointsTeam1);

                    int maxPointsTeam2 = Math.max(team2[0].getPoints(), team2[1].getPoints());
                    team2[0].setPoints(maxPointsTeam2);
                    team2[1].setPoints(maxPointsTeam2);

                    screen.showScore(count);
                    roundContinue = false;
                }
                if (count + 1 > players.length -1) {
                    count = 0;
                } else {
                    count++;
                }

                GameState estat = new GameState(players, team1, team2, mode, gameTypeChecked, count, mesa.getTable().tiles, bossa.getAll().tiles);
                dao.saveGame(estat, "partidaPonce.ser");
            }

            PlayerPoints = getTopPlayer();
        }
        screen.winMsg(mode, count);
    }

    @Override
    public boolean winCond(int points) {
        if (points >= 20) {
            return true;
        }
        return false;
    }

    private void updatePlayerPoints(int count, boolean firstTime, int skippedPlayers) {
        int pointsToAdd = (firstTime || skippedPlayers == players.length - 1) ? 2 : 1;
        int previousPlayerIndex = (count - 1 >= 0) ? count - 1 : players.length - 1;
        players[previousPlayerIndex].setPoints(players[previousPlayerIndex].getPoints() + pointsToAdd);
    }

    public int pointsCalculator(int points) {

        double pointsD = points/10.0;

        return (int) new BigDecimal(pointsD).setScale(0, RoundingMode.HALF_DOWN).doubleValue();
    }
}
