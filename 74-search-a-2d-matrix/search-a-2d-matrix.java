class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        Boolean ans = true;
        int low = 0;
        int high = matrix.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][matrix[mid].length-1]){
                int nlow=0;
                int nhigh=matrix[mid].length-1;

                while(nlow<=nhigh){
                    int nmid = nlow+(nhigh-nlow)/2;
                    if(matrix[mid][nmid]==target){
                        return ans;
                    }
                    else if(matrix[mid][nmid] < target){
                        nlow = nmid + 1;
                    }
                    else{
                        nhigh = nmid - 1;
                    }
                }
                return false;
            }
            else if(target<matrix[mid][0]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}