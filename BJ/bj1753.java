package BJ;

import java.util.*;
import java.io.*;

public class bj1753 {
    static int INF = 10000000;

    static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = toInt(st.nextToken());
        int E = toInt(st.nextToken());
        int K = toInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();  
        for (int i=0;i<V+1;i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int u = toInt(st.nextToken());
            int v = toInt(st.nextToken());
            int w = toInt(st.nextToken());
            graph.get(u).add(new Node(v,w));
        }

        int[] dist = new int[V+1];

        for (int i=0;i<V+1;i++) {
            dist[i] = INF;
        }
        PriorityQueue<Node> queue = new PriorityQueue<Node>((o1,o2)-> Integer.compare(o1.cost, o2.cost));
        queue.offer(new Node(K,0));
        dist[K] = 0;

        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            if (dist[temp.idx] < temp.cost) {
                continue;
            }

            for (int i=0;i<graph.get(temp.idx).size();i++) {
                Node nextNode = graph.get(temp.idx).get(i);
                if (dist[nextNode.idx] > temp.cost + nextNode.cost) {
                    dist[nextNode.idx] = temp.cost+nextNode.cost;
                    queue.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }
    }

    public static int toInt(String str) {
        return Integer.parseInt(str);
    }
}
