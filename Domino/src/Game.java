public abstract class Game {

    protected int numberOfPlayers;
    protected Player[] team1;
    protected Player[] team2;
    protected Player[] players;
    protected char mode;
    protected char gameType;
    protected char gameTypeChecked;
    protected char[] checkType = {'E','M','L','C','V','X','P'};
    protected int counter = 0;
    protected Table mesa;
    protected Bag bossa;
    protected Screen screen;

    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }

    public Game(int numberOfPlayers, char mode, char gameType, Screen screen) {
        this.mesa = new Table();
        this.bossa = new Bag();
        this.screen = screen;
        
        if (numberOfPlayers>4) {
            Screen.errorMng(1);
            System.exit(1);
        }
        this.numberOfPlayers = numberOfPlayers;
        this.mode = mode;
        this.gameType = gameType;
        this.gameTypeChecked = screen.checkGameType(gameType, checkType);

        players = new Player[numberOfPlayers];
        team1 = mode == 'I' ? null : new Player[numberOfPlayers / 2];
        team2 = mode == 'I' ? null : new Player[numberOfPlayers / 2];
    }

    public void setUpGame() {

        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player();
            players[i] = player;

            if (mode != 'I') {
                if (i % 2 == 0) {
                    team1[i / 2] = player;
                } else {
                    team2[i / 2] = player;
                }
            }
        }
    }

    public int selectStarter() {
        for (int x = 6; x >= 0; x--) {
            for (int i = 0; i < getNumberOfPlayers(); i++) {
                for (int j = 0; j < players[i].getHand().size(); j++) {
                    if (players[i].getHand().get(j).getEsquerra() == x && players[i].getHand().get(j).getDreta() == x) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    public int totalPoints(int count, char mode) {
        int points = 0;
        if (mode != 'I') {
            if (team1[0] == players[count] || team1[1] == players[count]) {
                for (int i = 0; i < team2.length; i++) {
                    for (int j = 0; j < team2[i].getHand().size(); j++) {
                        points += team2[i].getHand().get(j).getValue();
                    }
                }
            } else if (team2[0] == players[count] || team2[1] == players[count]) {
                for (int i = 0; i < team1.length; i++) {
                    for (int j = 0; j < team1[i].getHand().size(); j++) {
                        points += team1[i].getHand().get(j).getValue();
                    }
                }
            }
        } else {
            for (int i = 0; i < players.length; i++) {
                for (int j = 0; j < players[i].getHand().size(); j++) {
                    if (i != count) {
                        points += players[i].getHand().get(j).getValue();
                    }
                }
            }
        }
        return points;
    }

    public int getTopPlayer() {
        int points = 0;
        for (int i = 1; i < players.length - 1; i++) {
            if (players[i - 1].getPoints() > players[i].getPoints()) {
                points = players[i - 1].getPoints();
            }
        }
        return points;
    }

    public abstract void playGame();

    public abstract boolean winCond(int points);
}
