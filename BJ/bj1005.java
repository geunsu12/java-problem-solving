package BJ;

import java.util.*;
import java.io.*;

public class bj1005 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i=0;i<t;i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] times = new int[n+1];
            boolean[][] graph = new boolean[n+1][n+1];
            int[] link = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for (int j=1;j<n+1;j++) {
                times[j] = Integer.parseInt(st.nextToken());
            }
            for (int j=0;j<k;j++) {
                st = new StringTokenizer(br.readLine());
                int pre = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());
                graph[pre][next] = true;
                link[next]++;
            }
            
            int w = Integer.parseInt(br.readLine());

            int[] buildTime = sort(times, graph, link);
            sb.append(buildTime[w]).append('\n');            
        }
        System.out.println(sb);
    }

    public static int[] sort(int[] times, boolean[][] graph, int[] link) {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[link.length];

        for (int i=1;i<link.length;i++) {
            if (link[i] == 0) {
                result[i] = times[i];
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int prev = q.poll();

            for (int i=1;i<link.length;i++) {
                if (graph[prev][i]) {
                    result[i] = Math.max(result[i], result[prev]+times[i]);
                    link[i]--;
                    if (link[i] == 0){ q.add(i);}
                }
            }
        }

        return result;
    }
}
