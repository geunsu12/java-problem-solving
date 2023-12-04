package BJ;

import java.util.*;
import java.io.*;

public class bj1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = toString(br.readLine());
        int[][] triangle = new int[n][n];


        for (int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0;j<i+1;j++) {
                triangle[i][j] = toString(st.nextToken());
            }
        }

        for (int i=1;i<n;i++) {
            triangle[i][0] = triangle[i-1][0] + triangle[i][0];
            for (int j=1;j<n;j++) {
                triangle[i][j] = triangle[i][j] + Math.max(triangle[i-1][j], triangle[i-1][j-1]);
            }
        }

        int result = 0;

        for (int i=0;i<n;i++) {
            result = Math.max(result,triangle[n-1][i]);
        }

        System.out.println(result);

    }

    public static int toString(String str) {
        return Integer.parseInt(str);
    }
}
