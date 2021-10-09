package leetcode;

public class SearchRange {
    public static void main(String[] args) {
    }
    public int[] searchRange(int[] nums, int target) {
        int[] n=new int[]{-1,-1};
        int i,j;
        int c=twoSearch(nums,target);
        if(c!=-1) {
            for (i =c;i>0&&nums[i]==target;i--);
            for (j=c;j<nums.length&&nums[j]==target;j++);
            n[0]=i+1;
            n[1]=j-1;
        }
        return n;
    }
    static int twoSearch(int[] n,int target)
    {
        int low=0,high= n.length-1;
        int mid;
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
        System.out.println(low+"'"+high);
        return -1;
    }
}
