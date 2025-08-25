/*A vertex is said to be an articulation point in a graph 
if removal of the vertex and associated edges disconnects the graph.

So, the removal of articulation points increases the number of connected components in a graph.

The main aim here is to find out all the articulations points in a graph.


Sample Input-1:
---------------
5
5
1 0
0 2
2 1
0 3
3 4

Sample Output-1:
----------------
[0, 3]

Sample Input-2:
---------------
4
3
0 1
1 2
2 3

Sample Output-2:
----------------
[1, 2]


Sample Input-3:
---------------
7
8
0 1 
1 2
2 0 
1 3
1 4
1 6
3 5
4 5

Sample Output-3:
----------------
[1]

Sample Input-4:
---------------
5
4
0 1
1 2
2 3
3 4

Sample Output-4:
----------------
[1, 2, 3] */
import java.util.*;

/**
 * An articulation point (or cut vertex) is a vertex in a graph that, if removed,
 * increases the number of connected components.
 * 
 * This program finds all articulation points in a given graph using Tarjan's algorithm,
 * which is based on Depth First Search (DFS).
 * 
 * The main idea is to use two arrays:
 * - `disc[u]`: Stores the discovery time of vertex `u` during DFS.
 * - `low[u]`: Stores the lowest discovery time reachable from `u` (including itself)
 *             through its DFS subtree, possibly using one back-edge.
 * 
 * A vertex `u` is an articulation point if it satisfies one of two conditions:
 * 1. `u` is the root of the DFS tree and has at least two children.
 * 2. `u` is not the root, and for some child `v` of `u`, `low[v] >= disc[u]`.
 *    This means `v` (and its subtree) cannot reach any ancestor of `u` using a back-edge.
 */
public class ArticulationPoint {
	private int V; // Number of vertices
	private LinkedList<Integer>[] adj; // Adjacency list representation
	private int time = 0; // Discovery time counter

	// Constructor
	public ArticulationPoint(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<>();
		}
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v); // Graph is undirected
	}

	// The main function that finds and prints all articulation points
	void findArticulationPoints() {
		boolean[] visited = new boolean[V];
		int[] disc = new int[V];
		int[] low = new int[V];
		int[] parent = new int[V];
		boolean[] ap = new boolean[V]; // To store articulation points

		// Initialize parent and visited arrays
		Arrays.fill(parent, -1);
		
		// Call the recursive helper function to find APs in DFS tree rooted with different vertices
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				apUtil(i, visited, disc, low, parent, ap);
			}
		}

		// Now ap[] contains the articulation points
		System.out.println("Articulation points in the graph are:");
		for (int i = 0; i < V; i++) {
			if (ap[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	// A recursive function that finds articulation points using DFS traversal
	private void apUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap) {
		// A static variable to count children in DFS Tree
		int children = 0;

		// Mark the current node as visited
		visited[u] = true;

		// Initialize discovery time and low value
		disc[u] = low[u] = ++time;

		// Go through all vertices adjacent to this
		for (Integer v : adj[u]) {
			// If v is not visited yet, then make it a child of u
			// in DFS tree and recur for it
			if (!visited[v]) {
				children++;
				parent[v] = u;
				apUtil(v, visited, disc, low, parent, ap);

				// Check if the subtree rooted with v has a connection to
				// one of the ancestors of u
				low[u] = Math.min(low[u], low[v]);

				// u is an articulation point in following cases:
				
				// (1) u is root of DFS tree and has two or more children.
				if (parent[u] == -1 && children > 1) {
					ap[u] = true;
				}

				// (2) If u is not root and low value of one of its children is more
				// than or equal to discovery time of u.
				if (parent[u] != -1 && low[v] >= disc[u]) {
					ap[u] = true;
				}
			}
			// Update low value of u for parent function calls.
			else if (v != parent[u]) {
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}
	
	public static void main(String[] args) {
		// Create a graph given in the example
		System.out.println("Articulation points in first graph");
		ArticulationPoint g1 = new ArticulationPoint(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		g1.findArticulationPoints(); // Expected output: 0 3

		System.out.println("\nArticulation points in second graph");
		ArticulationPoint g2 = new ArticulationPoint(4);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		g2.findArticulationPoints(); // Expected output: 1 2

		System.out.println("\nArticulation points in third graph");
		ArticulationPoint g3 = new ArticulationPoint(7);
		g3.addEdge(0, 1);
		g3.addEdge(1, 2);
		g3.addEdge(2, 0);
		g3.addEdge(1, 3);
		g3.addEdge(1, 4);
		g3.addEdge(1, 6);
		g3.addEdge(3, 5);
		g3.addEdge(4, 5);
		g3.findArticulationPoints(); // Expected output: 1
	}
}

