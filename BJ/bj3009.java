package BJ;

import java.util.*;

public class bj3009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] x = new int[3];   
        int[] y= new int[3];
        int newX, newY;

        for(int i=0;i<3;i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        
        if(x[1] == x[2]) {
            newX = x[0];
        } else {
            newX = (x[0] == x[1] ? x[2]:x[1]);
        }

        if(y[1] == y[2]) {
            newY = y[0];
        } else {
            newY = (y[0] == y[1] ? y[2]:y[1]);
        }
        sc.close();
        
        System.out.println(newX+" "+newY);
   
    }
}
