import java.util.Scanner;

public class Screen {


    public static int getPlayers() {
        int nPlayers;
        Scanner getPlayers = new Scanner(System.in);
        System.out.println("Nombre de jugadors: ");
        nPlayers = Integer.parseInt(getPlayers.next());
        return nPlayers;
    }

    public static char getGameMode() {

        char p;
        Scanner getTeam = new Scanner(System.in);
        System.out.println("[I] Individual | [P] Parella");
        p = getTeam.next().toUpperCase().charAt(0);

        return p;
    }

    public static char offerIndvGames() {
        char g;
        Scanner getIndv = new Scanner(System.in);
        System.out.println("[E] Español | [M] Mexica | [X] Xilè");
        g = getIndv.next().toUpperCase().charAt(0);

        return g;
    }

    public static char offerTeamGames() {
        char g;
        Scanner getTeam = new Scanner(System.in);
        System.out.println("[E] Español | [M] Mexica | [L] Llatí | [C] Colombiá | [V] Veneçolá | [X] Xilè | [P] Ponce ");
        g = getTeam.next().toUpperCase().charAt(0);

        return g;
    }

   /* public void errorMng(int errorCode) {
        if ()
    }*/

    public static void jocIndividual(){
        System.out.println("jugadors insuficients per jugar en parelles. Aquestes son les opcions per jocs individuals.");
    }
}
