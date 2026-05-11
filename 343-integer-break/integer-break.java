class Solution {
    public int integerBreak(int n) {
        return solve(n, n, 1);
    }
    public int solve(int n, int target ,int i){
        
        if(target == 0) return 1;
        if(i >=  n || target < 0) return 0;

        int include = i * solve(n, target - i, i);
        int exclude = solve(n, target, i+1);

        return Math.max(include, exclude);
    }
}