package BJ;

import java.util.*;
import java.io.*;


public class bj1620 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        HashMap<String, Integer> pokemonStr = new HashMap<>();
        HashMap<Integer, String> pokemonInt = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i=1;i<n+1;i++) {
            String tmp = br.readLine();
            pokemonStr.put(tmp,i);
            pokemonInt.put(i, tmp);

        }

        StringBuilder sb = new StringBuilder();

        for (int i=0;i<m;i++) {
            String tmp = br.readLine();
            try {
                int intTmp = Integer.parseInt(tmp);
                sb.append(pokemonInt.get(intTmp)).append('\n');
            } catch(Exception e) {
                sb.append(pokemonStr.get(tmp)).append('\n');
            }
        }
        System.out.println(sb);
    }
    
}
