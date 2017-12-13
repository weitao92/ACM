package ACPC2017;

import java.util.*;


public class universeWithBFS {
    
    static class path
    {
        int det;
        int length;
        
        public path(int d, int l)
        {
            det = d;
            length = l;
        }
    }
    
    static LinkedHashSet<Integer> g1 = new LinkedHashSet<Integer>();
    static LinkedHashSet<Integer> g2 = new LinkedHashSet<Integer>();

    @SuppressWarnings("unchecked")
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int N1 = in.nextInt();
        int N2 = in.nextInt();
        int m1 = in.nextInt();
        int m2 = in.nextInt();
        
        ArrayList<Integer>[] gragh1 = new ArrayList[N1];
        ArrayList<Integer>[] gragh2 = new ArrayList[N2];
        
        for(int i = 0; i < N1; i++)
        {
            gragh1[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < N2; i++)
        {
            gragh2[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < m1; i++)
        {
            int src = in.nextInt() - 1;
            int det = in.nextInt() - 1;
            gragh1[src].add(det);
            //e1.add(new edge(src, det));
        }
        
        for(int i = 0; i < m2; i++)
        {
            int src = in.nextInt() - 1;
            int det = in.nextInt() - 1;
            gragh2[src].add(det);
            //e2.add(new edge(src, det));
        }
        
        bfs(gragh1, 0, N1-1, 1);
        bfs(gragh2, 0, N2 - 1, 2);
        
        LinkedHashSet<Integer> result = new LinkedHashSet<Integer>();
        
        for(int i : g1)
        {
            for(int j : g2)
            {
                result.add(i + j);
            }
        }
        
        int q = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++)
        {
            int sum = in.nextInt();
            if(result.contains(sum))
            {
                sb.append("Yes\n");
            }
            else
            {
                sb.append("No\n");
            }
        }
        System.out.println(sb);
    
    }
    
    private static void bfs(ArrayList<Integer>[] gragh, int src, int det, int mode)
    {
        ArrayDeque<path> queue = new ArrayDeque<path>();
        queue.add(new path(src, 0));
        boolean[][] list = new boolean[2001][gragh.length];
        list[0][0] = true;
        
        while(!queue.isEmpty())
        {
            path current = queue.removeFirst();

            if(current.det == det)
            {
                if(mode == 1)
                {
                    g1.add(current.length);
                }
                else
                {
                    g2.add(current.length);
                }
            }
            
            for(int i : gragh[current.det])
            {
                if(!list[current.length + 1][i])
                {             
                    list[current.length + 1][i] = true;
                    queue.addLast(new path(i, current.length + 1));
                }
            }
        }
    }

}
