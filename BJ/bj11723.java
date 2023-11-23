package BJ;

import java.io.*;
import java.util.*;

public class bj11723 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        int bit_set = 0;

        StringBuilder sb = new StringBuilder();

        for (int i=0;i<m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            switch (op) {
                case "add":
                    bit_set = bit_set | (1 << Integer.parseInt(st.nextToken())-1);
                    break;
                case "remove":
                    bit_set = bit_set & ~(1 << Integer.parseInt(st.nextToken())-1);
                    break;
                case "check":
                    String tmpResult = (bit_set & (1 << Integer.parseInt(st.nextToken())-1)) !=0 ? "1":"0";
                    sb.append(tmpResult + "\n");
                    break;
                case "toggle":
                    bit_set = bit_set ^ (1 << Integer.parseInt(st.nextToken())-1);
                    break;
                case "all":
                    bit_set = bit_set | ~0;
                    break;
                case "empty":
                    bit_set = bit_set & 0;
                    break;
            }
        }

        System.out.println(sb);

    }
    
}
