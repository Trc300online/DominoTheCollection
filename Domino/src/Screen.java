import java.util.Scanner;

public class Screen {

    public static void printHands() {
        for (int i = 0; i < Game.getNumberOfPlayers(); i++) {
            for (int j = 0; j < Game.totalPlayers[i].getHand().size(); j++) {
                System.out.print(Game.totalPlayers[i].getHand().get(j));
            }
            System.out.println();
        }
    }

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

    public static void errorMng(int errorCode) {
        if (errorCode == 1) {
            System.out.println("Nombre de jugadors massa elevat per aquesta aplicació.");
        }
    }

    public static void jocIndividual(){
        System.out.println("jugadors insuficients per jugar en parelles. Aquestes son les opcions per jocs individuals.");
    }
}
