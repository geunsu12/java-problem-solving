package BJ;

import java.util.*;
import java.io.*;

public class bj2108 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> maxList = new ArrayList<Integer>();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int tmp;
        double sum = 0;
        for (int i=0;i<n;i++) {
            tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;
            sum += (double)tmp;
            map.put(tmp, map.getOrDefault(tmp,0)+1);
        }

        Arrays.sort(arr);

        int maxMap = Collections.max(map.values());

        for (int num : map.keySet()) {
            if (map.get(num) == maxMap) {
                maxList.add(num);
            }
        }

        int maxMapValue;
        if (maxList.size() == 1) {
            maxMapValue = maxList.get(0);
        } else {
            Collections.sort(maxList);
            maxMapValue = maxList.get(1);
        }

        int minValue = arr[0];
        int maxValue = arr[arr.length-1];
        int avgValue = (int)Math.round(sum / n);
        int medValue = arr[(int)(n/2)];

        System.out.println(avgValue);
        System.out.println(medValue);
        System.out.println(maxMapValue);
        System.out.println(maxValue-minValue);
        

    }
}
