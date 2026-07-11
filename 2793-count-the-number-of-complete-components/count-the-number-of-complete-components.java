class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<Integer>[] adj=new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
            adj[i].add(i);
        }
        for(int[] edg: edges){
            adj[edg[0]].add(edg[1]);
            adj[edg[1]].add(edg[0]);
        }
        HashMap<ArrayList<Integer>, Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> samp=adj[i];
            Collections.sort(samp);
            mp.put(samp,mp.getOrDefault(samp,0)+1);
        }
        int ans=0;
        for(ArrayList<Integer> key:mp.keySet()){
            if(mp.get(key)==key.size()){
                ans++;
            }
        }
        return ans;
    }
}