package BJ.review;

import java.util.Scanner;

public class bj2562 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int index = 0;
        int tmp;
        for(int i=0;i<9;i++){
            tmp = sc.nextInt();
            if(max<tmp) {
                max = tmp;
                index = i;
            }
        }
        sc.close();
        System.out.println(max);
        System.out.println(index);
    }
    
}
