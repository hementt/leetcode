class Solution {
    Boolean dp[][];
    public boolean palindrome(String s, int i, int j){
        if(i >= j) return true;
        
        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) != s.charAt(j)){
            dp[i][j] = false;
        }else{
            dp[i][j] = palindrome(s, i+1, j-1);
        }

        return dp[i][j];
    }
    public String longestPalindrome(String s) {
        dp = new Boolean[s.length()][s.length()];
        int start = 0;
        int max = 1;
        for(int i =0; i<s.length(); i++){
            for(int j =i; j<s.length(); j++){
                if(palindrome(s, i, j)){
                    if(max < j - i + 1){
                        start = i;
                        max = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }
}