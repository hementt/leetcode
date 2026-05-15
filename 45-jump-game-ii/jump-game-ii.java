class Solution {
    Integer dp[][];
    public int jump(int[] nums) {
        dp = new Integer[nums.length+1][1001];
        return solve(nums, 0, 1);
    }
    public int solve(int nums[], int i, int j){
        if(i == nums.length -1 ) return 0;
        if(i >= nums.length) return 0;

        if(nums[i] < j) return (int)1e5;

        if(dp[i][j] != null) return dp[i][j];

        int jump = 1 + solve(nums, i + j, 1);
        int skip = solve(nums, i, j+1);

        return dp[i][j] = Math.min(jump, skip);
    }
}