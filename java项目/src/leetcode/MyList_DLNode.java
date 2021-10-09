package leetcode;

import java.util.Iterator;
import java.util.List;

class ExceptionPositionInvalid extends RuntimeException
{
    ExceptionPositionInvalid(String e)
    {
        super(e);
    }
}
class ExceptionListEmpty extends RuntimeException
{
    ExceptionListEmpty(String e)
    {
        super(e);
    }
}
interface MyList
{
    public int getSize();
    public boolean isEmpty();
    public MyPosition first();
    public MyPosition last();
    public MyPosition getNext(MyPosition p);
    public MyPosition getPrev(MyPosition p);
    public MyPosition insertFirst(Object e);
    public MyPosition insertLast(Object e);
    public MyPosition insertAfter(MyPosition p,Object e);
    public MyPosition insertBefore(MyPosition p,Object e);
    public Object remove(MyPosition p)throws ExceptionPositionInvalid;
    public Object removeFirst();
    public Object removeLast();
    public Object replace(MyPosition p,Object e)throws ExceptionPositionInvalid;
    public Iterator positions();
    public Iterator elements();
}
public class MyList_DLNode implements MyList{
    protected int numElem;
    protected MyDLNode header,trailer;
    MyList_DLNode()
    {
        header=new MyDLNode();
        trailer=new MyDLNode();
        header.setNext(trailer);
        trailer.setPrev(header);
    }
    public MyDLNode checkPosition(MyPosition p)throws ExceptionPositionInvalid
    {
        if(null==p)
            throw new ExceptionPositionInvalid("p is null");
        else if(p==header)
            throw new ExceptionPositionInvalid("p is head");
        else if(p==trailer)
            throw new ExceptionPositionInvalid("p is trailer");
        return (MyDLNode) p;
    }
    @Override
    public int getSize() {
        return numElem;
    }

    @Override
    public boolean isEmpty() {
        return getSize()==0;
    }

    @Override
    public MyPosition first() throws ExceptionListEmpty{
        if(isEmpty())
            throw new ExceptionListEmpty("ListIsEmpty");
        return header.getNext();
    }

    @Override
    public MyPosition last() throws ExceptionListEmpty{
        if(isEmpty())
            throw new ExceptionListEmpty("ListIsEmpty");
        return trailer.getPrev();
    }

    @Override
    public MyPosition getNext(MyPosition p) throws ExceptionBoundaryViolation{
        MyDLNode v=checkPosition(p).getNext();
        if(v==trailer)
            throw new ExceptionBoundaryViolation("next is trailer");
        return v;
    }

    @Override
    public MyPosition getPrev(MyPosition p) throws ExceptionBoundaryViolation{
        MyDLNode v=checkPosition(p);
        MyDLNode prev=v.getPrev();
        if(prev==header)
            throw new ExceptionBoundaryViolation("prev is header");
        return prev;
    }

    @Override
    public MyPosition insertFirst(Object e) {
        numElem++;
        MyDLNode v=new MyDLNode(e,header,header.getNext());
        header.setNext(v);
        v.getNext().setPrev(v);
        return v;
    }

    @Override
    public MyPosition insertLast(Object e) {
        MyDLNode v=new MyDLNode(e,trailer.getPrev(),trailer);
        trailer.setPrev(v);
        v.getPrev().setNext(v);
        numElem--;
        return v;
    }

    @Override
    public MyPosition insertAfter(MyPosition p, Object e)throws ExceptionPositionInvalid {
        numElem++;
        MyDLNode v=checkPosition(p);
        MyDLNode v2=new MyDLNode(e,v,v.getNext());
        v.setNext(v2);
        v2.getNext().setPrev(v2);
        return v2;
    }

    @Override
    public MyPosition insertBefore(MyPosition p, Object e) throws ExceptionPositionInvalid{
        numElem++;
        MyDLNode v=checkPosition(p);
        MyDLNode v2=new MyDLNode(e,v.getPrev(),v);
        v.setPrev(v2);
        v2.getPrev().setNext(v2);
        return v2;
    }

    @Override
    public Object remove(MyPosition p) throws ExceptionPositionInvalid {
        numElem--;
        MyDLNode v=checkPosition(p);
        v.getPrev().setNext(v.getNext());
        v.getNext().setPrev(v.getPrev());
        Object e=v.getElement();
        return e;
    }

    @Override
    public Object removeFirst() throws ExceptionListEmpty{
        return remove(header.getNext());
    }

    @Override
    public Object removeLast() {
        return remove(trailer.getPrev());
    }
    @Override
    public Object replace(MyPosition p, Object e) throws ExceptionPositionInvalid {
        MyDLNode v=checkPosition(p);
        Object element=v.getElement();
        v.setElement(e);
        return element;
    }
    @Override
    public Iterator positions()
    {
        return new ListIterator(this);
    }

    @Override
    public Iterator elements() {
        return new ListIterator(this);
    }
}

class ListIterator implements Iterator
{
    private MyPosition nextPosition;
    private MyList list;
    ListIterator()
    {

    }
    ListIterator(MyList_DLNode l)
    {
        list=l;
        if(list.isEmpty())
            nextPosition=null;
        else
        nextPosition=list.first();
    }
    @Override
    public boolean hasNext() {
        return nextPosition!=null;
    }

    @Override
    public Object next() {
        if(!hasNext())throw new ExceptionBoundaryViolation("no next position");
        MyPosition currentPosition=nextPosition;
        if(currentPosition==list.last())
            nextPosition=null;
        else
            nextPosition=list.getNext(nextPosition);
        return currentPosition;
    }
}

