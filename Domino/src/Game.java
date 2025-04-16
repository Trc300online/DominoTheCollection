public class Game {

    private static int numberOfPlayers = Screen.getPlayers();
    private Player[] team1 = new Player[numberOfPlayers / 2];
    private Player[] team2 = new Player[numberOfPlayers / 2];
    protected static Player[] totalPlayers = new Player[numberOfPlayers - 1];
    private char mode;
    private char gameType;
    private char gameTypeTeam;

    public static int getNumberOfPlayers(){
        return numberOfPlayers;
    }

    public static void setUpGame() {
        Bag.createBag();

        Background.giveTiles();
        Screen.printHands();

        /*if (numberOfPlayers == 4) {

            mode = Screen.getGameMode();

            if (mode == 'I') {

                gameType = Screen.offerIndvGames();
            } else {

                gameTypeTeam = Screen.offerTeamGames();
            }
        } else if (numberOfPlayers < 4) {

            Screen.jocIndividual();
            gameType = Screen.offerIndvGames();
        } else {

            Screen.errorMng(1);
            System.exit(0);
        }
        // select game mode + num players

        // create players and sort teams
        for (int i = 0; i < numberOfPlayers; i++) {
            Player jugador = new Player();
            totalPlayers[i] = jugador;

            if (mode != 'I') {
                if (i % 2 == 0) {
                    team1[i / 2] = jugador;
                } else {
                    team2[i / 2] = jugador;
                }
            }
        }
    }

    public void playGame() {
        // deal tiles from bag to hand
        Background.giveTiles();

        // standard partida individual

        while (p = 150) // check win cond (reach points req)
            do {
                p = 0; // total score
                while (bfichas) // round end --> if skipped players == NPlayers || player hand is empty
                    do {
                        asdfasdf; // play round with player rotation
                                        // if cant place tile --> skip player
                        p += score; // count points of round + sum to total score

                        // save progres
                    }
            }*/

    }
}
