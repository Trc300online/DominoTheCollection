public class Main {
    public static void main(String[] args) {
        int numberOfPlayers;
        char gameType;
        numberOfPlayers = Screen.getPlayers();
        char mode = Screen.getGameMode();
        if (mode == 'I') {
            if (numberOfPlayers < 4) {
                Screen.jocIndividual();
            }
            gameType = Screen.offerIndvGames();
        } else {
            gameType = Screen.offerTeamGames();
        }


        Game selectedGame = GameFactory.createGame(gameType, numberOfPlayers, mode);
        selectedGame.playGame();
    }

}
/*TODO: remove statics attrb, desmontar background*/
    /* abstarct de Game ^^^ . try merge/wrapper class for arrayLists de Tiles !?!?!?. jocs amb estructura diferent:Ponce(punts per pase),
       Xile(menys punts guanya), Llati,Colomabia,Veneçola(parella suma punts de altre parella) ^^^^ */