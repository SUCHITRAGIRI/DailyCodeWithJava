package GraphImplementation;

import java.util.*;

public class Graph {
	// Queue<Integer> q = new LinkedList<>();

	private LinkedList<Integer> adj[];

	public Graph(int v) {
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	// main function
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// enter the no. of vertices and edges
		System.out.println("enter the verties and edges \n");
		int v = sc.nextInt();
		int e = sc.nextInt();

		Graph graph = new Graph(v);

		System.out.println("enter " + e + " edge");

		for (int i = 0; i < e; i++) {
			int source = sc.nextInt();
			int destination = sc.nextInt();

			graph.addEdge(source, destination);
		}
		System.out.println("Enter the source and destination for DFS traversal\n");
		System.out.println("Enter the source and destination for BFS traversal\n");
		int s = sc.nextInt();
	    int d = sc.nextInt();
		//System.out.print("\nThe minimum distance between " + s + " and " + d + " is " + graph.bfs(s, d));
		System.out.println(graph.dfsStack(s, d));
	}

	// add edges on graph
	public void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	// apply BFS for finding minimum distance bet source to destination

	public int bfs(int source, int destination) {
		boolean[] visit = new boolean[adj.length];
		int[] parent = new int[adj.length];

		Queue<Integer> q = new LinkedList<>();

		q.add(source);
		visit[source] = true;
		parent[source] = -1;
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (curr == destination)
				break;

			for (int neighbor : adj[curr]) {
				if (!visit[neighbor]) {
					q.add(neighbor);
					visit[neighbor] = true;
					parent[neighbor] = curr;
				}
			}
		}
		int distance = 0;
		int cur = destination;
		while (parent[cur] != -1) {
			System.out.print(cur + "->");
			cur = parent[cur];
			distance++;
		}
		System.out.print(source);
		return distance;

	}
	
	//apply DFS for checking whether path exist from source and destination or not
	//two to implement DFS is : using stack and recursion stack
	
	//Using Recursion stack
	public boolean dfsRec(int source, int destination, boolean visit[]) {
		if(source == destination)return true;
		
		for(int neighbor: adj[source]) {
			if(!visit[neighbor]) {
				visit[neighbor] = true;
				boolean isConnected = dfsRec(neighbor, destination, visit);//call
				if(isConnected) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean dfs(int source, int destination) {
		boolean visit[] = new boolean[adj.length];
		visit[source] = true;
		
		return dfsRec(source, destination, visit); // call
	}
	
	//Using stack data structure
	public boolean dfsStack(int source, int destination){

		Stack<Integer> stack = new Stack<>();
		boolean[] visit = new boolean[adj.length];
		
		stack.push(source);
		visit[source] = true;
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			if(destination == curr)return true;
			
		for(int neighbor : adj[curr]) {
		if(!visit[neighbor]) {
			visit[neighbor] = true;
			stack.push(neighbor);
		}
		
		}
		}
		return false;
	}
	}
