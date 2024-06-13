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

	   
void addEdge(char v, char w) {
	        int indexV = v - 'a';
	        int indexW = w - 'a'; 
	        adj[indexV].add(w);
	    }

	   
List<String> BFS(char v) {
    boolean visited[] = new boolean[V];
	List<String> traversalPath = new ArrayList<>();

	        
LinkedList<Character> queue = new LinkedList<>();
    int index = v - 'a'; 
	visited[index] = true;
	queue.add(v);

	while (!queue.isEmpty()) {
	         
	char current = queue.poll();
	traversalPath.add(current + "");

	int currentIndex = current - 'a';
	    for (char neighbor : adj[currentIndex]) {
	  int neighborIndex = neighbor - 'a';
	   if (!visited[neighborIndex]) {
	     visited[neighborIndex] = true;
	     queue.add(neighbor);
	     traversalPath.add(current + "->" + neighbor); 
	}
}
}

return traversalPath;
}

public static void main(String args[]) {
BFS g = new BFS(6); 	       
g.addEdge('a', 'b');
g.addEdge('a', 'd');
g.addEdge('b', 'e');
g.addEdge('c', 'f');
g.addEdge('c', 'd');
g.addEdge('d', 'e');
g.addEdge('e', 'f');

List<String> bfsTraversal = g.BFS('a');

	System.out.println("BFS Traversal:");
	System.out.println(String.join(" -> ", bfsTraversal));
	   
}
}

