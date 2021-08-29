
//using BFS in undireacted graph
class Node{
    int first;
    int second;
    
    Node(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        //using bfs
        boolean vis[] = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                if(bfs(i, vis, adj))return true;
        }
    }
    return false;
}
public boolean bfs(int s, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
    Queue<Node> q = new LinkedList<>();
    
    q.add(new Node(s, -1));
    vis[s] = true;
    
    while(!q.isEmpty()){
        Node node = q.poll();
        
        for(Integer it : adj.get(node.first)){
            if(vis[it] == false){
            q.add(new Node(it, node.first));
            vis[it] = true;
            }
            else{
                if(node.second != it)return true;
            }
        }
        
    }
    return false;
}
}
