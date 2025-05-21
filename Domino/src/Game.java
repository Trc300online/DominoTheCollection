public abstract class Game {

    protected static int numberOfPlayers;
    protected static Player[] team1;
    protected static Player[] team2;
    protected static Player[] totalPlayers;
    protected static char mode;
    protected static char gameType;
    protected static char[] checkType = {'E','M','L','C','V','X','P'};
    static int counter = 0;

    public static int getNumberOfPlayers(){
        return numberOfPlayers;
    }

    static {
        numberOfPlayers = Screen.getPlayers();
        if (numberOfPlayers>4) {
            Screen.errorMng(1);
            System.exit(1);
        }
        mode = (numberOfPlayers < 4) ? 'I' : Screen.getGameMode();
        gameType = (mode == 'I') ? Screen.offerIndvGames() : Screen.offerTeamGames();
        for (int i = 0; i < checkType.length; i++) {
            if (gameType != checkType[i]) {
                counter++;
                if (counter >= checkType.length) {
                    Screen.errorMng(3);
                    System.exit(1);
                }
            }
        }

        totalPlayers = new Player[numberOfPlayers];
        team1 = mode == 'I' ? null : new Player[numberOfPlayers / 2];
        team2 = mode == 'I' ? null : new Player[numberOfPlayers / 2];
    }

    public static void setUpGame() {

        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player();
            totalPlayers[i] = player;

            if (mode != 'I') {
                if (i % 2 == 0) {
                    team1[i / 2] = player;
                } else {
                    team2[i / 2] = player;
                }
            }
        }
    }

    public abstract void playGame();

    public abstract boolean winCond(int points);
}
