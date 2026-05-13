class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index1 = findindex1(nums, target);
        int index2 = findindex2(nums, target);

        return new int[] {index1, index2};
    }
    public int findindex1(int [] nums, int target){
        int left =0;
        int right = nums.length-1;
        int index1 = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                index1 = mid;
                right = mid-1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return index1;
    }
    public int findindex2(int [] nums, int target){
        int left =0;
        int right = nums.length-1;
        int index2 = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                index2 = mid;
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return index2;
    }
}