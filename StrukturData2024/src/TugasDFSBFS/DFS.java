package TugasDFSBFS;
import java.util.*;
public class DFS {
private int V; 
private LinkedList<Character> adj[]; 

   
DFS(int v) {
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

   
void DFSUtil(char v, boolean visited[], List<String> traversalPath) {
  int index = v - 'a'; 
  visited[index] = true;

 for (char n : adj[index]) {
   int nIndex = n - 'a'; 
   if (!visited[nIndex]) {
   traversalPath.add(v + "->" + n);
      DFSUtil(n, visited, traversalPath);
            }
        }
    }

    
String DFS(char v) {
  boolean visited[] = new boolean[V];
  List<String> traversalPath = new ArrayList<>();
  DFSUtil(v, visited, traversalPath);
  return String.join(" ", traversalPath);
 }

public static void main(String args[]) {
  DFS g = new DFS(6); 

     
  g.addEdge('a', 'b');
  g.addEdge('a', 'd');
  g.addEdge('b', 'e');
  g.addEdge('c', 'f');
  g.addEdge('c', 'd');
  g.addEdge('d', 'e');
  g.addEdge('e', 'f');

        System.out.println("DFS Traversal dari simpul awal ke tujuan");
        System.out.println(g.DFS('a')); 
    }
}
