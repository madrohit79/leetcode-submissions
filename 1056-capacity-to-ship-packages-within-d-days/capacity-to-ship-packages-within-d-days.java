class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int s=0;
        for(int i =0;i<weights.length;i++){
            s+=weights[i];
            if(weights[i]>max){
                max=weights[i];
            }
        }
        int low = max;
        int high = s;
        while(low<=high){
            int d=1;
            int cap = low+(high-low)/2;
            int sum =0;
            for(int i =0;i<weights.length;i++){
                if(sum+weights[i]>cap){
                    d++;
                    sum=weights[i];
                }
                else{
                    sum+=weights[i];
                }
            }
            if(d<=days){
                high=cap-1;
            }
            else{
                low=cap+1;
            }
        }
        return low;
    }
}