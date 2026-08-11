/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n=mountainArr.length();
        int l=1;
        int r=n-2;
        int mid=l+(r-l)/2;
        while(l<=r){
            mid=(l+r)/2;
            int val=mountainArr.get(mid);
            int lval=mountainArr.get(mid-1);
            int rval=mountainArr.get(mid+1);
            if(val>rval && val> lval){
                break;
            }else if(val>rval && val< lval){
                r=mid-1;

            }else{
                l=mid+1;
            }
        }

        int peak=mid;
        l=0;
        r=peak;
        while(l<=r){
            mid=(l+r)/2;
            int val=mountainArr.get(mid);
            if(val==target){
                return mid;
            }else if(target<val){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        l=peak;
        r=n-1;
        while(l<=r){
            mid=(l+r)/2;
            int val=mountainArr.get(mid);
            if(val==target){
                return mid;
            }else if(target<val){
                
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;

    }
}