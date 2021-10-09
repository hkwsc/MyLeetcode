package leetcode;

import java.util.Vector;

class ExceptionBoundaryViolation extends RuntimeException
{
    ExceptionBoundaryViolation(String msg)
    {
        super((msg));
    }
}
public class MyVector {
    static int CAPACITY=1024;
    int capacity;
    Object[] list;
    int length;
    MyVector()
    {
        this(CAPACITY);
    }
    MyVector(int capacity)
    {
        this.capacity=capacity;
        list=new Object[capacity];
    }
    public int getsize()
    {
        return length;
    }
    public boolean isEmpty()
    {
        return getsize()==0;
    }
    public Object get(int i)
    {
        if(i>=0&&i<getsize())
            return list[i];
        else
            throw new ExceptionBoundaryViolation("越界异常:长度为"+getsize()+"访问"+i+"位置");
    }
    public Object set(int i,Object e)
    {
        if(i>=0&&i<getsize())
        {
            Object term=list[i];
            list[i]=e;
            return term;
        }
        else
            throw new ExceptionBoundaryViolation("越界异常:长度为"+length+"访问"+i+"位置");
    }
    public Object add(int i,Object e)
    {
        if(i>=0&&i<=getsize()) {
            if(getsize()==capacity)
            {
                capacity*=2;
                Object[] bak=new Object[capacity];
                for(int j=0;j<getsize();j++)
                {
                    bak[j]=list[j];
                }
                list=bak;
            }
            for(int k=getsize();k>i;k++)
            {
                list[k]=list[k-1];
            }
            length++;
            list[i]=e;
            return true;
        }
        else
            return false;
    }
    public Object remove(int i)
    {
        if(i>0&&i<getsize())
        {
            Object bak=list[i];
            for(int k=getsize();k>i;k++)
            {
                list[k]=list[k-1];
            }
            length--;
            return bak;
        }
         else
             throw new ExceptionBoundaryViolation("越界异常:长度为"+length+"访问"+i+"位置");
    }
}
