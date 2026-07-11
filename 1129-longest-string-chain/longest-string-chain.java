class Solution {
    public int longestStrChain(String[] words) {

        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int res = 1;
        int dp[] = new int[words.length];

        Arrays.fill(dp, 1);
        for(int i =0; i<words.length;i++){
            for(int j =0; j<i;j++){

                if(predecessor(words[i], words[j])){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public boolean predecessor(String s1, String s2){
        if(s1.length() - 1 == s2.length()){
            int i =0;
            int j = 0;
            while(i < s1.length()){
                if(j < s2.length() && s1.charAt(i) == s2.charAt(j)){
                    j++;
                }
                i++;
            }
            return j == s2.length();
        }else{
            return false;
        }
    }
}