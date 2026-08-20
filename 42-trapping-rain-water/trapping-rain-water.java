class Solution {
    public int trap(int[] h) {

        int left = 0;
        int right = h.length - 1;
        int lmax = 0;
        int rmax = 0;
        int water = 0;
        while(left<right){
            if(h[left]<=h[right]){
                if(h[left]>=lmax){
                    lmax = h[left];
                }
                else{
                    water += lmax - h[left];
                }
                left++;
            }
            else{
                if(h[right]>=rmax){
                    rmax = h[right];
                }
                else{
                    water += rmax - h[right];
                }
                right--;
            }
        }
        return water;
    }
}