package BJ;

import java.io.*;
import java.util.*;

public class bj25501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i=0;i<t;i++) {
            String target = br.readLine();
            int[] tmp = isPalindrome(target);
            System.out.println(tmp[0]+" "+tmp[1]);

        }
    }

    public static int[] recur(String s , int l,int r, int depth) {
        if (l >= r) return new int[] {1, depth};
        else if (s.charAt(l) != s.charAt(r)) return new int[]{0, depth};
        else return recur(s, l+1, r-1,depth+1);
    }

    public static int[] isPalindrome(String s) {
        return recur(s, 0,s.length()-1,1);
    }
}
