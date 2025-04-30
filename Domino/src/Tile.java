public class Tile {

    private int esquerra;
    private int dreta;
    private int value;

    public Tile(int esquerra, int dreta){
        this.esquerra = esquerra;
        this.dreta = dreta;
        this.value = dreta + esquerra;
    }


    public String toString(){
        return  "[" + esquerra + "|" + dreta + "]";
    }

    public int getValue() {
        return value;
    }

    public int getEsquerra() {
        return esquerra;
    }

    public int getDreta() {
        return dreta;
    }
}
