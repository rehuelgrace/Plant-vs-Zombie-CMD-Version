import java.util.Set;

public class FreezePeaShooter extends Plant{
    private char type = 'F';

    public FreezePeaShooter(int x, int y, Array arrFPS, ArrayAll<FreezePeaShooter> fps){
        super(x,y,'F');
        arrFPS.setArray((2*x - 1), y, 'F');
        fps.setArray ((((x-1)*60)+y), this);
        setHealth(250);
        setPower(25);
    }
    public void makeFP(Array arraydisp, ArrayAll<Pea> arrFPS){
        FreezePea fps = new FreezePea(arraydisp, super.getRow(), super.getColumn(),arrFPS);
        arrFPS.setArray(((super.getRow()*60)+super.getColumn()), fps);
    }
    public String getName(){
        String name = "Freeze Pea Shooter";
        return name;
    }
    public void serangZombie(Array arr, ArrayAll<ZombieBoss> zombieBoss, ArrayAll<ZombieIndie> zombieIndie,ArrayAll<Pea> tembakFreezePea){
        /*boolean baris1 = false;
        boolean baris2 = false;
        boolean baris3 = false;
        boolean baris4 = false;*/
        int i = super.getRow();
        int j = super.getColumn();
        //int cek = (i * 60) + j - zombie.getColumn();
        FreezePea fp = new FreezePea(arr, i, j+1, tembakFreezePea);
        /*ArrayAll<FreezePea> tembakFreezePea = new ArrayAll<FreezePea>('-');
        if (cek >= 0 && cek <= 59) {
            baris1 = true;
            tembakFreezePea.insertObj(fp, ((i*60)+(j+1)));
        } else if (cek >= 61 && cek <= 120){
            baris2 = true;
            tembakFreezePea.insertObj(fp, ((i*60)+(j+1)));
        } else if (cek >= 121 && cek <= 180){
            baris3 = true;
            tembakFreezePea.insertObj(fp, ((i*60)+(j+1)));
        } else if (cek >= 181 && cek <= 240){
            baris4 = true;
            tembakFreezePea.insertObj(fp,((i*60)+(j+1)));
        } else {
            baris1 = false;
            baris2 = false;
            baris3 = false;
            baris4 = false;
        }*/
    }
    //public void move(Array arr, ArrayAll<ZombieBoss> zombieBoss, ArrayAll<ZombieIndie> zombieIndie, ArrayAll<Pea> tembakFreezePea){
        /*boolean adaPeluru = false;
        boolean baris1 = false;
        boolean baris2 = false;
        boolean baris3 = false;
        boolean baris4 = false;*/
        /*int i = p.getRow();
        int j = p.getColumn();
        while ((i+1)!=zombie.getRow()){
            tembakFreezePea.deleteObj(p, ((i*60)+j));
            tembakFreezePea.insertObj(p, ((i*60)+(j+2)));
        }
        tembakFreezePea.deleteObj(p, ((i*60)+j));
        zombie.attacked(getPower());
    } */
} 
            
        /*}
        if (barisan >= 1 && barisan <= 60){
            adaPeluru = true;
            baris1 = true;
            } else {
                tembakFreezePea.deleteObj(fp, ((i*60)+j));
            }
        } else if (barisan >= 61 && barisan <= 120){
            adaPeluru = true;
            baris2 = true;
            if ((fp.getRow()+1)!=zombie.getRow()){
                tembakFreezePea.deleteObj(fp, ((i*60)+j));
                tembakFreezePea.insertObj(fp, ((i*60)+(j+2)));
            } else {
                tembakFreezePea.deleteObj(fp, ((i*60)+j));
            }
        } else if (barisan >= 121 && barisan <= 180){
            adaPeluru = true;
            baris2 = true;
            if ((fp.getRow()+1)!=zombie.getRow()){
                tembakFreezePea.deleteObj(fp, ((i*60)+j));
                tembakFreezePea.insertObj(fp, ((i*60)+(j+2)));
            } else {
                tembakFreezePea.deleteObj(fp, ((i*60)+j));
            }
        } else if (barisan >= 181 && barisan <= 240){
            adaPeluru = true;
            baris2 = true;
            if ((fp.getRow()+1)!=zombie.getRow()){
                tembakFreezePea.deleteObj(fp, ((i*60)+j));
                tembakFreezePea.insertObj(fp, ((i*60)+(j+2)));
            } else {
                tembakFreezePea.deleteObj(fp, ((i*60)+j));
            }
        } else {
            baris1 = false;
            baris2 = false;
            baris3 = false;
            baris4 = false;
            adaPeluru = false;
        }
    }
} */