class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int sizel=0;
        int temp=12;
        int[] arr={12,123,1234,12345,123456,1234567,12345678,123456789};
        int in=11;
        int cnt=8;
        int i=0;
        ArrayList<Integer> ls=new ArrayList<>();
        while(cnt>0){
            temp=arr[8-cnt];
            while(i<cnt){
                ls.add(temp);
                temp+=in;
                
                i++;
            }
            in=in*10+1;
            i=0;
            cnt--;
        }
        for(int ii=0;ii<ls.size();ii++){
            if(ls.get(ii)<low || ls.get(ii)>high){
                ls.remove(ii);
                ii--;
            }
        }
        return ls;
    }
}