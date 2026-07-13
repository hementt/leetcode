class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        for(int i =1;i<=9;i++){
            int num = i;
            for(int j =i+1;j<=9;j++){
                num = num * 10;
                num += j;
                if(num >= low && num <= high) ans.add(num);
                if(num > high) break;
            }
        }
        Collections.sort(ans);

        return ans;
    }
}