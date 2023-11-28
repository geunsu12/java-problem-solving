package BJ;

import java.util.*;
import java.io.*;

public class bj1043 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] truthPeople = new boolean[51];
    static int n, m, total = 0;
    static int[] parent;

    // 유니온 파인드 알고리즘 사용
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 유니온 파인드 초기화 -> 현재 자기 자신을 가지고 있는다.
        parent = new int[n+1];
        for (int i=1;i<=n;i++) {
            parent[i] = i;
        }

        // 진실을 아는 사람 정보 받아오기
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i=0;i<n;i++) {
            truthPeople[Integer.parseInt(st.nextToken())] = true;
        }

        // 파티 정보를 받아오면서 같은 파티 사람들 유니온
        ArrayList<Integer>[] peoples = new ArrayList[m];
        for (int i=0;i<m;i++) {
            peoples[i] = new ArrayList<>();
        }
        int value, pre = 0;
        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n > 0) {
                pre = Integer.parseInt(st.nextToken());
                peoples[i].add(pre);
            }
            for (int j=1;j<n;j++) {
                value = Integer.parseInt(st.nextToken());
                peoples[i].add(value);
                union(pre, value);
                pre = value;
            }
        }

        int parent;
        for (int i=1;i<truthPeople.length;i++) {
            if (truthPeople[i]) {
                truthPeople[find(i)] = true;
            }
        }

        for (int i=0;i<m;i++) {
            if (peoples[i].size() > 0) {
                parent = find(peoples[i].get(0));
                if (!truthPeople[parent]) total++;
            }
        }
        
        System.out.println(total);
    }

    public static int find(int x) {
        if (parent[x] == x) { return parent[x] = x; }
        else { return find(parent[x]); }
    }

    public static boolean union (int a, int b) {
        a = find(a);
        b = find(b);

        if (a!=b) {
            if (a>b) {
                parent[a] = b;
            } else {
                parent[b] = a;
            }
            return true;
        }
        return false;
    }
}
