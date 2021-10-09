package leetcode;
interface MyPosition
{
    public Object getElement();
    public void setElement(Object e);
}
public class MyStack_List {
    protected MyNode top=null;
    protected int size=0;
    public MyStack_List()
    {}
    public int getSize(){return size;}
    public boolean isEmpty()
    {
        return getSize()==0;
    }
    public Object top()
    {
        if(!isEmpty())
            return top.getElement();
        throw new outStackException("栈为空");
    }
    public void push(Object e)
    {
        MyNode head=new MyNode(e,top);
        top=head;
        size++;
    }
    public Object pop()
    {
        if(isEmpty())
            throw  new outStackException("栈为空");
        MyNode head=top;
        top=top.getNext();
        size--;
        return head.getElement();
    }

}
