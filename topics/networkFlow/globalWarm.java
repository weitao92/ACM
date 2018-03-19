package networkFlow;

import java.util.*;

/**
 * https://open.kattis.com/contests/na17warmup3/problems/globalwarming
 * @author weitao92
 *
 */
public class globalWarm {
	
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
	
	static class pair
	{
		long x;
		long y;
		
		public pair(long a, long b)
		{
			x = a;
			y = b;
		}
	}
	
	static class Edge1
	{
		int src;
		int det;
		long weight;
		
		public Edge1(int s, int d, long w)
		{
			src = s;
			det = d;
			weight = w;
		}
		
		public boolean equals(Object o)
		{
			Edge1 another = (Edge1) o;
			return src == another.src && det == another.det;
		}
	}
	
	static TreeSet<Integer> red = new TreeSet<Integer>();
	static TreeSet<Integer> blue = new TreeSet<Integer>();
	static boolean[] finished;
	static boolean[] redList;
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n % 2 != 0)
		{
			System.out.println("impossible");
			in.close();
			System.exit(0);
		}
		else
		{
			finished = new boolean[n];
			redList = new boolean[n];
			EdmondsKarp mf = new EdmondsKarp();
			Node source = mf.addNode();
			Node sink = mf.addNode();
			TreeMap<Integer, Node> map = new TreeMap<Integer, Node>();
			HashMap<Node, Integer> ans = new HashMap<Node, Integer>();
			ArrayList<Edge1>[] gragh = new ArrayList[n];
			for(int i = 0; i < n; i++)
			{
				gragh[i] = new ArrayList<Edge1>();
				Node c = mf.addNode();
				map.put(i, c);
				ans.put(c, i);
			}
			
			int[] union = new int[n];
			Arrays.fill(union, -1);
			
			int m = in.nextInt();
			HashMap<Edge1, Long> es = new HashMap<Edge1, Long>();
			Edge1[] es1 = new Edge1[m];
			for(int i = 0; i < m; i++)
			{
				int a = in.nextInt() - 1;
				int b = in.nextInt() - 1;
				long w = in.nextLong();
				Edge1 e = new Edge1(a, b, w);
				gragh[a].add(e);
				Edge1 e1 = new Edge1(b,a,w);
				gragh[b].add(e1);
				es.put(e, w);
				es.put(e1, w);
				es1[i] = e;
				
				int r1 = root(union, a);
				int r2 = root(union, b);
				if(r1 != r2)
				{
					union[r1] = r2;
				}
			}
			
			ArrayList<Integer> roots = new ArrayList<Integer>();
			for(int i = 0; i < n; i++)
			{
				if(union[i] == -1)
				{
					roots.add(i);
				}
			}
			
			TreeMap<Integer, Integer> map1 = new TreeMap<Integer, Integer>();
			for(int i = 0; i < n; i++)
			{
				int r = root(union, i);
				Integer count = map1.get(r);
				if(count == null)
				{
					map1.put(r, 1);
				}
				else
				{
					map1.put(r, count + 1);
				}
			}
			
			Set<Integer> set = map1.keySet();
			for(int i : set)
			{
				if(map1.get(i) % 2 == 1)
				{
					System.out.println("impossible");
					System.exit(0);
				}
			}
			
			//System.out.println(roots.size());
			
			for(int root : roots)
			{
				bfs(gragh, root);
			}
			
			//System.out.println(red.size() + " " + blue.size());
			
			if(red.size() != blue.size())
			{
				System.out.println("impossible");
				System.exit(0);
			}
			else
			{
				for(int left : red)
				{
					Node c = map.get(left);
					mf.link(source, c, 1, 0);
					for(Edge1 e : gragh[left])
					{
						Node next = map.get(e.det);
						mf.link(c, next, 1, es.get(e));
					}
				}
				
				for(int right : blue)
				{
					Node c = map.get(right);
					mf.link(c, sink, 1, 0);
				}
				
				mf.getMaxFlow(source, sink);
				//List<Edge> minCut = mf.getMinCut(source);
				long result = 0;
				//System.out.println(minCut.size());
				for(int left : red)
				{
					Node c = map.get(left);
					int right = -1;
					for(Edge e : c.edges)
					{
						if(e.flow == 1)
						{
							right = ans.get(e.to);
							break;
						}
					}
					
					//System.out.println(es.get(new Edge1(left, right)));
					//System.out.println(left + " " + right);
					for(Edge1 e : es1)
					{
						if((e.src == left && e.det == right) || (e.src == right && e.det == left)) 
						{
							result += e.weight;
						}
					}
				}
				
				System.out.println(result);
			}
		}
		
	}
	
	private static void bfs(ArrayList<Edge1>[] gragh, int src)
	{
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		queue.addLast(src);
		redList[src] = true;
		
		while(!queue.isEmpty())
		{
			int current = queue.removeFirst();
			if(finished[current])
			{
				continue;
			}
			else
			{
				finished[current] = true;
				if(redList[current])
				{
					red.add(current);
				}
				else
				{
					blue.add(current);
				}
				
				for(Edge1 e : gragh[current])
				{
					if(!finished[e.det])
					{
						queue.addLast(e.det);
					}
					
					if(redList[current])
					{
						redList[e.det] = false;
					}
					else
					{
						redList[e.det] = true;
					}
				}
			}
		}
	}
	
	private static int root(int[] union, int index)
	{
		while(union[index] != -1)
		{
			index = union[index];
		}
		return index;
	}
}
