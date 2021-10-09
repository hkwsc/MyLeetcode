package leetcode;

public class MyDLNode implements MyPosition{
    private Object element;
    private MyDLNode prev;
    private MyDLNode next;
    public MyDLNode()
    {
        this(null,null,null);
    }
    public MyDLNode(Object element)
    {
        this(element,null,null);
    }
    public MyDLNode(Object element, MyDLNode prev, MyDLNode next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public MyDLNode getPrev() {
        return prev;
    }

    public void setPrev(MyDLNode prev) {
        this.prev = prev;
    }

    public MyDLNode getNext() {
        return next;
    }

    public void setNext(MyDLNode next) {
        this.next = next;
    }
}
