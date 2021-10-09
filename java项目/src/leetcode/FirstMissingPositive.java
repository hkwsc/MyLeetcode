package leetcode;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<0)
                nums[i]=n+1;
        }
        for(int i=0;i<n;i++)
        {
            int j=Math.abs(nums[i]);
            if(j<=n)
                nums[j-1]=-(Math.abs(nums[j-1]));
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
                return i+1;
        }
        return n+1;
    }
}
