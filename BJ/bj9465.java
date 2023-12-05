package BJ;

import java.util.*;
import java.io.*;

public class bj9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = toInt(br.readLine());
        
        for (int t=0;t<T;t++) {
            int n = toInt(br.readLine());
            int[][] stickers = new int[2][n];
            for (int j=0;j<2;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i=0;i<n;i++) {
                    stickers[j][i] = toInt(st.nextToken());
                }                 
            }
            
            if (n>1) {
                stickers[0][1] = stickers[1][0] + stickers[0][1];
                stickers[1][1] = stickers[0][0] + stickers[1][1];
            }

            
            for (int i=2;i<n;i++) {
                for (int j=0;j<2;j++) {
                    int maxValue = Math.max(Math.max(stickers[1-j][i-2],stickers[j][i-2]),stickers[1-j][i-1]);
                    stickers[j][i] = stickers[j][i] + maxValue;
                }
            }
            int maxValue = 0;
            for (int j=0;j<2;j++) {
                for (int i=0;i<n;i++) {
                    maxValue = Math.max(maxValue,stickers[j][i]);
                }
            }
            System.out.println(maxValue);
        }
    }

    public static int toInt(String str) {
        return Integer.parseInt(str);
    }
}
