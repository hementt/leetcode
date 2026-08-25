class Solution {
    public int missingMultiple(int[] nums, int k) {
        int freq[] = new int[101];
        for(int num : nums) freq[num]++;

        int res = 0;
        for(int i = k; i<= 100;){
            if(freq[i] == 0) return i;
            if(freq[i] >= 1) res = i;
            i=i+k;
        }

        return res+k;
    }
}