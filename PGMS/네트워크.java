package PGMS;

import java.util.*;

class 네트워크 {
    
    ArrayList<ArrayList<Integer>> graph; 
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        graph = new ArrayList<>();
        
        visited = new boolean[n];
        Arrays.fill(visited, false);
        
        for (int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int j=0;j<computers.length;j++) {
            for (int i=0;i<computers[0].length;i++) {
                // System.out.println(computers[j][i]);
                if (i != j && computers[j][i] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        
        for (int i=0;i<n;i++) {
            if (visited[i] == false) {
                answer++;
                visited[i] = true;
                dfs(i);
            }
        }
        
        return answer;
    }
    
    public void dfs(int node) {
        
        for (int i=0;i<graph.get(node).size();i++) {
            if (visited[graph.get(node).get(i)] == false) {
                visited[graph.get(node).get(i)] = true;
                dfs(graph.get(node).get(i));
            }    
        }
        
    }
    
}