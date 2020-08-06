public abstract class Zombie
{
    private int speed;
    private int power;
    private int locX;
    private int locY;
    private int health;
    private char type;
    //ini mending method ato atribut ya
    private boolean isAlive;
    private boolean isMoving;

    public Zombie(int speed, int power, char type, int locX)
    {
        this.speed = speed;
        this.power = power;
        this.health = 100;
        this.type = type;
        this.isAlive = true;
        this.isMoving = true;
        this.locY = 59; // kolom
        this.locX = locX; //row
    }

    public void attackPS(char[][] array, PeaShooter peashooter) //LANGSUNG NGURANGIN PEASHOOTER
    {
        int depan = this.locY - 1;
        char tipe = array[this.locX][depan];
        if (tipe == 'P')
        {
            peashooter.reduceHealth(this.power);
        }
    }

    public boolean getStatAlive()
    {
        return isAlive;
    }

    public void attackFPS(char[][] array, FreezePeaShooter fpeashooter)
    {
        int depan = this.locY - 1;
        char tipe = array[this.locX][depan];
        if (tipe == 'F')
        {
            fpeashooter.reduceHealth(this.power);
        }
    }

    public void attacked(int plantPower)
    {
        if (plantPower < health)
        {
            health -= plantPower;
        }
        else
        {
            health = 0;
            isAlive = false;
        }
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getPower()
    {
        return power;
    }

    public void setPower(int power)
    {
        this.power = power;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public void setColumn (int column)
    {
        this.locY = column;
    }

    public int getColumn ()
    {
        return locY;
    }

    public void setRow (int row)
    {
        this.locX = row;
    }
    
    public int getRow ()
    {
        return locX;
    }

    /*public boolean canJump(Zombie zombiecek)
    {
        boolean canJump = true;
        if (this.getLocY() == zombiecek.getLocY()) // kl di baris yg sama
        {   
            if (this.getLocX() - this.getSpeed() == zombiecek.getLocX() - zombiecek.getSpeed()) // kl bakal berakhir di tempat yg sama
            {
                canJump = false;
            }
            else // ga berimpit
            {
                canJump = true;
            }
        }
        return canJump;

    }*/

    public abstract void move(ArrayAll<ZombieBoss> arrayZombieBoss, ArrayAll<ZombieIndie> arrayZombieIndie, Array arraydisplay, ArrayAll<Pea> arrayPea, ArrayAll<FreezePeaShooter> arrayFreezePeaShooter, ArrayAll<PeaShooter> arrayPeaShooter); //ini dia slalu ngecek apakah didepan dia bakal nabrak zombie didepannnya pake canJump.
    //tapi bingung krn dia ngelakuin itu trus2an sampe ujung, nah mending loopnya gmn ya
    
    public char getType()
    {
        return type;
    }

    public boolean isGameOver()
    {
        if (!isAlive)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setLive()
    {
        isAlive = false;
    }

}