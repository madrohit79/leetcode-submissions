class Solution {
    public int[] dailyTemperatures(int[] t) {
        int[] ans = new int[t.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<t.length;i++){
            while(!stack.isEmpty() && t[i]>t[stack.peek()]){
                int p=stack.pop();
                ans[p] = i-p;
            }
            stack.push(i);
        }
        return ans;
    }
}