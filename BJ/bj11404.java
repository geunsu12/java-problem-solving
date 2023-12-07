package BJ;

import java.util.*;
import java.io.*;

public class bj11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = toInt(br.readLine());
        int m = toInt(br.readLine());

        int INF = 200000000;
        int[][] map = new int[n+1][n+1];

        for (int i=0;i<n+1;i++) {
            for (int j=0;j<n+1;j++) {
                if (i == j) { map[i][j] = 0; }
                else { map[i][j] = INF; }
            }
        }

        for (int i=0;i<m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = toInt(st.nextToken());
            int to = toInt(st.nextToken());
            int cost = toInt(st.nextToken());
            map[from][to] = Math.min(map[from][to],cost);
        }

        for (int mid=0;mid<n+1;mid++) {
            for (int from=0;from<n+1;from++) {
                for (int to=0;to<n+1;to++) {
                    if (map[from][to] > map[from][mid] + map[mid][to]) {
                        map[from][to] = map[from][mid] + map[mid][to];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i=1;i<n+1;i++) {
            for (int j=1;j<n+1;j++) {
                if (map[i][j] == INF) {
                    sb.append("0 ");        
                } else {
                    sb.append(map[i][j]+" ");
                }
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    public static int toInt(String str) {
        return Integer.parseInt(str);
    }
}
