class Solution {
    public int findLengthOfLCIS(int[] nums) {
        return solve(nums,1, 1,1);
    }
    public int solve(int nums[], int i, int ans, int curr){
        if(i == nums.length) return ans;

        if(nums[i] > nums[i-1]){
            curr+= 1;
        }else{
            curr = 1;
        }

        ans = Math.max(ans, curr);

        return solve(nums, i+1, ans, curr);

    }
}