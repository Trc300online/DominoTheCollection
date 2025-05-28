public class Background {



    public static int selectStarter() {
        for (int x = 6; x >= 0; x--) {
            for (int i = 0; i < Game.getNumberOfPlayers(); i++) {
                for (int j = 0; j < Game.players[i].getHand().size(); j++) {
                    if (Game.players[i].getHand().get(j).getEsquerra() == x && Game.players[i].getHand().get(j).getDreta() == x) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }



    public static int totalPoints(int count, char mode) {
        int points = 0;
        if (mode != 'I') {
            if (Game.team1[0] == Game.players[count] || Game.team1[1] == Game.players[count]) {
                for (int i = 0; i < Game.team2.length; i++) {
                    for (int j = 0; j < Game.team2[i].getHand().size(); j++) {
                        points += Game.team2[i].getHand().get(j).getValue();
                    }
                }
            } else if (Game.team2[0] == Game.players[count] || Game.team2[1] == Game.players[count]) {
                for (int i = 0; i < Game.team1.length; i++) {
                    for (int j = 0; j < Game.team1[i].getHand().size(); j++) {
                        points += Game.team1[i].getHand().get(j).getValue();
                    }
                }
            }
        } else {
            for (int i = 0; i < Game.players.length; i++) {
                for (int j = 0; j < Game.players[i].getHand().size(); j++) {
                    if (i != count) {
                        points += Game.players[i].getHand().get(j).getValue();
                    }
                }
            }
        }
        return points;
    }

    public static int getTopPlayer() {
        int points = 0;
        for (int i = 1; i < Game.players.length - 1; i++) {
            if (Game.players[i - 1].getPoints() > Game.players[i].getPoints()) {
                points = Game.players[i - 1].getPoints();
            }
        }
        return points;
    }
}
