public class FreezePea extends Pea{
    private int power;
    private int speed;
    private int x;
    private int y;
   // private Zombie zombie;
 
    public FreezePea(Array arr,int x, int y, ArrayAll<Pea> ar) {
        super(arr, x, y, ar);
        this.power = 20;
        this.speed = 2;

    }
    public int getPower(){
        return power;
    }
}
