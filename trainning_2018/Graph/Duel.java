package Graph;
import java.util.*;

/**
 * https://pcs.cs.cloud.vt.edu/problems/65
 */
public class Duel {
	
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        @SuppressWarnings("unchecked")
		Set<Integer>[] adj = new HashSet[n];
        
        for (int i = 0; i < adj.length; i++)
            adj[i] = new HashSet<>();

        int[] incoming = new int[n];
        
        for (int i = 0; i < m; i++){
            int start = in.nextInt() - 1;
            int end = in.nextInt() - 1;
            adj[start].add(end);
            incoming[end]++;
        }
        in.close();
        System.out.println(topSort(adj, incoming, m));
    }

    /**
     * Topological sorting using Kahn's algorithm.
     * https://en.wikipedia.org/wiki/Topological_sorting#Algorithms
     *
     * @param adj non-empty adjacency list.
     * @param incomingCounts counts of the incoming edges of a node; mutated by this method.
     * @return 0 if no sorting (cycle present), 1 if exactly one sorting, 2 if more than one sorting.
     */
    static int topSort(Collection<Integer>[] adj, int[] incomingCounts, int numEdges) {
        int edgesRemoved = 0;
        boolean multiple = false;
        List<Integer> sorted = new ArrayList<>();
        // Set of all nodes with no incoming edges.
        Queue<Integer> sourcesQueue = new ArrayDeque<>();

        // Initialize sourcesQueue to sources with no incoming edges
        for (int i = 0; i < adj.length; i++) {
            if (incomingCounts[i] == 0) {
                sourcesQueue.add(i);
            }
        }

        while (sourcesQueue.size() != 0) {
            if (sourcesQueue.size() > 1) {
                multiple = true;
            }
            int node = sourcesQueue.poll();
            sorted.add(node);
            for (Integer succ : adj[node]) {
                incomingCounts[succ]--;
                edgesRemoved++;
                if (incomingCounts[succ] == 0) {
                    sourcesQueue.add(succ);
                }
            }
        }

        if (edgesRemoved != numEdges) {
            return 0;
        }

        return multiple ? 2 : 1;
    }
}