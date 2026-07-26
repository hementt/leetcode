class Solution {
    Integer dp[][];
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int num : stones) sum += num;

        dp = new Integer[stones.length][(sum/2) + 1];
        int ans = solve(stones, 0, sum/2);

        return (sum) - (2 * ans);

    }
    public int solve(int nums[], int i, int target){
        if(target < 0) return (int) -1e9;
        if(i == nums.length) return 0;
        if(dp[i][target] != null) return dp[i][target];

        int take = nums[i] + solve(nums, i+1, target - nums[i]);
        int skip = solve(nums, i+1, target);

        return dp[i][target] = Math.max(take, skip);
    }
}