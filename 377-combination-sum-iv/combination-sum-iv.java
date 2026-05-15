class Solution {
    Integer dp[][];
    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[nums.length][target+1];
        return solve(nums, target, 0);
    }
    public int solve(int nums[], int target, int i){
        if(i == nums.length){
            return 0;
        }
        if(target == 0){
            return 1;
        }
        if(target < 0) return 0;

        if(dp[i][target] != null) return dp[i][target];

        int include = solve(nums, target - nums[i], 0);
        int exclude = solve(nums, target, i+1);

        return dp[i][target] = include + exclude;
    }
}