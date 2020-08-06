public class ZombieBoss extends Zombie
{
    public ZombieBoss(Array arraydisp, int locX, ArrayAll<ZombieBoss> ar)
    {
        super(4, 30, 'B', locX);
        int i = super.getRow();
        int j = super.getColumn();
        arraydisp.setArray((2*i - 1), j, 'B');
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
        //ZombieBoss[] arrayproc = arrayZombieBoss.getArray(); //array si zombieboss, null kl kosong
        ZombieBoss proc = arrayZombieBoss.getContent(i, j); // return zombieboss
        
        int awal = ((i-1) * 60) + j;
        int tujuan = ((i-1) * 60) + j - super.getSpeed();
        int coltujuan = j - super.getSpeed();

        boolean nabrak;
        //if (((tujuan >= 0) && (tujuan <= 59)) || ((tujuan >= 60) && (tujuan <= 119)) || ((tujuan >= 120) && (tujuan <= 179)) || ((tujuan >= 180) && (tujuan <= 239)))
        if ((tujuan / 60) == (i-1)) // kalo masih di baris yg sama 
        {
            nabrak = false;
        }
        else 
        {
            nabrak = true;
        } //krn kl udh ganti baris brrt nabrak ato gameover

        //1. TUJUAN KOSONG
        char[][] arrayprocdisplay = arraydisplay.getArrayGame();
        int tujuanjadi = tujuan;
        if (!nabrak)
        {
            boolean ketemu = false;
            //GA NGELEWATIN APA2
            for (int k = j - 1; k >= coltujuan; k--) //ngecek apakah mau ke tujuan tuh ada sesuatu / ga
            {
                if (arrayprocdisplay[i][k] == '-') //kl dia ngelewatin peluru, ketembak
                {
                    //tujuanjadi = ((i-1) * 60) + k + 1; //di sebelah kanannya pea stop
                    super.attacked(arrayPea.getContentIdx(tujuanjadi - 1).getPower());
                    //arrayZombieBoss.insertObj(proc, tujuanjadi);
                    //arrayZombieBoss.deleteObj(proc, awal);
                    //arraydisplay.move('B', (2*i - 1), j, (2*1 - 1), k);
                    //super.setColumn(k);
                    //ketemu = true;
                }
                else if (arrayprocdisplay[i][k] == 'F') //kl lewatin plant peashot dia attack
                {
                    tujuanjadi = ((i-1) * 60) + k+1; //gantiin tempat peashot
                    super.attackFPS(arrayprocdisplay, arrayFreezePeaShooter.getContentIdx(tujuanjadi-1));
                    arrayZombieBoss.insertObj(proc, tujuanjadi);
                    arrayZombieBoss.deleteObj(proc, awal);
                    arraydisplay.move('B', (2*i - 1), j, (2*1 - 1), k+1);
                    super.setColumn(k+1);
                    ketemu = true;
                }

                else if (arrayprocdisplay[i][k] == 'P') //kl lewatin plant fpeashot
                {
                    tujuanjadi = ((i-1) * 60) + k;
                    super.attackPS(arraydisplay.getArrayGame(), arrayPeaShooter.getContentIdx(tujuanjadi));
                    arrayZombieBoss.insertObj(proc, tujuanjadi);
                    arrayZombieBoss.deleteObj(proc, awal);
                    arraydisplay.move('B', (2*i - 1), j, (2*1 - 1), k);
                    super.setColumn(k);
                    ketemu = true;
                }
            }
            if (!ketemu) //gaada yg dilewatin
            {
                arrayZombieBoss.insertObj(proc, tujuan);
                arrayZombieBoss.deleteObj(proc, awal);
                arraydisplay.move('B', (2*i - 1), j, (2*i - 1), coltujuan);
                super.setColumn(coltujuan);
            }
        }
        /*
        else if ((arrayprocdisplay[i][j - super.getSpeed()] != ' ') && (!nabrak)) //berhimpit, ada sesuatu di tujuan
        {
            if (arrayprocdisplay[i][j - super.getSpeed()] == 'F') //kalo ketemu si freezepea, nyerang
            {
                super.attackFPS(arraydisplay, arrayFreezePeaShooter.getArray()[tujuan]);
                arrayZombieBoss.insertObj(proc, tujuan);
                arrayZombieBoss.deleteObj(proc, awal);
                arraydisplay.move('B', (2*i - 1), j, (2*1 - 1), j - super.getSpeed());
            }
            else if (arrayprocdisplay[i][j-super.getSpeed()] == 'P')
            {
                super.attackPS(arraydisplay, arrayPeaShooter.getArray()[tujuanjadi]);
                arrayZombieBoss.insertObj(proc, tujuanjadi);
                arrayZombieBoss.deleteObj(proc, awal);
                arraydisplay.move('B', (2*i - 1), j, (2*1 - 1), j - super.getSpeed());
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
                    arrayZombieBoss.deleteObj(proc, (i*60) + j);
                }
                super.attacked(arrayPea.getArray()[tujuanjadi - 1].getPower());
                arrayZombieBoss.insertObj(proc, tujuanjadi);
                arrayZombieBoss.deleteObj(proc, awal);
                arraydisplay.move('B', (2*i - 1), j, (2*1 - 1), tujuan);
            }
        }*/
        else //gameover
        {
            arraydisplay.move('B', (2*i - 1), j, (2*i - 1), 0);
            arrayZombieBoss.insertObj(proc, tujuan);
            arrayZombieBoss.deleteObj(proc, awal);
            super.setColumn(0);
        }

/*
arrayZombieBoss.insertObj(proc, (i * 60) + k + 1); //ditaroh di kanannya pea
                    arrayZombieBoss.deleteObj(proc, (i * 60) + j);
*/

//                else if (arraydisplay[i])
           
        /*ArrayAll<Zombie> 
        char[][] arrayprocessed = arraygame.getArrayGame();
        for (int j = 1; j <= 60; j++)
        {
            if (this.locX != j) // if ga ngeidentify itself
            {
                
                if (arrayprocessed[i][j] == 'B')
                {
                    LivingObjects zombiecek = arraygame.contentArray(i,j);
                    if (this.locX + this.speed != j + 2)
                    {
                        this.locX = j+2;  
                    }
                    else // ngehandle yg gbs jump
                    {
                    }
                }
                else if (arrayprocessed[i][j] == 'I')
                {
                    if (this.locX + this.speed != j + 1)
                    {
                        this.locX = j + 1 ;
                    }
                    else 
                    {
                        //gbs jump, gmn?
                    }
                }
            }
    
            
            else if (arrayprocessed[i][j] == ' ')
            {
                this.locX += this.speed;
            }
        }
            //kl plant? kl pea? */
    }
}
