class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n=bills.length;
        int fis=0;
        int tens=0;
        for(int i=0;i<n;i++){
            if(bills[i]==5){
                fis++;
            }else if(bills[i]==10){
                if(fis>0){
                    fis--;
                    tens++;
                }else{
                    return false;
                }
            }else{
                if((fis>0 && tens>0)){
                    fis--;
                    tens--;
                }else if(fis>2){
                    fis-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}