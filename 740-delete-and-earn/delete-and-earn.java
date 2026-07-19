class Solution {
    int [] points;
    Integer dp[];
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums) max = Math.max(num, max);

        points = new int[max + 1];

        for(int num : nums){
            points[num] += num;
        }
        dp = new Integer[max+1];

        return solve(0);
    }public int solve(int i){
        if(i >= points.length) return 0;

        if(dp[i] != null) return dp[i];

        int take = points[i] + solve(i+2);
        int skip = solve(i+1);

        return dp[i] = Math.max(take, skip);
    }
}