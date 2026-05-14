class Solution {
    public boolean isGood(int[] nums) {
        int max = nums[0];
        int freq[] = new int[201];
        for(int i =0; i<nums.length;i++){
            if(max < nums[i]) max = nums[i];
            freq[nums[i]]++;
        }

        if(nums.length != max+1) return false;
        for(int i =0; i<freq.length;i++){
            if(i != max && freq[i] > 1) return false;
        }

        return freq[max] == 2 ?true : false;
    }
}