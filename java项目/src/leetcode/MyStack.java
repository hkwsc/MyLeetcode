package leetcode;
class outStackException extends RuntimeException{
    outStackException(String msg)
    {
        super(msg);
    }
}
class ParenMatch
{
    static boolean parenMatch(String s) {
        MyStack stack = new MyStack();
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++)
        {
            if(builder.charAt(i)=='(')
                stack.push(builder.charAt(i));
            else if(builder.charAt(i)==')')
            {
                if((char)stack.top()=='(')
                    stack.pop();
                else
                    return false;
            }
            System.out.println(stack.top);
        }
        if(stack.size()==0)
            return true;
        else
            return false;
    }
}
public class MyStack {
    public static void main(String[] args) {
        System.out.println(ParenMatch.parenMatch("()"));
    }
    final static int CAPACITY=1024;
    int capacity;
    int top=-1;
    Object[] list;
    MyStack()
    {
        this(CAPACITY);
    }
    MyStack(int capacity)
    {
        this.capacity=capacity;
        list=new Object[capacity];
    }
    boolean isEmpty()
    {return top==-1;}
    Object top()throws outStackException
    {
        if(isEmpty())
        {
            throw new outStackException("sda");
        }
        return list[top];
    }
    int size()
    {return top+1;}
    Object pop()
    {
        Object elem;
        if(top==-1)
            throw new outStackException("asd");
        elem=list[top];
        list[top--]=null;
        return elem;
    }
    public void push(Object elem)throws outStackException
    {
        if(top==capacity-1)
            throw new outStackException("234");
        list[++top]=elem;
    }
}
