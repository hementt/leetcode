class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 == 1) return false;

        int target = sum/2;

        boolean dp[][] = new boolean[nums.length+1][target + 1];
        for(int i=0; i<=nums.length;i++){
            dp[i][0] = true;
        }

        for(int i = nums.length -1;i>=0;i--){
            for(int j =1; j<=target;j++){
                
                boolean exclude = dp[i+1][j];
                boolean include = false;
                if(j >= nums[i]) include = dp[i+1][j - nums[i]];
                
                dp[i][j] = include || exclude;
            }
        }
        return dp[0][target];
    }
}