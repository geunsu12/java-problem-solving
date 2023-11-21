package BJ;

import java.io.*;
import java.util.*;

public class bj2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] paper = new int[100][100];

        int n = Integer.parseInt(st.nextToken());

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            for (int k=90-y;k<100-y;k++) {
                for (int j=x;j<10+x;j++) {
                    paper[k][j] = 1;
                }
            }
        }
        int result = 0;
        for (int j=0;j<100;j++) {
            for(int i=0;i<100;i++) {
                if (paper[j][i] == 1) result += 1;
            }
        }

        System.out.println(result);
    }
}
