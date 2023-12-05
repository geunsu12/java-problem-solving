package BJ;

import java.io.*;
import java.util.*;

public class bj11725 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] parent = new int[n+1];

        for (int i=0;i<n+1;i++) {
            list.add(new ArrayList<>());
        }

        for (int i=0;i<n-1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = toString(st.nextToken());
            int to = toString(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }

        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();

        visited[1] = true;

        queue.add(1);

        while(!queue.isEmpty()) {
            int curNode = queue.poll();

            for (int nextNode : list.get(curNode)) {
                if (visited[nextNode] == true) continue;
                visited[nextNode] = true;
                queue.add(nextNode);
                parent[nextNode] = curNode;
            }
        }

        for (int i=2;i<n+1;i++) {
            System.out.println(parent[i]);
        }

        
    }

    public static int toString(String str) {
        return Integer.parseInt(str);
    }
}
