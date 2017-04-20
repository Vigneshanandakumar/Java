package geeksForGeeks;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
	private int V; //Vertices in the graph
	private LinkedList<Integer> adj[]; //Adjacency Lists for a vertex
	
	BFS(int v){
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i){
			adj[i] = new LinkedList();
		}
	}
	
	public void addEdges(int v, int e){
		adj[v].add(e); //add edges to the vertices
	}
	
	void BreadthFirstSearch(int v){
		
		boolean[] visited = new boolean[V]; //create a boolean array to identify visited nodes/vertices
		
		LinkedList<Integer> queue = new LinkedList<Integer>(); //to store the values of the visited vertices and perform BFS
		
		visited[v] = true; //mark 'v' as visited
		
		queue.add(v); //add 'v' to the queue
		
		while(!queue.isEmpty()){
			v = queue.poll(); //removes the first element of the queue
			
			System.out.print(v+"\t");
			
			Iterator<Integer> itr = adj[v].listIterator(); //iterate through the adjacency lists of vertex 'v'
			
			while (itr.hasNext()){
				
				int n = itr.next(); 
				
				while(!visited[n]){ //check if 'n' is visited
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	public static void main(String[] args){
		BFS g = new BFS(4);
		
		g.addEdges(0, 1);
        g.addEdges(0, 2);
        g.addEdges(1, 2);
        g.addEdges(2, 0);
        g.addEdges(2, 3);
        g.addEdges(3, 3);
        
        System.out.println("Breadth First Traversal for the Graph is :");
        
        g.BreadthFirstSearch(2);
		
	}
}
