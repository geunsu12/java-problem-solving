package BJ;

import java.util.*;
import java.io.*;

public class bj11053 {
    static int[] results;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = toInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        results = new int[n];

        for (int i=0;i<n;i++){
            a[i] = toInt(st.nextToken());
        }
        
        results[0] = a[0];
        int idx = 0;
        
        for (int i=1;i<n;i++) {
            if (results[idx] < a[i]) {
                results[idx++] = a[i];
            }
            else if (results[idx] == a[i]) {
                int tmpIdx = binarySearch(0,idx,a[i]);
            }
        }
    }

    public static int toInt(String str) {
        return Integer.parseInt(str);
    }

    public static int binarySearch(int st, int end, int target) {
        if (st == end) { return st; }
        int mid = (st+end)/2;

        if (results[mid] < target) {
            return binarySearch(mid,end,target);
        }
        else {
            return binarySearch(st,mid,target);
        }
    }

}
