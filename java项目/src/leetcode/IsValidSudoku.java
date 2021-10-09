package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class IsValidSudoku {
    public static void main(String[] args) {
        int[] n=new int[]{1,2,3,4,5};
        for(int i=0;i<n.length;i++)
            n[i]=0;
        for (int k:n)
            System.out.println(k);
    }
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] columns = new HashSet[9];
        HashSet<Integer>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Integer>();
            columns[i] = new HashSet<Integer>();
            boxes[i] = new HashSet<Integer>();
        }
        for(int i=0;i<board.length;i++)
            for (int j=0;j<board[0].length;j++)
            {
                char c=board[i][j];
                if(c!='.')
                {
                    int n1=(char)c;
                    if(rows[i].add(n1)==false)return false;
                    if(columns[j].add(n1)==false)return false;
                    if(boxes[3*(i/3)+(j/3)].add(n1)==false)return false;
                }
            }
        return true;
    }

}