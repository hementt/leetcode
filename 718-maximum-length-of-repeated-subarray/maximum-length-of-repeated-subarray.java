class Solution {
    int res =0;
    Integer dp[][];
    public int findLength(int[] nums1, int[] nums2) {
        dp = new Integer[nums1.length+1][nums2.length + 2];
        solve(0,0, nums1, nums2);
        return res;
    }
    public int solve(int i , int j ,int nums1[], int nums2[]){
        if(i == nums1.length || j == nums2.length) return 0;
        if(dp[i][j] != null) return dp[i][j];

        int ans =0;

        if(nums1[i] == nums2[j]){
            ans = 1 + solve(i+1, j+1, nums1, nums2);
            res = Math.max(res, ans);
        }
        solve(i + 1, j, nums1, nums2);
        solve(i, j + 1, nums1, nums2);

        return dp[i][j] =ans;
    }
}