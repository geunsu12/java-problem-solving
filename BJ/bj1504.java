package BJ;

import java.util.*;
import java.io.*;

public class bj1504 {

    static ArrayList<ArrayList<Node>> graph;
    static long[] dist;
    static boolean[] visited;
    static final int INF = 2000000000;

    static class Node {
        int idx;
        long cost;

        public Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = toInt(st.nextToken());
        int E = toInt(st.nextToken());

        graph = new ArrayList<>();
        dist = new long[N+1];
        visited = new boolean[N+1];

        for (int i=0;i<N+1;i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int a = toInt(st.nextToken());
            int b = toInt(st.nextToken());
            int c = toInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = toInt(st.nextToken());
        int v2 = toInt(st.nextToken());


        // 1->v1->v2->N
        long result1 = 0;
        result1 += dijkstra(1,v1);
        result1 += dijkstra(v1,v2);
        result1 += dijkstra(v2,N);

        // 1->v2->v1->N
        long result2 = 0;
        result2 += dijkstra(1,v2);
        result2 += dijkstra(v2,v1);
        result2 += dijkstra(v1,N);
        if (result1 >= INF && result2 >= INF) {
            System.out.println("-1");
        } else {
            System.out.println(Math.min(result1, result2));
        }
                
    }
    
    public static long dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>((o1,o2) -> Long.compare(o1.cost, o2.cost));

        Arrays.fill(dist, INF);
        dist[start] = 0;
        queue.offer(new Node(start,0));
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();

            if (tmp.cost != dist[tmp.idx]) { continue; }

            for (int i=0;i<graph.get(tmp.idx).size();i++) {
                Node nextNode = graph.get(tmp.idx).get(i);
                if (dist[nextNode.idx] > tmp.cost + nextNode.cost) {
                    dist[nextNode.idx] = tmp.cost + nextNode.cost;
                    queue.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }
        return dist[end];
    }

    public static int toInt(String str) {
        return Integer.parseInt(str);
    }
}
