class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int sum = 0;
        int ans = 1000000000;
        int l = 0;
        int r = 0;
        while(r<nums.length){
            sum+=nums[r];
            r++;
            while(sum>=target){
                ans = Math.min(ans,r-l);
                sum-=nums[l];
                l++;
            }
        }
        if (ans == 1000000000) {
            return 0;
        }
        return ans;
    }
}