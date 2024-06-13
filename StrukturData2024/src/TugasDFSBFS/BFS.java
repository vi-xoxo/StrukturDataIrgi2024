package TugasDFSBFS;
import java.util.*;
public class BFS {
	    private int V;
	    private LinkedList<Character> adj[];

	    
	    	BFS(int v) {
	        V = v;
	        adj = new LinkedList[v];
	        for (int i = 0; i < v; ++i)
	            adj[i] = new LinkedList<>();
	    }

	    // Function to add an edge into the graph (using characters as nodes)
	    void addEdge(char v, char w) {
	        int indexV = v - 'a'; // Convert character 'a'-'z' to index 0-25
	        int indexW = w - 'a'; // Convert character 'a'-'z' to index 0-25
	        adj[indexV].add(w);
	    }

	    // Breadth First Search traversal starting from vertex v (character)
	    List<String> BFS(char v) {
	        boolean visited[] = new boolean[V];
	        List<String> traversalPath = new ArrayList<>();

	        // Create a queue for BFS
	        LinkedList<Character> queue = new LinkedList<>();

	        // Mark the current node as visited and enqueue it
	        int index = v - 'a'; // Convert character 'a'-'z' to index 0-25
	        visited[index] = true;
	        queue.add(v);

	        while (!queue.isEmpty()) {
	            // Dequeue a vertex from queue and add it to traversal path
	            char current = queue.poll();
	            traversalPath.add(current + "");

	            // Get all adjacent vertices of the dequeued vertex current
	            // If an adjacent vertex has not been visited, then mark it visited and enqueue it
	            int currentIndex = current - 'a';
	            for (char neighbor : adj[currentIndex]) {
	                int neighborIndex = neighbor - 'a';
	                if (!visited[neighborIndex]) {
	                    visited[neighborIndex] = true;
	                    queue.add(neighbor);
	                    traversalPath.add(current + "->" + neighbor); // Adding arrow notation
	                }
	            }
	        }

	        return traversalPath;
	    }

	    public static void main(String args[]) {
	        BFS g = new BFS(6); // Graph with 6 vertices

	        // Adding edges to the graph (using characters 'a'-'f')
	        g.addEdge('a', 'b');
	        g.addEdge('a', 'd');
	        g.addEdge('b', 'e');
	        g.addEdge('c', 'f');
	        g.addEdge('c', 'd');
	        g.addEdge('d', 'e');
	        g.addEdge('e', 'f');

	        // Perform BFS from node 'a'
	        List<String> bfsTraversal = g.BFS('a');

	        // Print BFS traversal steps
	        System.out.println("BFS Traversal:");
	        System.out.println(String.join(" -> ", bfsTraversal));
	    }
	}

