package leetcode;

public class MyNode {
    private Object element;
    private MyNode next;

    public MyNode() {
    }

    public MyNode(Object element) {
        this.element = element;
    }

    public MyNode(Object element, MyNode next) {
        this.element = element;
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }
}
