public class Tile {

    private int esquerra;
    private int dreta;

    public Tile(int esquerra, int dreta){
        this.esquerra = esquerra;
        this.dreta = dreta;
    }


    public String toString(){
        return  "[" + esquerra + "|" + dreta + "]";
    }

}
