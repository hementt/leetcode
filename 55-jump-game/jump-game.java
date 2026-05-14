class Solution {
    Boolean dp[];
    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length+1];
        return solve(nums, 0);
    }
    public boolean solve(int nums[], int i){
        if(i == nums.length-1) return true;
        if(i >= nums.length) return false;

        if(dp[i] != null) return dp[i];

        for(int j =1; j<=nums[i];j++){
            if(solve(nums, i+j)){
                return dp[i] = true;
            }
        }
        return dp[i] = false;
    }   
}