package geeksForGeeks;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	private int V; //Number of vertices
	
	private LinkedList<Integer> adj[]; //for adjacency list
	
	DFS(int v){
		
		V = v;
		
		adj = new LinkedList[V];
		
		for (int i = 0; i < v; ++i){
			adj[i] = new LinkedList();
		}
	}
	
	void addEdges(int v, int e){
		adj[v].add(e); //add Edges
	}
	
	void DepthFirstUtil(int v, boolean visited[]){
		
		visited[v] = true; //mark 'v' as visited
		
		System.out.print(v+"\t");
		
		Iterator<Integer> itr = adj[v].listIterator(); //iterate through adjacent vertices of 'v'
		
		while(itr.hasNext()){
			int n = itr.next();
			if(!visited[n]){
				DepthFirstUtil(n,visited); //call the function recursively
			}
		}
	}
	
	void DepthFirstSearch(int v){
		
		boolean visited[] = new boolean[V]; //to identify if the vertex has been visited or not
		
		DepthFirstUtil(v, visited);
	}
	
	public static void main(String[] args){
		DFS g = new DFS(4);
		
		g.addEdges(0, 1);
        g.addEdges(0, 2);
        g.addEdges(1, 2);
        g.addEdges(2, 0);
        g.addEdges(2, 3);
        g.addEdges(3, 3);
        
        System.out.println("Depth First Traversal for the graph is :");
        
        g.DepthFirstSearch(2);
	}
}
