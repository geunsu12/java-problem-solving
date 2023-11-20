package BJ;

import java.util.Scanner;

public class bj2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int index = 0;

        for (int i=0;i<9;i++) {
            int input = sc.nextInt();
            if (max < input) {
                max = input;
                index = i+1;
            }
        }
        sc.close();
        System.out.println(max);
        System.out.println(index);

    }
}
