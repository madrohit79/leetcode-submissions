class Solution {
    public int carFleet(int t, int[] p, int[] s) {
        int n = p.length;
        Stack<Double> stack = new Stack<>(); // storing times 
        int[][] arr = new int[n][2];   //positions and speeds array for sorting purpose 
        for(int i = 0 ; i<n;i++){
            arr[i][0]=p[i];
            arr[i][1]=s[i];
        }
        Arrays.sort(arr, (a,b)->Integer.compare(b[0],a[0]));
        for(int i=0;i<n;i++){
            double time = (double)(t-arr[i][0])/arr[i][1];
            if(stack.isEmpty()||time>stack.peek()){
                stack.push(time);
            }
        }
        return stack.size();
    }
}