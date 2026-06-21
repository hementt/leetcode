class Solution {
    public int maxIceCream(int[] costs, int coins) {

        Arrays.sort(costs);
        int count = 0;
        int target = coins;
        for(int num : costs){
            if(target - num >= 0){
                count++;
                target -= num;
            }
        }

        return count;
    }
}