class Solution {
    boolean flag = false;
    Integer dp[][];
    public int maximumJumps(int[] nums, int target) {
        dp = new Integer[nums.length+1][nums.length+1];
        // if(target == 0 ) return -1;
        int ans = solve(nums, target, 0, 1);
        if(!flag) return -1;
        return ans;
    }
    public int solve(int nums[], int target, int i, int j){
        if(i == nums.length - 1) return 0;

        if(j >= nums.length) return -(int)1e9;

        int include = -(int)1e9;
        if(dp[i][j] != null) return dp[i][j];
        
        if(Math.abs(nums[i] - nums[j]) <= target){
            if(j == nums.length -1 || i == nums.length -1 ) flag = true;
            include = 1 + solve(nums, target, j, j+1);
        }
        int exclude = solve(nums, target, i, j+1);

        return dp[i][j] = Math.max(include, exclude);
    }
}