class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        int max = 0;
        int count[] = new int[n+1];
        Arrays.fill(count, 1);
        Arrays.fill(dp, 1);


        for(int i =0; i<n;i++){
            for(int j = i - 1;j>=0; j--){
                if(nums[i] > nums[j]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if(dp[i] == dp[j] + 1){
                        count[i] += count[j];
                    }

                }

            }
            max = Math.max(dp[i], max);
        }


        
        int res = 0;
        

        for(int i =0; i<n;i++){
            if(dp[i] == max){
                res += count[i];
            }
        }

        return res;
    }
}