package ECNA2016;
import java.util.*;

/**
 * https://open.kattis.com/problems/waif
 * @author weitao92
 *
 */
public class I {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // children
		int m = scan.nextInt(); // toys
		int p = scan.nextInt(); // categories
		
		MaxFlowSolver ek = new EdmondsKarp();
		Node src = ek.addNode();
		Node sink = ek.addNode();
		
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		HashMap<Integer, Node> kidsMap = new HashMap<>();
	
		for (int i = 0; i < n; i++) {
			int k = scan.nextInt();
			for (int j = 0; j < k; j++) {
				int toy = scan.nextInt();
				HashSet<Integer> kidSet = map.get(toy);
				if (kidSet == null) {
					kidSet = new HashSet<>();
				}
				kidSet.add(i);
				map.put(toy, kidSet);
			}
			Node node = ek.addNode();
			ek.link(src, node, 1);
			kidsMap.put(i, node);
		}
		
		HashMap<Integer, Node> toyMap = new HashMap<>();
		HashMap<Integer, HashSet<Integer>> catMap = new HashMap<>();
		HashSet<Integer> usedToys = new HashSet<>();
		
		for (int i = 0; i < p; i++) {
			int k = scan.nextInt();
			HashSet<Integer> catSet = new HashSet<>();
			for (int j = 0; j < k; j++) {
				int toy = scan.nextInt();
				usedToys.add(toy);
				HashSet<Integer> kids = map.get(toy);
				if (kids == null) {
					kids = new HashSet<>();
					map.put(toy, kids);
				}
				Node toyNode = toyMap.get(toy);
				if (toyNode == null) {
					toyNode = ek.addNode();
					toyMap.put(toy, toyNode);
				}
				catSet.add(toy);
				
				for (int kid : kids) {
					Node kidNode = kidsMap.get(kid);
					if (kidNode == null) {
						kidNode = ek.addNode();
						kidsMap.put(kid,kidNode);
					}
					ek.link(kidNode, toyNode, 1);
				}
				
			}
			int lim = scan.nextInt();
			Node catNode = ek.addNode();
			for (int toyNum : catSet) {
				Node toyNode = toyMap.get(toyNum);
				if (toyNode == null) {
					toyNode = ek.addNode();
					toyMap.put(toyNum, toyNode);
				}
				ek.link(toyNode, catNode, 1);
			}
			ek.link(catNode, sink, lim);
		}
		
		for (int key : map.keySet()) {
			if (!usedToys.contains(key)) {
				HashSet<Integer> set = map.get(key);
				
				Node toyNode = toyMap.get(key);
				if (toyNode == null) {
					toyNode = ek.addNode();
					toyMap.put(key, toyNode);
				}
				if (set == null) {
					set = new HashSet<>();
					map.put(key, set);
				}
				for (int kid : set) {
					Node kidNode = kidsMap.get(kid);
					if (kidNode == null) {
						kidNode = ek.addNode();
						kidsMap.put(kid, kidNode);
					}
					ek.link(kidNode, toyNode, 1);
				}
				ek.link(toyNode, sink, 1);
			}
		}
		
		long ans = ek.getMaxFlow(src, sink);
		System.out.println(ans);
		
	}
	
	static class Node {
		private Node() {};
		List<Edge> edges = new ArrayList<>();
		int index;
		
		int dist;
		long excess;
		int mindj;
		int currentarc;
		long mincapacity;
		
		Node next, prev;
		void remove() {
			this.next.prev = this.prev;
			this.prev.next = this.next;
		}
		void linkWith(Node n) {
			this.next = n;
			n.prev = this;
		}
		void insertBefore(Node n) {
			n.prev.linkWith(this);
			this.linkWith(n);
		}
	}
	
	static class Edge {
		boolean forward;
		Node from, to;
		long flow;
		final long capacity;
		Edge dual;
		long cost;
		
		protected Edge(Node s, Node d, long c, boolean f) {
			forward = f;
			from = s;
			to = d;
			capacity = c;
		}
		
		long remaining() { return capacity - flow; }
		
		void addFlow(long amount) {
			flow += amount;
			dual.flow -= amount;
		}
	}
	
	static abstract class MaxFlowSolver {
		List<Node> nodes = new ArrayList<>();
		
		public void link(Node n1, Node n2, long capacity) {
			link(n1, n2, capacity, 1);
		}
		
		public void link(Node n1, Node n2, long capacity, long cost) {
			Edge e12 = new Edge(n1, n2, capacity, true);
			Edge e21 = new Edge(n2, n1, 0, false);
			e12.dual = e21;
			e21.dual = e12;
			n1.edges.add(e12);
			n2.edges.add(e21);
			e12.cost = cost;
			e21.cost = -cost;
		}
		
		void link(int n1, int n2, long capacity) {
			link(nodes.get(n1), nodes.get(n2), capacity);
		}
		
		protected MaxFlowSolver(int n) {
			for (int i = 0; i < n; i++) {
				addNode();
			}
		}
		
		protected MaxFlowSolver() { this(0); }
		
		public abstract long getMaxFlow(Node src, Node snk);
		
		public Node addNode() {
			Node n = new Node();
			n.index = nodes.size();
			nodes.add(n);
			return n;
		}
		
		List<Edge> getMinCut(Node src) {
			Queue<Node> bfs = new ArrayDeque<>();
			Set<Node> visited = new HashSet<>();
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
			List<Edge> minCut = new ArrayList<>();
			for (Node s : visited) {
				for (Edge e : s.edges) {
					if (e.forward && !visited.contains(e.to)) {
						minCut.add(e);
					}
				}
			}
			return minCut;
		}
		
		void computeDistanceLabelsByReverseBFS(Node snk, int[] count) {
			final int n = nodes.size();
			count[0]++;
			
			Node[] Q = new Node[n];
			int head = 0, tail = 0;
			snk.dist = 0;
			Q[tail++] = snk;
			while (head < tail) {
				Node x = Q[head++];
				for (Edge e : x.edges) {
					if (e.to.dist == -1) {
						e.to.dist = e.from.dist + 1;
						count[e.to.dist]++;
						Q[tail++] = e.to;
					}
				}
			}
		}
	}
	
	static abstract class MinCostMaxFlowSolver extends MaxFlowSolver {
		abstract long[] getMinCostMaxFlow(Node src, Node snk);
		MinCostMaxFlowSolver() { this(0); }
		MinCostMaxFlowSolver(int n) { super(n); }
	}
	
	static class EdmondsKarp extends MinCostMaxFlowSolver {
		EdmondsKarp() { this(0); }
		EdmondsKarp(int n) { super(n); }
		
		long minCost;
		
		@Override
		public long[] getMinCostMaxFlow(Node src, Node snk) {
			long maxflow = getMaxFlow(src, snk);
			return new long[] { maxflow, minCost };
		}
		
		static final long INF = Long.MAX_VALUE / 4;
		
		@Override
		public long getMaxFlow(Node src, Node snk) {
			final int n = nodes.size();
			final int source = src.index;
			final int sink = snk.index;
			long flow = 0;
			long cost = 0;
			long[] potential = new long[n];
			
			while (true) {
				Edge[] parent = new Edge[n];
				long[] dist = new long[n];
				Arrays.fill(dist, INF);
				dist[source] = 0;
				
				PriorityQueue<Item> que = new PriorityQueue<>();
				que.add(new Item(0, source));
				while (!que.isEmpty()) {
					Item item = que.poll();
					if (item.dist != dist[item.v]) {
						continue;
					}
					
					for (Edge e : nodes.get(item.v).edges) {
						long temp = dist[item.v] + e.cost + potential[item.v] - potential[e.to.index];
						if (e.capacity > e.flow && dist[e.to.index] > temp) {
							dist[e.to.index] = temp;
							parent[e.to.index] = e;
							que.add(new Item(temp, e.to.index));
						}
					}
				}
				
				if (parent[sink] == null) {
					break;
				}
				for (int i = 0; i < n; i++) {
					if (parent[i] != null) {
						potential[i] += dist[i];
					}
				}
				
				long augFlow = Long.MAX_VALUE;
				for (int i = sink; i != source; i = parent[i].from.index) {
					augFlow = Math.min(augFlow, parent[i].capacity - parent[i].flow);
				}
				
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
	
	static class Category {
		public int limit;
		ArrayList<Integer> list;
		public Category(int lim) {
			limit = lim;
			list = new ArrayList<>();
		}
	}

}