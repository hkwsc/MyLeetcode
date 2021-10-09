package leetcode;

public class SearchInsert {
    public static void main(String[] args) {
        int[] n=new int[]{1,3,5,6};
        System.out.println(searchInsert(n,0));
    }
    public static int searchInsert(int[] nums, int target) {
        int[] c=twoSearch(nums,target);
        int i,j;
        if(c[0]!=-1)
            return c[0];
        if(c[1]<0)c[1]=0;
        if(c[1]>=nums.length)c[1]=nums.length-1;
        if(target<nums[c[1]])
        {
            for (i=c[1];i>=0&&nums[i]>target;i--);
            if(i<0)return 0;
            return i+1;
        }
        else
        {
            for(j=c[1];j<nums.length&&nums[j]<target;j++)
                if(j==nums.length)return j;
                return j;
        }
    }
    static int[] twoSearch(int[] n,int target)
    {
        int nums[]=new int[3];
        int low=0,high=n.length-1;
        int mid;
        while (low<high)
        {
            mid=(low+high)/2;
            if(n[mid]==target) {
                nums[0]=mid;
                return nums;
            }
            else if(n[mid]>target)
                high=mid-1;
            else
                low=low+1;
        }
        nums[0]=-1;
        nums[1]=low;
        nums[2]=high;
        return nums;
    }
}
