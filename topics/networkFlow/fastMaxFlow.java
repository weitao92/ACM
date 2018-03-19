package networkFlow;

import java.util.*;

public class fastMaxFlow {
	
	public static class Node {
	    // thou shall not create nodes except through addNode()
	    private Node() { }

	    List<Edge> edges = new ArrayList<Edge>();
	    int index;          // index in nodes array

	    int dist;
	    boolean active;
	    boolean blocked;
	}

	public static class Edge
	{
	    boolean forward; // true: edge is in original graph
	    // false: edge is a backward edge
	    Node from, to;   // nodes connected
	    long flow;        // current flow
	    final long capacity;
	    Edge dual;      // reference to this edge's dual
	    long cost;      // only used for MinCost.

	    // thou shall not create edges except through link()
	    protected Edge(Node s, Node d, long c, boolean f)
	    {
	        forward = f;
	        from = s;
	        to = d;
	        capacity = c;
	    }

	    // remaining capacity()
	    long remaining() { return capacity - flow; }

	    // increase flow and adjust dual
	    void addFlow(long amount) {
	        flow += amount;
	        dual.flow -= amount;
	    }
	}

	/* A Max Flow solver base class. */
	public static abstract class MaxFlowSolver {
	    /* List of nodes, indexed. */
	    List<Node> nodes = new ArrayList<Node>();

	    /* Create an edge between nodes n1 and n2 */
	    public void link(Node n1, Node n2, long capacity)
	    {
	    /*
	     * Only the EdmondsKarp solver takes cost into account
	     * during getMaxFlow().  Setting it to 1 for problems
	     * that do not involve cost means it uses a shortest path
	     * search when finding augmenting paths.  In practice,
	     * this does not seem to make a difference.
	     */
	        link(n1, n2, capacity, 1);
	    }

	    /* Create an edge between nodes n1 and n2 and assign cost */
	    public void link(Node n1, Node n2, long capacity, long cost)
	    {
	        Edge e12 = new Edge(n1, n2, capacity, true);
	        Edge e21 = new Edge(n2, n1, 0, false);
	        e12.dual = e21;
	        e21.dual = e12;
	        n1.edges.add(e12);
	        n2.edges.add(e21);
	        e12.cost = cost;
	        e21.cost = -cost;
	    }

	    /* Create an edge between nodes n1 and n2 */
	    void link(int n1, int n2, long capacity)
	    {
	        link(nodes.get(n1), nodes.get(n2), capacity);
	    }

	    /* Create a graph with n nodes. */
	    protected MaxFlowSolver(int n) {
	        for (int i = 0; i < n; i++)
	            addNode();
	    }

	    protected MaxFlowSolver() { this(0); }

	    public abstract long getMaxFlow(Node src, Node snk);

	    /* Add a new node. */
	    public Node addNode() {
	        Node n = new Node();
	        n.index = nodes.size();
	        nodes.add(n);
	        return n;
	    }

	    /* OPTIONAL: Returns the edges associated with the Min Cut.
	     * Must be run immediately after a getMaxFlow() call.  */
	    List<Edge> getMinCut(Node src) {
	        Queue<Node> bfs = new ArrayDeque<Node>();
	        Set<Node> visited = new HashSet<Node>();
	        bfs.offer(src);
	        visited.add(src);
	        while (!bfs.isEmpty()) {
	            Node u = bfs.poll();
	            for (Edge e : u.edges) {
	                if (e.remaining() > 0 && !visited.contains(e.to)) {
	                    visited.add(e.to);
	                    bfs.offer(e.to);
	                }
	            }
	        }
	        List<Edge> minCut = new ArrayList<Edge>();
	        for (Node s : visited) {
	            for (Edge e : s.edges)
	                if (e.forward && !visited.contains(e.to))
	                    minCut.add(e);
	        }
	        return minCut;
	    }
	}

	/**
	 * Dinic's algorithm, Shimon Even variant.
	 */
	public static class Dinic extends MaxFlowSolver
	{
	    long BlockingFlow(Node src, Node snk) {
	        int N = nodes.size();
	        for (Node u : nodes) {
	            u.dist = -1;
	            u.blocked = false;
	        }
	        Node [] Q = new Node[N];

	        /* Step 1.  BFS from source to compute levels */
	        src.dist = 0;
	        int head = 0, tail = 0;
	        Q[tail++] = src;
	        while (head < tail) {
	            Node x = Q[head++];
	            List<Edge> succ = x.edges;
	            for (Edge e : succ) {
	                if (e.to.dist == -1 && e.remaining() > 0) {
	                    e.to.dist = e.from.dist + 1;
	                    Q[tail++] = e.to;
	                }
	            }
	        }

	        if (snk.dist == -1)     // no flow if sink is not reachable
	            return 0;

	        /* Step 2. Push flow down until we have a blocking flow */
	        long flow, totflow = 0;
	        do {
	            flow = dfs(src, snk, Long.MAX_VALUE);
	            totflow += flow;
	        } while (flow > 0);
	        return totflow;
	    }

	    /*
	     * Run DFS on the BFS level graph.
	     */
	    long dfs(Node v, Node snk, long mincap) {
	        // reached sink
	        if (v == snk)
	            return mincap;

	        for (Edge e : v.edges) {
	            // standard DFS, but consider an edge only if
	            if (!e.to.blocked    // the path to the sink is not already blocked
	                    && e.from.dist + 1 == e.to.dist // it's in the BFS level graph
	                    && e.remaining() > 0) {  // the edge has remaining capacity
	                long flow = dfs(e.to, snk, Math.min(mincap, e.remaining()));
	                if (flow > 0) {
	                    e.addFlow(flow);
	                    return flow;
	                }
	            }
	        }
	        // if we couldn't add any flow then there is no point in ever going
	        // past this node again.  Mark it blocked.
	        v.blocked = true;
	        return 0;
	    }

	    @Override
	    public long getMaxFlow(Node src, Node snk) {
	        long flow, totflow = 0;
	        while ((flow = BlockingFlow(src, snk)) != 0)
	            totflow += flow;
	        return totflow;
	    }

	    public Dinic () { this(0); }
	    public Dinic (int n) { super(n); }
	}

	static abstract class MinCostMaxFlowSolver extends MaxFlowSolver {
	    // returns [maxflow, mincost]
	    abstract long [] getMinCostMaxFlow(Node src, Node snk);
	    // unavoidable boiler plate
	    MinCostMaxFlowSolver ()      { this(0); }
	    MinCostMaxFlowSolver (int n) { super(n); }
	}

	/**
	 * Implements Edmonds/Karp min-cost max-flow.
	 *
	 * This algorithm uses costs to find an mincost augmenting path.
	 *
	 * See Theoretical Improvements in Algorithmic Efficiency for
	 * Network Flow Problems by Edmonds and Karp,
	 * Journal of the Association for Computing Machinery,
	 * Vol. 19, No. 2, Apri; 1972. pp. 248-264.
	 */
	static class EdmondsKarp extends MinCostMaxFlowSolver
	{
	    EdmondsKarp ()      { this(0); }
	    /* Create a graph with n nodes. */
	    EdmondsKarp (int n) { super(n); }

	    long minCost;

	    @Override
	    public long [] getMinCostMaxFlow(Node src, Node snk) {
	        long maxflow = getMaxFlow(src, snk);
	        return new long [] { maxflow, minCost };
	    }
	    static final long INF = Long.MAX_VALUE/4;

	    /**
	     * Maximize the flow, and simultaneously minimize its cost.
	     * Code taken from judge solution to Chicago 2013/Job Postings
	     * http://serjudging.vanb.org/wp-content/uploads/jobpostings_artur.java
	     */
	    @Override
	    public long getMaxFlow(Node src, Node snk) {
	        final int n = nodes.size();
	        final int source = src.index;
	        final int sink = snk.index;
	        long flow = 0;
	        long cost = 0;
	        long[] potential = new long[n]; // allows Dijkstra to work with negative edge weights

	        while (true) {
	            Edge[] parent = new Edge[n]; // used to store an augmenting path
	            long[] dist = new long[n]; // minimal cost to vertex
	            Arrays.fill(dist, INF);
	            dist[source] = 0;

	            // Dijkstra on cost
	            PriorityQueue<Item> que = new PriorityQueue<Item>();
	            que.add(new Item(0, source));
	            while (!que.isEmpty()) {
	                Item item = que.poll();
	                if (item.dist != dist[item.v])
	                    continue;

	                for (Edge e : nodes.get(item.v).edges) {
	                    long temp = dist[item.v] + e.cost + potential[item.v] - potential[e.to.index];
	                    // if can push some flow, and new cost is cheaper than push
	                    if (e.capacity > e.flow && dist[e.to.index] > temp) {
	                        dist[e.to.index] = temp;
	                        parent[e.to.index] = e;
	                        que.add(new Item(temp, e.to.index));
	                    }
	                }
	            }

	            // couldn't reach sink
	            if (parent[sink] == null)
	                break;
	            // update potentials for Dijkstra
	            for (int i = 0; i < n; i++)
	                if (parent[i] != null)
	                    potential[i] += dist[i];

	            // maximum flow that can be pushed
	            long augFlow = Long.MAX_VALUE;
	            for (int i = sink; i != source; i = parent[i].from.index)
	                augFlow = Math.min(augFlow, parent[i].capacity - parent[i].flow);

	            // push the flow
	            for (int i = sink; i != source; i = parent[i].from.index) {
	                Edge e = parent[i];
	                e.addFlow(augFlow);
	                cost += augFlow * e.cost;
	            }
	            flow += augFlow;
	        }

	        minCost = cost;
	        return flow;
	    }

	    static class Item implements Comparable<Item> {
	        long dist;
	        int v;

	        public Item(long dist, int v) {
	            this.dist = dist;
	            this.v = v;
	        }

	        public int compareTo(Item that) {
	            return Long.compare(this.dist, that.dist);
	        }
	    }
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		// Creating a new solver that uses Dinic's Algorithm
		MaxFlowSolver mf = new Dinic();

		// Creating the nodes
		Node[] nodes = new Node[n];
		for (int i = 0; i < n; i++) {
		 nodes[i] = mf.addNode();
		}
		
		for (int i = 0; i < m; i++) {
			 // Adding an edge from node u to node v
			 // This method also creates the backward edge,
			 // but this is abstracted away from you
			 int u = in.nextInt() - 1;
			 int v = in.nextInt() - 1;
			 int capacity = in.nextInt();
			 mf.link(nodes[u], nodes[v], capacity);
			 mf.link(nodes[v], nodes[u], capacity);
		}

		long maxFlow = mf.getMaxFlow(nodes[0], nodes[n-1]);
		in.close();
		System.out.println(maxFlow);
	}

}
