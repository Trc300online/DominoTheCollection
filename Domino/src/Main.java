public class Main {
    public static void main(String[] args) {

        Game selectedGame = GameFactory.createGame(Game.gameTypeChecked);
        selectedGame.playGame();
    }

    /*TODO: remove statics attrb, desmontar background*/
    /* abstarct de Game ^^^ . try merge/wrapper class for arrayLists de Tiles !?!?!?. jocs amb estructura diferent:Ponce(punts per pase),
       Xile(menys punts guanya), Llati,Colomabia,Veneçola(parella suma punts de altre parella) ^^^^ */
}