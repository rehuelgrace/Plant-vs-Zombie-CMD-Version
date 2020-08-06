public class ZombieIndie extends Zombie
{
    public ZombieIndie(Array arraydisp, int locX, ArrayAll<ZombieIndie> ar)
    {
        super(2,15,'I', locX);
        int i = super.getRow();
        int j = super.getColumn();
        arraydisp.setArray((2*i - 1), j, 'I');
        ar.setArray(((i-1)*60)+j, this) ;
    }

    public char getType()
    {
        return super.getType();
    }

    public void move(ArrayAll<ZombieBoss> arrayZombieBoss, ArrayAll<ZombieIndie> arrayZombieIndie, Array arraydisplay, ArrayAll<Pea> arrayPea, ArrayAll<FreezePeaShooter> arrayFreezePeaShooter, ArrayAll<PeaShooter> arrayPeaShooter)
    {
        int i = super.getRow(); //baris antara 1-4
        int j = super.getColumn();

        //ZombieIndie[] arrayproc = arrayZombieIndie.getArray(); 
        ZombieIndie proc = arrayZombieIndie.getContent(i, j);
        
        int awal = ((i-1) * 60) + j;
        int tujuan = ((i-1) * 60) + j - super.getSpeed();
        int coltujuan = j - super.getSpeed();

        boolean nabrak;

        //if (((tujuan >= 1) && (tujuan <= 60)) || ((tujuan <= 61) && (tujuan <= 120)) || ((tujuan >= 121) && (tujuan <= 180)) || ((tujuan >= 181) && (tujuan <= 240)))
        if ((tujuan / 60) == (i-1))
        {
            nabrak = false;
        }
        else
        {
            nabrak = true;
        }

        //1. TUJUAN KOSONG
        char[][] arrayprocdisplay = arraydisplay.getArrayGame();
        int tujuanjadi = tujuan;
        if (!nabrak)
        {
            boolean ketemu = false;
            //GA NGELEWATIN APA2
            for (int k = j-1; k >= coltujuan; k--) //ngecek apakah sampe tujuan tuh ada sesuatu / ga
            {
                //System.out.println("CURRENTLY CHECKED"+k);
                if (arrayprocdisplay[i][k] == '-') //kl dia ngelewatin peluru, ketembak
                {
                    //tujuanjadi = ((i-1) * 60) + k + 1; //di sebelah kanannya pea stop
                    super.attacked(arrayPea.getContentIdx(tujuanjadi -1).getPower());
                    //arrayZombieIndie.insertObj(proc, tujuanjadi);
                    //arrayZombieIndie.deleteObj(proc, awal);
                    //arraydisplay.move('I', (2*i - 1), j, (2*1 - 1), k);
                    //super.setColumn(k);
                    //ketemu = true;
                }
                else if (arrayprocdisplay[i][k] == 'F') //kl lewatin plant peashot dia attack, dia antara ngabisin si plant ato diabisin
                {
                    tujuanjadi = ((i-1) * 60) + k+1; //di sebelah kanannya peashot sampe mati/ngematiin
                    super.attackFPS(arrayprocdisplay, arrayFreezePeaShooter.getContentIdx(tujuanjadi-1));
                    arrayZombieIndie.insertObj(proc, tujuanjadi);
                    arrayZombieIndie.deleteObj(proc, awal);
                    arraydisplay.move('I', (2*i - 1), j, (2*1 - 1), k+1);
                    ketemu = true;
                    super.setColumn(k+1);
                }

                else if (arrayprocdisplay[i][k] == 'P') //kl lewatin plant fpeashot
                {
                    tujuanjadi = ((i-1) * 60) + k+1;
                    super.attackPS(arrayprocdisplay, arrayPeaShooter.getContentIdx(tujuanjadi-1));
                    arrayZombieIndie.insertObj(proc, tujuanjadi);
                    arrayZombieIndie.deleteObj(proc, awal);
                    arraydisplay.move('I', (2*i - 1), j, (2*1 - 1), k+1);
                    ketemu = true;
                    super.setColumn(k+1);
                }                
            }
            if (!ketemu) //gaada yg dilewatin
            {
                arrayZombieIndie.insertObj(proc, tujuanjadi);
                arrayZombieIndie.deleteObj(proc, awal);
                arraydisplay.move('I', (2*i - 1), j, (2*i - 1),coltujuan);
                super.setColumn(coltujuan);
            }
        }
       
        else //NABRAK
        {
            arraydisplay.move('I', (2*i - 1), j, (2*i - 1), 0);
            arrayZombieIndie.insertObj(proc, tujuan);
            arrayZombieIndie.deleteObj(proc, awal);
            super.setColumn(0);
        }
        //System.out.println("Asalnya" + awal);
        //System.out.println("INI TUJUANNYA" + tujuanjadi);
    }
}



 /*else if ((arrayprocdisplay[i][j - super.getSpeed()] != ' ') && (tujuansebaris)) //berhimpit, ada sesuatu di 
        {
            if (arrayprocdisplay[i][j] - super.getSpeed() == 'F') //kalo ketemu si freezepea, nyerang
            {
                
            }
            else if (arrayprocdisplay[i][j-super.getSpeed()] == 'P')
            {

            }
            else if (arrayprocdisplay[i][j-super.getSpeed()] == 'B')
            {//do nothing ? gtau
            }
            else if (arrayprocdisplay[i][j-super.getSpeed()] == 'I')
            {//do nothing? gtau
            }
            else if (arrayprocdisplay[i][j-super.getSpeed()] == '-')
            {
                
                Pea[] arrayprocpea = arrayPea.getArray();
                Pea peakena = arrayprocpea[(i*60) + j-super.getSpeed()];
                int plantpower = peakena.getPower();
                super.attacked(plantpower);
                if (!getStatAlive())
                {
                    arrayZombieIndie.deleteObj(proc, (i*60) + j);
                }
            }
        }*/