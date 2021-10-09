package leetcode;

import java.util.List;

public class MySort {
    public void mergeSort(List<Comparable> s,int n)
    {
        if(n>1)
        {
            merge(s,0,n-1);
        }

    }
    public void merge(List<Comparable> s,int lh,int rh)
    {
        if(rh==lh)
            return;
        else if(rh==lh+1) {
            if (s.get(lh).compareTo(s.get(rh))>0) {
                Comparable temp=s.get(lh);
                s.set(lh,s.get(rh));
                s.set(rh,temp);
            }
        }
        merge(s,lh,lh+(lh+rh)/2);
    }
}
