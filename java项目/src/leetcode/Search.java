package leetcode;

public class Search {
    public static void main(String[] args) {
        int[] n=new int[]{4,5,6,7,1,2};
        System.out.println(search(n,5));
    }
    public static int search(int[] nums, int target) {
        int i=0,j=0;
        int[] n=new int[nums.length];
        while (i<nums.length-1&&nums[i]<nums[i+1])
        {
            i++;
        }
        if(i==nums.length-1)
        {
            return twoSearch(nums,target);
        }
        for(j=0;j<(nums.length-i-1);j++)
        {
            n[j]=nums[j+i+1];
        }
        for(int k=0;k<=i;k++)
        {
            n[j+k]=nums[k];
        }
        int c=twoSearch(n,target);
        if(c<0)
            return -1;
        else if(c<j)
            return c+i+1;
        else
            return c-j;
    }
    public static int twoSearch(int[] n,int target)
    {
        int low=0,high=n.length-1;
        int mid=(low+high)/2;
        while (low<=high)
        {
            mid=(low+high)/2;
            if(n[mid]==target)
                return mid;
            else if(n[mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}
