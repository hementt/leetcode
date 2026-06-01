class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        int pointer = 0;
        while(left<=right){
            int mid = left + (right-left) /2;
            if(target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length-1] ){
                pointer = mid;
                break;
            }else if(target < matrix[mid][0] && target < matrix[mid][matrix[0].length-1]){
                right = mid-1;
            }else{
                left = mid +1;
            }
        }

        int left1 = 0;
        int right1 = matrix[0].length-1;
        while(left1<=right1){
            int mid = left1 + (right1 - left1)/2;
            if(matrix[pointer][mid]== target){
                return true;
            }else if(matrix[pointer][mid] > target){
                right1 = mid-1;
            }else{
                left1 = mid+1;
            }
        }

        return false;

    }
}