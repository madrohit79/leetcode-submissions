class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int index=0;
        int high=nums.length-1;
        while(low<=high){
            int mid = low + ( high - low)/2;
            int val = nums[mid];
            if(val<target){
                low=mid+1;
            }
            else if(val>target){
                high=mid-1;
            }
            else{
                return mid;
            }
        }
        return low;
    }
}