class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        HashMap<Character, Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(word.charAt(i), mp.getOrDefault(word.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>> ls=new ArrayList<>(mp.entrySet());
        ls.sort(Map.Entry.comparingByValue());
        Collections.reverse(ls);
        int ans=0;
        int count=0;
        int coef=1;
        for(Map.Entry<Character,Integer> e: ls){
            if(count<8){
                ans=ans+(coef*(e.getValue()));
                count++;
            }else{
                count=0;
                coef++;
                ans=ans+(coef*(e.getValue()));
                count++;
            }
        }
        

        return ans;
    }
}