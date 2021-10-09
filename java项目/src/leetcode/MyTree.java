package leetcode;

import java.util.Queue;

public class MyTree {
    MyTree parent=null;
    Object data=null;
    MyTree firstChild=null;
    MyTree nextSibling=null;
    MyTree(){}
    MyTree(Object data){this.data=data;}
    MyTree(Object data,MyTree firstChild,MyTree nextSibling)
    {
        this.data=data;
        this.firstChild=firstChild;
        this.nextSibling=nextSibling;
    }
    MyTree(MyTree parent,Object data,MyTree firstChild,MyTree nextSibling)
    {
        this(data,firstChild,nextSibling);
        this.parent=parent;
    }
    public Object getElement()
    {
        return data;
    }
    public Object setElement(Object e)
    {
        Object term=data;
        data=e;
        return term;
    }
    public MyTree getParent()
    {
        return parent;
    }
    public MyTree getFristChild()
    {
        return firstChild;
    }
    public MyTree getNextSibling()
    {
        return nextSibling;
    }
    //public int getSize()
    //{
    //    MyQueue myQueue=new MyQueue();
    //    if(firstChild==null)return 0;
    //    int num=0;
    //    myQueue.enqueue(this);
    //    while (!myQueue.isEmpty())
    //    {
    //        num++;
    //        MyTree child=(MyTree) myQueue.dequeue();
    //        if(child.getFristChild()!=null) {
    //                myQueue.enqueue(child.getFristChild());
    //                child = child.getNextSibling();
    //                for (; child != null; child = child.getNextSibling())
    //                    myQueue.enqueue(child);
    //        }
    //    }
    //    return num;
    //}
    public int getSize()
    {
        int num=1;
        MyTree next=firstChild;
        while (next!=null)
        {
            num+=next.getSize();
            next=next.getNextSibling();
        }
        return num;
    }
    public int getHeight()
    {
        int num=-1;
        MyTree next=firstChild;
        while (next!=null)
        {
            num=Math.max(num,(int) next.getHeight());
            next=next.getNextSibling();
        }
        return num+1;
    }
    public int getDepth()
    {
        int depth=0;
        MyTree parent=getParent();
        while (parent!=null)
        {
            depth++;
            parent=parent.getParent();
        }
        return depth;
    }
    public void preOrderTraversal(MyTree myTree) {
        if (myTree != null) {
            MyTree next = myTree.firstChild;
            while (next != null) {
                preOrderTraversal(next);
                next = nextSibling;
            }
        }
    }
}
