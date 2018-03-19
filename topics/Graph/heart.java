package Graph;
import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/contests/56/problems
 */
class heart
{   
    static class state implements Comparable<state>
    {
        int index;
        int troop;
        public state(int i, int t)
        {
            index = i;
            troop = t;
        }
        
        public int compareTo(state another)
        {
            return Integer.compare(troop, another.troop);
        }
    }
    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int limit = in.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n];
        
        int[] troops = new int[n];
        for(int i = 0; i < n; i++)
        {
            troops[i] = in.nextInt();
            int m = in.nextInt();
            graph[i] = new ArrayList<Integer>();
            for(int j = 0; j < m; j++)
            {
                graph[i].add(in.nextInt());
            }
        }
        
        PriorityQueue<state> queue = new PriorityQueue<state>();
        HashSet<Integer> bag = new HashSet<Integer>();
        state[] states = new state[n];
        for(int i = 0; i < n; i++)
        {
            bag.add(i);
            state current = new state(i,troops[i]);
            for(int next : graph[i])
            {
                current.troop += troops[next];
            }
            queue.add(current);
            states[i] = current;
        }
        
        while(!queue.isEmpty())
        {
            state current = queue.poll();
            if(current.troop >= limit)
            {
                break;
            }
            if(bag.contains(current.index))
            {
                bag.remove(current.index);
                for(int next : graph[current.index])
                {
                    if(bag.contains(next))
                    {
                        state nextState = new state(next, states[next].troop - troops[current.index]);
                        states[next] = nextState;
                        queue.add(nextState);
                    }
                }
            }
        }
        int result = 0;
        for(int remain : bag)
        {
            result += troops[remain];
        }
        System.out.print(bag.size() + " " + result);      
    }
}