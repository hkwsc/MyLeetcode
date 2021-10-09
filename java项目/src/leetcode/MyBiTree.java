package leetcode;

import java.util.Iterator;
import java.util.List;

public class MyBiTree {
    public Object element;
    public MyBiTree parent;
    public MyBiTree lChild;
    public MyBiTree rChild;
    public int size;
    public int height;
    public int depth;
    public MyBiTree()
    {
        this(null,null,true,null,null);
    }
    public MyBiTree(Object element,MyBiTree parent,boolean asLChild,MyBiTree lChild,MyBiTree rChild)
    {
            size=1;
            height=depth=0;
            parent=lChild=rChild=null;
            this.element=element;
            if(asLChild)parent.attachL(this);
            else parent.attachR(this);
            if(null!=lChild)this.attachL(lChild);
            if(null!=rChild)this.attachR(rChild);
    }

    public boolean hasParent()
    {
        return parent!=null;
    }
    public boolean hasLChild()
    {
        return lChild!=null;
    }
    public boolean hasRChild()
    {
        return rChild!=null;
    }
    public boolean isLeaf()
    {
        return !hasLChild()&&!hasRChild();
    }
    public boolean isLChild()
    {
        return hasParent()&&getParent().getlChild()==this;
    }
    public boolean isrChild()
    {
        return  hasParent()&&getParent().getrChild()==this;
    }
    public void updateSize()
    {
        size=1;
        if(hasLChild())size+=lChild.getSize();
        if(hasRChild())size+= rChild.getSize();
        if(hasParent())getParent().updateSize();
    }
    public void updateHeight()
    {
        height=0;
        if(hasLChild())height=Math.max(height,1+ lChild.height);
        if(hasRChild())height=Math.max(height,1+ rChild.height);
        if(hasParent())getParent().updateHeight();
    }
    public void updateDepth()
    {
        depth=hasParent()?getParent().getDepth()+1:0;
        if(hasLChild())getlChild().updateDepth();
    }
    public MyBiTree getPrev()
    {
        MyBiTree bak;
        if(hasLChild())
        {
            bak=getlChild();
            while (bak.hasRChild())
                bak=bak.getrChild();
            return bak;
        }
        if(isrChild())return getParent();
        MyBiTree v=this;
        while (v.isLChild())v=v.getParent();
        return v.getParent();
    }
    public MyBiTree getSucc()
    {
        if(hasRChild())
        {
            MyBiTree bak=rChild;
            while (bak.lChild!=null)
                bak=bak.lChild;
            return bak;
        }
        if(isLChild())return parent;
        MyBiTree v=parent;
        while (v.isrChild())v=v.parent;
        return v.parent;
    }
    public MyBiTree secede()
    {
        if(isLChild())
        {
            parent.lChild=null;
        }
        else if(isrChild())
        {
            parent.rChild=null;
        }
        else
            return this;
        parent.updateHeight();
        parent.updateSize();
        parent=null;
        updateDepth();
        return this;
    }
    public MyBiTree attachL(MyBiTree c)
    {
        if(null==c)return this;
        c.secede();
        lChild=c;
        c.parent=this;
        updateHeight();
        updateSize();
        c.updateDepth();
        return this;
    }
    public MyBiTree attachR(MyBiTree c)
    {
        if(null==c)return this;
        c.secede();
        setrChild(c);
        c.setParent(this);
        updateHeight();
        updateSize();
        c.updateDepth();
        return this;
    }
    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public MyBiTree getParent() {
        return parent;
    }

    public void setParent(MyBiTree parent) {
        this.parent = parent;
    }

    public MyBiTree getlChild() {
        return lChild;
    }

    public void setlChild(MyBiTree lChild) {
        this.lChild = lChild;
    }

    public MyBiTree getrChild() {
        return rChild;
    }

    public void setrChild(MyBiTree rChild) {
        this.rChild = rChild;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
