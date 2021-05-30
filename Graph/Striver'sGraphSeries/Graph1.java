package GraphImplementation;
import java.util.*;
//Learning graph how to define, traversal--> BFS, DFS all are here!
//Actually its been 4th days and I didn't do coding:(
//that's y I am not feeling well.BTW I will cover nd again from earlier days i will put my interest on it:)
public class Graph1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//creating a graph with 5
		int v = 5;
		//creating a graph with adjacency list
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i <= v; i++)
			adj.add(new ArrayList<Integer>());
		
		// 1--2
		adj.get(1).add(2);
		adj.get(2).add(1);
		
		//2--3
		adj.get(2).add(3);
		adj.get(3).add(2);
		
		//1--3
		adj.get(1).add(3);
		adj.get(3).add(1);
		
		//3--4
//		adj.get(3).add(4);
//		adj.get(4).add(3);
		
		//4--5
		adj.get(4).add(5);
		adj.get(5).add(4);
		
		
		// the graph looks like this
//		 1----2
//		  \	 /
//         \3---4----5 		
		
//		for(int i = 1; i <= v; i++) {
//			for(int j = 0; j < adj.get(i).size(); j++) {
//				System.out.println(adj.get(i).get(j) + " ");
//			}
//			System.out.println();
//		}
		ArrayList<Integer> list = new ArrayList<>();
		//for bfs
//		list = bfs(adj, v);
//		for(Integer i: list)
//		System.out.print(i+"-->");
		
		//for dfs
		list = dfs(adj, v);
		for(Integer i: list)
		System.out.print(i+"-->");
		
	}
	
	//Now Doing Breadth First Search(BFS)
	
	public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int v){
		//suppose the graph is having multiple component means (Disconnected Graph)
		
//		1--2
//	        \
//	         3          4----5
	//component 1      component 2 
		
		//take visit array
		boolean vis[] = new boolean[v + 1];
		ArrayList<Integer> list = new ArrayList<>();
		//Define a Queue
		Queue<Integer> q = new LinkedList<>();
		
		//otherwise we add have to take this for loop(if we know that connected graph ###not having multiple component)
		
		for(int i = 1; i <= v; i++) {
			if(vis[i] == false) {
			q.offer(i);
			vis[i] = true;
			while(!q.isEmpty()) {
				Integer temp = q.poll();
				list.add(temp);
				
				for(Integer j : adj.get(temp)) {
					if(vis[j] == false) {
						vis[j] = true;
						q.add(j);
					}
				}

			}
		}
		}
		return list;
	}
	
//Depth first search(DFS) (Have to use recursion)
	
	public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj, int v){
		ArrayList<Integer> dfsStore = new ArrayList<>();
		boolean vis[] = new boolean[v + 1];
		for(int i = 1; i <= v; i++) {
			if(vis[i] == false) {
				dfsGraph(i, vis, adj, dfsStore);
			}
		}
		return dfsStore;
	}
	
	public static void dfsGraph(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsStore) {
		
		dfsStore.add(node);
		vis[node] = true;
		
		for(Integer it : adj.get(node)) {
			if(vis[it] == false) {
				dfsGraph(it, vis, adj, dfsStore);
			}
		}
		
		
	}

}
