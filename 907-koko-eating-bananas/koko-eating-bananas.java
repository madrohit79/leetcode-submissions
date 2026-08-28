class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max =0;
        for(int i =0;i<piles.length;i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }
        int low=1;
        int high=max;
        while(low<=high){
            int mid = low+(high-low)/2;
            int val = mid; // this is our k selection 
            long hour=0;
            for(int j=0;j<piles.length;j++){
                hour += (long)(piles[j]+val-1)/val;
            }
            if(hour<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}