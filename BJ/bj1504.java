package BJ;

import java.util.*;
import java.io.*;

public class bj1504 {

    public class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        int N = toInt(st.nextToken());
        int E = toInt(st.nextToken());

        
    }

    public static int toInt(String str) {
        return Integer.parseInt(str);
    }
}
