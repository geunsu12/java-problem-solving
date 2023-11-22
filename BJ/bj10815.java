package BJ;

import java.util.*;
import java.io.*;

public class bj10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0;i<n;i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(cards);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i=0;i<m;i++) {
            int tmp = binarySearch(cards, 0, n, Integer.parseInt(st.nextToken()));
            sb.append(tmp+" ");
        }

        System.out.println(sb);

    }

    public static int binarySearch(int[] cards, int minIdx, int maxIdx, int target) {
        
        int midIdx = (maxIdx+minIdx)/2;
        if (minIdx == midIdx) {
            if (cards[minIdx] == target) return 1;
            else return 0;
        }
        if (cards[midIdx] > target) {
            return binarySearch(cards, minIdx, midIdx, target);
        } else {
            return binarySearch(cards, midIdx, maxIdx, target);
        }
    }
}
