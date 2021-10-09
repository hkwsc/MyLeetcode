package leetcode;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int k=0;
        int length=nums.length;
        for(int i=0;i<nums.length-k;)
        {
            if(nums[i]==val)
                k++;
            else
                i++;
            if(i<length-k)
            nums[i]=nums[i+k];
        }
        return length-k;
    }

    public static void main(String[] args) {
        int[] n=new int[]{1,2,3,4,5,5,4,7,8,4,5,7,8,6};
        int val=4;
        removeElement(n,val);
    }
}
