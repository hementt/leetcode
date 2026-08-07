class Solution {
    Integer dp[][];
    public int numDistinct(String s, String t) {
        dp = new Integer[s.length() + 1][t.length() + 1];
        return solve(s, t, 0,0);
    }
    public int solve(String s, String t, int i, int j){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        if(dp[i][j] != null) return dp[i][j]; 
        int skip1 = 0;
        int skip2 = 0;

        if(s.charAt(i) == t.charAt(j)) skip1 = solve(s, t, i+1, j+1);
        
        skip2 = solve(s, t, i+1, j);
        

        return dp[i][j] = skip1 + skip2;
    }
}