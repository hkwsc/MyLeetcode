package leetcode;
class test1
{
    public static void main(String[] args) {

    }
}
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length<2)return;
        int temp=0,i,j,length=nums.length;
        for(i=length-1;i>0;i--)
        {
            if(nums[i]>nums[i-1])
            {
                for(j=length-1;nums[j]<=nums[i-1];j--);
                System.out.println(nums[j]+"'"+nums[i-1]);
                swap(nums, i - 1, j);
                reverse(nums,i,length-1);
                return;
            }
        }
                reverse(nums,0,length-1);
    }
    public void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int[] nums,int low,int high)
    {
        int temp;
        for(int i=0;i<(high-low+1)/2;i++)
        {
            temp=nums[i+low];
            nums[i+low]=nums[high-i];
            nums[nums.length-1-i]=temp;
        }
    }
    public void sort(int[] n,int low,int high)
    {
        if(low>=high)return;
        int num=n[low];
        int i=low,j=high;
        while (i<j)
        {
            for(;j>i&&n[j]>=num;j--);
            for(;j>i&&n[i]<=num;i++);
            swap(n,i,j);
        }
        n[low]=n[i];
        n[i]=num;
        sort(n,low,i-1);
        sort(n,i+1,high);
        return;
    }
}
