package NCPC2017;

import java.util.*;

/**
 * credit goes to Justin Park, my teammate of ICPC.
 * 
 * https://open.kattis.com/problems/distinctivecharacter
 *
 */
public class ProblemD {
	
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int k = scan.nextInt();
        visited = new boolean[1 << k];
        adj = new ArrayList<>();
        
        for (int i = 0; i < 1 << k; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < 1 << k; i++) {
            int curr = i;
            for (int j = 0; j < k; j++) {
                int res = curr ^ (1 << j);
                adj.get(curr).add(res);
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String s = scan.next();
            int num = Integer.parseInt(s, 2);
            visited[num] = true;
            q.add(num);
        }
        
        int best = bfs(q);
        System.out.println(String.format("%" + k + "s", Integer.toBinaryString(best)).replace(" ", "0"));
    }
    
    static int bfs(ArrayDeque<Integer> q) {
        int best = q.peek();
        
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    best = v;
                }
            }
        }
        
        return best;
    }

}