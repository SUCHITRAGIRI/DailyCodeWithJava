package GraphImplementation;
import java.util.*;

public class CycleDetectionDFS {

	public static void main(String[] args) {
	int v = 6;
	//Graph define
	ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	
	for(int i = 0; i < v; i++)
		adj.add(new ArrayList<Integer>());

	//add nodes
	
//	
//	5 5
//	0 4
//	1 2
//	1 4
//	2 3
//	3 4
//	
	adj.get(0).add(1);
	adj.get(1).add(0);
	
	//2--1
	adj.get(2).add(1);
	adj.get(1).add(2);
	
	//3--2
	adj.get(3).add(2);
	adj.get(2).add(3);
	
	//4---5
	adj.get(4).add(5);
	adj.get(5).add(4);
	
	
//	for(int i = 0; i < v; i++) {
//		System.out.print(i +"---->");
//		for(int it : adj.get(i)) {
//			System.out.print(it+" ");
//		}
//		System.out.println();
//	}
	
	

	if(cycle(adj, v))
		System.out.println("cycle contain!");
	else
		System.out.println("No cycle contain!");

	}
	
	//create class node for store the curr node value as well as parent node value for identifying the cycle 
	
	
	public static boolean cycle(ArrayList<ArrayList<Integer>> adj, int v) {
		boolean vis[] = new boolean[v];
		//Arrays.fill(vis, false);
	
		
		for(int i = 0; i < v; i++) {
			if(vis[i] == false) {
				if(dfs(i, adj, vis, -1))return true;
			}
		}
		return false;
	}
	
	public static boolean dfs(int s, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int parent) {
		
		vis[s] = true;
		for(Integer it : adj.get(s)) {
			if(vis[it] == false) {
				if(dfs(it, adj, vis, s))return true;
			}else {
				if(it != parent)return true;
			}
			
		}
		return false;
	
	}

}
