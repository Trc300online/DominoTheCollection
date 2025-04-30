public class Game {

    private static int numberOfPlayers = Screen.getPlayers();
    private static Player[] team1 = new Player[numberOfPlayers / 2];
    private static Player[] team2 = new Player[numberOfPlayers / 2];
    protected static Player[] totalPlayers = new Player[numberOfPlayers];
    private static char mode;
    private static char gameType;
    //private static char gameTypeTeam;

    public static int getNumberOfPlayers(){
        return numberOfPlayers;
    }

    public static void setUpGame() {
        Bag.createBag();

        if (numberOfPlayers == 4) {

            mode = Screen.getGameMode();

            if (mode == 'I') {

                gameType = Screen.offerIndvGames();
            } else {

                gameType = Screen.offerTeamGames();
                //gameTypeTeam = Screen.offerTeamGames();
            }
        } else if (numberOfPlayers < 4) {

            mode = 'I';
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
//        Background.giveTiles();
//
//        for (int i = 0; i < totalPlayers.length; i++) {
//            System.out.println(totalPlayers[i].getHand());
//        }
//        System.out.println();
//        System.out.println(team1[0].getHand());
//        System.out.println(team1[1].getHand());
//        System.out.println(team2[0].getHand());
//        System.out.println(team2[1].getHand());

        /*
        switch (gameType) {
            case 'E':
                GameEspañol(mode);
            case 'M':
                GameMexica(mode);
            case 'L':
                GameLlati(mode);
            case 'C':
                GameColomabia(mode);
            case 'V':
                GameVeneçola(mode);
            case 'X':
                GameXile(mode);
            case 'P':
                GamePonce(mode);
        }
         */
    }

    public void playGame(int points, char mode) {
        // deal tiles from bag to hand
        Background.giveTiles();

        while (!winCond()){

            int count = Background.selectStarter();
            int skippedPlayers = 0;

            while (skippedPlayers < totalPlayers.length){

                if (!canPlaceTileOnTable()){
                    Screen.errorMng(2);
                    if (canSteal)
                    skippedPlayers++;
                }
                    placeTileOnTable();

                if (totalPlayers[count].isEmptyHand()){
                    break;
                }
                if (count++ == totalPlayers.length -1) {
                    count = 0;
                } else {
                    count++;
                }

                if (count == 1){
                    count = 2;
                } else if (count == 2) {
                    count = 3;
                } else if (count == 3) {
                    count = 4;
                } else if (count == 4) {
                    count = 1;
                }
            }
        }


        // standard partida individual
        /*
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
