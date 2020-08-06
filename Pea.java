
public class Pea{
    private int speed;
    private int power;
    private int x;
    private int y;
    private char simbol = '-';
    private Array arr;
    private boolean kenaZombie;
    protected Zombie zombie;
 
    public Pea(Array arr, int x, int y, ArrayAll<Pea> ar){
        this.x = x;
        this.y = y;
        this.arr = arr;
        this.power = 10;
        this.speed = 2;
        ar.setArray(((x-1)*60)+y, this);
        arr.setArray((2*x - 1), y, '-');
    }
    public int getRow(){
        return x;
    }
    public void setRow(int x){
        this.x = x;
    }
    public int getColumn(){
        return y;
    }
    public void setColumn(int y){
        this.y = y;
    }
    public char getSimbol(){
        return simbol;
    }
    public int getPower(){
        return power;
    }
    public int getSpeed(){
        return speed;
    }
    public boolean isKena(){
        return kenaZombie;
    }
    public void attackZB(char[][] array, ZombieBoss zB) //NGURANGIN HEALTH ZOMBIE BOSS
    {
        int depan = this.y + 1;
        char tipe = array[this.x][depan];
        if (tipe == 'B')
        {
            zB.setHealth(zB.getHealth()-this.power);
        }
    }
        public void attackZI(char[][] array, ZombieIndie zI) //NGURANGIN HEALTH ZOMBIE INDIE
    {
        int depan = this.y + 1;
        char tipe = array[this.x][depan];
        if (tipe == 'I')
        {
            zI.setHealth(zI.getHealth()-this.power);
        }
    }

    public void move(ArrayAll<ZombieBoss> arrayZombieBoss, ArrayAll<ZombieIndie> arrayZombieIndie, Array arraydisplay, ArrayAll<Pea> arrayPea, ArrayAll<FreezePeaShooter> arrayFreezePeaShooter, ArrayAll<PeaShooter> arrayPeaShooter)
    {
        int i = getRow();
        int j = getColumn();
        Pea proc = arrayPea.getContent(i,j);

        int awal = ((i-1) * 60) + j;
        int tujuan = ((i-1)* 60) + j + getSpeed();
        int coltujuan = j + getSpeed();

        char[][] arrayproc = arraydisplay.getArrayGame();
        int tujuanjadi = tujuan;
        
        if((tujuan / 60) == (i-1))
        {
            boolean ketemu = false;
            for (int k = j; k < coltujuan; k++)
            {
                //System.out.println(k);
                //System.out.println(j);
                if (arrayproc[i][k] == 'I')
                {
                    tujuanjadi = (((i-1)*60) + k-1);
                    attackZI(arrayproc, arrayZombieIndie.getContentIdx(tujuanjadi+1));
                    arrayPea.deleteObj(proc, awal);
                    //arrayPea.insertObj(proc, tujuanjadi-1);
                    arraydisplay.move('-',(2*i-1),j,(2*1-1),(k-1));
                    setColumn(k-1);
                    ketemu = true;
                    //System.out.println(k);
                    //System.out.println(tujuanjadi);
                }
                else if (arrayproc[i][k] == 'B')
                {
                    tujuanjadi = (((i-1)*60) + k-1);
                    attackZB(arrayproc, arrayZombieBoss.getContentIdx(tujuanjadi+1));
                    arrayPea.deleteObj(proc, awal);
                    //arrayPea.insertObj(proc, tujuanjadi-1);
                    arraydisplay.move('-',(2*i-1),j,(2*1-1),(k-1));
                    setColumn(k-1);
                    ketemu = true;
                    //System.out.println(k);
                    //System.out.println(tujuanjadi);
                }
            }
            if (!ketemu)
            {
                    arrayPea.deleteObj(proc, awal);
                    arrayPea.insertObj(proc, tujuan);
                    //arrayPea.deleteObj(proc, awal);
                    arraydisplay.move('-', (2*i-1),j,(2*i-1),coltujuan);
                    setColumn(coltujuan);
                    //System.out.println(coltujuan);
            }
        }
    }
}
