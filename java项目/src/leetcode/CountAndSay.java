package leetcode;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }
    public static String countAndSay(int n) {
        if(n==1)return "1";
        int k=1;
        StringBuilder builder=new StringBuilder("1");
        StringBuilder builder1=new StringBuilder();
        for(int i=0;i<n-1;i++)
        {
            int num=0;
            char val=0;
            for(int j=0;j<builder.length();j++)
            {
                if(j==0)
                {
                    num=1;val=builder.charAt(j);
                }
                else if(j>0&&builder.charAt(j)==builder.charAt(j-1))
                {
                    num++;
                }
                else
                {
                    builder1.append(num);
                    builder1.append(val);
                    num=1;
                    val=builder.charAt(j);
                }
            }
            builder1.append(num);
            builder1.append(val);
            builder.delete(0,builder.length());
            builder.append(builder1);
            builder1.delete(0,builder1.length());
        }
        return builder.toString();
    }
}
