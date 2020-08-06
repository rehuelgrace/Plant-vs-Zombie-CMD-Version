//Array.java

public class Array
{
    private char[][] arraygame; // 4 x 60
    
    
    public Array()
    {
        this.arraygame = new char[9][60];
    }
    
    public char[][] getArrayGame()
    {
        return arraygame;
    }

    public void setArray(int i, int j, char value)
    {
        arraygame[i][j] = value;
    }
    public void startGame()

    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 60; j++)
            {
                arraygame[i][j] = ' ';
            }
        }
    }

    public void printGame()
    {
        for (int i = 0; i < 9; i++)
        {
            if (i % 2 == 0)
            {
                System.out.println("****************************************************************"); // kl baris genap isinya bates
            }
            else
            {
                System.out.print("* ");
                for (int j = 0; j < 60; j++)
                {
                    //System.out.print(j);
                    /*if (this.arraygame[i][j] == 'I')
                    {
                        System.out.print("I");
                    }
                    else if (this.arraygame[i][j] == 'B')
                    {
                        System.out.print("B");
                    }
                    else if (this.arraygame[i][j] == 'P')
                    {
                        System.out.print("P");
                    }
                    else if (this.arraygame[i][j] == 'F')
                    {
                        System.out.print("F");
                    }
                    else if (this.arraygame[i][j] == '-')
                    {
                        System.out.print("-");
                    }
                    else if (this.arraygame[i][j] == '.')
                    {
                        System.out.print(" ");
                    }*/
                    System.out.print(arraygame[i][j]);
                }
                System.out.println(" *");
            }
            
        }
    }
    
    public void insertFromArrayAll(ArrayAll arrayAll) //ngeinsert hasil ArrayAll
    {
        for (int i = 0; i <= 59; i++)
        {
            char isi = arrayAll.getType();
            arraygame[1][i] = isi;
        }
        for (int i = 60; i <= 119; i++)
        {
            char isi = arrayAll.getType();
            arraygame[3][i] = isi;
        }
        for (int i = 120; i <= 179; i++)
        {
            char isi = arrayAll.getType();
            arraygame[5][i] = isi;
        }
        for (int i = 180; i <= 239; i++)
        {
            char isi = arrayAll.getType();
            arraygame[7][i] = isi;
        }
    }

    /*public boolean isGameOverB(ArrayAll<ZombieBoss> az)
    {
        boolean a = false;
        Zombie[] arr = az.getArray();
        for (int i = 0; i < 240; i++)
        {
            if (arr[i].isGameOver())
            {
                a = true;
            }
        }
        return a;
    }*/

    /*public boolean isGameOverI(ArrayAll<ZombieIndie> az)
    {
        boolean a = false;
        Zombie[] arr = az.getArray();
        for (int i = 0; i < 240; i++)
        {
            if (arr[i].isGameOver())
            {
                a = true;
            }
        }
        return a;
    }*/

    public boolean isGameOver()
    {
        boolean bool = false;
        for (int i = 0; i < 9; i++)
        {
            if (i%2 == 1) // kl di baris ganjil
            {
                if ((arraygame[i][0] == 'I') || (arraygame[i][0] == 'B'))
                {
                    bool = true;
                }
            }
        }
        return bool;
    }

    public void move(char type, int rowawal, int columnawal, int rowtujuan, int columntujuan)
    {
        arraygame[rowawal][columnawal] = ' ';
        arraygame[rowtujuan][columntujuan] = type;
    }
}

