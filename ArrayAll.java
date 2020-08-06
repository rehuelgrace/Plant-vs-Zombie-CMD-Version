import java.lang.reflect.Array;

//import java.util.ArrayList;

public class ArrayAll<T>
{
//    private T[] t;
    private Object[] t;
    private static int count;
    private char type;

    public ArrayAll(char type)
    {
        t = new Object[240];
        //t = new T[240];
        count = 0;
        for (int i = 0; i < 240; i++)
        {
            t[i] = null;
        }
        this.type = type;
    }

    public char getType()
    {
        return(type);
    }

    /*public T[] getArray()
    {
        T[] a = (T[]) t;
        return a;
    }*/

    public void setArray(int i, T x)
    {
        /*for (int j = 0; j<240; j++)
        {
            t[j] = new Object();
        }*/
        t[i] = new Object();
        t[i] = x;
    }

    public T getContent(int i, int j)
    {
        @SuppressWarnings("unchecked")
        T x = (T) t[((i-1)*60)+j];
        return x;
    }

    public T getContentIdx(int i)
    {
        @SuppressWarnings("unchecked")
        T x = (T) t[i];
        return x;
    }

    /*public T[] newArrayObject()
    {
        t = (T[]) new Object[240];
        count = 0;
        for (int i = 0; i < 240; i++)
        {
            this.t[i] = null;
        }
        return t;
    }*/

    public void countNeff()
    {
        for (int i = 1; i<240; i++)
        {
            if (t[i] != null)
            {
                this.count += 1;
            }
        }
    }

    public void insertObj(T x, int i)
    {
        this.t[i] = new Object();
        this.t[i] = x;
    }

    public void deleteObj(T t, int i)
    {
        this.t[i] = null;
    }

    /*public boolean isNull(int i)
    {
        if (t[i] == null)
        {
            return true;
        }
        else return false;
    }*/

}