package leetcode;
public class Trap {
    public static void main(String[] args) {
        int[] n=new int[]{4,2,3};
        System.out.println(trap(n));
    }
    public static int trap(int[] height) {
        int i=0,j=0;
        int capacity=0;
        while (i<height.length-1)
        {
            int other=0;
            j=i+1;
            while (j<height.length&&height[j]<height[i]) {
                other+=height[j];
                j++;
            }
            if(j!=height.length) {
                capacity += (j - i - 1) * height[i] - other;
                i = j;
            }
            else
                i++;
        }
        return capacity;
    }
}
