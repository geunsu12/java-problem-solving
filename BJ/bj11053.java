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
        results = new int[n+1];

        for (int i=0;i<n;i++){
            a[i] = toInt(st.nextToken());
        }
        
        results[0] = a[0];
        int idx = 0;
        
        for (int i=1;i<n;i++) {
            if (results[idx] < a[i]) {
                idx++;
                results[idx] = a[i];
            }
            else {
                int tmpIdx = binarySearch(0,idx,a[i]);
                results[tmpIdx] = a[i];
            }
        }
        for (int i=0;i<n+1;i++) {
            if (results[i] == 0) {
                System.out.println(i);
                break;
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
            return binarySearch(mid+1,end,target);
        }
        else {
            return binarySearch(st,mid,target);
        }
    }
}
