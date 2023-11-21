package BJ.review;

import java.util.*;

public class bj3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Set<Integer> set = new HashSet<Integer>();

        for (int i=0;i<10;i++) {
            set.add(sc.nextInt()%42);
        }
        sc.close();

        System.out.println(set.size());
        
    }
}
