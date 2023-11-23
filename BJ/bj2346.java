package BJ;

import java.util.*;
import java.io.*;

public class bj2346 {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0;i<n;i++) {
            deque.add(new int[] {i+1,Integer.parseInt(st.nextToken())});
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("1 ");
        int[] nowDeque = deque.poll();
        int nextDeque = nowDeque[1];

        while(!deque.isEmpty()) {
            if (nextDeque > 0) {
                for (int i=0;i<nextDeque-1;i++) {
                    deque.add(deque.poll());
                }
                nowDeque = deque.poll();
                nextDeque = nowDeque[1];
                sb.append(nowDeque[0] + " ");
            }
            else {
                for (int i=0;i<-nextDeque-1;i++) {
                    deque.addFirst(deque.pollLast());
                }

                nowDeque = deque.pollLast();
                nextDeque = nowDeque[1];
                sb.append(nowDeque[0] + " ");
            }    
        }

        System.out.println(sb);
    }
}