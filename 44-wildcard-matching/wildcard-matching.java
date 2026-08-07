class Solution {
    Boolean dp[][];
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return solve(0,0,s,p);
    }
    public boolean solve(int i, int j, String s, String p){
        if(i == s.length() && j == p.length()){
            return true;
        }
        if(j == p.length()) return false;
        if(dp[i][j] != null) return dp[i][j];
        if(i == s.length()){
            while(j < p.length()){
                if(p.charAt(j) != '*') return false;
                j++;
            }
            return true;
        }

        

        boolean match = false;
        boolean skip = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            match = solve(i+1, j+1, s, p);
        }else if(p.charAt(j) == '*'){
            skip = solve(i+1, j, s, p) || solve(i, j+1, s, p);
        }
        return dp[i][j] = match || skip;
    }

}