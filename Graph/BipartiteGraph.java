//Bipartite check using BFS (reference - https://www.youtube.com/watch?v=nbgaEu-pvkU)
package GraphImplementation;

import java.util.*;

public class BipartiteGraph {
 //Graph is starting from 0
	
	
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 int V = sc.nextInt();
		 int E = sc.nextInt();
		 
		 ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		 
		 for(int i = 0; i < V; i++) {
			 adj.add(new ArrayList<Integer>());
		 }
		 
		 for(int i = 0; i < E; i++) {
			 int u = sc.nextInt();
			 int v = sc.nextInt();
			 
			 adj.get(u).add(v);
			 adj.get(v).add(u);
		 }
		    
		    
//		    for(int i = 0; i <= v; i++) {
//		    	adj.add(new ArrayList<Integer>());
//		    }
//		    
//		    //1---2 
//		    adj.get(1).add(2);
//		    adj.get(2).add(1);
//		    
//		    //2---3
//		    adj.get(2).add(3);
//		    adj.get(3).add(2);
//		    
//		    //4---3
//		    adj.get(4).add(3);
//		    adj.get(3).add(4);
//		    
//		    //4--5
//		    adj.get(4).add(5);
//		    adj.get(5).add(4);
//		    
//		    // 1--5
//		    adj.get(1).add(5);
//		    adj.get(5).add(1);
		    
		    //Display the graph
		    for(int i = 0; i < adj.size(); i++) {
		    for(Integer it : adj.get(i))
		    System.out.print(it +"--");
		    System.out.println();
		    }
	     
		    // check for bipartite graph
		    int color1 = 0;
		    int color2 = 1;
		    
		    System.out.println(bipartite(adj, V, color1, color2));
		    
	}
	// using BFS
	public static boolean bipartite(ArrayList<ArrayList<Integer>> adj, int v, int color1, int color2) {
		
		int color[] = new int[v];
		Arrays.fill(color, -1);
		
		
		for(int i = 0; i < v; i++) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		color[0] = color1;
		q.add(0);
		
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(Integer it : adj.get(node)) {
				if(color[it] == -1) {
					color[it] = 1 - color[node];
					q.add(it);
				}else {
					if(color[it] == color[node])return false;
				}
			}
		}
		}
		
		return true;
	}
	
}

