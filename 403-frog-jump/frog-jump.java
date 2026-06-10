class Solution {
    HashSet<Integer> set;
    HashMap<Integer, HashMap<Integer, Boolean>> dp;
    public boolean canCross(int[] stones) {
        if (stones.length > 1 && stones[1] != 1) return false;
        set = new HashSet<>();
        for(int num : stones) set.add(num);
        dp = new HashMap<>();
        return solve( 1,1,stones[stones.length - 1]);
    }
    public boolean solve(int k, int curr, int target){
        if(curr == target){
            return true;
        }
        if(dp.containsKey(curr) && dp.get(curr).containsKey(k)) return dp.get(curr).get(k);

        if(curr > target || k <= 0){
            return false;
        }

        boolean first = false,  second = false, third = false;

        if(set.contains(curr + k-1)) first = solve(k-1, curr + k-1, target);
        if(set.contains(curr + k)) second = solve(k, curr + k, target);
        if(set.contains(curr + k+1)) third = solve(k+1, curr + k + 1, target);

        boolean ans = first || second || third;

        dp.putIfAbsent(curr, new HashMap<>());
        dp.get(curr).put(k, ans);
        return   first || second || third;
    }
}