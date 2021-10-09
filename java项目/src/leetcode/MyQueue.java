package leetcode;
interface MyQueue1
{
    public int getSize();
    public boolean isEmpty();
    public Object front();
    public void enqueue(Object obj)throws QueueFullException;
    public Object dequeue()throws QueueEmptyException;
    public void Traversal()throws QueueEmptyException;
}
class QueueFullException extends RuntimeException
{
    QueueFullException(String msg)
    {
        super(msg);
    }
}
class QueueEmptyException extends RuntimeException
{
    QueueEmptyException(String msg)
    {
        super(msg);
    }
}
class test
{
    public static void main(String[] args) {
        MyQueue queue=new MyQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(5);
        queue.dequeue();
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.Traversal();
    }
}
public class MyQueue implements MyQueue1{
    static int CAPACITY=1024;
    int capacity;
    Object[] list;
    int f=0;
    int r=0;
    MyQueue()
    {
        this(CAPACITY);
    }
    MyQueue(int capacity)
    {
        this.capacity=capacity+1;
        list=new Object[this.capacity];
    }
    @Override
    public int getSize() {
        return (r-f+capacity)%capacity;
    }

    @Override
    public boolean isEmpty() {
        return f==r;
    }

    @Override
    public Object front() {
        return list[f];
    }

    @Override
    public void enqueue(Object obj) throws QueueFullException {
        if(r+1==f)
        {
            throw new QueueFullException("QueueFull");
        }
        list[r]=obj;
        r=(r+1)%capacity;
    }

    @Override
    public Object dequeue() throws QueueEmptyException {
        if(f==r)
        {
            throw new QueueEmptyException("QueueEmpty");
        }
        int frist=f;
        f=(f+1)%capacity;
        return list[frist];
    }

    @Override
    public void Traversal() throws QueueEmptyException {
        if(isEmpty())
            throw new QueueFullException("QueueEmpty");
        if(f<r)
        {
            for(int i=f;i<r;i++)
                System.out.print(list[i]);
        }
        else
        {
            for(int i=f;i<capacity;i++)
                System.out.println(list[i]);
            for(int i=0;i<r;i++)
                System.out.println(list[i]);
        }
    }
}
class MyLinkedQueue implements MyQueue1
{
    static int CAPACITY=1024;
    int capacity;
    ListNode f=new ListNode();
    ListNode r=f;
    MyLinkedQueue()
    {
        this(CAPACITY);
    }
    MyLinkedQueue(int capacity)
    {
        this.capacity=capacity;
        ListNode p=f;
        for(int i=0;i<capacity;i++)
        {
            p.next=new ListNode();
            p=p.next;
        }
        p.next=f;
    }
    @Override
    public int getSize() {
        ListNode p=f;
        int i=0;
        for(i=0;p.next!=f;i++,p=p.next);
        return i;
    }

    @Override
    public boolean isEmpty() {
        return f==r;
    }

    @Override
    public Object front() throws QueueEmptyException{
        if(isEmpty())
            throw new QueueEmptyException("QueueEmpty");
        return f.val;
    }

    @Override
    public void enqueue(Object obj) throws QueueFullException {
        if(r.next==f)
            throw new QueueFullException("QueueFull");
    }

    @Override
    public Object dequeue() throws QueueEmptyException {
        return  null;
    }

    @Override
    public void Traversal() throws QueueEmptyException {

    }
}
