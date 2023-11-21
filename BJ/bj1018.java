package BJ;

import java.util.*;
import java.io.*;

public class bj1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = 100;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        
        for (int i=0;i<n;i++) {
            String tmp = br.readLine();
            for (int j=0;j<m;j++) {
                board[i][j] = tmp.charAt(j);
            }
        }

        for (int i=0;i<=n-8;i++) {
            for (int j=0;j<=m-8;j++) {
                min = Math.min(min,getResult(board,i,j));
            }
        }
        System.out.println(min);
    } 

    public static int getResult(char[][] board, int sti, int stj) {
        int resultWB = 0;
        int resultBW = 0;

        char[] wb = {'W','B','W','B','W','B','W','B'};
        char[] bw = {'B','W','B','W','B','W','B','W'};

        for (int i=0;i<8;i++) {
            if (i %2 == 0) {
                for (int j=0;j<8;j++) {
                    if (board[sti+i][stj+j] != wb[j]) resultWB += 1; 
                }
            }
            else {
                for (int j=0;j<8;j++) {
                    if (board[sti+i][stj+j] != bw[j]) resultWB += 1; 
                }
            }
        }

        for (int i=0;i<8;i++) {
            if (i %2 == 0) {
                for (int j=0;j<8;j++) {
                    if (board[sti+i][stj+j] != bw[j]) resultBW += 1; 
                }
            }
            else {
                for (int j=0;j<8;j++) {
                    if (board[sti+i][stj+j] != wb[j]) resultBW += 1; 
                }
            }
        }

        return Math.min(resultBW, resultWB);
    }
    
}
