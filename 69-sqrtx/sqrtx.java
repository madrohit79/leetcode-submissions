class Solution {
    public int mySqrt(int x) {
        if(x==1){
            return 1;
        }
        int low=0;
        int high=x/2;
        while(low<=high){
            int mid=low+(high-low)/2;
            long sq = (long)mid*mid;
            int val = mid;
            if(sq<x){
                low=mid+1;
            }
            else if(sq>x){
                high=mid-1;
            }
            else{
                return mid;
            }
        }
        return low-1;
    }
}