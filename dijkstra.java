package geeksForGeeks;

public class dijkstra {
	private static final int V  = 9;
	int minDistance(int[] dist, boolean[] mstSet){
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		for(int v =0; v < V; v++)
		if(mstSet[v] == false && dist[v] <= min){
			min = dist[v];
			min_index = v;
		}
		return min_index;
	}
	
    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" \t\t "+dist[i]);
    }
	
	void Dijkstra(int graph[][], int src){
		int[] dist = new int[V];
		boolean[] mstSet = new boolean[V];
		
		for (int i = 0; i < V; i++){
			dist[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		
		dist[src] = 0;
		
		for(int count = 0; count < V-1; count++){
			int u = minDistance(dist, mstSet);
			mstSet[u] = true;
			
			for(int v = 0; v < V; v++){
				if(graph[u][v] != 0 && !mstSet[v] && dist[u]+graph[u][v] < dist[v] && dist[u] != Integer.MAX_VALUE)
					dist[v] = dist[u]+graph[u][v];
			}
		}
		printSolution(dist, V);
	}
	  public static void main (String[] args)
	{
        /* Let us create the example graph discussed above */
       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };
        dijkstra t = new dijkstra();
        t.Dijkstra(graph, 0);
    }
}
