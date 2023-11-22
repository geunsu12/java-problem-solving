package BJ.review;

import java.io.*;
import java.util.*;

public class bj3009 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int x[] = new int[3];
        int y[] = new int[3];
        int newX, newY;

        for (int i=0;i<3;i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        if(x[0] == x[1]) {
            newX = x[2];
        } else {
            newX = x[1] == x[2] ? x[0]:x[1];
        }

        if(y[0] == y[1]) {
            newY = y[2];
        } else {
            newY = y[1] == y[2] ? y[0]:y[1];
        }

    }
}
