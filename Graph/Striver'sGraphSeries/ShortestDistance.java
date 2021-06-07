package GraphImplementation;
import java.util.*;

//Using BFS algo calculate the shortest distance between source to destination in a graph

public class ShortestDistance {

	public static void main(String[] args) {
		
		int v = 5;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		int[] dis =  new int[v];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		for(int i = 0; i < v; i++) {
		 adj.add(new ArrayList<>());
		}
		// add edges
		
		// 0--2
		adj.get(0).add(2);
		adj.get(2).add(0);
		
		//1--2 
		adj.get(1).add(2);
		adj.get(2).add(1);
		
		//2--3
		adj.get(2).add(3);
		adj.get(3).add(2);
		
		//3--4
		adj.get(3).add(4);
		adj.get(4).add(3);
		
		for(int i = 0; i < v; i++) {
			for(Integer it : adj.get(i)) {
				System.out.print(it+" ");
			}
			System.out.println();
		}
		
		int source = 0; 
		//for(int i = 0; i < v; i++)
		shortestDistance(adj, dis, source, v);
	}
	
	public static void shortestDistance(ArrayList<ArrayList<Integer>> adj, int[] dis, int s, int v) {
		Queue<Integer> q = new LinkedList<>();
		
		dis[s] = 0;
		q.add(s);
		
		while(!q.isEmpty()) {
			Integer node = q.poll();
			for(Integer it : adj.get(node)) {
				if(dis[node] + 1 < dis[it]) {
					dis[it] = dis[node] + 1;
					q.add(it);
				}
			}
			
		}
		
		for(int i = 0; i < v; i++) {
			System.out.println("shortest distance bet 0 to " + i +" is "+ dis[i]);
		}
		
	}
	

}

