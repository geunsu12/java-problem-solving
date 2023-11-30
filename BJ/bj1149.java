package BJ;

import java.util.*;
import java.io.*;

public class bj1149 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        int n = toInt(br.readLine());
        cost = new int[n][3];

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<3;j++) {
                cost[i][j] = toInt(st.nextToken());
            }
        }

        for (int i=1;i<n;i++) {
            runDP(i);
        }
        int result = Math.min(Math.min(cost[n-1][0],cost[n-1][1]),cost[n-1][2]);
        System.out.println(result);
    }

    static int toInt(String str) {
        return Integer.parseInt(str);
    }

    static void runDP(int i) {
        cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
        cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
        cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
    }

}
