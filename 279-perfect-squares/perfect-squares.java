class Solution {
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int s =1;
        while( s*s <= n){
            list.add(s*s);
            s++;
        }
        int k = list.size();
        int dp[][] = new int[k + 1][n+1];

        for(int i = 1; i<=n ;i++) dp[k][i] = (int) 1e5;

        for(int i = list.size() - 1; i>=0;i--){
            for(int j =0; j<= n;j++){

                int skip = dp[i+1][j];

                int take = (int) 1e5;
                if(list.get(i) <= j) take = 1 + dp[i][j - list.get(i)];

                dp[i][j] = Math.min(skip, take);
            }
        }

        return dp[0][n];

    }
}