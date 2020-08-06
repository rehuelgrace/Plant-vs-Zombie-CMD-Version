public class PeaShooter extends Plant{
    private char type = 'P';
    //public Timer shooterTimer;


    public PeaShooter(int x, int y, Array arrPS, ArrayAll<PeaShooter> ps){
        super(x,y,'P');
        arrPS.setArray((2*x - 1), y, 'P');
        ps.setArray ((((x-1)*60)+y),this);
        setHealth(200);
        setPower(20);
    }
    public void makeP(Array arraydisp, ArrayAll<Pea> arrPS){
        Pea ps = new Pea(arraydisp, super.getRow(), super.getColumn(), arrPS);
        arrPS.setArray(((super.getRow()*60)+super.getColumn()), ps);
    }
    public String getName(){
        String name = "Pea Shooter";
        return name;
    }
    public void serangZombie(Array arr, ArrayAll<ZombieBoss> zombieBoss, ArrayAll<ZombieIndie> zombieIndie,ArrayAll<Pea> tembakPea){
        /*boolean baris1 = false;
        boolean baris2 = false;
        boolean baris3 = false;
        boolean baris4 = false;*/
        int i = super.getRow();
        int j = super.getColumn();
        //int cek = (i * 60) + j - zombie.getColumn();
        Pea pea = new Pea(arr, i, j+1, tembakPea);
        //tembakPea.setArray((i*60)+j, pea);
        /*ArrayAll<Pea> tembakPea = new ArrayAll<Pea>('-');
        if (cek >= 1 && cek <= 60) {
            baris1 = true;
            tembakPea.insertObj(pea, ((i*60)+(j+1)));
        } else if (cek >= 61 && cek <= 120){
            baris2 = true;
            tembakPea.insertObj(pea, ((i*60)+(j+1)));
        } else if (cek >= 121 && cek <= 180){
            baris3 = true;
            tembakPea.insertObj(pea, ((i*60)+(j+1)));
        } else if (cek >= 181 && cek <= 240){
            baris4 = true;
            tembakPea.insertObj(pea,((i*60)+(j+1)));
        } else {
            baris1 = false;
            baris2 = false;
            baris3 = false;
            baris4 = false;
        }*/
    }
    /*public void move(Array arr, ArrayAll<ZombieBoss> zombieBoss, ArrayAll<ZombieIndie> zombieIndie, ArrayAll<Pea> tembakPea){
        int i = p.getRow();
        int j = p.getColumn();
        while ((i+1)!=zombie.getRow()){
            tembakPea.deleteObj(p, ((i*60)+j));
            tembakPea.insertObj(p, ((i*60)+(j+2)));
        }
        tembakPea.deleteObj(p, ((i*60)+j));
        zombie.attacked(getPower());
    }*/
}
        /*boolean adaPeluru = false;
        boolean baris1 = false;
        boolean baris2 = false;
        boolean baris3 = false;
        boolean baris4 = false;
        int x = super.getRow();
        int y = super.getColumn();
        Pea p = new Pea(arr, x, y+1, tembakPea);
        int i = p.getRow();
        int j = p.getColumn();
        int barisan = (i * 60) + j;
        if (barisan >= 1 && barisan <= 60){
            adaPeluru = true;
            baris1 = true;
            if ((p.getRow()+1)!=zombie.getRow()){
                tembakPea.deleteObj(p, ((i*60)+j));
                tembakPea.insertObj(p, ((i*60)+(j+2)));
            } else {
                tembakPea.deleteObj(p, ((i*60)+j));
            }
        } else if (barisan >= 61 && barisan <= 120){
            adaPeluru = true;
            baris2 = true;
            if ((p.getRow()+1)!=zombie.getRow()){
                tembakPea.deleteObj(p, ((i*60)+j));
                tembakPea.insertObj(p, ((i*60)+(j+2)));
            } else {
                tembakPea.deleteObj(p, ((i*60)+j));
            }
        } else if (barisan >= 121 && barisan <= 180){
            adaPeluru = true;
            baris2 = true;
            if ((p.getRow()+1)!=zombie.getRow()){
                tembakPea.deleteObj(p, ((i*60)+j));
                tembakPea.insertObj(p, ((i*60)+(j+2)));
            } else {
                tembakPea.deleteObj(p, ((i*60)+j));
            }
        } else if (barisan >= 181 && barisan <= 240){
            adaPeluru = true;
            baris2 = true;
            if ((p.getRow()+1)!=zombie.getRow()){
                tembakPea.deleteObj(p, ((i*60)+j));
                tembakPea.insertObj(p, ((i*60)+(j+2)));
            } else {
                tembakPea.deleteObj(p, ((i*60)+j));
            }
        } else {
            baris1 = false;
            baris2 = false;
            baris3 = false;
            baris4 = false;
            adaPeluru = false;
        }
    }
}*/