class SegmentTree{
    private int[] arr;
    private int[] seg;
    private int n;
    public SegmentTree(int[] arr){
        this.arr= arr;
        this.n=arr.length;
        this.seg=new int[4*n];
        build(1,0,n-1);
    }

    private void build(int in, int l, int r){
        if(n==0){
            return;
        }
        if(l==r){
            seg[in]=arr[l];
            return;
        }
        int mid=(l+r)/2;
        build(2*in, l, mid);
        build(2*in +1, mid+1, r);
        seg[in]=Math.max(seg[2*in], seg[2*in+1]);
    }

    public int que(int l, int r){
        if(n==0){
            return 0;
        }
        return query(1, 0, n-1, l,r);
    }
    private int query(int in, int l, int r, int L, int R){
        if(l>=L && r<=R){
            return seg[in];
        }
        if(r<L || l>R){
            return 0;
        }
        int mid=(l+r)/2;
        int lef=query(2*in, l,mid,L,R);
        int ref=query(2*in+1, mid+1,r,L,R);
        return Math.max(lef,ref);
    }
}

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n=s.length();
        int m=queries.length;
        int tot=0;
        for(char c:s.toCharArray()){
            if(c=='1'){
                tot++;
            }
        }
        ArrayList<Integer> ls=new ArrayList<>();
        ArrayList<Integer> lf=new ArrayList<>();
        ArrayList<Integer> rf=new ArrayList<>();
        int i=0;
        int in=0;
        while(i<n){
            int c=0;
            if(s.charAt(i)=='0'){
                in =i;
                while(i<n && s.charAt(i)==s.charAt(in)){
                    c++;
                    i++;
                }
                lf.add(in);
                rf.add(i-1);
                ls.add(c);
                
            }else{
                i++;
            }
        }
        int[] ans=new int[m];
        int pl=ls.size()-1;
        if(pl==-1){
            ArrayList<Integer> ams= new ArrayList<>();
            for(int a:ans){
                ams.add(tot);
            }
            System.out.println(tot);
            return ams;
        }
        int[] psum=new int[pl];
        for(int j=0;j<pl;j++){
            psum[j]=ls.get(j)+ls.get(j+1);
        }
        SegmentTree segT=new SegmentTree(psum);
        i=0;
        for(int[] q: queries){
            int l=q[0];
            int r=q[1];
            int le=rightin(rf,l);
            int re=leftin(lf,r)-1;
            if(le>pl || re<0 || le>=re){
                ans[i++]=tot;
                continue;
            }
            int leftsum=rf.get(le)-Math.max(l,lf.get(le))+1;
            int rightsum=Math.min(r,rf.get(re))-lf.get(re)+1;

            if(le+1==re){
                ans[i++]=(tot+leftsum+rightsum);
                continue;
            }
            if(le==re){
                ans[i++]=tot;
                continue;
            }

            ans[i++]=(tot+ Math.max(segT.que(le+1,re-2),Math.max(leftsum+ls.get(le+1),rightsum+ls.get(re-1))));


        }
        ArrayList<Integer> ams= new ArrayList<>();
        for(int a:ans){
            ams.add(a);
        }
        System.out.println(tot);
        return ams;
    }

    public int rightin(ArrayList<Integer> ls, int a){
        int l=0;
        int r=ls.size();
        
        while(l<r){
            int mid=(l+r)/2;
            if(ls.get(mid)<a){
                l=mid+1;
            }else{
                r=mid;
            }
            
        }
        return l;
    }

    public int leftin(ArrayList<Integer> ls, int a){
        int l=0;
        int r=ls.size();
        
        while(l<r){
            int mid=(l+r)/2;
            if(ls.get(mid)<=a){
                l=mid+1;
            }else{
                r=mid;
            }
            
        }
        return l;
    }
}