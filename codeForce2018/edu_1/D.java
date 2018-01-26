package edu_1;
import java.util.*;

public class D {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		ArrayList<Integer>[] graph = new ArrayList[n];
		int[] incoming = new int[n];
		for(int i = 0; i < n; i++)
		{
			graph[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < m; i++)
		{
			int src = in.nextInt()-1;
			int det = in.nextInt()-1;
			graph[src].add(det);
			incoming[det]++;
		}
		
		int result = topSort(graph, incoming, m);
		
	}
	
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
