class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        Integer cand1=null;
        Integer cand2=null;
        int count1=0;
        int count2=0;
        for(int num:nums){
            if(count1==0 &&(cand2==null || cand2!=num)){
                cand1=num;
                count1++;
            }else if(count2==0 &&(cand1==null || cand1!=num)){
                cand2=num;
                count2++;
            }else if(cand1!=null && cand1==num){
                count1++;
            }else if(cand2!=null && cand2==num){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        int cnt1=0;
        int cnt2=0;
        for(int a:nums){
            if(cand1!=null && a==cand1){
                cnt1++;
            }
            if(cand2!=null && a==cand2){
                cnt2++;
            }
        }
        ArrayList<Integer> ls=new ArrayList<>();
        if(cnt1>n/3 && cand1!=null){
            ls.add(cand1);
        }
        if(cnt2>n/3 && cand2!=null){
            ls.add(cand2);
        }
        return ls;

    }
}