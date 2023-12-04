package BJ;

import java.util.*;
import java.io.*;

public class bj1629 {
    public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long a = Integer.parseInt(st.nextToken());    
    long b = Integer.parseInt(st.nextToken());
    long c = Integer.parseInt(st.nextToken());

    long result = getRemain(a,b,c);

    System.out.println(result);

    }

    public static long getRemain(long a, long b, long c) {
        if (b == 1) {
            return a%c;
        }

        // 차수가 짝수인 경우
        if (b%2 == 0) {
            b /= 2;
            long tmp = getRemain(a,b,c);
            // System.out.println("짝수 : "+"a: "+a+" b: "+b+" c: "+c+" tmp: "+tmp);
            return (tmp*tmp)%c;
        } else {
            b /= 2;
            long tmp = getRemain(a,b,c);
            // System.out.println("홀수 : "+"a: "+a+" b: "+b+" c: "+c+" tmp: "+tmp);
            return (tmp*tmp%c)*a%c;
        }
    }
}
