package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums=new int[]{-1,2,1,-4};
        int target=1;
        System.out.println(threeSumClosest(nums,target));
    }
    public static int threeSumClosest(int[] nums, int target) {
        int length=nums.length;
        int i,j,k;
        int recentNum=nums[0]+nums[1]+nums[length-1]-target;
        Arrays.sort(nums);
        for(i=0;i<length-2;i++)
        {
            j=i;
            k=length-1;
            int num=nums[i];
            for(j=i+1;j<length-1;j++)
            {
                if(j>i+1&&nums[j]==nums[j-1])continue;
                while (j<k&&nums[j]+nums[k]+nums[i]>target)k--;
                if(j==k)
                {
                    if(nums[j]+nums[j+1]+nums[i]-target==0)return target;
                    if(Math.abs(nums[j]+nums[j+1]+nums[i]-target)<Math.abs(recentNum))
                    {
                        recentNum=nums[j]+nums[j+1]+nums[i]-target;
                    }
                }
                else
                {
                    if(nums[j]+nums[k]+nums[i]-target==0)return target;
                    if(Math.abs(nums[j]+nums[k]+nums[i]-target)<Math.abs(recentNum))
                    {
                        recentNum=nums[j]+nums[k]+nums[i]-target;
                    }
                    if(k<length-1)
                    {
                        if(Math.abs(nums[j]+nums[k+1]+nums[i]-target)<Math.abs(recentNum))
                        {
                            recentNum=nums[j]+nums[k+1]+nums[i]-target;
                        }
                    }
                }
            }
        }
        return target+recentNum;
    }
}