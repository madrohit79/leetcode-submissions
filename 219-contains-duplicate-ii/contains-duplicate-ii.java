class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i< nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(i>=k){ // we did this because we this is our window , when i crossess our limit then we have to eliminate the first element right 
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}