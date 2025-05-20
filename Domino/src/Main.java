public class Main {
    public static void main(String[] args) {

        Game selectedGame = GameFactory.createGame(Game.gameType, Game.mode);
        selectedGame.playGame();
    }

    /*TODO: abstarct de Game. try merge arrayLists de Tiles. jocs amb estructura diferent:Ponce(punts per pase),
       Xile(menys punts guanya), Llati,Colomabia,Vewneçola(parella suma punts de altre parella), Mexica(suma tots punts de l'altre parella, indv parelles canvien cada ronda) */
}