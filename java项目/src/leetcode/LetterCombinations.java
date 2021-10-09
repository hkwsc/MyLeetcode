package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        List<Character[]> letterList=new ArrayList();
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        StringBuilder builder=new StringBuilder(digits);
        List<String> strings=new ArrayList<>();
        int i=0;
        while (i<builder.length())
        {
            addLetter(strings,builder.charAt(i),phoneMap);
            i++;
        }
        return strings;
    }
    public static List<String> addLetter(List<String> digits,char num,Map<Character,String> map)
    {
        int length=digits.size();
        if(length==0)
        {
            String s=map.get((char)num);
            for(int j=0;j< s.length();j++)
            {
                digits.add(s.charAt(j)+"");
            }
        }
        for(int i=0;i<length;i++)
        {
            String s=map.get((char)num);
            for(int j=1;j< s.length();j++)
            {
                digits.add(digits.get(i) +s.charAt(j));
            }
            digits.set(i,digits.get(i)+s.charAt(0));
        }
        return digits;
    }
}
