//

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        boolean[] recStack = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == false)if(dfs(i, vis, recStack, adj))return true;
        }
        
       return false; 
    }
    
    public boolean dfs(int i, boolean[] vis, boolean[] recStack, ArrayList<ArrayList<Integer>> adj){
       
       if(recStack[i])return true;
       if(vis[i])return false;
       
       vis[i] = true;
       recStack[i] = true;
       for(Integer it : adj.get(i)){
           if(dfs(it, vis, recStack, adj))return true;
       }
       
       recStack[i] = false;
       return false;
    }
}








