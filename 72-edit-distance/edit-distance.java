class Solution {
    Integer dp[][];
    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length() + 1][word2.length() + 1];
        return solve(word1, word2, 0,0);
    }
    public int solve(String s1, String s2, int i, int j){
        if(i == s1.length()){
            return s2.length() - j;
        }

        if(j == s2.length()){
            return s1.length() - i;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(s1, s2, i+1, j+1);
        }
        int insert = solve(s1, s2, i, j + 1);
        int delete = solve(s1, s2, i + 1, j);
        int replace = solve(s1, s2, i + 1, j + 1);

        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}