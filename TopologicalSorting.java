package geeksForGeeks;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSorting {
	private int V;
	private LinkedList<Integer> adj[];
	
	TopologicalSorting(int v){
		V = v;
		adj = new LinkedList[V];
		for(int i = 0; i < v; ++i){
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int v, int e){
		adj[v].add(e);
	}
	
	void topoSortUtil(int v, boolean visited[], Stack stack){
		visited[v] = true;
		Integer i;
		
		Iterator<Integer> itr = adj[v].listIterator();
		while(itr.hasNext()){
			i = itr.next();
			if(!visited[i]){
				topoSortUtil(i, visited, stack);
			}
		}
		
		stack.push(new Integer(v));
		
	}
	
	void topoSort(){
		Stack stack = new Stack();
		
		boolean visited[] = new boolean[V];
		
		for (int i = 0; i < V; i++){
			visited[i] = false;
		}
		
		for (int i = 0; i < V; i++){
			if(visited[i] == false){
				topoSortUtil(i, visited, stack);
			}
		}
		
		while(stack.empty() == false)
			System.out.print(stack.pop()+"\t");
	}
	
	public static void main(String args[])
    {
        // Create a graph given in the above diagram
        TopologicalSorting g = new TopologicalSorting(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological " +
                           "sort of the given graph");
        g.topoSort();
    }
}
