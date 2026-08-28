class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> ans = new HashMap<>();
        Arrays.sort(nums);
        int c=1;
        int l=1;

        if(nums.length!=0){
            for(int i = 1; i<nums.length;i++){
                if(nums[i]==nums[i-1]){
                continue;
                }
                if(nums[i]==nums[i-1]+1){
                    c++;
                }
                else{
                    l=Math.max(l,c);
                    c=1;
                }
            }

            return Math.max(l,c);
        }
        else{
            return 0;
        } 
    }
}