class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length;
        int[] indegree =new int[n+2];
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            indegree[u]++;
            indegree[v]++;

        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==n){
                return i;
            }
        }
        return -1;
    }
}